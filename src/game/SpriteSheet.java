
package game;

import java.awt.image.BufferedImage;

/**
 *
 * @author alexpopa95
 */
public class SpriteSheet {
    
    private final BufferedImage img;
    
    public SpriteSheet (BufferedImage image) {
        img=image;
    }
    
    public BufferedImage sottraiImmagine32(int colonna, int riga, int larghezza, int altezza){
        BufferedImage image = img.getSubimage((colonna * 32)-31, (riga * 32)-31, larghezza, altezza);
        return image;
    }
    
    public BufferedImage sottraiImmagine64(int colonna, int riga, int larghezza, int altezza){
        BufferedImage image = img.getSubimage((colonna * 64)-63, (riga * 64)-63, larghezza, altezza);
        return image;
    }
    
    public BufferedImage sottraiSfondo(double x, double y, int larghezza, int altezza){
        BufferedImage image = img.getSubimage((int) x/2,(int) y/5, larghezza, altezza);
        return image;
    }
    
}
