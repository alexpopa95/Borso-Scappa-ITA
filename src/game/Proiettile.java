
package game;

import classi.EntitaA;
import classi.EntitaC;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;

/**
 *
 * @author alexpopa95
 */
public class Proiettile extends OggettoGioco implements EntitaA{
    
    
    Gioco game;
    Textures tex;
    Controller c;
    boolean versoDestra;
    
    public Proiettile (double x, double y, Gioco game, Textures tex, Controller c) {
        super(x, y);
        Gioco.munizioni--;
        this.tex=tex;
        this.game=game;
        this.c = c;
        versoDestra = Gioco.versoDestraGiocatore;
    }
    
    @Override
    public void aggiorna(){
        if(versoDestra) {
            x+=5;
        }
        else {
            x-=5;
        }
        
        //Collisione con la terra
        if(Physics.nonPasso(this, Gioco.ec)){
            c.rimuoviEntita(this);
        }
    }
    
    @Override
    public void disegna(Graphics g){
        if(versoDestra)
            g.drawImage(tex.proiettile[0], (int)x, (int)y, null);
        else
            g.drawImage(tex.proiettile[1], (int)x, (int)y, null);
    }
    
    @Override
    public Rectangle getBordi(){
        return new Rectangle((int)x, (int)y, 31, 5);
    }
    
    @Override
    public double getX(){
        return x;
    }
    
    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setX(double x) {
        this.x=x;
    }

    @Override
    public void setY(double y) {
        this.y=y;
    }
}
