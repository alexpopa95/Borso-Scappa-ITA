
package game;

import classi.EntitaG;
import static game.Gioco.ALTEZZA;
import static game.Gioco.LARGHEZZA;
import static game.Gioco.SCALA;
import static game.Gioco.altezzaGiocatore;
import static game.Gioco.altezzaTerra;
import static game.Gioco.livello;
import static game.Gioco.sto_saltando;
import static game.Gioco.sto_atterrando;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import librerie.Animazione;

/**
 *
 * @author alexpopa95
 */
public class Giocatore extends OggettoGioco implements EntitaG{
    
    int time = 0;
    double velX = 0;
    private double velY = 0;
    private final double velSalto = 4;
    private final double velCaduta = 4;
    private static final double altezzaSalto = 75;
    private double backupAlt;
    Gioco game;
    private double backupX, backupY;
    
    private final Textures tex;
    
    BufferedImage salto;
    BufferedImage caduta;
    BufferedImage saltoSinistra;
    BufferedImage cadutaSinistra;
    BufferedImage posto, postoSX;
    Animazione destra, sinistra;
    Controller c;
    
    
    public Giocatore(double x, double y, Textures tex, Gioco game, Controller c) {
        super(x, y);
        this.tex = tex;
        this.game=game;
        this.c = c;
        
        posto = tex.giocatore[1];
        postoSX = tex.giocatore_girato[1];
        salto = tex.giocatore[0];
        caduta = tex.giocatore[0];
        saltoSinistra = tex.giocatore_girato[0];
        cadutaSinistra = tex.giocatore_girato[0];
        destra = new Animazione(5, tex.giocatore[0], tex.giocatore[1], tex.giocatore[2], tex.giocatore[1]);
        sinistra = new Animazione(5, tex.giocatore_girato[0], tex.giocatore_girato[1], tex.giocatore_girato[2], tex.giocatore_girato[1]);
    }
    
    @Override
    public void aggiorna(){
        /*
        //Se non c'è collisione
        if(!Physics.nonPasso(this, game.ec)){
            x+=velX;
            //Se sta saltando
            if(Gioco.sto_saltando) {
                System.out.println("Sto Saltando!");
                if(y>Gioco.altezzaGiocatore-altezzaSalto) {
                    y-=velSalto;
                }
                else {
                    Gioco.sto_saltando=false;
                    Gioco.sto_atterrando=true;
                    y+=0.005;
                    //Niente collisione
                    if(!Physics.nonPasso(this, game.ec)) {
                        Gioco.sto_atterrando=true;
                        Gioco.altezzaGiocatore=Gioco.altezzaTerra;
                        
                    }
                    //Collisione
                    else
                        y-=0.005;
                }
            }
            //Se sta atterrando
            else if(Gioco.sto_atterrando) {
                if(y<=Gioco.altezzaGiocatore) {
                    y+=velSalto;
                    System.out.println("Sto Atterrando!");
                }
                else
                    Gioco.sto_atterrando=false;
            }
        }
        //Se c'è collisione
        else
        {
            if(Gioco.sto_atterrando) {
                Gioco.altezzaGiocatore = Gioco.altezzaGiocatore-32;
                Gioco.sto_atterrando=false;
                y=Gioco.altezzaGiocatore;
                System.out.println("AltezzaGiocatore: "+Gioco.altezzaGiocatore);
            }
            else {
                System.out.println("AltezzaTerra: "+Gioco.altezzaTerra);
                x-=0.1;
            }
        }
        */
        
        
        backupX = x; 
        backupY = y;
       
        x+=velX;
        if(Physics.nonPasso(this, game.ec)) {
            x=backupX;
        }
        
        //--------------------------------------
        y+=0.1;
        if(Physics.nonPasso(this, game.ec)) {
            y=backupY;
        }
        else {
            y=backupY;
            if(!sto_saltando && !sto_atterrando) backupAlt = altezzaGiocatore;
            altezzaGiocatore = ALTEZZA*SCALA-63;
            if(y<altezzaGiocatore) {
                sto_atterrando = true;
            }
        }
        //--------------------------------------
        
        if(sto_saltando) {
            if(y<=0)
            {
                sto_saltando=false;
                sto_atterrando=true;
            }
            if(y>backupAlt-altezzaSalto) {
                sto_atterrando = false;
                y-=velSalto;
                if(Physics.nonPasso(this, game.ec)) {
                    y+=velSalto;
                    sto_saltando=false;
                    sto_atterrando=true;
                }
            }
            else {
                sto_saltando=false;
                sto_atterrando=true;
            }
        }
        else if(sto_atterrando) {
            if(y<=backupAlt) {
                y+=velCaduta;
                if(Physics.nonPasso(this, game.ec)) {
                    y=backupY;
                    altezzaGiocatore = y;
                    sto_atterrando = false;
                }
            }
            else {
                sto_atterrando=false;
            }
        }
        
        time -= 15;
        if(Physics.controNemico(this, game.eb)) {
            Gioco.vita_giocatore-=5;
            if(time <= 0) {
                game.audioPantera();
                time = 400;
            }
        }
        if(livello<4){
            if(Physics.controPapa(this, Gioco.NI)) {
                Gioco.vita_giocatore-=10;
            }
        }
        
        if(Gioco.vita_giocatore<=0) Gioco.State = Gioco.STATE.OVER;
        //System.out.println("Vita: "+Gioco.vita_giocatore);
        
        if(x>120 && !Gioco.insegui) Gioco.insegui=true;
        
        if(x <= 0)
            x=0;
        if(x > (LARGHEZZA*SCALA)-40)
            x=(LARGHEZZA*SCALA)-40;
        if(y <= 0)
            y=0;
        if(y >= (altezzaGiocatore))
            y=(altezzaGiocatore);
        
        if(!Gioco.sto_saltando) {
            destra.avviaAnimazione();
            sinistra.avviaAnimazione();
        }
        if(this.y>=Gioco.ALTEZZA*Gioco.SCALA-63) Gioco.State = Gioco.STATE.OVER;
        
        if(!Gioco.miMuovo) if(!Gioco.sto_saltando && !Gioco.sto_atterrando) Gioco.fermoGiocatore=true;
    }
    
    @Override
    public void disegna(Graphics g){
        if(Gioco.fermoGiocatore) {
            if(!Gioco.sto_saltando && !Gioco.sto_atterrando){
                if(Gioco.versoDestraGiocatore) {
                    g.drawImage(posto, (int)x, (int)y, game);
                }
                else {
                    g.drawImage(postoSX, (int)x, (int)y, game);
                }
            }
        }
        else if(Gioco.versoDestraGiocatore) {
            if(Gioco.sto_saltando)
                g.drawImage(salto, (int) x, (int) y, game);
            else if(Gioco.sto_atterrando)
                g.drawImage(caduta, (int) x, (int) y, game);
            else
                destra.disegnaAnimazione(g, x, y, 0);
        }
        else {
            if(Gioco.sto_saltando)
                g.drawImage(saltoSinistra, (int) x, (int) y, game);
            else if(Gioco.sto_atterrando)
                g.drawImage(cadutaSinistra, (int) x, (int) y, game);
            else
                sinistra.disegnaAnimazione(g, x, y, 0);
        }
            
    }
    
    @Override
    public Rectangle getBordi(){
        return new Rectangle((int)x, (int)y, 35, 48);
    }
    
    @Override
    public double getX(){
        return x;
    }
    
    @Override
    public double getY() {
        return y;
    }
    
    public void setVelX(double vel) {
        velX=vel;
    }
    
    public void setVelY(double vel) {
        velY=vel;
    }
    
    public void setX(double x) {
        this.x=x;
    }
    
    public void setY(double y) {
        this.y=y;
    }
    
    public void setVita(int v) {
        Gioco.vita_giocatore = v;
    }
}
