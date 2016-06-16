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
import java.util.HashMap;

/**
 * Luokka sisältää vain main-metodin.
 */
public class Peli {

    /**
     * Metodi on main-metodi ja käynnistää pelin luomalla ja avaamalla uuden
     * aloitusvalikon.
     *
     * @param args argumentit
     */
    public static void main(String[] args) {

        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);

    }

}
