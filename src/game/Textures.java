
package game;

import java.awt.image.BufferedImage;

/**
 *
 * @author alexpopa95
 */
public class Textures {
    
    public BufferedImage[] giocatore = new BufferedImage[4];
    public BufferedImage[] giocatore_girato = new BufferedImage[4];
    public BufferedImage[] proiettile = new BufferedImage[2];
    public BufferedImage[] nemico = new BufferedImage[3];
    public BufferedImage[] nemico_girato = new BufferedImage[3];
    public BufferedImage[] terra = new BufferedImage[3];
    public BufferedImage[] erba = new BufferedImage[1];
    public BufferedImage[] sabbia = new BufferedImage[1];
    public BufferedImage[] mattoni = new BufferedImage[1];
    public BufferedImage[] nemicoIns = new BufferedImage[8];
    public BufferedImage[] acqua = new BufferedImage[3];
    public BufferedImage[] acqua_onda = new BufferedImage[2];
    public BufferedImage[] moneta = new BufferedImage[3];
    public BufferedImage[] freccia = new BufferedImage[1];
    
    private final SpriteSheet ss;
    private final SpriteSheet sst;
    
    public Textures(Gioco game) {
        ss = new SpriteSheet(game.getSpriteSheetGamers());
        sst = new SpriteSheet(game.getSpriteSheetTextures());
        
        getTextures();
    }
    
    private void getTextures() {
        giocatore[0] = ss.sottraiImmagine64(1, 1, 63, 63);
        giocatore[1] = ss.sottraiImmagine64(1, 2, 63, 63);
        giocatore[2] = ss.sottraiImmagine64(1, 3, 63, 63);
        giocatore[3] = ss.sottraiImmagine64(1, 4, 63, 63);
        
        giocatore_girato[0] = ss.sottraiImmagine64(2, 1, 63, 63);
        giocatore_girato[1] = ss.sottraiImmagine64(2, 2, 63, 63);
        giocatore_girato[2] = ss.sottraiImmagine64(2, 3, 63, 63);
        giocatore_girato[3] = ss.sottraiImmagine64(2, 4, 63, 63);
        
        proiettile[0] = sst.sottraiImmagine32(7, 1, 31, 5);
        proiettile[1] = sst.sottraiImmagine32(7, 2, 31, 5);
        
        nemico[0] = ss.sottraiImmagine64(6, 4, 63, 63);
        nemico[1] = ss.sottraiImmagine64(6, 5, 63, 63);
        nemico[2] = ss.sottraiImmagine64(6, 6, 63, 63);
        
        nemico_girato[0] = ss.sottraiImmagine64(6, 1, 63, 63);
        nemico_girato[1] = ss.sottraiImmagine64(6, 2, 63, 63);
        nemico_girato[2] = ss.sottraiImmagine64(6, 3, 63, 63);
        
        terra[0] = sst.sottraiImmagine32(1, 1, 31, 31);
        terra[1] = sst.sottraiImmagine32(2, 1, 31, 31);
        terra[2] = sst.sottraiImmagine32(2, 2, 31, 31);
        
        erba[0] = sst.sottraiImmagine32(6, 2, 31, 31);
        
        nemicoIns[0] = ss.sottraiImmagine64(5, 1, 63, 63);
        nemicoIns[1] = ss.sottraiImmagine64(5, 2, 63, 63);
        nemicoIns[2] = ss.sottraiImmagine64(5, 3, 63, 63);
        nemicoIns[3] = ss.sottraiImmagine64(5, 4, 63, 63);
        nemicoIns[4] = ss.sottraiImmagine64(5, 5, 63, 63);
        nemicoIns[5] = ss.sottraiImmagine64(5, 6, 63, 63);
        nemicoIns[6] = ss.sottraiImmagine64(5, 7, 63, 63);
        nemicoIns[7] = ss.sottraiImmagine64(5, 8, 63, 63);
        
        mattoni[0] = sst. sottraiImmagine32(1, 2, 31, 31);
        
        sabbia[0] = sst.sottraiImmagine32(4, 1, 31, 31);
        
        acqua[0] = sst.sottraiImmagine32(3, 1, 31, 31);
        acqua[1] = sst.sottraiImmagine32(3, 2, 31, 31);
        acqua[2] = sst.sottraiImmagine32(3, 3, 31, 31);
        
        acqua_onda[0] = sst.sottraiImmagine32(3, 4, 31, 31);
        acqua_onda[1] = sst.sottraiImmagine32(3, 5, 31, 31);
        
        moneta[0] = sst.sottraiImmagine32(8, 1, 30, 30);
        moneta[1] = sst.sottraiImmagine32(8, 2, 30, 30);
        moneta[2] = sst.sottraiImmagine32(8, 3, 30, 30);
        
        freccia[0] = sst.sottraiImmagine32(4, 1, 30, 30);
    }
}
