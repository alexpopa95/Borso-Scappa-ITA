
package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author alexpopa95
 */
public class FinestraInfo {
    
    public Rectangle playButton = new Rectangle(Gioco.LARGHEZZA/2 + 120, 150, 100, 50);
    
    public void disegna(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.drawImage(Immagini.pulsanteRiprendi, 720, 620, null);
    }
}
