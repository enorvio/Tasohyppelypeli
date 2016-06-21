/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli.logiikka;

/**
 *
 * @author enorvio
 */
/**
 * Luokka toimii pohjana tasohyppelypelin liikkuville olioille.
 */
public class Hahmo {

    private int x;
    private int y;
    private boolean onElossa;
    private boolean tormaaEsteisiin;
    private int dx;
    private int dy;
    private Kentta kentta;

     /**
     * Metodi on Hahmo-luokan konstruktori ilman kenttää, jotta kenttä voitaisiin tarvittaessa lisätä jälkikäteen.
     *
     * @param x hahmon vasemman reunan x-koordinaatti 
     * @param y hahmon yläreunan y-koordinaatti
     */
    
    public Hahmo(int x, int y) {
        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = 0;
        this.onElossa = true;
        this.tormaaEsteisiin = false;
    }

     /**
     * Metodi on Hahmo-luokan konstruktori, jolle annetaan kenttä parametrina.
     *
     * @param x hahmon vasemman reunan x-koordinaatti 
     * @param y hahmon yläreunan y-koordinaatti
     * @param kentta kenttä, jossa hahmon olisi tarkoitus olla
     */
    
    public Hahmo(int x, int y, Kentta kentta) {
        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = 0;
        this.onElossa = true;
        this.tormaaEsteisiin = false;
        this.kentta = kentta;
    }

    public Kentta getKentta() {
        return this.kentta;
    }

    public void setKentta(Kentta kentta) {
        this.kentta = kentta;
    }

    public void setTormaaEsteisiin(boolean tormaaEsteisiin) {
        this.tormaaEsteisiin = tormaaEsteisiin;
    }

    public boolean onElossa() {
        return this.onElossa;
    }

    public void ela() {
        this.onElossa = true;
    }

    public void kuole() {
        this.onElossa = false;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int uusiX) {
        this.x = uusiX;
    }

    public void setY(int uusiY) {
        this.y = uusiY;
    }

    /**
     * Metodi nollaa hahmon pysty- ja vaakasuuntaisen nopeuden.
     */
    public void pysahdy() {
        this.dx = 0;
        this.dy = 0;
    }

    public int getDx() {
        return this.dx;
    }

    public int getDy() {
        return this.dy;
    }

    public void setDx(int uusiDx) {
        this.dx = uusiDx;
    }

    public void setDy(int uusiDy) {
        this.dy = uusiDy;
    }

    /**
     * Metodi kertoo onko välittömästi hahmon alareunan alla laatta.
     *
     * @return tieto siitä onko hahmo ilmassa totuusarvon muodossa
     */
    public boolean pelaajaOnIlmassa() {
        if (this.kentta.pikseliKuuluuEsteeseen(this.x, this.y + 32)) {
            return false;
        }
        if (this.kentta.pikseliKuuluuEsteeseen(this.x + 31, this.y + 32)) {
            return false;
        }
        return true;
    }

    /**
     * Metodi kertoo onko välittömästi hahmon yläreunan yläpuolella laatta.
     *
     * @return tieto siitä onko hahmon yläreunan yläpuolella laatta totuusarvona
     */
    public boolean ylhaallaOnEste() {
        if (this.kentta.pikseliKuuluuEsteeseen(x, y - 1)) {
            return true;
        }
        if (this.kentta.pikseliKuuluuEsteeseen(this.x + 31, this.y - 1)) {
            return true;
        }
        return false;
    }

    /**
     * Metodi liikuttaa hahmoa yhden pikselin verran vaaka- ja pystysuunnassa
     * hahmon nopeustietojen perusteella, mikäli se on mahdollista.
     */
    public void liiku() {
        int uusiX = this.x + this.dx;
        int uusiY = this.y + this.dy;
        if (!this.tormaaEsteisiin) {
            this.x = uusiX;
            this.y = uusiY;
        } else if (voiLiikkuaPisteeseen(uusiX, uusiY)) {
            this.x = uusiX;
            this.y = uusiY;
        } else if (voiLiikkuaPisteeseen(this.x, uusiY)) {
            this.y = uusiY;
        } else if (voiLiikkuaPisteeseen(uusiX, this.y)) {
            this.x = uusiX;
        }
    }

    /**
     * Metodi kertoo olisiko hahmon mahdollista olla annetussa paikassa.
     *
     * @param a hahmon vasemman reunan x-koordinaatti tarkistettavassa paikassa
     * @param b hahmon yläreunan y-koordinaatti tarkistettavassa paikassa
     * @return tieto siitä onko paikka sallittu, totuusarvon muodossa
     */
    public boolean voiLiikkuaPisteeseen(int a, int b) {
        if ((a < 0) || (b < 0) || (a > 992) || (b > 480)) {
            return false;
        }
        if (this.kentta.pikseliKuuluuEsteeseen(a, b) || this.kentta.pikseliKuuluuEsteeseen(a, b + 31) || this.kentta.pikseliKuuluuEsteeseen(a + 31, b + 31) || this.kentta.pikseliKuuluuEsteeseen(a + 31, b)) {
            return false;
        }
        return true;

    }

    /**
     * Metodi kertoo kuuluuko annettu hahmon kentän pikseli hahmoon.
     *
     * @param a tarkistettavan pikselin x-koordinaatti
     * @param b tarkistettavan pikselin y-koordinaatti
     * @return tieto siitä onko pikseli (a, b) osa hahmoa, totuusarvon muodossa
     */
    public boolean kuuluukoPikseliHahmoon(int a, int b) {
        if (a >= this.x && b >= this.y) {
            if (a - this.x < 32 && b - this.y < 32) {
                return true;
            }
        }
        return false;
    }

}
