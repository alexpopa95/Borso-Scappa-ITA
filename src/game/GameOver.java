
package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author alexpopa95
 */
public class GameOver {
    
    public Rectangle playButton = new Rectangle(Gioco.LARGHEZZA/2 + 120, 150, 100, 50);
    
    public void disegna(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.drawImage(Immagini.background2, 0, 0, null);
        g2d.drawImage(Immagini.pulsanteRiprova, 375, 350, null);
    }
}
