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
import fi.enorvio.tasohyppelypeli.logiikka.Vihollinen;
import java.util.*;
import java.io.*;

/**
 * Luokka tarjoaa toiminnallisuuden tasohyppelypelin yksittäisen tason luomiseen
 * ja tiedon saamiseen sen kustakin laatasta (tile), vihollisesta ja
 * teleportista.
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

    public int selvitaPikselinTyyppi(int x, int y) {
        int sarake = x / 32;
        int rivi = y / 32;
        return this.laatat[rivi][sarake];
    }

    public boolean pikseliKuuluuEsteeseen(int x, int y) {
        int tyyppi = selvitaPikselinTyyppi(x, y);
        if (tyyppi !=0 && tyyppi < 50) {
            return true;
        }
        return false;
    }
    
    public boolean pikseliKuuluuTeleporttiin(int x, int y) {
        int tyyppi = selvitaPikselinTyyppi(x, y);
        if (tyyppi >71 && tyyppi <= 73) {
            return true;
        }
        return false;
    }
    
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

    public void luoTeleportti(int alkux, int alkuy, int loppux, int loppuy) {
        int[] alku = {alkux, alkuy};
        int[] loppu = {loppux, loppuy};
        this.teleportit.put(alku, loppu);
        this.teleportit.put(loppu, alku);
        this.setLaatta(alkux, alkuy, 72);
        this.setLaatta(loppux, loppuy, 72);
    }

    public void tulostaTeleportit() {
        for (int[] alku : this.teleportit.keySet()) {
            System.out.println("alku: " + alku[0] + ", " + alku[1] + ", loppu: " + this.teleportit.get(alku)[0] + ", " + this.teleportit.get(alku)[1]);
        }
    }

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
