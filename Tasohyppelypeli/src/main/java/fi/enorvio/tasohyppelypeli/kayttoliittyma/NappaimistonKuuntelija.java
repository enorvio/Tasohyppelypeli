/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli.kayttoliittyma;

import fi.enorvio.tasohyppelypeli.logiikka.Pelaaja;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;

/**
 *
 * @author tabby
 */

/**
 * Luokka implementoi KeyListener-interfacen ja toimii näppäinkontrollien
 * kuuntelijana pelin aikana, päivittäen pelaajan nopeustietoja ja kommunikoi
 * PeliIkkuna-luokan kanssa ja ohjaa pelaajan animointia.
 */
public class NappaimistonKuuntelija implements KeyListener {

    private int pelaajanAnimaationTila;
    private Pelaaja pelaaja;

    /**
     * Metodi on NappaimistonKuuntelija-luokan konstruktori. 
     *
     */
    public NappaimistonKuuntelija(Pelaaja pelaaja) {
        this.pelaajanAnimaationTila = 1;
        this.pelaaja = pelaaja;
    }

    @Override
    public void keyTyped(KeyEvent key) {
    }

    @Override
    public void keyPressed(KeyEvent key) {

        int code = key.getKeyCode();

        if (code == KeyEvent.VK_LEFT) {
            if (this.pelaajanAnimaationTila == -1) {
                this.pelaajanAnimaationTila = -2;
            } else if (this.pelaajanAnimaationTila == -2) {
                this.pelaajanAnimaationTila = -3;
            } else if (this.pelaajanAnimaationTila == -3) {
                this.pelaajanAnimaationTila = -1;
            } else {
                this.pelaajanAnimaationTila = -1;
            }
            this.pelaaja.setDx(-1);
        }

        if (code == KeyEvent.VK_RIGHT) {
            if (this.pelaajanAnimaationTila == 1) {
                this.pelaajanAnimaationTila = 2;
            } else if (this.pelaajanAnimaationTila == 2) {
                this.pelaajanAnimaationTila = 3;
            } else if (this.pelaajanAnimaationTila == 3) {
                this.pelaajanAnimaationTila = 1;
            } else {
                this.pelaajanAnimaationTila = 1;
            }
            this.pelaaja.setDx(1);
        }

        if (code == KeyEvent.VK_SPACE) {
            this.pelaaja.hyppaa();
        }
        
        if (code == KeyEvent.VK_Q) {
            this.pelaaja.setElamat(-1);
            this.pelaaja.kuole();
        }
        
    }

    @Override
    public void keyReleased(KeyEvent key) {

        int code = key.getKeyCode();

        if (code == KeyEvent.VK_LEFT) {
            this.pelaajanAnimaationTila = -1;
            this.pelaaja.setDx(0);
        }

        if (code == KeyEvent.VK_RIGHT) {
            this.pelaajanAnimaationTila = 1;
            this.pelaaja.setDx(0);
        }
    }

    public int getPelaajanAnimaationTila() {
        return this.pelaajanAnimaationTila;
    }

}
