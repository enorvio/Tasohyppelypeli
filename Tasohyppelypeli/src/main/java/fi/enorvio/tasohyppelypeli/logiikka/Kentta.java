
package fi.enorvio.tasohyppelypeli.logiikka;

/**
 *
 * @author tabby
 */
import fi.enorvio.tasohyppelypeli.logiikka.Vihollinen;
import java.util.*;
import java.io.*;

/**
 * Luokka tarjoaa toiminnallisuuden tasohyppelypelin tason luomiseen ja tiedon
 * saamiseen sen kustakin laatasta, vihollisesta ja teleportista.
 */
public class Kentta {

    private int leveys;
    private int korkeus;
    private int laatanLeveys;
    private int laatanKorkeus;
    private int[][] laatat;
    private ArrayList<Vihollinen> viholliset;
    private int pisteet;
    private int elamat;
    private HashMap<int[], int[]> teleportit;

    public Kentta(int[][] laatat) {
        this.leveys = 32;
        this.korkeus = 16;
        this.laatanLeveys = 16;
        this.laatanKorkeus = 16;
        this.laatat = laatat;
        this.pisteet = 0;
        this.viholliset = new ArrayList<Vihollinen>();
        this.teleportit = new HashMap<int[], int[]>();
    }

    public Kentta(int[][] laatat, ArrayList<Vihollinen> viholliset) {
        this.leveys = 32;
        this.korkeus = 16;
        this.laatanLeveys = 16;
        this.laatanKorkeus = 16;
        this.laatat = laatat;
        this.pisteet = 0;
        this.viholliset = viholliset;
        this.teleportit = new HashMap<int[], int[]>();
    }

    public ArrayList<Vihollinen> getViholliset() {
        return this.viholliset;
    }

    public int getPisteet() {
        return this.pisteet;
    }

    public void setPisteet(int pisteet) {
        this.pisteet = pisteet;
    }

    public int getElamat() {
        return this.elamat;
    }

    public int getLeveys() {
        return this.leveys;
    }

    public int getKorkeus() {
        return this.korkeus;
    }

    public int getLaatta(int x, int y) {
        return this.laatat[y][x];
    }

    public void setLaatta(int x, int y, int arvo) {
        this.laatat[y][x] = arvo;
    }

    /**
     * Metodi kertoo millaiseen laattaan annettu pikseli kuuluu.
     *
     * @param x pikselin x-koordinaatti
     * @param y pikselin y-koordinaatti
     * @return laatan tyyppi kokonaislukuna (numerot 0-110)
     */
    public int selvitaPikselinTyyppi(int x, int y) {
        int sarake = x / 32;
        int rivi = y / 32;
        return this.laatat[rivi][sarake];
    }

    /**
     * Metodi kertoo kuuluuko pikseli kiinteään laattaan tai reunaan.
     *
     * @param x pikselin x-koordinaatti
     * @param y pikselin y-koordinaatti
     * @return boolean: onko laatta kiinteä
     */
    public boolean pikseliKuuluuEsteeseen(int x, int y) {
        int tyyppi = selvitaPikselinTyyppi(x, y);
        if (tyyppi != 0 && tyyppi < 50) {
            return true;
        }
        return false;
    }

    /**
     * Metodi kertoo kuuluuko annettu pikseli johonkin teleporttiin.
     *
     * @param x pikselin x-koordinaatti
     * @param y pikselin y-koordinaatti
     * @return boolean: kuuluuko pikseli teleporttiin
     */
    public boolean pikseliKuuluuTeleporttiin(int x, int y) {
        int tyyppi = selvitaPikselinTyyppi(x, y);
        if (tyyppi > 71 && tyyppi <= 73) {
            return true;
        }
        return false;
    }

    /**
     * Metodi poimii pelaajalle pisteen annetusta koordinaatista.
     *
     * @param x pikselin x-koordinaatti
     * @param y pikselin y-koordinaatti
     */
    public void poistaPiste(int x, int y) {
        int tyyppi = selvitaPikselinTyyppi(x, y);
        int sarake = x / 32;
        int rivi = y / 32;
        if (tyyppi >= 50 && tyyppi <= 71 && (Math.abs(x - 32 * sarake) < 10) && (Math.abs(x - 32 * sarake) < 10)) {
            this.setLaatta(sarake, rivi, 0);
            if (tyyppi < 60) {
                this.pisteet++;
            } else if (tyyppi == 60) {
                this.pisteet += 2;
            } else if (tyyppi < 63) {
                this.pisteet += 5;
            } else if (tyyppi == 64) {
                this.pisteet += 10;
            } else if (tyyppi == 65) {
                this.pisteet += 25;
            } else if (tyyppi == 66) {
                this.pisteet += 50;
            } else if (tyyppi == 67) {
                this.pisteet += 100;
            } else if (tyyppi == 68) {
                this.pisteet += 1000;
            } else if (tyyppi == 69) {
                this.pisteet += 10000;
            } else if (tyyppi == 70) {
                this.elamat++;
            } else if (tyyppi == 71) {
                this.elamat += 10;
            }
        }
    }

    /**
     * Metodi luo kenttään uuden teleportin.
     *
     * @param alkux teleportin alkupään x-koordinaatti
     * @param alkuy teleportin alkupään y-koordinaatti
     * @param loppux teleportin loppupään x-koordinaatti
     * @param loppuy teleportin loppupään y-koordinaatti
     */
    public void luoTeleportti(int alkux, int alkuy, int loppux, int loppuy) {
        int[] alku = {alkux, alkuy};
        int[] loppu = {loppux, loppuy};
        this.teleportit.put(alku, loppu);
        this.teleportit.put(loppu, alku);
        this.setLaatta(alkux, alkuy, 72);
        this.setLaatta(loppux, loppuy, 72);
    }

    /**
     * Metodi kertoo missä teleportin toinen pää on.
     *
     * @param alku teleportin alkupään koordinaatit
     * @return teleportin loppupään koordinaatit (2-paikkainen taulukko)
     */
    public int[] getTeleportinToinenPaa(int[] alku) {
        for (int[] taulukko : this.teleportit.keySet()) {
            if (Arrays.equals(taulukko, alku)) {
                return this.teleportit.get(taulukko);
            }
        }
        return null;
    }

    public HashMap<int[], int[]> getTeleportit() {
        return this.teleportit;
    }
}
