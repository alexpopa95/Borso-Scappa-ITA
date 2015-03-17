
package game;

import classi.EntitaC;
import static game.Gioco.altezzaGiocatore;
import static game.Gioco.altezzaTerra;
import static game.Gioco.giocatore;
import static game.Gioco.sto_atterrando;
import static game.Gioco.sto_saltando;
import java.awt.Graphics;
import java.awt.Rectangle;
import librerie.Animazione;

/**
 *
 * @author alexpopa95
 */
public class Terra extends OggettoGioco implements EntitaC {

    
    Textures tex;
    Animazione anim;
    Gioco game;
    Controller c;
    EntitaC entc;
    private double backupX, backupY;
    
    public Terra(double x, double y, Gioco game, Textures tex, Controller c) {
        super(x, y);
        this.tex = tex;
        this.game=game;
        this.c=c;
        
        anim = new Animazione(10, tex.terra[0], tex.terra[0]);
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
