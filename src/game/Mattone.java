
package game;

import classi.EntitaC;
import java.awt.Graphics;
import java.awt.Rectangle;
import librerie.Animazione;

/**
 *
 * @author alexpopa95
 */
public class Mattone extends OggettoGioco implements EntitaC {

    
    Textures tex;
    Animazione anim;
    Gioco game;
    Controller c;
    EntitaC entc;
    private double backupX, backupY;
    
    public Mattone(double x, double y, Gioco game, Textures tex, Controller c) {
        super(x, y);
        this.tex = tex;
        this.game=game;
        this.c=c;
        
        anim = new Animazione(10, tex.mattoni[0], tex.mattoni[0]);
    }
    
    @Override
    public void aggiorna() {
        /*
        backupX = x;
        
        x-=giocatore.velX;

        if(this.getBordi().intersects(giocatore.getBordi())) {
            x=backupX;
            Gioco.collisione = 1;
        }
        else
           Gioco.collisione=0;
        
        */
        /* PER SPINGERE UN BLOCCO DI TERRA!!!!
        backupX = x; 
        backupY = y;
        System.out.println("X "+x+" Y "+y+" altGioc "+altezzaGiocatore);
        x-=giocatore.velX;
        if(this.getBordi().intersects(giocatore.getBordi())) {
            this.x=backupX;
        }
        */
        anim.avviaAnimazione();
    }

    @Override
    public void disegna(Graphics g) {
        anim.disegnaAnimazione(g, x, y, 0);
    }

    @Override
    public Rectangle getBordi(){
        return new Rectangle((int)x, (int)y, 26, 26);
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
