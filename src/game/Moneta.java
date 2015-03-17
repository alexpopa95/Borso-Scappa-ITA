
package game;

import classi.EntitaM;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
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
public class Moneta extends OggettoGioco implements EntitaM {

    
    Textures tex;
    Animazione anim;
    Gioco game;
    Controller c;
    
    public Moneta(double x, double y, Gioco game, Textures tex, Controller c) {
        super(x, y);
        this.tex = tex;
        this.game=game;
        this.c=c;
        
        anim = new Animazione(15, tex.moneta[0], tex.moneta[1], tex.moneta[2], tex.moneta[1]);
    }
    
    @Override
    public void aggiorna() {
        
        if(Physics.raccogli(this, Gioco.giocatore)){
            //Gioco.monete++;
            audioMoneta();
            Gioco.moneteLivello++;
            c.rimuoviEntita(this);
        }
        anim.avviaAnimazione();
    }
    private void audioMoneta() {
        AudioInputStream audioInputStream = null;
        Clip clip;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(URLs.coin);
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

    @Override
    public void disegna(Graphics g) {
        anim.disegnaAnimazione(g, x, y, 0);
    }

    @Override
    public Rectangle getBordi(){
        return new Rectangle((int)x, (int)y, 31, 31);
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
