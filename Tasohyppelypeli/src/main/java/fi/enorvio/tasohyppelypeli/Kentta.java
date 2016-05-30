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
import java.util.*;
import java.io.*;

public class Kentta {
    private int leveys;
    private int korkeus;
    private int laatanLeveys;
    private int laatanKorkeus;
    private int[][] laatat; 
    private ArrayList<Vihollinen> viholliset;
    private int pisteet;
    
    public Kentta(int[][] laatat) {
        this.leveys = 32;
        this.korkeus = 16;
        this.laatanLeveys = 16;
        this.laatanKorkeus = 16;
        this.laatat = laatat;
        this.pisteet = 0;
        this.viholliset = new ArrayList<Vihollinen>();
    }
    
    public Kentta(String tiedostonnimi) {
        this.leveys = 32;
        this.korkeus = 16;
        this.laatanLeveys = 16;
        this.laatanKorkeus = 16;
        this.laatat = new int[16][32];
        this.pisteet = 0;
        this.viholliset = new ArrayList<Vihollinen>();
        try {
            File tiedosto = new File(tiedostonnimi);
            Scanner lukija = new Scanner(tiedosto);
            for (int i=0; i<16; i++) {
                int j = 0;
                String rivi = lukija.nextLine();
                String[] osat = rivi.split(","); 
                for (String osa : osat) {
                    if (osa.equals("1")) {
                        this.laatat[i][j] = 1;
                    } else if (osa.equals("0")) {
                        this.laatat[i][j] = 0;
                    } else if (osa.equals("2")) {
                        this.laatat[i][j] = 2;
                    }
                j++;
            }
            }
            while (lukija.hasNextLine()) {
                String rivi = lukija.nextLine();
                String[] osat = rivi.split(",");
                int x = Integer.parseInt(osat[0]);
                int y = Integer.parseInt(osat[1]);
                String suunnat = osat[2];
                char[] suunnat1 = new char[suunnat.length()];
                for (int i = 0; i < suunnat.length(); i++) {
                    suunnat1[i] = suunnat.charAt(i);
                }
                String[] kaannospisteet = osat[3].split(":");
                int[] kaannospisteet1 = new int[kaannospisteet.length];
                    for (int i = 0; i < kaannospisteet.length; i++) {
                        kaannospisteet1[i] = Integer.parseInt(kaannospisteet[i]);
                    }
                this.viholliset.add(new Vihollinen(x, y, suunnat1, kaannospisteet1));
            }
            lukija.close();
  } catch (Exception e) {
      System.out.println("Tiedostoa ei loydy");
  }
    }
    
    
    public ArrayList<Vihollinen> getViholliset() {
        return this.viholliset;
    }
    
    public int getPisteet() {
        return this.pisteet;
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
        } else if (this.laatat[rivi][sarake] == 2) {
            if (Math.abs(x - (16 * sarake) + 7) < 10) {
                if ((Math.abs(y - (16 * rivi) + 7) < 10)) {
                    this.laatat[rivi][sarake] = 0;
                    this.pisteet++;
                }
            }
        }
        for (Vihollinen vihollinen : this.viholliset) {
            if (vihollinen.kuuluukoPikseliHahmoon(x, y)) {
                return true;
            }
        }
        return false;
    }
    
}

