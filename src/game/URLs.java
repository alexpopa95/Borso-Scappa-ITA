/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import java.net.URL;

/**
 *
 * @author alexpopa95
 */
public class URLs {
    static URL coin;
    static URL jump;
    static URL salto;
    static URL sparo;
    static URL over;
    static URL vinto;
    static URL pantera;
    static URL pantera2;
    
    public URLs() {
        coin = this.getClass().getClassLoader().getResource("Sound/coin.wav");
        jump = this.getClass().getClassLoader().getResource("Sound/jump.wav");
        salto = this.getClass().getClassLoader().getResource("Sound/salto.wav");
        sparo = this.getClass().getClassLoader().getResource("Sound/sparo.wav");
        over = this.getClass().getClassLoader().getResource("Sound/over.wav");
        vinto = this.getClass().getClassLoader().getResource("Sound/vinto.wav");
        pantera = this.getClass().getClassLoader().getResource("Sound/roar.wav");
        pantera2 = this.getClass().getClassLoader().getResource("Sound/roar_die.wav");
    }
    
}
