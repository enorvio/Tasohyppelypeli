/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tabby
 */
public class KenttaTest {

    public KenttaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    int[][] laatat = {{1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1}};
    Kentta testiKentta = new Kentta(laatat);

    @Test
    public void testaaKuuluukoKeskellaOlevaPikseliEsteeseen() {
        System.out.println("Testataan että laattojen keskellä olevista pikseleistä havaitaan kuuluvatko ne esteeseen.");
        for (int i = 0; i < 32; i++) {
            if (testiKentta.getLaatta(i, 6) == 0) {
                assertFalse(testiKentta.kuuluukoPikseliEsteeseen(16 * i + 2, 98));
            } else {
                assertTrue(testiKentta.kuuluukoPikseliEsteeseen(16 * i + 2, 98));
            }

        }
    }

    @Test
    public void testaaKuuluukoVasemmanReunanPikseliEsteeseen() {
        System.out.println("Testataan että laattojen vasemmassa reunassa olevista pikseleistä havaitaan kuuluvatko ne esteeseen.");
        for (int i = 0; i < 32; i++) {
            if (testiKentta.getLaatta(i, 6) == 0) {
                assertFalse(testiKentta.kuuluukoPikseliEsteeseen(16 * i, 98));
            } else {
                assertTrue(testiKentta.kuuluukoPikseliEsteeseen(16 * i, 98));
            }

        }
    }

    @Test
    public void testaaKuuluukoOikeanReunanPikseliEsteeseen() {
        System.out.println("Testataan että laattojen vasemmassa reunassa olevista pikseleistä havaitaan kuuluvatko ne esteeseen.");
        for (int i = 0; i < 32; i++) {
            if (testiKentta.getLaatta(i, 6) == 0) {
                assertFalse(testiKentta.kuuluukoPikseliEsteeseen(16 * i + 15, 98));
            } else {
                assertTrue(testiKentta.kuuluukoPikseliEsteeseen(16 * i + 15, 98));
            }

        }
    }

    @Test
    public void testaaKuuluukoYlaReunanPikseliEsteeseen() {
        System.out.println("Testataan että laattojen yläreunassa olevista pikseleistä havaitaan kuuluvatko ne esteeseen.");
        for (int i = 1; i < 16; i++) {
            if (testiKentta.getLaatta(6, i) == 0) {
                assertFalse(testiKentta.kuuluukoPikseliEsteeseen(98, 16 * i));
            } else {
                assertTrue(testiKentta.kuuluukoPikseliEsteeseen(98, 16 * i));
            }

        }
    }

    @Test
    public void testaaKuuluukoAlaReunanPikseliEsteeseen() {
        System.out.println("Testataan että laattojen yläreunassa olevista pikseleistä havaitaan kuuluvatko ne esteeseen.");
        for (int i = 0; i < 16; i++) {
            if (testiKentta.getLaatta(6, i) == 0) {
                assertFalse(testiKentta.kuuluukoPikseliEsteeseen(98, 16 * i + 15));
            } else {
                assertTrue(testiKentta.kuuluukoPikseliEsteeseen(98, 16 * i + 15));
            }

        }
    }
    
    @Test
    public void testaaEttaVihollisetLuetaanTiedostostaOikein() {
        System.out.println("Testataan että kaikki viholliset saadaan tiedostosta oikein.");
        Kentta testiKentta2 = new Kentta("src/main/resources/esimerkkiTaso2.txt");
        assertEquals(testiKentta2.getViholliset().get(0).toString(), "Vihollinen pisteessa x = 80, y = 80, on nyt reitinosuudella 0, suunnat: drul, kaannospisteet 80 250 0 80");   
        assertEquals(testiKentta2.getViholliset().get(1).toString(), "Vihollinen pisteessa x = 30, y = 30, on nyt reitinosuudella 0, suunnat: drul, kaannospisteet 30 90 4 30");
        assertEquals(testiKentta2.getViholliset().size(), 2);
        
    }
    
    @Test
    public void testaaEttaKaikkiTiedostonRivitLuetaan() {
        System.out.println("Testataan että kentän kaikki laattarivit luetaan.");
        Kentta testiKentta2 = new Kentta("src/main/resources/esimerkkiTaso2.txt");
        assertEquals(testiKentta2.getLaatta(15, 15), 1);
        
    }
    
    @Test
    public void testaaEttaPisteetEivatEstaLiikkumista() {
        System.out.println("Testataan että pisteitä sisältäviä ruutuja ei tulkita esteeksi.");
        for (int i = 0; i < 32; i++) {
            testiKentta.setLaatta(i, 5, 2);
            assertFalse(testiKentta.kuuluukoPikseliEsteeseen(i * 16, 80));
            assertFalse(testiKentta.kuuluukoPikseliEsteeseen (i * 16 + 15, 80));
            assertFalse(testiKentta.kuuluukoPikseliEsteeseen (i * 16 + 8, 80));
        } 
        
    }
    
    @Test
    public void testataanPisteidenPoimimista() {
        System.out.println("");
        for (int i = 0; i < 32; i++) {
            testiKentta.setLaatta(i, 5, 2);
            assertFalse(testiKentta.kuuluukoPikseliEsteeseen(i * 16, 80));
            assertEquals(testiKentta.getLaatta(i, 5), 0);            
        } 
        assertEquals(testiKentta.getPisteet(), 32);
    }
    
   
}
