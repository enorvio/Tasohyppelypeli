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
    private ArrayList<Kentta> kentat;
    private int kentanNumero;
    private Lukija lukija;

    public Logiikka(String[] kenttienTiedostonimet) {
        this.kentanNumero = 0;
        this.kentat = new ArrayList<Kentta>();
        this.kenttienTiedostonimet = kenttienTiedostonimet;
        this.lukija = new Lukija();
        for (String nimi : this.kenttienTiedostonimet) {
            this.lukija.lataaKentta(nimi);
            Kentta kentta = new Kentta(this.lukija.lataaLaatat(), this.lukija.lataaViholliset());
            kentta.luoTeleportti(2, 15, 14, 3);
            kentta.luoTeleportti(4, 14, 13, 14);
            for (Vihollinen vihollinen : kentta.getViholliset()) {
                vihollinen.setKentta(kentta);
            }
            this.kentat.add(kentta);
            kentta.tulostaTeleportit();
        }
        this.pelaaja = new Pelaaja(this.kentat.get(0));
    }

    public Pelaaja getPelaaja() {
        return this.pelaaja;
    }

    public void resetoiKentta() {
        this.pelaaja.setX(1);
        this.pelaaja.setY(1);
        this.lukija.lataaKentta(this.kenttienTiedostonimet[this.kentanNumero]);
        Kentta uusiKentta = new Kentta(this.lukija.lataaLaatat(), this.lukija.lataaViholliset());
        this.pelaaja.setKentta(uusiKentta);
        this.kentat.set(kentanNumero, uusiKentta);
    }

    public void seuraavaKentta() {
        this.pelaaja.setPisteet(this.pelaaja.getPisteet() + this.kentat.get(this.kentanNumero).getPisteet());
        if (this.kentanNumero < this.kentat.size() - 1) {
            this.kentanNumero++;
        } else {
            lopetaPeli();
        }
        this.resetoiKentta();
    }

    public void lopetaPeli() {

    }

    public void paivita() {
        if (!pelaaja.onElossa()) {
            this.pelaaja.ela();
            this.resetoiKentta();
            this.pelaaja.ela();
        }
        pelaaja.liiku();
        for (Vihollinen vihollinen : this.pelaaja.getKentta().getViholliset()) {
            vihollinen.liiku();
            if (vihollinen.kuuluukoPikseliHahmoon(this.pelaaja.getX(), this.pelaaja.getY())) {
                this.pelaaja.kuole();
            }
        }
        if (pelaaja.getX() >= 495) {
            this.seuraavaKentta();
        }
    }

}
