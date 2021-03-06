/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli.logiikka;

import fi.enorvio.tasohyppelypeli.logiikka.Hahmo;

/**
 *
 * @author tabby
 */

/**
 * Luokka jonka instanssi vastaa pelaajaa (koko pelin ajan, ei vain yksittäisessä kentässä). Luokka tarjoaa metodit pelaajan liikuttamiseen ja kuoleman käsittelyyn. 
 */
public class Pelaaja extends Hahmo {

    private Kentta kentta;
    private int hyppy;
    private int elamat;
    private int pisteet;
    private int kentanNumero;
    private String[] kenttienTiedostonimet;

    /**
     * Metodi on Pelaaja-luokan konstruktori.
     *
     * @param kentta pelaajan kenttä
     */    
    public Pelaaja(Kentta kentta) {
        super(1, 1, kentta);
        this.hyppy = 0;
        super.setTormaaEsteisiin(true);
        String[] nimet = {"src/main/resources/esimerkkiTaso1.txt", "src/main/resources/esimerkkiTaso.txt"};
        this.kenttienTiedostonimet = nimet;
        this.elamat = 9;
        this.pisteet = 0;
        this.kentanNumero = 0;
    }

    public Kentta getKentta() {
        return super.getKentta();
    }

    public void setKentta(Kentta kentta) {
        super.setKentta(kentta);
    }

    public int getElamat() {
        return this.elamat;
    }
    
    public void setElamat(int elamat) {
        this.elamat = elamat;
    }

    public int getPisteet() {
        return this.pisteet;
    }

    public void setPisteet(int uudetPisteet) {
        this.pisteet = uudetPisteet;
    }

    public void hyppaa() {
        if (!super.pelaajaOnIlmassa()) {
            this.hyppy = 80;
        }
    }

    public int getHyppy() {
        return this.hyppy;
    }

    @Override public void kuole() {
        super.kuole();
        this.elamat--;
    }

    @Override public void liiku() {
        if (this.hyppy == 0) {
            super.setDy(1);
            if (super.getY() >= 478) {
                kuole();
            }
        }
        if (super.ylhaallaOnEste()) {
            this.hyppy = 0;
        } else if (this.hyppy > 0) {
            super.setDy(-1);
            this.hyppy--;
        }
        super.liiku();
        int nykyinenX = super.getX();
        int nykyinenY = super.getY();
        super.getKentta().poistaPiste(nykyinenX, nykyinenY);
        if (super.getKentta().pikseliKuuluuTeleporttiin(nykyinenX, nykyinenY)) {
            int[] alku = {nykyinenX / 32, nykyinenY / 32};
            int[] loppu = super.getKentta().getTeleportinToinenPaa(alku);
            if (loppu != null) {
                this.setX((loppu[0] + 1) * 32);
                this.setY((loppu[1]) * 32);
            }
            
        }

    }

}
