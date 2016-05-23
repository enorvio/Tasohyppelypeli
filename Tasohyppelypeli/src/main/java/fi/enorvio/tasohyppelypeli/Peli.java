/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli;

/**
 *
 * @author tabby
 */

import javax.swing.JFrame;
import java.awt.Dimension;



public class Peli {
    
    public static void main(String[] args) {
        int[][] laatat = {{1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1}, 
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1}};
        char[] suunnat1 = {'d', 'r', 'u', 'l'};
        int[] kaannokset1 = {0, 200, 80, 80};
        Vihollinen vihollinen1 = new Vihollinen(80, 80, suunnat1, kaannokset1);
        char[] suunnat2 = {'d', 'r', 'u', 'l'};
        int[] kaannokset2 = {70, 20, 8, 19};
        Vihollinen vihollinen2 = new Vihollinen(30, 30, suunnat2, kaannokset2);
        Vihollinen[] viholliset = {vihollinen1, vihollinen2};
        Kentta esimerkkiKentta = new Kentta(laatat, viholliset);
        
        
        
        JFrame ikkuna = new JFrame("Peli");
        Pelaaja esimerkkiPelaaja = new Pelaaja(esimerkkiKentta);
        PeliIkkuna esimerkkiPeliIkkuna = new PeliIkkuna(esimerkkiPelaaja);
        
        ikkuna.setFocusable(true);
        ikkuna.setPreferredSize(new Dimension(600, 600));
        ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        ikkuna.pack();
        ikkuna.setContentPane(esimerkkiPeliIkkuna);
        ikkuna.setVisible(true);       
        System.out.println(esimerkkiPeliIkkuna.isFocusOwner());
        
        
        esimerkkiPeliIkkuna.run();
        }
        
    
    
        
    }

