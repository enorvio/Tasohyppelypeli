/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli.logiikka;

/**
 *
 * @author tabby
 */
/**
 * Luokka jossa toteutetaan viholliset, joihin osuessaan pelaaja kuolee.
 * Viholliset liikkuvat ennalta määrättyä reittiä.
 */
public class Vihollinen extends Hahmo {

    private int reitinOsuus;
    private char[] suunnat;
    private int[] kaannospisteet;

    public Vihollinen(int x, int y, char[] suunnat, int[] kaannospisteet) {
        super(x, y);
        this.reitinOsuus = 0;
        this.suunnat = suunnat;
        this.kaannospisteet = kaannospisteet;
    }

    public Vihollinen(int x, int y, char[] suunnat, int[] kaannospisteet, Kentta kentta) {
        super(x, y, kentta);
        this.reitinOsuus = 0;
        this.suunnat = suunnat;
        this.kaannospisteet = kaannospisteet;
    }

    @Override
    public String toString() {
        return "Vihollinen pisteessa x = " + super.getX() + ", y = " + super.getY() + ", on nyt reitinosuudella " + this.reitinOsuus + ", suunnat: " + this.suunnatMerkkijonona() + ", kaannospisteet" + this.kaannospisteetMerkkijonona();
    }

    public char[] getSuunnat() {
        return this.suunnat;
    }

    public int[] getKaannospisteet() {
        return this.kaannospisteet;
    }

    public int getReitinOsuus() {
        return this.reitinOsuus;
    }

    public String suunnatMerkkijonona() {
        String mjono = "";
        for (char suunta : this.suunnat) {
            mjono += suunta;
        }
        return mjono;
    }

    public String kaannospisteetMerkkijonona() {
        String mjono = "";
        for (int kaannospiste : this.kaannospisteet) {
            mjono = mjono + " " + kaannospiste;
        }
        return mjono;
    }

    @Override public void liiku() {
        if ((this.suunnat[reitinOsuus] == 'd' && this.getY() < this.kaannospisteet[reitinOsuus]) || ((this.suunnat[reitinOsuus] == 'u' && this.getY() > this.kaannospisteet[reitinOsuus]) || (this.suunnat[reitinOsuus] == 'l' && this.getX() > this.kaannospisteet[reitinOsuus]) || (this.suunnat[reitinOsuus] == 'r' && this.getX() < this.kaannospisteet[reitinOsuus]))) {
            super.liiku();
        } else {
            kaanny();
        }

    }

    /**
     * Metodi päivittää reittinsä käännöskohdassa olevan Vihollisen nopeustiedot ja tiedon siitä millä reitinpätkällä Vihollinen on. 
     *
     */
    public void kaanny() {
        if (reitinOsuus < this.suunnat.length - 1) {
            this.reitinOsuus++;
        } else {
            this.reitinOsuus = 0;
        }
        super.pysahdy();
        if (this.suunnat[reitinOsuus] == 'd') {
            super.setDy(1);
        } else if (this.suunnat[reitinOsuus] == 'u') {
            super.setDy(-1);
        } else if (this.suunnat[reitinOsuus] == 'r') {
            super.setDx(1);
        } else if (this.suunnat[reitinOsuus] == 'l') {
            super.setDx(-1);
        }
        super.liiku();
    }

}
