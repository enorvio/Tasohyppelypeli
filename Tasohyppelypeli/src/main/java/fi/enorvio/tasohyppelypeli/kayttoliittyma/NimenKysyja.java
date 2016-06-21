/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author tabby
 */
/**
 * Luokka sisältää ikkunan, joka kysyy pelin jälkeen pelaajalta tämän nimeä.
 */
public class NimenKysyja implements Runnable {

    private JFrame ikkuna;
    private GridLayout asettelija;
    private JButton ok;
    private int pisteet;
    private NimenKysyjanKuuntelija kuuntelija;

    /**
     * Metodi on NimenKysyja-luokan konstruktori. 
     *
     * @param pisteet käyttäjän pelissä saamat pisteet
     */
    public NimenKysyja(int pisteet) {
        this.pisteet = pisteet;
        this.kuuntelija = null;
    }

    @Override
    public void run() {
        ikkuna = new JFrame("Valikko");
        ikkuna.setPreferredSize(new Dimension(300, 200));
        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(ikkuna.getContentPane());

        ikkuna.pack();
        ikkuna.setVisible(true);
    }

    
    /**
     * Metodi sijoittaa Nimenkysyjään kuuluvat komponentit paikoilleen Containeriin, luo niille kuuntelijan ja kytkee sen komponentteihin.
     *
     * @param Container Container-olio johon komponentit sijoitetaan, käytännössä Nimenkysyjän ikkunan ContentPane
     */
    private void luoKomponentit(Container container) {
        GridLayout asettelija = new GridLayout(3, 1);
        container.setLayout(asettelija);
        JPanel paneeli = new JPanel(new GridLayout(1, 1));
        paneeli.setFocusable(true);
        JTextField syotekentta = new JTextField("");
        JButton nappi = new JButton("OK");
        paneeli.add(nappi);
        JLabel teksti = new JLabel("Points:" + this.pisteet + "What's your name?");
        paneeli.add(teksti);
        container.add(syotekentta);
        container.add(paneeli);
        this.kuuntelija = (new NimenKysyjanKuuntelija(this.ikkuna, this.pisteet, nappi, syotekentta));
        nappi.addActionListener(kuuntelija);

    }

    public String getNimi() {
        return this.kuuntelija.getNimi();
    }
}
