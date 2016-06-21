/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli.kayttoliittyma;


import javax.imageio.ImageIO;
import java.awt.image.*;
import java.util.HashMap;
import fi.enorvio.tasohyppelypeli.tiedostonkasittely.Lukija;
/**
 *
 * @author tabby
 */

/**
 * Luokka sisältää HashMapin, jossa säilytetään pelin tarvitsemia BufferedImage-kuvia, sekä metodin niiden palauttamiseen avaimen perusteella.
 */
public class Grafiikka {
    private HashMap<Integer, BufferedImage> kuvat;
    private Lukija lukija;
    
    /**
     * Metodi on Grafiikka-luokan konstruktori. 
     *
     */   
    public Grafiikka() {
        this.lukija = new Lukija();
        this.kuvat = new HashMap<Integer, BufferedImage>();
        for (int i = 0; i < 110; i++) {
            String tiedostonimi = "src/main/resources/" + i + ".png";
            this.kuvat.put(i, this.lukija.lataaKuva(tiedostonimi));            
        }
    }
    
    /**
     * Metodi palauttaa kuvan sen numerosarjan perusteella.
     *
     * @param kuvanNumero kuvaa vastaava tunnusnumero
     * @return numeroa vastaava BufferedImage-olio
     */     
    public BufferedImage haeKuva(int kuvanNumero) {
        return this.kuvat.get(kuvanNumero);
    }
}
