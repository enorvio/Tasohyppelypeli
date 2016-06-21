/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli.logiikka;

import fi.enorvio.tasohyppelypeli.*;
import fi.enorvio.tasohyppelypeli.tiedostonkasittely.*;
import java.util.*;

/**
 *
 * @author tabby
 */
/**
 * Luokka huolehtii olennaisesta pelilogiikasta kuten tasosta toiseen
 * siirtymisestä, tason resetoimisesta ja pelitilanteen päivittämisestä.
 * Luokassa myös luodaan pelin kentät.
 */
public class Logiikka {

    private Pelaaja pelaaja;
    private String[] kenttienTiedostonimet;
    private int kentanNumero;
    private Lukija lukija;
    private boolean jatkuu;

    /**
     * Metodi on Logiikka-luokan konstruktori.
     * 
     *@param kenttienTiedostonimet Niiden tiedostojen nimet (listana), joista pelin kentät ladataan.
     */
    
    public Logiikka(String[] kenttienTiedostonimet) {
        this.kentanNumero = 0;
        this.kenttienTiedostonimet = kenttienTiedostonimet;
        this.lukija = new Lukija();
        this.pelaaja = new Pelaaja(this.lukija.lataaKentta(this.kenttienTiedostonimet[this.kentanNumero]));
        this.jatkuu = true;
    }

    public Pelaaja getPelaaja() {
        return this.pelaaja;
    }

    public int getKentanNumero() {
        return this.kentanNumero;
    }
    
    /**
     * Metodi resetoi kentän pelitilanteen lataamalla kentän uudelleen
     * tiedostosta, asettaen pelaajan aloitusasemaan.
     *
     */
    public void resetoiKentta() {
        this.pelaaja.setX(1);
        this.pelaaja.setY(1);
        Kentta uusiKentta = this.lukija.lataaKentta(this.kenttienTiedostonimet[this.kentanNumero]);
        this.pelaaja.setKentta(uusiKentta);
    }

    /**
     * Metodi tallentaa pelaajan edellisestä kentästä saamat pisteet ja elämät
     * pelaajan oliomuuttujiin, lataa seuraavan kentän tai lopettaa pelin jos
     * kenttä oli viimeinen, pelaajan läpäistessä edellisen kentän.
     *
     */
    public void seuraavaKentta() {
        this.pelaaja.setPisteet(this.pelaaja.getPisteet() + this.pelaaja.getKentta().getPisteet());
        this.pelaaja.setElamat(this.pelaaja.getElamat() + this.pelaaja.getKentta().getElamat());
        if (this.kentanNumero < this.kenttienTiedostonimet.length - 1) {
            this.kentanNumero++;
        } else {
            lopetaPeli();
        }
        this.resetoiKentta();
    }

    /**
     * Metodi ilmoittaa pelin loppumisesta Logiikka.jatkuu -oliomuuttujan
     * välityksellä.
     *
     */
    public void lopetaPeli() {
        this.jatkuu = false;
    }

    /**
     * Metodi päivittää pelilogiikan tilannetta liikuttaen kaikkia hahmoja
     * pikselin verran niiden nopeuden perusteella ja ja resetoiden kentän tai
     * edeten seuraavaan kenttään jos sille on tarvetta..
     *
     */
    public void paivita() {
        if (!pelaaja.onElossa()) {
            if (pelaaja.getElamat() > 0) {
                this.pelaaja.ela();
                this.resetoiKentta();
                this.pelaaja.ela();
            } else {
                lopetaPeli();
            }
        }
        pelaaja.liiku();
        for (Vihollinen vihollinen : this.pelaaja.getKentta().getViholliset()) {
            vihollinen.liiku();
            if (vihollinen.kuuluukoPikseliHahmoon(this.pelaaja.getX(), this.pelaaja.getY())) {
                this.pelaaja.kuole();
            }
        }
        if (pelaaja.getX() >= 990) {
            this.seuraavaKentta();
        }
    }

    public boolean jatkuu() {
        return this.jatkuu;
    }

}
