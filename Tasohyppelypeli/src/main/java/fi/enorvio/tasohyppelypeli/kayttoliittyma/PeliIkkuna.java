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

public class PeliIkkuna extends JPanel implements KeyListener, ActionListener {

    public JLabel statuspaneeli;
    public BufferedImage kuva;
    private Pelaaja pelaaja;
    public final static int INTERVAL = 10;
    private Timer timer;
    private Logiikka logiikka;

    public PeliIkkuna(Logiikka logiikka) {
        super();
        this.kuva = new BufferedImage(512, 256, BufferedImage.TYPE_INT_RGB);
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
            this.pelaaja.setDx(-1);

        }
        if (code == KeyEvent.VK_RIGHT) {
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
            this.pelaaja.setDx(0);

        }
        if (code == KeyEvent.VK_RIGHT) {
            this.pelaaja.setDx(0);
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        g.drawImage(kuva, 0, 0, null);
        g.setColor(Color.red);
        Kentta nykyinenKentta = this.pelaaja.getKentta();
        for (int i = 0; i < nykyinenKentta.getKorkeus(); i++) {
            for (int j = 0; j < nykyinenKentta.getLeveys(); j++) {
                if (nykyinenKentta.getLaatta(j, i) == 1) {
                    g.fillRect(j * 16, i * 16, 16, 16);
                    repaint();
                }
            }

        }
        g.setColor(Color.yellow);
        for (int i = 0; i < nykyinenKentta.getKorkeus(); i++) {
            for (int j = 0; j < nykyinenKentta.getLeveys(); j++) {
                if (nykyinenKentta.getLaatta(j, i) == 2) {
                    g.fillRect(j * 16, i * 16, 3, 3);
                    repaint();
                }
            }

        }
        g.setColor(Color.green);
        g.fillRect(this.pelaaja.getX(), this.pelaaja.getY(), 16, 16);
        g.setColor(Color.blue);
        for (Vihollinen vihollinen : this.pelaaja.getKentta().getViholliset()) {
            g.fillRect(vihollinen.getX(), vihollinen.getY(), 16, 16);
        }
        repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
            this.logiikka.paivita();
            this.statuspaneeli.setText("Lives: " + this.pelaaja.getElamat() + "Points: " + (this.pelaaja.getPisteet() + this.pelaaja.getKentta().getPisteet()));
        

    }

    public JLabel getStatuspaneeli() {
        return this.statuspaneeli;
    }
}
