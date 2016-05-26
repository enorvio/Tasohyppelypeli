/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli;

/**
 *
 * @author tabby
 */


public class Kentta {
    private int leveys;
    private int korkeus;
    private int laatanLeveys;
    private int laatanKorkeus;
    private int[][] laatat; 
    private Vihollinen[] viholliset;
    
    public Kentta(int[][] laatat) {
        this.leveys = 32;
        this.korkeus = 16;
        this.laatanLeveys = 16;
        this.laatanKorkeus = 16;
        this.laatat = laatat;
    }
    
    public Kentta(int[][] laatat, Vihollinen[] viholliset) {
        this.leveys = 32;
        this.korkeus = 16;
        this.laatanLeveys = 16;
        this.laatanKorkeus = 16;
        this.laatat = laatat;
        this.viholliset = viholliset;
    }
    
    public Vihollinen[] getViholliset() {
        return this.viholliset;
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
    
    public boolean kuuluukoPikseliEsteeseen(int x, int y) {
        int sarake = x / 16;
        int rivi = y / 16;
        if (this.laatat[rivi][sarake] == 1) {
            return true;
        }
        return false;
    }
    
}

