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
import java.awt.GridLayout;
import javax.swing.JLabel;
import fi.enorvio.tasohyppelypeli.kayttoliittyma.*;
import javax.swing.SwingUtilities;

public class Peli {
    
    public static int pisteet = 0;
    public static int elamat = 9;
    
    public static void main(String[] args) {
        
        String[] kentanNimet = {"src/main/resources/esimerkkiTaso2.txt", "src/main/resources/esimerkkiTaso.txt"};
        Pelaaja esimerkkiPelaaja1 = new Pelaaja(kentanNimet);
        PeliIkkuna esimerkkiPeliIkkuna = new PeliIkkuna(esimerkkiPelaaja1);
        System.out.println("uusi peli");
        JFrame ikkuna = new JFrame("Peli");
        GridLayout asettelija = new GridLayout(2, 1);
        ikkuna.setLayout(asettelija);
        ikkuna.add(esimerkkiPeliIkkuna);
        JLabel kentta = esimerkkiPeliIkkuna.getStatuspaneeli();
        ikkuna.add(kentta);
        ikkuna.setPreferredSize(new Dimension(600, 600));
        ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ikkuna.pack();
        ikkuna.setVisible(true);
        
        
       
    }

}
