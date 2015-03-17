/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import classi.EntitaB;
import static game.Gioco.ALTEZZA;
import static game.Gioco.SCALA;
import static game.Gioco.altezzaGiocatore;
import static game.Gioco.altezzaTerra;
import static game.Gioco.sto_atterrando;
import static game.Gioco.sto_saltando;
import java.awt.Graphics;
import java.awt.Rectangle;
import librerie.Animazione;

/**
 *
 * @author alexpopa95
 */
public class Nemico extends OggettoGioco implements EntitaB{
    
    Textures tex;
    Animazione anim;
    Animazione anim_girato;
    Gioco game;
    Controller c;
    
    private int vita = 2;
    private boolean versoDestra;
    private final double velNemico = 1;
    private final double velCaduta = 3;
    
    private double backupX, backupY;
    
    public Nemico(double x, double y, Gioco game, Textures tex, Controller c) {
        super(x, y);
        this.tex = tex;
        this.game=game;
        this.c=c;
        versoDestra=false;
        
        anim = new Animazione(4, tex.nemico[0], tex.nemico[1], tex.nemico[2], tex.nemico[1]);
        anim_girato = new Animazione(4, tex.nemico_girato[0], tex.nemico_girato[1], tex.nemico_girato[2], tex.nemico_girato[1]);
    }
    
    @Override
    public void aggiorna() {
        backupX=x;
        backupY=y;
        
        /*
        if(Physics.nonPasso(this, Gioco.ec)) {
            y=backupY-velCaduta;
            if(Physics.nonPasso(this, Gioco.ec)) {
                versoDestra = !versoDestra;
                System.out.println("CAMBIO DIREZIONE");
            }
            
            //if(Gioco.collisione==0) {
                if(versoDestra) {
                    x += velNemico;
                    System.out.println("DESTRA");
                }
                else {
                    x += -velNemico;
                    System.out.println("SINISTRA");
                }
            //}
        }
        else {
            
            y+=velCaduta;
        }
        */
        y+=0.1;
        if(Physics.nonPasso(this, game.ec)) {
            y=backupY;
        }
        else {
            y=backupY;
            y+=velCaduta;
            if(Physics.nonPasso(this, game.ec)) {
                    y=backupY;
                }
        }
        
        if(Physics.nonPasso(this, Gioco.ec)) {
                versoDestra = !versoDestra;
                //System.out.println("CAMBIO DIREZIONE");
            }
        if(versoDestra) {
                    x += velNemico;
                    //System.out.println("DESTRA");
                }
                else {
                    x += -velNemico;
                    //System.out.println("SINISTRA");
                }
        
        
        
        if(Physics.Collisione(this, game.ea)){
            vita--;
            if(vita==0) { 
                c.rimuoviEntita(this); 
                Gioco.uccisioni++;
            }
            c.rimuoviEntita(game.ea.getFirst());
            game.audioPantera2();
        }
        anim.avviaAnimazione();
        anim_girato.avviaAnimazione();
    }
    
    @Override
    public void disegna(Graphics g) {
        if(versoDestra)
            anim.disegnaAnimazione(g, x, y, 0);
        else
            anim_girato.disegnaAnimazione(g, x, y, 0);
    }
    
    @Override
    public Rectangle getBordi(){
        return new Rectangle((int)x, (int)y, 63, 31);
    }
    
    @Override
    public double getX(){
        return x;
    }
    
    @Override
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
