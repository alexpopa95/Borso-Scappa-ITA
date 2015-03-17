
package game;

import java.util.LinkedList;
import classi.EntitaA;
import classi.EntitaB;
import classi.EntitaC;
import classi.EntitaG;
import classi.EntitaM;

/**
 *
 * @author alexpopa95
 */
public class Physics {
    
    public static boolean controPapa(EntitaG entg, NemicoInseguitore ni) {
        
        if(entg.getBordi().intersects(ni.getBordi())) {
            return true;
        }
        return false;
    }
    
    public static boolean Collisione(EntitaA enta, LinkedList<EntitaB> entb) {
        
        for(int i=0; i<entb.size(); i++) {
            if(enta.getBordi().intersects(entb.get(i).getBordi())) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean Collisione(EntitaB entb, LinkedList<EntitaA> enta) {
        
        for(int i=0; i<enta.size(); i++) {
            if(entb.getBordi().intersects(enta.get(i).getBordi())) {
                return true;
            }
        }
        return false;
    }
    
    
    public static boolean nonPasso(EntitaG entg, LinkedList<EntitaC> entc) {
        
        for(int i=0; i<entc.size(); i++) {
            if(entg.getBordi().intersects(entc.get(i).getBordi())) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean raccogli(EntitaG entg, LinkedList<EntitaM> entm) {
        
        for(int i=0; i<entm.size(); i++) {
            if(entg.getBordi().intersects(entm.get(i).getBordi())) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean raccogli(EntitaM entm, Giocatore gioc) {
        return entm.getBordi().intersects(gioc.getBordi());
    }
    
    public static boolean controPapa(EntitaG entg, LinkedList<EntitaM> entm) {
        
        for(int i=0; i<entm.size(); i++) {
            if(entg.getBordi().intersects(entm.get(i).getBordi())) {
                return true;
            }
        }
        return false;
    }
    public static boolean controNemico(EntitaG entg, LinkedList<EntitaB> entb) {
        
        for(int i=0; i<entb.size(); i++) {
            if(entg.getBordi().intersects(entb.get(i).getBordi())) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean nonPasso(EntitaA enta, LinkedList<EntitaC> entc) {
        
        for(int i=0; i<entc.size(); i++) {
            if(enta.getBordi().intersects(entc.get(i).getBordi())) {
                return true;
            }
        }
        return false;
    }
    public static boolean nonPasso(NemicoInseguitore ni, LinkedList<EntitaC> entc) {
        
        for(int i=0; i<entc.size(); i++) {
            if(ni.getBordi().intersects(entc.get(i).getBordi())) {
                return true;
            }
        }
        return false;
    }
    public static boolean nonPasso(EntitaM entm, LinkedList<EntitaC> entc) {
        
        for(int i=0; i<entc.size(); i++) {
            if(entm.getBordi().intersects(entc.get(i).getBordi())) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean nonPasso(EntitaB entb, LinkedList<EntitaC> entc) {
        
        for(int i=0; i<entc.size(); i++) {
            if(entb.getBordi().intersects(entc.get(i).getBordi())) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean nonPasso(EntitaC entc, LinkedList<EntitaG> entg) {
        
        for(int i=0; i<entg.size(); i++) {
            if(entc.getBordi().intersects(entg.get(i).getBordi())) {
                return true;
            }
        }
        return false;
    }
    public static boolean ucciso(EntitaA enta, LinkedList<EntitaB> entb) {
        
        for(int i=0; i<entb.size(); i++) {
            if(enta.getBordi().intersects(entb.get(i).getBordi())) {
                return true;
            }
        }
        return false;
    }
}
