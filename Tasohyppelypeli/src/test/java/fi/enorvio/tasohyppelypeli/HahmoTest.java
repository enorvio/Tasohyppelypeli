/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tabby
 */
public class HahmoTest {
    
    int[][] laatat = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
    Kentta testiKentta = new Kentta(laatat);
    Hahmo testiHahmo = new Hahmo(0, 0);
    
    public HahmoTest() {
        
    }

    /**
     * Test of setTormaaEsteisiin method, of class Hahmo.
     */
    @Test
    public void testaaEttaEsteidenLapiMenoToimiiOikein() {
        testiHahmo.setTormaaEsteisiin(false);
        
    }

    
    
 
    @Test
    public void testaaEttaHahmoPysahtyyYlareunaan() {
        testiHahmo.setTormaaEsteisiin(true);
        testiHahmo.setX(10);
        testiHahmo.setY(10);
        testiHahmo.setYlos(true);
        while(testiHahmo.getY()>=1) {
            testiHahmo.liiku(testiKentta);
        }
        assertEquals(testiHahmo.getY(), 0);
    }

    /**
     * Test of setAlas method, of class Hahmo.
     */
    @Test
    public void testSetAlas() {
    }

    /**
     * Test of pelaajaOnIlmassa method, of class Hahmo.
     */
    @Test
    public void testPelaajaOnIlmassa() {
        testiHahmo.setX(48);
        testiHahmo.setTormaaEsteisiin(true);
        for (int i = 15; i > 2; i--) {
            testiKentta.setLaatta(3, i, 1);
            testiHahmo.setAlas(true);
            while (testiHahmo.pelaajaOnIlmassa(testiKentta)) {
                testiHahmo.liiku(testiKentta);
            }
            assertEquals(testiHahmo.getX(), 48);
            assertEquals(testiHahmo.getY() + 16, i * 16);
            testiHahmo.setY(0);
            testiKentta.setLaatta(3, i, 0);
        }
        testiHahmo.setAlas(false);
        
    }
        
    

    /**
     * Test of oikeallaOnEste method, of class Hahmo.
     */
    @Test
    public void testOikeallaOnEste() {
    }

    /**
     * Test of vasemmallaOnEste method, of class Hahmo.
     */
    @Test
    public void testVasemmallaOnEste() {
    }

    /**
     * Test of ylhaallaOnEste method, of class Hahmo.
     */
    @Test
    public void testYlhaallaOnEste() {
    }

    /**
     * Test of liikuVasemmalle method, of class Hahmo.
     */
    @Test
    public void testLiikuVasemmalle() {
    }

    /**
     * Test of liikuOikealle method, of class Hahmo.
     */
    @Test
    public void testLiikuOikealle() {
    }

    /**
     * Test of liikuAlas method, of class Hahmo.
     */
    @Test
    public void testLiikuAlas() {
    }

    /**
     * Test of liikuYlos method, of class Hahmo.
     */
    @Test
    public void testLiikuYlos() {
    }

    /**
     * Test of liiku method, of class Hahmo.
     */
    @Test
    public void testLiiku() {
    }

    /**
     * Test of kuuluukoPikseliHahmoon method, of class Hahmo.
     */
    @Test
    public void testKuuluukoPikseliHahmoon() {
    }
    
}
