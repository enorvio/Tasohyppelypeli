/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.Timer;

public class PeliIkkuna extends JPanel implements KeyListener, ActionListener {

    public BufferedImage kuva;
    private Pelaaja pelaaja;
    public final static int INTERVAL = 10;
    private Timer timer;

    public PeliIkkuna(Pelaaja pelaaja) {
        super();
        this.kuva = new BufferedImage(512, 256, BufferedImage.TYPE_INT_RGB);
        this.pelaaja = pelaaja;
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
            this.pelaaja.setVasen(true);
            this.pelaaja.setOikea(false);

        }
        if (code == KeyEvent.VK_RIGHT) {
            this.pelaaja.setOikea(true);
            this.pelaaja.setVasen(false);
        }
        if (code == KeyEvent.VK_SPACE) {
            this.pelaaja.hyppaa();
        }
    }

    @Override
    public void keyReleased(KeyEvent key) {

        int code = key.getKeyCode();

        if (code == KeyEvent.VK_LEFT) {
            this.pelaaja.setVasen(false);
        }
        if (code == KeyEvent.VK_RIGHT) {
            this.pelaaja.setOikea(false);
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
        this.pelaaja.liiku();
        for (Vihollinen vihollinen : this.pelaaja.getKentta().getViholliset()) {
            vihollinen.liiku(this.pelaaja.getKentta());
        }

    }
}
