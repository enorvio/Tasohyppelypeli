/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli.logiikka;

import fi.enorvio.tasohyppelypeli.logiikka.Kentta;
import fi.enorvio.tasohyppelypeli.logiikka.Vihollinen;
import fi.enorvio.tasohyppelypeli.logiikka.Pelaaja;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author enorvio
 */
public class VihollinenTest {

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
    char[] suunnat = {'u', 'r', 'd', 'l'};
    int[] kaannospisteet = {0, 496, 240, 0};
    Vihollinen testiVihollinen = new Vihollinen(0, 0, suunnat, kaannospisteet);

    public VihollinenTest() {
    }

    @Test
    public void testToString() {
        for (int i = 0; i < 40; i++) {
            testiVihollinen.liiku();
        }
        assertEquals(testiVihollinen.toString(), "Vihollinen pisteessa x = 40, y = 0, on nyt reitinosuudella 1, suunnat: urdl, kaannospisteet 0 496 240 0");
    }

    @Test
    public void testLiiku() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; i < 60; i++) {
                testiVihollinen.liiku();
            }
            if (testiVihollinen.getSuunnat()[testiVihollinen.getReitinOsuus()] == 'u') {
                assertEquals(testiVihollinen.getDx(), 0);
                assertEquals(testiVihollinen.getDy(), -1);
            } else if (testiVihollinen.getSuunnat()[testiVihollinen.getReitinOsuus()] == 'd') {
                assertEquals(testiVihollinen.getDx(), 0);
                assertEquals(testiVihollinen.getDy(), 1);
            } else if (testiVihollinen.getSuunnat()[testiVihollinen.getReitinOsuus()] == 'l') {
                assertEquals(testiVihollinen.getDx(), -1);
                assertEquals(testiVihollinen.getDy(), 0);
            } else if (testiVihollinen.getSuunnat()[testiVihollinen.getReitinOsuus()] == 'r') {
                assertEquals(testiVihollinen.getDx(), 1);
                assertEquals(testiVihollinen.getDy(), 0);
            }
        }

    }
    
    @Test 
    public void testKaanny() {
        testiVihollinen.kaanny();
        assertEquals(testiVihollinen.getSuunnat()[testiVihollinen.getReitinOsuus()],'r');
        assertEquals(testiVihollinen.getDy(), 0);
        assertEquals(testiVihollinen.getDx(), 1);
    }

    
   
}
