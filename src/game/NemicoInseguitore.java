/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import classi.EntitaB;
import classi.EntitaM;
import static game.Gioco.ALTEZZA;
import static game.Gioco.SCALA;
import static game.Gioco.altezzaGiocatore;
import static game.Gioco.altezzaTerra;
import static game.Gioco.sto_atterrando;
import static game.Gioco.sto_saltando;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import librerie.Animazione;

/**
 *
 * @author alexpopa95
 */
public class NemicoInseguitore extends OggettoGioco{
    
    Textures tex;
    Animazione anim;
    Animazione animSX;
    Gioco game;
    Controller c;
    
    private int vita = 2;
    private boolean audiofatto = false;
    private boolean versoDestra;
    private final double velSalto = 4;
    private final double velNemico = 1.25;
    private final double velCaduta = 4;
    private static final double altezzaSalto = 65;
    private static boolean salto = false;
    private static boolean atterro = false;
    private static boolean collisione = false;
    
    private double backupX, backupY, backupAlt;
    
    public NemicoInseguitore(double x, double y, Gioco game, Textures tex, Controller c) {
        super(x, y);
        this.tex = tex;
        this.game=game;
        this.c=c; 
        versoDestra=true;
        
        anim = new Animazione(4, tex.nemicoIns[0], tex.nemicoIns[1], tex.nemicoIns[2], tex.nemicoIns[3]);
        animSX = new Animazione(4, tex.nemicoIns[4], tex.nemicoIns[5], tex.nemicoIns[6], tex.nemicoIns[7]);
    }
    
    public void aggiorna() {
        backupX=x;
        backupY=y;
        
        if(Gioco.giocatore.x != x && (Gioco.giocatore.x+5 > x || Gioco.giocatore.x < x+5)) {
            if(Gioco.giocatore.x > x) versoDestra=true;
            else if(Gioco.giocatore.x < x) versoDestra=false;
            if(Gioco.insegui && versoDestra) x+=velNemico;
            if(Gioco.insegui && !versoDestra) x-=velNemico;
            if(Physics.nonPasso(this, Gioco.ec)) {
                x=backupX;
                if(!salto && !atterro) collisione=true;
            }

            //--------------------------------------
            if(Gioco.insegui)  y+=0.1;
            if(Physics.nonPasso(this, Gioco.ec)) {
                y=backupY;
            }
            else {
                y=backupY;
                if(!salto && !atterro) backupAlt = Gioco.altezzaNemico;
                //if(!salto && !atterro)System.out.println("AltezzaNemico: "+backupAlt);
                Gioco.altezzaNemico = ALTEZZA*SCALA-63;
                if(y<Gioco.altezzaNemico) {
                    atterro = true;
                }
            }
        }
        
        
        
        
        
        
        
        
        
        
        /* BACKUP!!!!!
        y+=velCaduta;
        if(Physics.nonPasso(this, Gioco.ec)) {
            y=backupY;
            if(!sto_saltando && !sto_atterrando) backupAlt = Gioco.altezzaNemico;
            if(Physics.nonPasso(this, Gioco.ec)) {
                salto=true;
            }
            
            //if(Gioco.collisione==0) {
                if(!salto) x+=velNemico;
            //}
        }
        else {
            y+=velCaduta;
        }
        
        
        */
        
        if(salto) {
            if(!audiofatto) this.audioSalto();
            audiofatto = true;
            if(y<=0)
            {
                salto=false;
                atterro=true;
            }
            if(y>backupAlt-altezzaSalto) {
                atterro = false;
                y-=velSalto;
                if(Physics.nonPasso(this, game.ec)) {
                    y+=velSalto;
                    salto=false;
                    atterro=true;
                }
            }
            else {
                salto=false;
                atterro=true;
            }
        }
        else if(atterro) {
            audiofatto=false;
            if(y<=backupAlt) {
                if(Gioco.insegui) y+=velCaduta;
                if(Physics.nonPasso(this, game.ec)) {
                    y=backupY;
                    Gioco.altezzaNemico = y;
                    atterro = false;
                }
            }
            else {
                atterro=false;
            }
        }
        
        
        if(collisione) {
            salto=true;
            collisione=false;
        }
        
        /* SPARARE AL NEMICO
        if(Physics.Collisione(this, game.ea)){
            vita--;
            if(vita==0) { 
                c.rimuoviEntita(this); 
                Gioco.uccisioni++;
            }
            c.rimuoviEntita(game.ea.getFirst());
        }
        */
        
        if(versoDestra)anim.avviaAnimazione();
        else animSX.avviaAnimazione();
    }
    
    public void audioSalto() {
        AudioInputStream audioInputStream = null;
        Clip clip;
        try {
            URL url = this.getClass().getClassLoader().getResource("Sound/salto.wav");
            audioInputStream = AudioSystem.getAudioInputStream(url);
            // Get a clip resource.
            clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Gioco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                audioInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(Gioco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
              
    public void disegna(Graphics g) {
        if(versoDestra) anim.disegnaAnimazione(g, x, y, 0);
        else animSX.disegnaAnimazione(g, x, y, 0);
    }
    
    public Rectangle getBordi(){
        return new Rectangle((int)x, (int)y, 35, 63);
    }
    
    public double getX(){
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public void setX(double x){
        this.x=x;
    }
    
    public void setY(double y) {
        this.y=y;
    }
}
