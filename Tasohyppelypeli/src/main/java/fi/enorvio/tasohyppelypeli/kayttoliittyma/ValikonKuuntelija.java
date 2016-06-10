/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli.kayttoliittyma;

import fi.enorvio.tasohyppelypeli.logiikka.*;
import fi.enorvio.tasohyppelypeli.tiedostonkasittely.Lukija;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author tabby
 */

/**
 * Luokassa on toteutettu aloitusvalikon nappien painamiseen reagointi, mukaan lukien uuden pelin aloittaminen.
 */
public class ValikonKuuntelija implements ActionListener {

    private JButton uusiPeli;
    private JButton lataaPeli;
    private JButton lopeta;
    private JButton korkeimmatPisteet;
    
    
    public ValikonKuuntelija(JButton uusiPeli, JButton lataaPeli, JButton korkeimmatPisteet, JButton lopeta) {
        this.uusiPeli = uusiPeli;
        this.lataaPeli = lataaPeli;
        this.lopeta = lopeta;
        this.korkeimmatPisteet = korkeimmatPisteet;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        try {
            if (ae.getSource() == uusiPeli) {
                System.out.println("jee");
                String[] kentanNimet = {"src/main/resources/esimerkkiTaso2.txt", "src/main/resources/esimerkkiTaso.txt"};
                Logiikka logiikka = new Logiikka(kentanNimet);
                PeliIkkuna esimerkkiPeliIkkuna = new PeliIkkuna(logiikka);
                System.out.println("uusi peli");
                JFrame ikkuna = new JFrame("Peli");
                GridLayout asettelija = new GridLayout(2, 1);
                ikkuna.setLayout(asettelija);
                ikkuna.add(esimerkkiPeliIkkuna);
                JLabel kentta = esimerkkiPeliIkkuna.getStatuspaneeli();
                ikkuna.add(kentta);
                ikkuna.setPreferredSize(new Dimension(1050, 1050));
                ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ikkuna.pack();
                ikkuna.setVisible(true);
            }
            if (ae.getSource() == korkeimmatPisteet) {
                JFrame pisteIkkuna = new JFrame("High scores"); 
                GridLayout asettelija = new GridLayout(10, 1);
                pisteIkkuna.setLayout(asettelija);
                Lukija lukija = new Lukija();
                ArrayList<String> pisteet = lukija.lataaPisteet();
                for (int i = 0; i < 10; i++) {
                    JLabel pistekentta = new JLabel((i + 1) + ". " + pisteet.get(i));
                    pisteIkkuna.add(pistekentta);
                }
                pisteIkkuna.setPreferredSize(new Dimension(1050, 1050));
                pisteIkkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                pisteIkkuna.pack();
                pisteIkkuna.setVisible(true);
                }
            
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("virhe");
        }

    }
}


