
package game;

import java.awt.Rectangle;

/**
 *
 * @author alexpopa95
 */
public class OggettoGioco{
    
    public double x, y;
    
    public OggettoGioco(double x, double y){
        this.x=x;
        this.y=y;
    }
    
    public Rectangle getBordi(int larghezza, int altezza){
        return new Rectangle((int)x, (int)y, larghezza, altezza);
    }
}
