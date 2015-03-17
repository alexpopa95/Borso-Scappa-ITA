
package game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author alexpopa95
 */
public class BufferedImageLoader {
    
    private BufferedImage img;
    
    public BufferedImage caricaImmagine(String posizione) throws IOException{
        
        img = ImageIO.read(getClass().getResource(posizione));
        return img;
        
    }
}
