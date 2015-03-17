/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import classi.EntitaB;
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
public class NemicoMedio extends OggettoGioco implements EntitaB{
    
    Textures tex;
    Animazione anim;
    Gioco game;
    Controller c;
    
    private int vita = 3;
    private boolean versoDestra;
    private final double velNemico = 1;
    private final double velCaduta = 1;
    
    private double backupX, backupY;
    
    public NemicoMedio(double x, double y, Gioco game, Textures tex, Controller c) {
        super(x, y);
        this.tex = tex;
        this.game=game;
        this.c=c;
        versoDestra=false;
        
        anim = new Animazione(4, tex.nemico[0], tex.nemico[1]);
    }
    
    @Override
    public void aggiorna() {
        backupX=x;
        backupY=y;
        
        y+=velCaduta;
        if(Physics.nonPasso(this, game.ec)) {
            y=backupY;
            if(Physics.nonPasso(this, game.ec)) {
                versoDestra = !versoDestra;
            }
            
            //if(Gioco.collisione==0) {
                if(versoDestra) {
                    x += velNemico;
                }
                else {
                    x += -velNemico;
                }
            //}
        }
        else {
            y+=velCaduta;
        }
        
        
        
        
        
        if(Physics.Collisione(this, game.ea)){
            vita--;
            if(vita==0) { 
                c.rimuoviEntita(this); 
                Gioco.uccisioni++;
            }
            c.rimuoviEntita(game.ea.getFirst());
        }
        anim.avviaAnimazione();
    }
    
    @Override
    public void disegna(Graphics g) {
        anim.disegnaAnimazione(g, x, y, 0);
    }
    
    @Override
    public Rectangle getBordi(){
        return new Rectangle((int)x, (int)y, 32, 63);
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
