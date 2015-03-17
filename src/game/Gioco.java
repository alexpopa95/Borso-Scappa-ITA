 /**
 * Popa George Alexandru 4G
 * 
 * Gioco Java Jungle Runner
 * 
 * Ultima modifica: 9/03/2014
 * 
 */


package game;

import classi.EntitaA;
import classi.EntitaB;
import classi.EntitaC;
import classi.EntitaD;
import classi.EntitaG;
import classi.EntitaM;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

/**
 *
 * @author alexpopa95
 */
public class Gioco extends Canvas implements Runnable, KeyListener {
    
    protected static final int LARGHEZZA = 300;
    public static final int ALTEZZA = 240;
    public static final int SCALA = 3;
    
    public final String TITOLO = "Borso scappa (ITALIANO)";
    public static boolean corniceAttivata = false; //setUNDECORATED
    
    static boolean running = false;
    static Thread thread;
    
    
    private final BufferedImage immagine = new BufferedImage(LARGHEZZA*SCALA+20, ALTEZZA*SCALA+20, BufferedImage.TYPE_INT_RGB);
    private Immagini immagini;
    private URLs urls;
    private BufferedImage spriteSheetGamers = null;
    private BufferedImage spriteSheetTextures = null;
    private BufferedImage sfondo = null;
    
    private boolean audioPartito = false;
    private boolean musicaPartita = false;
    
    private boolean sto_sparando = false;
    public static boolean sto_saltando = false;
    public static boolean sto_atterrando = false;
    private final boolean per_terra = true;
    static boolean miMuovo=false;
    
    public static int munizioni = 10;
    public static int backupMunizioni=10;
    
    private boolean dxsxpremuto = false;
    
    public static boolean versoDestraGiocatore = true;
    public static boolean fermoGiocatore = true;
    public static int livello;
    public final int livelli = 4;
    public static int uccisioni = 0;
    static int monete = 0;
    static int moneteLivello;
    private int tmpmonete;
    public static boolean insegui = false;
    public static boolean seminato1 = false;
    public static boolean seminato2 = false;
    public static boolean seminato3 = false;
    
    public static int vita_giocatore = 100;
    private boolean messaggioMonete = false;
    
    public static int collisione = 0;
    public static double altezzaTerra = 380-32-1;
    public static double altezzaGiocatore = altezzaTerra;
    public static double altezzaNemico = altezzaTerra;
    private final double velox = 2.5;
    public static boolean versoDestraNemico;
    
    public static Giocatore giocatore;
    public static Controller c;
    public static Textures tex;
    private Menu menu;
    private GameOver over;
    private GiocoFinito end;
    private FinestraInfo info;
    private Musica musica;
    
    public static LinkedList<EntitaA> ea;
    public static LinkedList<EntitaB> eb;
    public static LinkedList<EntitaC> ec;
    public static LinkedList<EntitaD> ed;
    public static LinkedList<EntitaG> eg;
    public static LinkedList<EntitaM> em;
    public static NemicoInseguitore NI;
    

    public Gioco() {        
        immagini = new Immagini();
        urls = new URLs();
        musica = new Musica();
            /*background = new BufferedImageLoader().caricaImmagine("/immagini/background.jpg");
            background2 = new BufferedImageLoader().caricaImmagine("/immagini/background2.jpg");
            background3 = new BufferedImageLoader().caricaImmagine("/immagini/background3.jpg");
            pulsanteAvanti = new BufferedImageLoader().caricaImmagine("/immagini/pulsanteAvanti.png");
            pulsanteRiprova = new BufferedImageLoader().caricaImmagine("/immagini/pulsanteRiprova.png");
            pulsanteRiprendi = new BufferedImageLoader().caricaImmagine("/immagini/PulsanteRiprendi.png");
            pulsanteInizia = new BufferedImageLoader().caricaImmagine("/immagini/pulsanteInizia.png");*/
            
            /*
            background = new BufferedImageLoader().caricaImmagine((System.getProperty("user.dir")+"/immagini/background.jpg").substring(0));
            background2 = new BufferedImageLoader().caricaImmagine((System.getProperty("user.dir")+"/immagini/background2.jpg").substring(0));
            background3 = new BufferedImageLoader().caricaImmagine((System.getProperty("user.dir")+"/immagini/background3.jpg").substring(0));
            pulsanteAvanti = new BufferedImageLoader().caricaImmagine((System.getProperty("user.dir")+"/immagini/pulsanteAvanti.png").substring(0));
            pulsanteRiprova = new BufferedImageLoader().caricaImmagine((System.getProperty("user.dir")+"/immagini/pulsanteRiprova.png").substring(0));
            pulsanteRiprendi = new BufferedImageLoader().caricaImmagine((System.getProperty("user.dir")+"/immagini/PulsanteRiprendi.png").substring(0));
            pulsanteInizia = new BufferedImageLoader().caricaImmagine((System.getProperty("user.dir")+"/immagini/pulsanteInizia.png").substring(0));
            */
    }
    
    public static enum STATE {
        MENU,
        GAME,
        OVER,
        END,
        INFO
    };
    
    public static STATE State = STATE.MENU;
    
    
    public void inizializza(int level) {
        
        livello = level;
        
        requestFocus();
        
        BufferedImageLoader loader = new BufferedImageLoader();
        try {
            spriteSheetGamers = loader.caricaImmagine("/64x64.png");
            spriteSheetTextures = loader.caricaImmagine("/32x32.png");
            sfondo = loader.caricaImmagine("/sfondo/sfondo"+level+".png");
        } catch (IOException ex) {
            Logger.getLogger(Gioco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tex = new Textures(this);
        
        
        c = new Controller(this, tex, livello);
        
        giocatore = new Giocatore(30, 530, tex, this, Gioco.c);
        sto_saltando=false;
        
        menu = new Menu();
        over = new GameOver();
        end = new GiocoFinito();
        info = new FinestraInfo();
        
        ea = c.getEntitaA();
        eb = c.getEntitaB();
        ec = c.getEntitaC();
        ed = c.getEntitaD();
        eg = c.getEntitaG();
        em = c.getEntitaM();
        
        
        seminato1=false;
        seminato2=false; 
        seminato3 = false;
        
        munizioni = backupMunizioni;
        
        moneteLivello = 0;
        
        this.addKeyListener(new KeyInput(this));
        this.addMouseListener(new MouseInput(this));
    }
    
    private synchronized void start(){
        if(running)
            return;
        
        running=true;
        thread = new Thread(this);
        thread.start();
    }
    
    synchronized void stop(){
        if(!running)
            return;
        
        running = false;
        try {
            System.out.println("Finito!");
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Gioco.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(1);
    }
    
    @Override
    public void run() {
        livello=1;
        inizializza(livello);
        //giocatore.setY(150);
        //giocatore.setX(10);
        long lastTime = System.nanoTime();
        final double numeroAggiornamenti = 60.0;
        double ns = 1000000000 / numeroAggiornamenti;
        double delta = 0;
        int aggiornamenti = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();
        
        while(running)
        {
            //Game LOOP
            long now = System.nanoTime();
            delta+= (now - lastTime) / ns;
            lastTime=now;
            if(delta>=1) {
                aggiorna();
                aggiornamenti++;
                delta--;
            }
            disegna();
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000) {
                timer+=1000;
                //System.out.println("Aggiornamenti : "+aggiornamenti+"  Fps: "+frames);
                aggiornamenti = 0;
                frames = 0;
            }
        }
        stop();
    }
    
    private void aggiorna() {
        if(State == STATE.GAME){
            giocatore.aggiorna();
            c.aggiorna();
            if(livello<4) NI.aggiorna();
            
            //Verifica Livello:
            /*if(giocatore.x == 0)
                if(livello>1){
                    livello--;
                    System.out.println("Livello: "+livello);
                    inizializza(livello);
                    insegui=false;
                    giocatore.setX(LARGHEZZA*SCALA-(64+1));
                    if(livello==1)
                        giocatore.setY(150);
                    versoDestraGiocatore=false;
                    if(sto_saltando){
                        sto_saltando=false;
                        sto_atterrando=true;
                    }
                }*/
            if(giocatore.x >= LARGHEZZA * SCALA -40){
                if(moneteLivello==10) {
                    if(livello<livelli) {
                        livello++;
                        munizioni+=5;
                        backupMunizioni = munizioni;
                        munizioni+=5;
                        monete+=moneteLivello;
                        //System.out.println("Livello: "+livello);
                        inizializza(livello);
                        insegui=false;
                        giocatore.setX(1);
                        if(livello==2)
                        {
                            giocatore.setY(180);
                        }
                        if(livello==4)
                        {
                            giocatore.setY(120);
                        }
                        versoDestraGiocatore=true;
                        if(sto_saltando){
                            sto_saltando=false;
                            sto_atterrando=true;
                        }
                    }
                    else if(livello == 4) {
                        State = STATE.END;
                    }
                }
                else {
                    messaggioMonete=true;
                }
            }
            if(giocatore.x < LARGHEZZA * SCALA -75)
                messaggioMonete=false;
        }
    }
    
    private void disegna() {
        SpriteSheet bg = new SpriteSheet(sfondo);
        BufferedImage imgBg;
        BufferStrategy buffer = this.getBufferStrategy();
        if(buffer==null)
        {
            createBufferStrategy(2);
            return;
        }
        Graphics g = buffer.getDrawGraphics();
        ///////////////////// /////////////////
        
        g.drawImage(immagine, 0, 0, getWidth(), getHeight(), this);
        //g.setColor(Color.cyan);
        //g.fillRect(0, 0, LARGHEZZA*SCALA+20, ALTEZZA*SCALA+20);
        //g.drawImage(background, 0, 0, this);
        
        
        if(State == STATE.GAME){
            if(!musicaPartita) { musica.play(); musicaPartita = true; }
            audioPartito=false;
            g.setColor(Color.cyan);
            //g.fillRect(0, 0, LARGHEZZA*SCALA, ALTEZZA*SCALA);
            //imgBg = bg.sottraiSfondo(giocatore.x, giocatore.y, LARGHEZZA*SCALA, ALTEZZA*SCALA);
            //g.drawImage(imgBg, 0, 0, null);
            
            
            g.drawImage(sfondo, (int) -giocatore.x/2, (int) -giocatore.y/5, null);
            
            giocatore.disegna(g);
            c.disegna(g);
            if(livello<4) NI.disegna(g);
            
            //VEDI STATUS GIOCO:
            g.setColor(Color.darkGray);
            g.fillRect(0, 0, LARGHEZZA*SCALA+20, 20);
            
            g.setColor(Color.WHITE);
            if(munizioni >10) g.setColor(Color.GREEN);
            else if(munizioni >5) g.setColor(Color.YELLOW);
            else if(munizioni >=1) g.setColor(Color.ORANGE);
            else if(munizioni == 0) g.setColor(Color.RED);
            g.drawString(" COLTELLI: "+munizioni, 3, 15);
            if(moneteLivello<5) g.setColor(Color.RED);
            else if(moneteLivello<10) g.setColor(Color.ORANGE);
            else g.setColor(Color.GREEN);
            g.drawString("MONETE: "+(monete+moneteLivello), 80+20, 15);
            //g.drawString("Livello: "+livello, 80, 15);
            //g.drawString("Uccisioni: "+uccisioni, 160, 15);
            //g.drawString("Monete: "+monete, 255, 15);
            g.setColor(Color.RED);
            if(messaggioMonete) g.drawString("RACCOGLI TUTTE LE MONETE", 650, 15);
            if(insegui && !seminato1 && !seminato2 && !seminato3 && livello!=4 && moneteLivello!=10) {
                g.drawString("STAI ATTENTO!", 160+30, 15);
            }
            
            if(livello==1 && (giocatore.x>450 && giocatore.x<550) && (giocatore.y<420)) seminato1=true;
            else if(livello==2 && (giocatore.x>350 && giocatore.x<450) && (giocatore.y<300)) Gioco.seminato2=true;
            else if(livello==3 && (giocatore.x>700 && giocatore.x<900) && (giocatore.y<350)) Gioco.seminato2=true;
            
            if(moneteLivello<10) {
                g.setColor(Color.YELLOW);
                if(Gioco.seminato1) g.drawString("SEI AL SICURO... Attento a non cadere", 160+30, 15);
                else if(Gioco.seminato2) g.drawString("SEI AL SICURO... Attento a non cadere", 160+30, 15);
                else if(Gioco.seminato3) g.drawString("SEI AL SICURO... Attento a non cadere", 160+30, 15);
            }
            else {
                g.setColor(Color.GREEN);
                g.drawString("PUOI ANDARE AVANTI!", 160+30, 15);
            }
        }
        else if(State == STATE.MENU){
            if(!musicaPartita) { musica.play(); musicaPartita = true; }
            g.drawImage(Immagini.background, 0, 0, this);
            insegui=false;
            menu.disegna(g);
        }
        else if(State == STATE.OVER){
            if(musicaPartita) { musica.stop(); musicaPartita = false; }
            insegui=false;
            if(!audioPartito) { audioGameOver(); audioPartito=true; }
            over.disegna(g);
        }
        else if(State == STATE.END){
            if(musicaPartita) { musica.stop(); musicaPartita = false; }
            if(!audioPartito) { this.audioVittoria(); audioPartito=true; }
            end.disegna(g);
        }
        else if(State == STATE.INFO){
            g.drawImage(Immagini.background, 0, 0, this);
            info.disegna(g);
        }
        
        
        //////////////////////////////////////
                
        g.dispose();
        buffer.show();
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        if(State == STATE.GAME) {
            if(key == KeyEvent.VK_RIGHT) {
                versoDestraGiocatore = true;
                dxsxpremuto = true;
                fermoGiocatore = false;
                miMuovo=true;
                giocatore.setVelX(velox);
            }
            else if(key == KeyEvent.VK_LEFT) {
                versoDestraGiocatore = false;
                dxsxpremuto = true;
                fermoGiocatore = false;
                miMuovo=true;
                giocatore.setVelX(-velox);
            }
            else if((key == KeyEvent.VK_SPACE) && (!sto_sparando)){
                sto_sparando=true;
                if(munizioni>0) this.audioSparo();
                fermoGiocatore = false;
                miMuovo=false;
                if(munizioni>0) c.aggiungiEntita(new Proiettile(giocatore.getX(), giocatore.getY()+25, this, tex, c));
            }
            else if(key == KeyEvent.VK_UP && !sto_atterrando) {
                if(!sto_saltando) this.audioSalto();
                sto_saltando = true;
                //miMuovo=true;
                fermoGiocatore = false;
            }
            else if(key == KeyEvent.VK_ESCAPE) {
                State = STATE.INFO;
            }
            else if(key == KeyEvent.VK_R) {
                //Preme il pulsante RIPROVA
                this.inizializza(Gioco.livello);
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
                insegui = false;
            }
        else if(key == KeyEvent.VK_I) {
            State = STATE.INFO;
        }
        }
        else if(key == KeyEvent.VK_ENTER && State == STATE.MENU) {
            State = STATE.GAME;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_RIGHT) {
            giocatore.setVelX(0); 
            dxsxpremuto = false;
            miMuovo=false;     
        }
        else if(key == KeyEvent.VK_LEFT) {
            giocatore.setVelX(0);
            dxsxpremuto = false;
            miMuovo=false;
        }
        else if((key == KeyEvent.VK_SPACE) && (sto_sparando)){
            sto_sparando=false;
            miMuovo=false;
        }
        else if(key == KeyEvent.VK_UP){
            if(!dxsxpremuto) miMuovo=false;
        }
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
    public static void main(String[] args) {
        Gioco game = new Gioco();
        
        game.setPreferredSize(new Dimension(LARGHEZZA * SCALA, ALTEZZA * SCALA));
        game.setMaximumSize(new Dimension(LARGHEZZA * SCALA, ALTEZZA * SCALA));
        
        JFrame cornice = new JFrame(game.TITOLO);
        cornice.setUndecorated(corniceAttivata);
        cornice.add(game);
        cornice.pack();
        cornice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cornice.setResizable(false);
        
        cornice.setLocationRelativeTo(null);
        cornice.setVisible(true);
        
        game.start();
    }
    
    public BufferedImage getSpriteSheetGamers(){
        return spriteSheetGamers;
    }
    public BufferedImage getSpriteSheetTextures(){
        return spriteSheetTextures;
    }
    
    public void audioSalto() {
        AudioInputStream audioInputStream = null;
        Clip clip;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(URLs.jump);
            // Get a clip resource.
            clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Gioco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                audioInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(Gioco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void audioSparo() {
        AudioInputStream audioInputStream = null;
        Clip clip;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(URLs.sparo);
            // Get a clip resource.
            clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Gioco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                audioInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(Gioco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void audioGameOver() {
        AudioInputStream audioInputStream = null;
        Clip clip;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(URLs.over);
            // Get a clip resource.
            clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Gioco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                audioInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(Gioco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void audioVittoria() {
        AudioInputStream audioInputStream = null;
        Clip clip;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(URLs.vinto);
            // Get a clip resource.
            clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Gioco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                audioInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(Gioco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void audioPantera() {
        AudioInputStream audioInputStream = null;
        Clip clip;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(URLs.pantera);
            // Get a clip resource.
            clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Gioco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                audioInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(Gioco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void audioPantera2() {
        AudioInputStream audioInputStream = null;
        Clip clip;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(URLs.pantera2);
            // Get a clip resource.
            clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Gioco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                audioInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(Gioco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    

    
}
