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
public class Grafiikka {
    private HashMap<Integer, BufferedImage> kuvat;
    private Lukija lukija;
    
    public Grafiikka() {
        this.lukija = new Lukija();
        this.kuvat = new HashMap<Integer, BufferedImage>();
        for (int i = 0; i < 100; i++) {
            String tiedostonimi = "src/main/resources/" + i + ".png";
            this.kuvat.put(i, this.lukija.lataaKuva(tiedostonimi));            
        }
    }
    
    public BufferedImage haeKuva(int kuvanNumero) {
        return this.kuvat.get(kuvanNumero);
    }
}
