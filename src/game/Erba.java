
package game;

import classi.EntitaD;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import librerie.Animazione;

/**
 *
 * @author alexpopa95
 */
public class Erba extends OggettoGioco implements EntitaD {

    
    Textures tex;
    Animazione anim;
    BufferedImage imgErba;
    Gioco game;
    Controller c;
    
    public Erba(double x, double y, Gioco game, Textures tex, Controller c) {
        super(x, y);
        this.tex = tex;
        this.game=game;
        this.c=c;
        
        imgErba = tex.erba[0];
        //anim = new Animazione(10, tex.erba[0], tex.erba[1]);
    }
    
    @Override
    public void aggiorna() {
        //anim.avviaAnimazione();
    }

    @Override
    public void disegna(Graphics g) {
        //anim.disegnaAnimazione(g, x, y, 0);
        g.drawImage(imgErba, (int) x, (int) y, game);
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
    
    @Override
    public void setX(double x){
        this.x=x;
    }
    
    @Override
    public void setY(double y) {
        this.y=y;
    }
    
}
