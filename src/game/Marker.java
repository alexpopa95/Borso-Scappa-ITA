
package game;

import classi.EntitaD;
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
public class Marker extends OggettoGioco implements EntitaD {

    
    Textures tex;
    Animazione anim;
    Gioco game;
    Controller c;
    EntitaD entd;
    private double backupX, backupY;
    
    public Marker(double x, double y, Gioco game, Textures tex, Controller c) {
        super(x, y);
        this.tex = tex;
        this.game=game;
        this.c=c;
        
        anim = new Animazione(10, tex.freccia[0], tex.freccia[0]);
    }
    
    @Override
    public void aggiorna() {
        
        anim.avviaAnimazione();
    }

    @Override
    public void disegna(Graphics g) {
        anim.disegnaAnimazione(g, x, y, 0);
    }

    @Override
    public Rectangle getBordi(){
        return null;
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
