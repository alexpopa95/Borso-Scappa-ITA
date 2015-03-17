/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexpopa95
 */
public class Immagini {
    
    static BufferedImage background = null;
    static BufferedImage background2 = null;
    static BufferedImage background3 = null;
    static BufferedImage pulsanteFine = null;
    static BufferedImage pulsanteRiprendi = null;
    static BufferedImage pulsanteRiprova = null;
    static BufferedImage pulsanteInizia = null;
    
    public Immagini() {
        try {
            background = new BufferedImageLoader().caricaImmagine("/Immagini/background.jpg");
            background2 = new BufferedImageLoader().caricaImmagine("/Immagini/background2.jpg");
            background3 = new BufferedImageLoader().caricaImmagine("/Immagini/background3.jpg");
            pulsanteFine = new BufferedImageLoader().caricaImmagine("/Immagini/pulsanteFine.png");
            pulsanteRiprova = new BufferedImageLoader().caricaImmagine("/Immagini/pulsanteRiprova.png");
            pulsanteRiprendi = new BufferedImageLoader().caricaImmagine("/Immagini/pulsanteRiprendi.png");
            pulsanteInizia = new BufferedImageLoader().caricaImmagine("/Immagini/pulsanteInizia.png");
        } catch (IOException ex) {
            Logger.getLogger(Immagini.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
