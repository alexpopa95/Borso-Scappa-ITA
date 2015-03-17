
package game;

import classi.EntitaA;
import classi.EntitaB;
import classi.EntitaC;
import classi.EntitaD;
import classi.EntitaG;
import classi.EntitaM;
import static game.Gioco.giocatore;
import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author alexpopa95
 */
public final class Controller {
    private final LinkedList<EntitaA> ea = new LinkedList<>();
    private final LinkedList<EntitaB> eb = new LinkedList<>();
    private final LinkedList<EntitaC> ec = new LinkedList<>();
    private final LinkedList<EntitaD> ed = new LinkedList<>();
    private final LinkedList<EntitaG> eg = new LinkedList<>();
    private final LinkedList<EntitaM> em = new LinkedList<>();
    
    EntitaA enta;
    EntitaB entb;
    EntitaC entc;
    EntitaD entd;
    EntitaG entg;
    EntitaM entm;
    
    Textures tex;
    
    private final Gioco game;
    
    private int livello;
    
    public Controller(Gioco game, Textures tex, int livello) {
        this.tex=tex;
        this.game=game;
        this.livello = livello;
        Gioco.moneteLivello = 0;
        
        //DA DISEGNARE per livello
        if(livello==1)
        {
            aggiungiEntita(new Marker(850, 200, game, tex, this));
            //Nemici
            aggiungiEntita(new Nemico(220, 275, game, tex, this));
            //aggiungiEntita(new Nemico(820, 230, game, tex, this));
            
            //Monete
            aggiungiEntita(new Moneta(100, 600, game, tex, this));
            aggiungiEntita(new Moneta(300, 510, game, tex, this));
            aggiungiEntita(new Moneta(420, 600, game, tex, this));
            aggiungiEntita(new Moneta(760, 420, game, tex, this));
            aggiungiEntita(new Moneta(460, 360, game, tex, this));
            aggiungiEntita(new Moneta(90, 230, game, tex, this));
            aggiungiEntita(new Moneta(170, 180, game, tex, this));
            aggiungiEntita(new Moneta(90, 90, game, tex, this));
            aggiungiEntita(new Moneta(720, 280, game, tex, this));
            
            
            aggiungiEntita(new TerraErba(150+93+93+31, 620-62-(31*8), game, tex, this));
            aggiungiEntita(new Nemico(150+93+93+93+93+93+93+93+93, 620-62-(31*5), game, tex, this));
            
            
            //----------------------------------------------------
            Gioco.NI = new NemicoInseguitore(-40, 550, game, tex, this);
            for(int i=0;i<=300;i+=31)
            {
                aggiungiEntita(new TerraErba(i, 650, game, tex, this));
            }
            aggiungiEntita(new Onda(310, 650, game, tex, this));
            aggiungiEntita(new Onda(310+31, 650, game, tex, this));
            aggiungiEntita(new Terra(310+62, 650, game, tex, this));
            aggiungiEntita(new Mattone(310+62, 620, game, tex, this));
            aggiungiEntita(new Mattone(310+62, 590, game, tex, this));
            for(int i=0;i<=Gioco.LARGHEZZA*Gioco.SCALA;i+=31)
            {
                aggiungiEntita(new Acqua(i, 681, game, tex, this));
            }
            for(int i=0;i<=Gioco.LARGHEZZA*Gioco.SCALA;i+=31)
            {
                aggiungiEntita(new Acqua(i, 681+31, game, tex, this));
            }
            
            for(int i=400;i<=700;i+=31)
            {
                aggiungiEntita(new TerraErba(i, 650, game, tex, this));
            }
            
            aggiungiEntita(new TerraErba(710-31, 650-31, game, tex, this));
            aggiungiEntita(new Terra(710-31, 650, game, tex, this));
            for(int i=710;i<=Gioco.LARGHEZZA*Gioco.SCALA;i+=31)
            {
                aggiungiEntita(new Onda(i, 650, game, tex, this));
            }
            //TerraErbaErba
            aggiungiEntita(new Mattone(150, 620, game, tex, this));
            aggiungiEntita(new Mattone(150+31, 620-31, game, tex, this));
            aggiungiEntita(new Mattone(150+62, 620-62, game, tex, this));
            aggiungiEntita(new Mattone(150+62+31, 620-62, game, tex, this));
            aggiungiEntita(new Mattone(150+62+62, 620-62, game, tex, this));
            aggiungiEntita(new Mattone(150+62+62+31, 620-62, game, tex, this));
            aggiungiEntita(new Mattone(150+62+62+62, 620-62-31, game, tex, this));
            aggiungiEntita(new Mattone(150+62+62+93, 620-62-31, game, tex, this));
            aggiungiEntita(new Mattone(150+62+93+93, 620-62-31, game, tex, this));
            aggiungiEntita(new Mattone(150+93+93+93, 620-62-31, game, tex, this));
            aggiungiEntita(new Mattone(550, 620-31, game, tex, this));
            //Mattoni
            aggiungiEntita(new Mattone(550+31, 620-62, game, tex, this));
            aggiungiEntita(new Mattone(550+62, 620-93, game, tex, this));
            aggiungiEntita(new Mattone(550+93, 620-93-31, game, tex, this));
            aggiungiEntita(new TerraErba(550+93, 620-93-62, game, tex, this));
            aggiungiEntita(new TerraErba(550+93+31, 620-93-62, game, tex, this));
            aggiungiEntita(new TerraErba(550+93+62, 620-93-62, game, tex, this));
            aggiungiEntita(new TerraErba(550+93+93, 620-93-62, game, tex, this));
            aggiungiEntita(new TerraErba(550+93+93+31, 620-93-62, game, tex, this));
            aggiungiEntita(new TerraErba(550+93+93+62, 620-93-62, game, tex, this));
            aggiungiEntita(new TerraErba(550+93+93+93, 620-93-62, game, tex, this));
            aggiungiEntita(new TerraErba(550+93+93+93+31, 620-93-62, game, tex, this));
            
            aggiungiEntita(new Mattone(550+93+93+93+31, 620-93-93-31, game, tex, this));
            aggiungiEntita(new Mattone(550+93+93+93+31, 620-93-93-62, game, tex, this));
            aggiungiEntita(new Mattone(550+93+93+93+31, 620-93-93-93, game, tex, this));
            aggiungiEntita(new Mattone(550+93+93+93+31, 620-93-93-93-31, game, tex, this));
            aggiungiEntita(new Moneta(550+93+93+93+31, 620-93-93-93-31-60, game, tex, this));
            
            aggiungiEntita(new Mattone(850+30+11, 620-310, game, tex, this));
            
            //FINALE
            aggiungiEntita(new Mattone(550+93+93+93, 620-93-93-93-31, game, tex, this));
            aggiungiEntita(new Mattone(550+93+93+62, 620-93-93-93-31, game, tex, this));
            aggiungiEntita(new Mattone(550+93+93+31, 620-93-93-93-31, game, tex, this));
            aggiungiEntita(new TerraErba(550+93+31, 620-93-93-93-31, game, tex, this));
            aggiungiEntita(new Mattone(550+93, 620-93-93-93-31, game, tex, this));
            aggiungiEntita(new TerraErba(550+93, 620-93-93-93-62, game, tex, this));
            //aggiungiEntita(new TerraErba(550+62, 620-93-93-93-31, game, tex, this));
            //aggiungiEntita(new TerraErba(550+31, 620-93-93-93-31, game, tex, this));
            aggiungiEntita(new TerraErba(550, 620-93-93-93-31, game, tex, this));
            //aggiungiEntita(new TerraErba(550-31, 620-93-93-93-31, game, tex, this));
            //aggiungiEntita(new TerraErba(550-62, 620-93-93-93-31, game, tex, this));
            //aggiungiEntita(new TerraErba(550-93, 620-93-93-93-31, game, tex, this));
            
            aggiungiEntita(new TerraErba(550-93-62, 620-93-93-93, game, tex, this));
            aggiungiEntita(new TerraErba(550-93-93, 620-93-93-93, game, tex, this));
            aggiungiEntita(new TerraErba(550-93-93-31, 620-93-93-93, game, tex, this));
            aggiungiEntita(new TerraErba(550-93-93-62, 620-93-93-93, game, tex, this));
            aggiungiEntita(new TerraErba(550-93-93-93, 620-93-93-93, game, tex, this));
            aggiungiEntita(new TerraErba(550-93-93-93-31, 620-93-93-93, game, tex, this));
            aggiungiEntita(new TerraErba(550-93-93-93-62, 620-93-93-93, game, tex, this));
            aggiungiEntita(new TerraErba(550-93-93-93-93, 620-93-93-93, game, tex, this));
            aggiungiEntita(new TerraErba(550-93-93-93-93, 620-93-93-93, game, tex, this));
            aggiungiEntita(new TerraErba(550-93-93-93-93-31, 620-93-93-93, game, tex, this));
            aggiungiEntita(new TerraErba(550-93-93-93-93-62, 620-93-93-93, game, tex, this));
            aggiungiEntita(new TerraErba(550-93-93-93-93-93, 620-93-93-93, game, tex, this));
            aggiungiEntita(new Terra(550-93-93-93-93-93-31, 620-93-93-93, game, tex, this));
            aggiungiEntita(new Mattone(550-93-93-93-93-93-62, 620-93-93-93, game, tex, this));
            aggiungiEntita(new Mattone(550-93-93-93-93-93-93, 620-93-93-93, game, tex, this));
            for(int i=620-93-93-93-31, cont=4; i>0;i-=31, cont++)
            {
                aggiungiEntita(new Terra(550-93-93-93-93-93-31, i, game, tex, this));
                if(cont == 5){
                    aggiungiEntita(new TerraErba(550-93-93-93-93-93, i, game, tex, this));
                    cont=0;
                }
            }
            
            for(int i=620-93-93-93-93-31, cont =2 ; i>150;i-=31)
            {
                aggiungiEntita(new Mattone(550-93-93-93-62, i, game, tex, this));
                if(cont == 2){
                    aggiungiEntita(new TerraErba(550-93-93-93-93, i, game, tex, this));
                    cont=0;
                }
                else cont++;
            }
            aggiungiEntita(new TerraErba(550-93-93-93-31, 620-93-93-93-93-62, game, tex, this));
            aggiungiEntita(new TerraErba(550-93-93-93, 620-93-93-93-93-62, game, tex, this));
            aggiungiEntita(new TerraErba(550-93-93-62, 620-93-93-93-93-62, game, tex, this));
            aggiungiEntita(new TerraErba(550-93-93-31, 620-93-93-93-93-62, game, tex, this));
            aggiungiEntita(new TerraErba(550-93-93, 620-93-93-93-93-62, game, tex, this));
            aggiungiEntita(new TerraErba(550-93-62, 620-93-93-93-93-62, game, tex, this));
            aggiungiEntita(new TerraErba(550-93-31, 620-93-93-93-93-62, game, tex, this));
            aggiungiEntita(new TerraErba(550-93, 620-93-93-93-93-31, game, tex, this));
            aggiungiEntita(new TerraErba(550-62, 620-93-93-93-93, game, tex, this));
            aggiungiEntita(new TerraErba(550-31, 620-93-93-93-62, game, tex, this));
            
            aggiungiEntita(new TerraErba(550-93-31, 620-93-93-93, game, tex, this));
            aggiungiEntita(new Terra(550-93-31, 620-93-93-62, game, tex, this));
            aggiungiEntita(new TerraErba(550-93-31, 620-93-93-31, game, tex, this));
            //aggiungiEntita(new Terra(550-93-31, 620-93-93, game, tex, this));
            
            aggiungiEntita(new TerraErba(550-93, 620-93-93, game, tex, this));
            aggiungiEntita(new TerraErba(550-93, 620-93-93-31, game, tex, this));
            aggiungiEntita(new TerraErba(550-62, 620-93-93, game, tex, this));
            aggiungiEntita(new TerraErba(550-31, 620-93-93, game, tex, this));
            aggiungiEntita(new TerraErba(550, 620-93-93, game, tex, this));
            
            
            aggiungiEntita(new Terra(150+93+93+90, 620-62-(31*5), game, tex, this));
            aggiungiEntita(new Terra(150+93+93+90+31, 620-62-(31*4), game, tex, this));
            
            //aggiungiEntita(new TerraErba(, , game, tex, this));
        }
        else if(livello==2)
        {
            aggiungiEntita(new Marker(850, 520, game, tex, this));
            
            aggiungiEntita(new Nemico(300, 180, game, tex, this));
            
            Gioco.NI = new NemicoInseguitore(-40, 150, game, tex, this);
            
            aggiungiEntita(new Mattone(0-31, 620-93-93-93-31, game, tex, this));
            aggiungiEntita(new Mattone(0, 620-93-93-93-31, game, tex, this));
            aggiungiEntita(new Mattone(0+31, 620-93-93-93-31, game, tex, this));
            aggiungiEntita(new Mattone(0+62, 620-93-93-93-31, game, tex, this));
            aggiungiEntita(new Mattone(0+93, 620-93-93-93-31, game, tex, this));
            aggiungiEntita(new Mattone(0+93, 620-93-93-93-31, game, tex, this));
            aggiungiEntita(new Mattone(0+93+31, 620-93-93-93-31, game, tex, this));
            aggiungiEntita(new Mattone(0+93+62, 620-93-93-93-31, game, tex, this));
            aggiungiEntita(new Mattone(0+93+62, 620-93-93-93, game, tex, this));
            aggiungiEntita(new Mattone(0+93+62, 620-93-93-62, game, tex, this));
            aggiungiEntita(new Mattone(0+93+62, 620-93-93-31, game, tex, this));
            aggiungiEntita(new Mattone(0+93+93, 620-93-93-31, game, tex, this));
            
            aggiungiEntita(new TerraErba(0, 620, game, tex, this));
            aggiungiEntita(new TerraErba(0+31, 620, game, tex, this));
            aggiungiEntita(new TerraErba(0+62, 620, game, tex, this));
            aggiungiEntita(new TerraErba(0+93, 620, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+31, 620, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+62, 620, game, tex, this));
            for(int i=93+62+31;i<750;i+=31)
            {
                aggiungiEntita(new Onda(i, 620, game, tex, this));
            }
            for(int i=0;i<900;i+=31)
            {
                for(int j=620+31;j<750;j+=31)
                {
                    aggiungiEntita(new Acqua(i, j, game, tex, this));
                }
            }
            //Rialzamento iniziale giù
            aggiungiEntita(new Terra(0, 620-31, game, tex, this));
            aggiungiEntita(new Terra(0, 620-62, game, tex, this));
            aggiungiEntita(new Terra(0, 620-93, game, tex, this));
            aggiungiEntita(new Terra(0, 620-93-31, game, tex, this));
            aggiungiEntita(new Mattone(0+31, 620-62, game, tex, this));
            aggiungiEntita(new Mattone(0+31+38, 620-93+10, game, tex, this));
            aggiungiEntita(new Mattone(0+31+45+31, 620-93-10, game, tex, this));
            aggiungiEntita(new Terra(0, 620-93-62, game, tex, this));
            aggiungiEntita(new TerraErba(0, 620-93-93, game, tex, this));
            
            //Avanzamento giù destra ponte sopra l'acqua 
            aggiungiEntita(new TerraErba(0+93+93, 620-31, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+31, 620-31, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+62, 620-62, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+93, 620-62, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+93+31, 620-62-31, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+93+62, 620-62-31, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+93+93, 620-62-31, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+93+93+31, 620-62-31, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+93+93+62, 620-62-31, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+93+93+93, 620-62-31, game, tex, this));
            
            //Mattoni in alto mezzo
            aggiungiEntita(new Mattone(0+93+93+93+93+93, 620-93-31, game, tex, this));
            aggiungiEntita(new Mattone(0+93+93+93+93+93+31, 620-93-62, game, tex, this));
            aggiungiEntita(new Mattone(0+93+93+93+93+93+62, 620-93-93, game, tex, this));
            aggiungiEntita(new Mattone(0+93+93+93+93+93+93, 620-93-93-31, game, tex, this));
            aggiungiEntita(new Terra(0+93+93+93+93+93+93+31, 620-93-93-62, game, tex, this));
            aggiungiEntita(new Terra(0+93+93+93+93+93+93+31, 620-93-93-31, game, tex, this));
            aggiungiEntita(new Terra(0+93+93+93+93+93+93+31, 620-93-93-93, game, tex, this));
            aggiungiEntita(new Terra(0+93+93+93+93+93+93+31, 620-93-93-93-31, game, tex, this));
            aggiungiEntita(new Terra(0+93+93+93+93+93+93+31, 620-93-93-93-62, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+93+93+93+93+31, 620-93-93-93-93, game, tex, this));
            aggiungiEntita(new Terra(0+93+93+93+93+93+93+62, 620-93-93-62, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+93+93+93+93+62, 620-93-93-93, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+93+93+93+93+93, 620-93-93-31, game, tex, this));
            aggiungiEntita(new Terra(0+93+93+93+93+93+93+62, 620-93-93-31, game, tex, this));
            //aggiungiEntita(new Terra(0+93+93+93+93+93+93+93, 620-93-93-31, game, tex, this));
            aggiungiEntita(new Mattone(0+93+93+93+93+93+93+93+31, 620-93-62, game, tex, this));
            aggiungiEntita(new Mattone(0+93+93+93+93+93+93+93, 620-93-93, game, tex, this));
            aggiungiEntita(new Mattone(0+93+93+93+93+93+93+93, 620-93-62, game, tex, this));
            aggiungiEntita(new Mattone(0+93+93+93+93+93+93+93+31, 620-93-31, game, tex, this));
            aggiungiEntita(new Mattone(0+93+93+93+93+93+93+93+62, 620-93, game, tex, this));
            aggiungiEntita(new Mattone(0+93+93+93+93+93+93+93+93, 620-62, game, tex, this));
            aggiungiEntita(new Mattone(0+93+93+93+93+93+93+93+93+31, 620-31, game, tex, this));
            
            //Piattaforma metà verso destra centro
            aggiungiEntita(new TerraErba(0+93+93+93+93+93, 620-93-93-62-31, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+93+93+62, 620-93-93-62-31, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+93+93+31, 620-93-93-62-31, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+93+93, 620-93-93-62-31, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+93+62, 620-93-93-62-31, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+93+31, 620-93-93-62-31, game, tex, this));
            aggiungiEntita(new Terra(0+93+93+93, 620-93-93-62-62, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+93, 620-93-93-62-93, game, tex, this));
            aggiungiEntita(new Terra(0+93+93+62, 620-93-93-93-93, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+62, 620-93-93-93-93-31, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+31, 620-93-93-93-93-62, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93, 620-93-93-93-93-62, game, tex, this));
            
            //Pedana alta sinistra
            aggiungiEntita(new Mattone(0, 620-93-93-93-93-93-62, game, tex, this));
            aggiungiEntita(new Mattone(0, 620-93-93-93-93-93-93, game, tex, this));
            aggiungiEntita(new Mattone(0, 620-93-93-93-93-93-93-31, game, tex, this));
            aggiungiEntita(new Mattone(0, 620-93-93-93-93-93-93-62, game, tex, this));
            
            aggiungiEntita(new Mattone(0, 620-93-93-93-93-93-31, game, tex, this));
            aggiungiEntita(new Mattone(0+31, 620-93-93-93-93-93-31, game, tex, this));
            aggiungiEntita(new Mattone(0+62, 620-93-93-93-93-93-31, game, tex, this));
            aggiungiEntita(new Mattone(0+93, 620-93-93-93-93-93-31, game, tex, this));
            
            //Pedada alta verso destra
            aggiungiEntita(new Mattone(0+93+93+93+93, 620-93-93-93-93-31, game, tex, this));
            aggiungiEntita(new Mattone(0+93+93+93+93+31, 620-93-93-93-93-31, game, tex, this));
            aggiungiEntita(new Mattone(0+93+93+93+93+62, 620-93-93-93-93-31, game, tex, this));
            aggiungiEntita(new Mattone(0+93+93+93+93+93, 620-93-93-93-93-31, game, tex, this));
            
            //Pedana alta destra destra
            aggiungiEntita(new TerraErba(0+93+93+93+93+93+93+93+93, 620-93-93-93-31, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+93+93+93+93+93+93+31, 620-93-93-93-31, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+93+93+93+93+93+93+62, 620-93-93-93-31, game, tex, this));
            aggiungiEntita(new Terra(0+93+93+93+93+93+93+93+93+62+31, 620-93-93-93-31, game, tex, this));
            aggiungiEntita(new Terra(0+93+93+93+93+93+93+93+93+93, 620-93-93-93-62, game, tex, this));
            aggiungiEntita(new Terra(0+93+93+93+93+93+93+93+93+93, 620-93-93-93-93, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+93+93+93+93+93+93+93, 620-93-93-93-93-31, game, tex, this));
            
            aggiungiEntita(new Terra(0+93+93+93+93+93+93+93+93+31, 620, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+93+93+93+93+93+93+62, 620, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+93+93+93+93+93+93+93, 620, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+93+93+93+93+93+93+93+31, 620, game, tex, this));
            aggiungiEntita(new TerraErba(0+93+93+93+93+93+93+93+93+93+62, 620, game, tex, this));
            
            //Monete
            //aggiungiEntita(new Moneta(40+15, 500, game, tex, this));
            aggiungiEntita(new Moneta(40+31, 480, game, tex, this));
            aggiungiEntita(new Moneta(40+31+15, 80, game, tex, this));
            //aggiungiEntita(new Moneta(40+31-35, 80, game, tex, this));
            aggiungiEntita(new Moneta(40+93+62, 250, game, tex, this));
            
            aggiungiEntita(new Moneta(40+31+15+690, 80+180, game, tex, this));
            aggiungiEntita(new Moneta(40+31+15+597, 80+180+190-30, game, tex, this));
            
            aggiungiEntita(new Moneta(350, 300, game, tex, this));
            aggiungiEntita(new Moneta(400, 175, game, tex, this));
            
            aggiungiEntita(new Moneta(40+93+62+100+35, 250+200+20, game, tex, this));
            aggiungiEntita(new Moneta(40+93+62+100+35+125, 250+180, game, tex, this));
            aggiungiEntita(new Moneta(40+93+62+100+35+125+85, 250+180-85, game, tex, this));
        }
        else if(livello==3)
        {
            aggiungiEntita(new Marker(850, 110, game, tex, this));
            
            aggiungiEntita(new Mattone(-15, 650-31, game, tex, this));
            
            for(int i=0;i<850;i+=31) {
                aggiungiEntita(new Acqua(i, 650+31, game, tex, this));
            }
            for(int i=0;i<850;i+=31) {
                aggiungiEntita(new Acqua(i, 650+62, game, tex, this));
            }
            for(int i=450+15;i<850;i+=31) {
                aggiungiEntita(new Onda(i, 650, game, tex, this));
            }
            for(int i=0;i<=450;i+=31)
            {
                aggiungiEntita(new TerraErba(i, 650, game, tex, this));
            }
            aggiungiEntita(new TerraErba(465, 650-31, game, tex, this));
            aggiungiEntita(new TerraErba(465+31, 650-62, game, tex, this));
            aggiungiEntita(new TerraErba(465+62, 650-62, game, tex, this));
            aggiungiEntita(new TerraErba(465+93, 650-62, game, tex, this));
            aggiungiEntita(new TerraErba(465+93+31, 650-93, game, tex, this));
            aggiungiEntita(new TerraErba(465+93+62, 650-93, game, tex, this));
            aggiungiEntita(new TerraErba(465+93+93, 650-93, game, tex, this));
            aggiungiEntita(new TerraErba(465+93+93+31, 650-93, game, tex, this));
            aggiungiEntita(new TerraErba(465+93+93+62, 650-93+31, game, tex, this));
            aggiungiEntita(new TerraErba(465+93+93+93, 650-93+31, game, tex, this));
            aggiungiEntita(new TerraErba(465+93+93+93+31, 650-93, game, tex, this));
            aggiungiEntita(new TerraErba(465+93+93+93+62, 650-93-31, game, tex, this));
            
            aggiungiEntita(new Mattone(465+93+93+93+93, 650-93-62, game, tex, this));
            
            for(int i=750; i>200;i-=31) {
                aggiungiEntita(new Terra(465+93+93+93+93+31, i, game, tex, this));
            }
            for(int i=750; i>200;i-=31) {
                aggiungiEntita(new Terra(465+93+93+93+93+31+31, i, game, tex, this));
            }
            
            aggiungiEntita(new Mattone(465+93+93+93, 650-93-93-31, game, tex, this));
            aggiungiEntita(new Mattone(465+93+93+62, 650-93-93-62, game, tex, this));
            aggiungiEntita(new Mattone(465+93+93+31, 650-93-93-93, game, tex, this));
            aggiungiEntita(new Mattone(465+93+93, 650-93-93-93-31, game, tex, this));
            aggiungiEntita(new Mattone(465+93+62, 650-93-93-93-31, game, tex, this));
            aggiungiEntita(new Mattone(465+93+31, 650-93-93-93-31, game, tex, this));
            aggiungiEntita(new Mattone(465+93, 650-93-93-93-31, game, tex, this));
            
            
            aggiungiEntita(new TerraErba(450, 450, game, tex, this));
            aggiungiEntita(new TerraErba(450-31, 450, game, tex, this));
            
            
            aggiungiEntita(new TerraErba(450-93-31, 450-31, game, tex, this));
            aggiungiEntita(new TerraErba(450-93-31-31, 450-31, game, tex, this));
            
            aggiungiEntita(new TerraErba(450-93-93-31, 450+31, game, tex, this));
            
            aggiungiEntita(new TerraErba(450-93-93-93-31, 450+62, game, tex, this));
            
            for(int i=450; i>0;i-=31) {
                aggiungiEntita(new Mattone(10, i, game, tex, this));
            }
            for(int i=450; i>0;i-=31) {
                aggiungiEntita(new Mattone(-21, i, game, tex, this));
            }
            
            aggiungiEntita(new Mattone(41, 450-62, game, tex, this));
            aggiungiEntita(new Mattone(41, 450-31, game, tex, this));
            aggiungiEntita(new Mattone(41, 450, game, tex, this));
            aggiungiEntita(new Mattone(41+31, 450, game, tex, this));
            
            for(int i=330; i>200;i-=31) {
                aggiungiEntita(new Mattone(160, i, game, tex, this));
            }
            
            aggiungiEntita(new Mattone(160-31, 330, game, tex, this));
            
            
            aggiungiEntita(new Mattone(41, 450-180, game, tex, this));
            
            
            aggiungiEntita(new Mattone(160-31, 330-124, game, tex, this));
            
            for(int i=10; i<950;i+=31) {
                aggiungiEntita(new Mattone(i, 15, game, tex, this));
            }
            for(int i=10; i<950;i+=31) {
                aggiungiEntita(new Mattone(i, 15+31, game, tex, this));
            }
            
            //aggiungiEntita(new TerraErba(200, 280, game, tex, this));
            //aggiungiEntita(new TerraErba(200+31, 280, game, tex, this));
            aggiungiEntita(new TerraErba(200+62, 280, game, tex, this));
            aggiungiEntita(new TerraErba(200+93, 280, game, tex, this));
            aggiungiEntita(new TerraErba(200+93+93, 280-31, game, tex, this));
            aggiungiEntita(new TerraErba(200+93+93+31, 280-31, game, tex, this));
            
            for(int i=480;i<950;i+=31) {
                aggiungiEntita(new Mattone(i, 280-62, game, tex, this));
            }
            aggiungiEntita(new TerraErba(480, 280-93, game, tex, this));
            aggiungiEntita(new TerraErba(480+190, 280-93, game, tex, this));
            aggiungiEntita(new TerraErba(480+190+150, 280-93, game, tex, this));
            
            //Nemici
            Gioco.NI = new NemicoInseguitore(-40, 550, game, tex, this);
            aggiungiEntita(new Nemico(600, 135, game, tex, this));
            aggiungiEntita(new Nemico(720, 135, game, tex, this));
            aggiungiEntita(new Nemico(700, 500, game, tex, this));
            //aggiungiEntita(new NemicoMedio(700, 270, game, tex, this));
            aggiungiEntita(new Nemico(250, 580, game, tex, this));
            
            //Monete
            aggiungiEntita(new Moneta(100, 600, game, tex, this));
            aggiungiEntita(new Moneta(300+15, 510-150, game, tex, this));
            aggiungiEntita(new Moneta(420, 600, game, tex, this));
            aggiungiEntita(new Moneta(800, 420, game, tex, this));
            aggiungiEntita(new Moneta(460, 360, game, tex, this));
            aggiungiEntita(new Moneta(135, 275, game, tex, this));
            aggiungiEntita(new Moneta(90-40, 85, game, tex, this));
            aggiungiEntita(new Moneta(170+110, 180+70, game, tex, this));
            aggiungiEntita(new Moneta(585, 185, game, tex, this));
            aggiungiEntita(new Moneta(585+160, 185, game, tex, this));
            
        }
        else if(livello==4) {
            //Superiore
            for(int i=0; i<900;i+=31) {
                aggiungiEntita(new Mattone(i, 15, game, tex, this));
            }
            for(int i=0; i<900;i+=31) {
                aggiungiEntita(new Mattone(i, 15+31, game, tex, this));
            }
            
            //Inferiore
            for(int i=0;i<900;i+=31) {
                aggiungiEntita(new Mattone(i, 280-62, game, tex, this));
            }
            for(int i=0;i<900;i+=31) {
                for(int j=280-31;j<750;j+=31) {
                    aggiungiEntita(new Terra(i, j, game, tex, this));
                }
            }
            for(int i=100;i<730;i+=31) {
                aggiungiEntita(new Mattone(i, 500, game, tex, this));
            }
            for(int i=100;i<730-31;i+=31) {
                aggiungiEntita(new Mattone(i, 500-31, game, tex, this));
            }
            for(int i=100;i<730-31;i+=31) {
                aggiungiEntita(new Mattone(i, 500+31, game, tex, this));
            }
            for(int i=0;i<200;i+=31) {
                aggiungiEntita(new Mattone(503+i, 285+i, game, tex, this));
            }
            for(int i=186, j=0;i>0;i-=31, j+=31) {
                aggiungiEntita(new Mattone(530+j, 285+215+i, game, tex, this));
            }
            
            //Monete
            for(int i = 0; i<10;i++) {
                aggiungiEntita(new Moneta(120+(75*i), 100, game, tex, this));
            }
        }
        
    }
    
    
    public void aggiorna() {
        //CLasse A
        for(int i=0; i < ea.size(); i++) {
           enta = ea.get(i);
           
           enta.aggiorna();
        }
        
        //Classe B
        for(int i=0; i < eb.size(); i++) {
           entb = eb.get(i);
           
           entb.aggiorna();
        }
        
        //Classe C
        for(int i=0; i < ec.size(); i++) {
           entc = ec.get(i);
               
           entc.aggiorna();
           //Gioco.collisione = 1;
        }
        
        //Classe D
        for(int i=0; i < ed.size(); i++) {
           entd = ed.get(i);
           
           entd.aggiorna();
        }
        
        //Classe G
        for(int i=0; i < eg.size(); i++) {
           entg = eg.get(i);
           
           entg.aggiorna();
        }
        
        //Classe M
        for(int i=0; i < em.size(); i++) {
           entm = em.get(i);
           
           entm.aggiorna();
        }
    }
    
    public void disegna(Graphics g) {
        //Classe A
        for(int i=0; i < ea.size(); i++) {
           enta = ea.get(i);
           
           enta.disegna(g);
        }
        
        //Classe B
        for(int i=0; i < eb.size(); i++) {
           entb = eb.get(i);
           
           entb.disegna(g);
        }
        
        //Classe C
        for(int i=0; i < ec.size(); i++) {
           entc = ec.get(i);
           
           entc.disegna(g);
        }
        
        //Classe D
        for(int i=0; i < ed.size(); i++) {
           entd = ed.get(i);
           
           entd.disegna(g);
        }
        
        //Classe G
        for(int i=0; i < eg.size(); i++) {
           entg = eg.get(i);
           
           entg.disegna(g);
        }
        
        //Classe M
        for(int i=0; i < em.size(); i++) {
           entm = em.get(i);
           
           entm.disegna(g);
        }
    }
    
    
    public void rimuoviEntita(EntitaA p) {
        ea.remove(p);
    }
    
    public void rimuoviEntita(EntitaB p) {
        eb.remove(p);
    }
    
    public void rimuoviEntita(EntitaC p) {
        ec.remove(p);
    }
    
    public void rimuoviEntita(EntitaD p) {
        ed.remove(p);
    }
    
    public void rimuoviEntita(EntitaG p) {
        eg.remove(p);
    }
    
    public void rimuoviEntita(EntitaM p) {
        em.remove(p);
    }
    
    
    
    
    public void aggiungiEntita(EntitaB p) {
        eb.add(p);
    }
    
    public void aggiungiEntita(EntitaA p) {
        ea.add(p);
    }
    
    public void aggiungiEntita(EntitaC p) {
        ec.add(p);
    }
    
    public void aggiungiEntita(EntitaD p) {
        ed.add(p);
    }
    
    public void aggiungiEntita(EntitaG p) {
        eg.add(p);
    }
    
    public void aggiungiEntita(EntitaM p) {
        em.add(p);
    }
    
    
    
    
    
    
    
    
    public LinkedList<EntitaA> getEntitaA(){
        return ea;
    }
    
    public LinkedList<EntitaB> getEntitaB(){
        return eb;
    }
    public LinkedList<EntitaC> getEntitaC(){
        return ec;
    }
    public LinkedList<EntitaD> getEntitaD(){
        return ed;
    }
    public LinkedList<EntitaG> getEntitaG(){
        return eg;
    }
    public LinkedList<EntitaM> getEntitaM(){
        return em;
    }
}
