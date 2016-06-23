/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli.tiedostonkasittely;

import fi.enorvio.tasohyppelypeli.logiikka.Vihollinen;
import fi.enorvio.tasohyppelypeli.logiikka.Kentta;
import java.util.*;
import java.io.*;
import fi.enorvio.tasohyppelypeli.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

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

    /**
     * Metodi lataa tiedostosta kentän ja palauttaa sen valmiina Kentta-oliona.
     *
     * @param tiedostonNimi (teksti)tiedoston nimi, josta kenttä ladataan
     * @return tiedostoon tallennettu kenttä
     */    
    public Kentta lataaKentta(String tiedostonNimi) {
        this.viholliset = new ArrayList<Vihollinen>();
        this.tiedostonNimi = tiedostonNimi;
        this.laatat = new int[16][32];
        boolean onTeleportteja = false;
        try {
            this.tiedosto = new File(this.tiedostonNimi);
            this.tiedostonLukija = new Scanner(this.tiedosto);
            for (int i = 0; i < 16; i++) {
                int j = 0;
                String rivi = this.tiedostonLukija.nextLine();
                String[] osat = rivi.split(",");
                for (String osa : osat) {
                    this.laatat[i][j] = Integer.parseInt(osa);
                    j++;
                }
            }
            while (this.tiedostonLukija.hasNextLine()) {
                String rivi = this.tiedostonLukija.nextLine();
                if (rivi.equals("teleportit")) {
                    onTeleportteja = true;
                    break;
                }
                this.viholliset.add(lataaVihollinen(rivi));
            }
            Kentta kentta = new Kentta(this.laatat, this.viholliset);
            if (onTeleportteja) {
                while (this.tiedostonLukija.hasNextLine()) {
                    String rivi = this.tiedostonLukija.nextLine();
                    String[] osat = rivi.split(":");
                    int alkux = (int) Integer.parseInt(osat[0]);
                    int alkuy = (int) Integer.parseInt(osat[1]);
                    int loppux = (int) Integer.parseInt(osat[2]);
                    int loppuy = (int) Integer.parseInt(osat[3]);
                    kentta.luoTeleportti(alkux, alkuy, loppux, loppuy);
                }
            }
            this.tiedostonLukija.close();
            return kentta;
        } catch (Exception e) {
            System.out.println("Tiedostoa ei löydy.");
        }
        return null;
    }

    /**
     * Metodi luo Vihollisen String-esityksen perusteella.
     *
     * @param rivi luotavan vihollisen tiedot Stringinä
     * @return valmis Vihollinen
     */    
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
    
    /**
     * Metodi lataa kuvan kuvatiedostosta.
     *
     * @param kuvanTiedostonimi kuvatiedoston nimi, josta kuva ladataan
     * @return kuva BufferedImagena
     */    
    public BufferedImage lataaKuva(String kuvanTiedostonimi) {
        BufferedImage kuva = null;
        try {
            kuva = ImageIO.read(new File(kuvanTiedostonimi));
        } catch (IOException e) {
        }
        return kuva;
    }

    /**
     * Metodi lukee korkeimmat pisteet highscore.txt-tiedostosta ja palauttaa ne ArrayListinä.
     *
     * @return Pistetilastot merkkijonoina ArrayListissä
     */    
    public ArrayList<String> lataaPisteet() {
        ArrayList<String> pisteet = new ArrayList<String>();
        try {
            File pistetaulu = new File("src/main/resources/highscore.txt");
            this.tiedostonLukija = new Scanner(pistetaulu);
            while (this.tiedostonLukija.hasNextLine()) {
                String rivi = this.tiedostonLukija.nextLine();
                pisteet.add(rivi);
            }
        } catch (Exception e) {
            System.out.println("tiedostoa ei löydy");
        }
        return pisteet;
    }

     /**
     * Metodi kirjoittaa ArrayListinä annetut pistetilastot highscore.txt-tiedostoon.
     *
     * @param pisteet Pistetilastot merkkijonoina ArrayListissä
     */ 
    public void kirjoitaPisteet(ArrayList<String> pisteet) {
        try {
            FileWriter kirjoittaja = new FileWriter("src/main/resources/highscore.txt");
            for (String piste : pisteet) {
                kirjoittaja.write(piste + "\n");
            }
            kirjoittaja.close();
        } catch (IOException e) {
            System.out.println("jotain meni vituiks pisteiden kirjoittamisessa");
        }

    }

    /**
     * Metodi tarkistaa, pääsevätkö annetut pisteet top10:een ja jos ne pääsevät, päivittää ne oikealle paikalleen highscore.txt-tiedostoon.
     *
     * @param nimi pelaajan nimi
     * @param pisteet pelaajan saamat pisteet
     */ 
    public void tallennaPisteet(String nimi, int pisteet) {
        ArrayList<String> nykyisetPisteet = this.lataaPisteet();
        int pistesija = -1;
        for (int i = 0; i < nykyisetPisteet.size(); i++) {
            String[] osat = nykyisetPisteet.get(i).split(":");
            if (pisteet > Integer.parseInt(osat[1])) {
                pistesija = i;
                break;
            }
        }
        if (pistesija >= 0) {
            nykyisetPisteet.add(pistesija, nimi + ":" + pisteet);
            nykyisetPisteet.remove(nykyisetPisteet.size() - 1);
            kirjoitaPisteet(nykyisetPisteet);
        }
    }

}
