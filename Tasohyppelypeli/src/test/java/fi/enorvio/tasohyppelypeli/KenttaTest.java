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
    {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
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
        for (int i = 0; i < 16; i++) {
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

}
