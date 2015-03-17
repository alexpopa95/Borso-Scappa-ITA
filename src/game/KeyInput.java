

package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author alexpopa95
 */
public class KeyInput implements KeyListener {
    
    Gioco game;
    
    public KeyInput(Gioco game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        game.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        game.keyReleased(e);
    }
}
