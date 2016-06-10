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
import javax.swing.SwingUtilities;

/**
 * Luokka sisältää itse peli-ikkunan ja sen grafiikan sekä näppäinkontrollien
 * kuuntelun.
 */
public class PeliIkkuna extends JPanel implements KeyListener, ActionListener {

    public JLabel statuspaneeli;
    public BufferedImage kuva;
    public BufferedImage sprite1;
    public BufferedImage sprite2;
    public BufferedImage sprite3;
    public BufferedImage sprite4;
    public BufferedImage sprite5;
    public BufferedImage sprite6;
    private int juoksunVaihe;
    private Pelaaja pelaaja;
    public final static int INTERVAL = 10;
    private Timer timer;
    private Logiikka logiikka;
    private int pelaajaJuoksee;
    private Grafiikka grafiikka;

    public PeliIkkuna(Logiikka logiikka) {
        super();
        this.kuva = new BufferedImage(1024, 512, BufferedImage.TYPE_INT_RGB);
        this.grafiikka = new Grafiikka();
        this.sprite1 = null;
        this.sprite2 = null;
        this.sprite3 = null;
        try {
            this.sprite1 = ImageIO.read(new File("src/main/resources/juokseva1.png"));
            this.sprite2 = ImageIO.read(new File("src/main/resources/juokseva2.png"));
            this.sprite3 = ImageIO.read(new File("src/main/resources/juokseva3.png"));
            this.sprite4 = ImageIO.read(new File("src/main/resources/juokseva4.png"));
            this.sprite5 = ImageIO.read(new File("src/main/resources/juokseva5.png"));
            this.sprite6 = ImageIO.read(new File("src/main/resources/juokseva6.png"));
        } catch (IOException e) {
            System.out.println("jotain meni vituiks kuvan lataamisessa");
        }
        this.juoksunVaihe = 1;
        String[] kentanNimet = {"src/main/resources/esimerkkiTaso2.txt", "src/main/resources/esimerkkiTaso.txt"};
        this.logiikka = logiikka;
        this.pelaaja = this.logiikka.getPelaaja();
        this.statuspaneeli = new JLabel("Lives: " + this.pelaaja.getElamat() + "Points: " + this.pelaaja.getPisteet());
        setFocusable(true);
        this.addKeyListener(this);
        requestFocus();
        timer = new Timer(INTERVAL, this);
        timer.start();

    }

    @Override
    public void keyTyped(KeyEvent key) {
    }

    @Override
    public void keyPressed(KeyEvent key) {
        int code = key.getKeyCode();

        if (code == KeyEvent.VK_LEFT) {
            this.pelaajaJuoksee = -1;
            this.pelaaja.setDx(-1);

        }
        if (code == KeyEvent.VK_RIGHT) {
            this.pelaajaJuoksee = 1;
            this.pelaaja.setDx(1);
        }
        if (code == KeyEvent.VK_SPACE) {
            this.pelaaja.hyppaa();
        }
    }

    @Override
    public void keyReleased(KeyEvent key) {

        int code = key.getKeyCode();

        if (code == KeyEvent.VK_LEFT) {
            this.pelaajaJuoksee = 2;
            this.pelaaja.setDx(0);

        }
        if (code == KeyEvent.VK_RIGHT) {
            this.pelaajaJuoksee = 0;
            this.pelaaja.setDx(0);
        }
    }
    
    public void pysayta() {
        timer.stop();
    }
    
    public void kaynnista() {
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {

        g.drawImage(kuva, 0, 0, null);
        Kentta nykyinenKentta = this.pelaaja.getKentta();
        for (int i = 0; i < nykyinenKentta.getKorkeus(); i++) {
            for (int j = 0; j < nykyinenKentta.getLeveys(); j++) {
                g.drawImage(grafiikka.haeKuva(nykyinenKentta.getLaatta(j, i)), j*32, i*32, null);
            }

        }
   
        if (this.pelaajaJuoksee == 1) {
            if (this.juoksunVaihe == 1) {
                g.drawImage(this.sprite1, this.pelaaja.getX(), this.pelaaja.getY(), null);
                this.juoksunVaihe = 2;

            } else if (this.juoksunVaihe == 2) {
                g.drawImage(this.sprite2, this.pelaaja.getX(), this.pelaaja.getY(), null);
                this.juoksunVaihe = 3;

            } else if (this.juoksunVaihe == 3) {
                g.drawImage(this.sprite3, this.pelaaja.getX(), this.pelaaja.getY(), null);
                this.juoksunVaihe = 1;
            }
        } else if (this.pelaajaJuoksee == -1) {
            if (this.juoksunVaihe == 1) {
                g.drawImage(this.sprite4, this.pelaaja.getX(), this.pelaaja.getY(), null);
                this.juoksunVaihe = 2;

            } else if (this.juoksunVaihe == 2) {
                g.drawImage(this.sprite5, this.pelaaja.getX(), this.pelaaja.getY(), null);
                this.juoksunVaihe = 3;

            } else if (this.juoksunVaihe == 3) {
                g.drawImage(this.sprite6, this.pelaaja.getX(), this.pelaaja.getY(), null);
                this.juoksunVaihe = 1;
            }
        } else if (this.pelaajaJuoksee == 0){
            g.drawImage(this.sprite1, this.pelaaja.getX(), this.pelaaja.getY(), null);
        } else if (this.pelaajaJuoksee == 2){
            g.drawImage(this.sprite4, this.pelaaja.getX(), this.pelaaja.getY(), null);
        }

        g.setColor(Color.blue);
        for (Vihollinen vihollinen : this.pelaaja.getKentta().getViholliset()) {
            g.fillRect(vihollinen.getX(), vihollinen.getY(), 32, 32);
        }
        repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (this.logiikka.jatkuu()) {
            this.logiikka.paivita();
            this.statuspaneeli.setText("Lives: " + (this.pelaaja.getElamat() + this.pelaaja.getKentta().getElamat()) + " Points: " + (this.pelaaja.getPisteet() + this.pelaaja.getKentta().getPisteet()));
        } else {
            this.timer.stop();
            System.out.println("game over");
            NimenKysyja nimenkysyja = new NimenKysyja(this.logiikka.getPelaaja().getPisteet());
            SwingUtilities.invokeLater(nimenkysyja);
            //String nimi = nimenkysyja.getNimi();
            //System.out.println(nimi);
        } 

    }

    public JLabel getStatuspaneeli() {
        return this.statuspaneeli;
    }
}
