
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
public class Menu {
    
    public Rectangle playButton = new Rectangle(Gioco.LARGHEZZA/2 + 120, 150, 100, 50);
    
    public void disegna(Graphics g) {
        //Graphics2D g2d = (Graphics2D) g;
        
        //Font font0 = new Font("arial", Font.BOLD, 50);
        //Font font1 = new Font("arial", Font.BOLD, 30);
        
        //g.setFont(font0);
        //g.setColor(Color.RED);
        //g.drawString("Aiuta borso a scappare", Gioco.LARGHEZZA/2, 50);
        
        //g.setFont(font1);
        //g.setColor(Color.WHITE);
        //g.drawString("           Alexandru Popa", Gioco.LARGHEZZA/2, 100);
        
        //g.setFont(font1);
        //g.drawString("Gioca", playButton.x+9, playButton.y+35);
        //g2d.draw(playButton);
        g.drawImage(Immagini.pulsanteInizia, 720, 620, null);
    }
}
