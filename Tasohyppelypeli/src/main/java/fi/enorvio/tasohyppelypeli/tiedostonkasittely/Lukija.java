/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli.tiedostonkasittely;

import fi.enorvio.tasohyppelypeli.logiikka.Vihollinen;
import java.util.*;
import java.io.*;
import fi.enorvio.tasohyppelypeli.*;

/**
 *
 * @author tabby
 */
/**
 * Luokka jonka avulla voidaan lukea tekstitiedostoja, joina kentät on
 * tallennettu.
 */
public class Lukija {

    private int[][] laatat;
    private ArrayList<Vihollinen> viholliset;
    private String tiedostonNimi;
    private Scanner tiedostonLukija;
    private File tiedosto;

    public void lataaKentta(String tiedostonNimi) {
        this.viholliset = new ArrayList<Vihollinen>();
        this.tiedostonNimi = tiedostonNimi;
        this.laatat = new int[16][32];
        try {
            this.tiedosto = new File(this.tiedostonNimi);
            this.tiedostonLukija = new Scanner(this.tiedosto);
            for (int i = 0; i < 16; i++) {
                int j = 0;
                String rivi = this.tiedostonLukija.nextLine();
                String[] osat = rivi.split(",");
                for (String osa : osat) {
                    if (osa.equals("1")) {
                        this.laatat[i][j] = 1;
                    } else if (osa.equals("0")) {
                        this.laatat[i][j] = 0;
                    } else if (osa.equals("2")) {
                        this.laatat[i][j] = 2;
                    } else if (osa.equals("4")) {
                        this.laatat[i][j] = 4;
                    }
                    j++;
                }
            }
            while (this.tiedostonLukija.hasNextLine()) {
                String rivi = this.tiedostonLukija.nextLine();
                this.viholliset.add(lataaVihollinen(rivi));
            }
            this.tiedostonLukija.close();
        } catch (Exception e) {
            System.out.println("Tiedostoa ei löydy.");
        }
    }

    public Vihollinen lataaVihollinen(String rivi) {
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
        return new Vihollinen(x, y, suunnat1, kaannospisteet1);
    }

    public ArrayList<Vihollinen> lataaViholliset() {
        return this.viholliset;
    }

    public int[][] lataaLaatat() {
        return this.laatat;
    }

}
