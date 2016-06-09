/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli.logiikka;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author tabby
 */
public class KenttaTest {

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
    
    public KenttaTest() {
    }

    @Before
    public void setUp() {
        
    }

    @Test
    public void testSelvitaPikselinTyyppi() {
        for (int j = 0; j < 16; j++) {
            for (int i = 0; i < 32; i++) {
                assertEquals(laatat[j][i], testiKentta.selvitaPikselinTyyppi(i * 16, j * 16));
                assertEquals(laatat[j][i], testiKentta.selvitaPikselinTyyppi(i * 16, j * 16 + 15));
                assertEquals(laatat[j][i], testiKentta.selvitaPikselinTyyppi(i * 16 + 15, j * 16));
                assertEquals(laatat[j][i], testiKentta.selvitaPikselinTyyppi(i * 16 + 15, j * 16 + 15));
            }
        }
    }

    @Test
    public void testPoistaPiste() {
        for (int i = 0; i < 16; i++) {
            testiKentta.setLaatta(i, 1, 2);
            testiKentta.poistaPiste(i*16, 16);
            assertEquals(testiKentta.selvitaPikselinTyyppi(i*16, 16), 0);
        }
        
    }

    @Test
    public void testLuoTeleportti() {
        for (int i = 0; i < 16; i++) {
            testiKentta.luoTeleportti(i, 14, i, 0);
            assertEquals(testiKentta.getLaatta(i, 14), 4);
            assertEquals(testiKentta.getLaatta(i, 0), 4);
        } 
    }

    @Test
    public void testGetTeleportinToinenPaa() {
        for (int i = 0; i < 16; i++) {
            testiKentta.luoTeleportti(i, 14, i, 0);
            int[] alku = {i, 14};
            int[] loppu = {i, 0};
            assertEquals(testiKentta.getTeleportinToinenPaa(alku)[0], i);
            assertEquals(testiKentta.getTeleportinToinenPaa(alku)[1], 0);
            assertEquals(testiKentta.getTeleportinToinenPaa(loppu)[0], i);
            assertEquals(testiKentta.getTeleportinToinenPaa(loppu)[1], 14);
        } 
    }

}
