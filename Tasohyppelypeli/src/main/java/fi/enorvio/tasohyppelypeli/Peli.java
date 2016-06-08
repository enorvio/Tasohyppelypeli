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
import fi.enorvio.tasohyppelypeli.kayttoliittyma.PeliIkkuna;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import fi.enorvio.tasohyppelypeli.kayttoliittyma.*;
import javax.swing.SwingUtilities;
import fi.enorvio.tasohyppelypeli.logiikka.Logiikka;

public class Peli {

    public static int pisteet = 0;
    public static int elamat = 9;

    public static void main(String[] args) {

        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);

        
        
    }

}
