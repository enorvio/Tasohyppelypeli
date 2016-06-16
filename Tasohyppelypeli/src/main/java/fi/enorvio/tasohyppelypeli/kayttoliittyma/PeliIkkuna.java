/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli.kayttoliittyma;

import fi.enorvio.tasohyppelypeli.logiikka.Kentta;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.JLabel;
import fi.enorvio.tasohyppelypeli.logiikka.Logiikka;
import fi.enorvio.tasohyppelypeli.logiikka.Logiikka;
import fi.enorvio.tasohyppelypeli.logiikka.Pelaaja;
import fi.enorvio.tasohyppelypeli.logiikka.Vihollinen;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Luokka sisältää itse peli-ikkunan ja sen grafiikan sekä näppäinkontrollien
 * kuuntelun.
 */
public class PeliIkkuna extends JPanel implements ActionListener {

    public JLabel statuspaneeli;
    public BufferedImage kuva;
    private Pelaaja pelaaja;
    public final static int INTERVAL = 50;
    private Timer timer;
    private Logiikka logiikka;
    private Grafiikka grafiikka;
    private NappaimistonKuuntelija nappaimistonKuuntelija;
    private JFrame ikkuna;

    public PeliIkkuna(Logiikka logiikka, JFrame ikkuna) {
        super();
        this.ikkuna = ikkuna;
        this.kuva = new BufferedImage(1024, 512, BufferedImage.TYPE_INT_RGB);
        this.grafiikka = new Grafiikka();
        String[] kentanNimet = {"src/main/resources/esimerkkiTaso2.txt", "src/main/resources/esimerkkiTaso.txt"};
        this.logiikka = logiikka;
        this.pelaaja = this.logiikka.getPelaaja();
        this.statuspaneeli = new JLabel("Lives: " + this.pelaaja.getElamat() + "Points: " + this.pelaaja.getPisteet());
        setFocusable(true);
        this.nappaimistonKuuntelija = new NappaimistonKuuntelija(this.pelaaja);
        this.addKeyListener(nappaimistonKuuntelija);
        requestFocus();
        timer = new Timer(INTERVAL, this);
        timer.start();
    }
 
    @Override
    public void paintComponent(Graphics g) {

        g.drawImage(grafiikka.haeKuva(100), 0, 0, null);
        Kentta nykyinenKentta = this.pelaaja.getKentta();
        for (int i = 0; i < nykyinenKentta.getKorkeus(); i++) {
            for (int j = 0; j < nykyinenKentta.getLeveys(); j++) {
                g.drawImage(grafiikka.haeKuva(nykyinenKentta.getLaatta(j, i)), j*32, i*32, null);
            }

        }
        int animaationVaihe = this.nappaimistonKuuntelija.getPelaajanAnimaationTila();
        g.drawImage(grafiikka.haeKuva(90+animaationVaihe), this.pelaaja.getX(), this.pelaaja.getY(), null);
        g.setColor(Color.blue);
        
        for (Vihollinen vihollinen : this.pelaaja.getKentta().getViholliset()) {
            g.fillRect(vihollinen.getX(), vihollinen.getY(), 32, 32);
        }
        repaint();
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (this.logiikka.jatkuu()) {
            this.timer.stop();
            this.logiikka.paivita();
            this.timer.start();
            this.statuspaneeli.setText("Lives: " + (this.pelaaja.getElamat() + this.pelaaja.getKentta().getElamat()) + " Points: " + (this.pelaaja.getPisteet() + this.pelaaja.getKentta().getPisteet()));
        } else {
            this.timer.stop();
            this.ikkuna.dispose();
            NimenKysyja nimenkysyja = new NimenKysyja(this.logiikka.getPelaaja().getPisteet());
            SwingUtilities.invokeLater(nimenkysyja);
        } 

    }

    public JLabel getStatuspaneeli() {
        return this.statuspaneeli;
    }
}
