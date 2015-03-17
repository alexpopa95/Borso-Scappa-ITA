package game;


import game.Gioco;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

class Musica {
    
        AudioInputStream audioInputStream = null;
        Clip clip;
        public Musica() {}
        
        public void play(){
            try {
                URL url = this.getClass().getClassLoader().getResource("Sound/musica.wav");
                audioInputStream = AudioSystem.getAudioInputStream(url);
                // Get a clip resource.
                clip = AudioSystem.getClip();
                // Open audio clip and load samples from the audio input stream.
                clip.open(audioInputStream);
                clip.loop(3);
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
        
        public void stop() {
            if(clip.isRunning()) clip.stop();
        }
    }


