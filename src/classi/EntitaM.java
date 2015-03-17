
package classi;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author alexpopa95
 */
public interface EntitaM {
    public void aggiorna();
    public void disegna(Graphics g);
    public Rectangle getBordi();
    
    public double getX();
    public double getY();
    public void setX(double x);
    public void setY(double y);
}