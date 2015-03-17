
package game;

import static game.Gioco.altezzaTerra;
import static game.Gioco.tex;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexpopa95
 */
public class MouseInput implements MouseListener{

    private Gioco game;
    MouseInput(Gioco game) {
        this.game = game;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        
        /**
                public Rectangle playButton = new Rectangle(Gioco.LARGHEZZA/2 + 120, 150, 100, 50);
        */
        
        if(Gioco.State == Gioco.STATE.MENU) {
            if(mx >= 720 && mx <= 720+160) {
                if(my >= 620 && my <= 620+90) {
                    //Preme il pulsante GIOCA
                    Gioco.State = Gioco.STATE.GAME;
                }
            }
        }
        else if(Gioco.State == Gioco.STATE.OVER) {
            if(mx >= 375 && mx <= 375+160) {
                if(my >= 350 && my <= 350+90) {
                    //Preme il pulsante RIPROVA
                    game.inizializza(Gioco.livello);
                    if(Gioco.livello==1) {
                        Gioco.giocatore.setY(550);
                        Gioco.giocatore.setX(1);
                    }
                    else if(Gioco.livello==2){
                        Gioco.giocatore.setY(150);
                        Gioco.giocatore.setX(1);
                    }
                    Gioco.giocatore.setVita(100);
                    Gioco.State = Gioco.STATE.GAME;
                }
            }
        }
        else if(Gioco.State == Gioco.STATE.END) {
            if(mx >= 375 && mx <= 375+160) {
                if(my >= 500 && my <= 500+90) {
                    Gioco.running = false;
                    try {
                        System.out.println("Finito!");
                        Gioco.thread.join();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Gioco.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.exit(1);
                }
            }
        }
        else if(Gioco.State == Gioco.STATE.INFO) {
            if(mx >= 720 && mx <= 720+160) {
                if(my >= 620 && my <= 620+90) {
                    //Preme il pulsante GIOCA
                    Gioco.State = Gioco.STATE.GAME;
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
