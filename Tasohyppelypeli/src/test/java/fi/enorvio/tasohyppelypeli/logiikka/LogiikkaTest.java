/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli.logiikka;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tabby
 */
public class LogiikkaTest {
    
    String[] kentanNimet = {"src/main/resources/kentta4.txt"};
    Logiikka testiLogiikka = new Logiikka(kentanNimet);
    
    public LogiikkaTest() {
        
    }

    @Test
    public void testResetoiKentta() {
        testiLogiikka.getPelaaja().getKentta().setLaatta(15, 15, 4);
        for (Vihollinen vihollinen : testiLogiikka.getPelaaja().getKentta().getViholliset()) {
            vihollinen.kuole();
        }
        testiLogiikka.resetoiKentta();
        assertFalse(testiLogiikka.getPelaaja().getKentta().getLaatta(15, 15) == 4);
        for (Vihollinen vihollinen : testiLogiikka.getPelaaja().getKentta().getViholliset()) {
            assertTrue(vihollinen.onElossa());
        }
    }

    @Test
    public void testSeuraavaKentta() {
        testiLogiikka.getPelaaja().setPisteet(1);
        testiLogiikka.getPelaaja().getKentta().setPisteet(8);
        testiLogiikka.seuraavaKentta();
        assertEquals(testiLogiikka.getPelaaja().getPisteet(), 9);
    }
    
    @Test
    public void testaaEttaElamatPaivittyvatSeuraavaanKenttaan() {
        testiLogiikka.getPelaaja().getKentta().setLaatta(0, 1, 70);
        testiLogiikka.getPelaaja().setX(1);
        testiLogiikka.getPelaaja().setY(1);
        for (int i = 0; i < 50; i++) {
            testiLogiikka.paivita();
        }
        testiLogiikka.seuraavaKentta();
        assertEquals(testiLogiikka.getPelaaja().getElamat(), 10);
    }

    @Test
    public void testKuoleminenResetoiKentan() {
        testiLogiikka.resetoiKentta();
        for (int i = 0; i<500; i++) {
            testiLogiikka.paivita();
        }
        testiLogiikka.getPelaaja().kuole();
        testiLogiikka.paivita();
        assertEquals(testiLogiikka.getPelaaja().getY(), 2);
    }
    
    @Test
    public void testPaivita() {
        for (int i = 0; i<500; i++) {
            testiLogiikka.paivita();
        }
        assertEquals(testiLogiikka.getPelaaja().getY(), 416);
    }
    
    @Test
    public void vihollinenTappaaPelaajan() {
        testiLogiikka.resetoiKentta();
        char[] suunnat = {'l', 'r'};
        int[] kaannospisteet = {1, 1};
        testiLogiikka.getPelaaja().getKentta().getViholliset().add(new Vihollinen(1, 1, suunnat, kaannospisteet));
        for(int i = 0; i < 10; i++) {
            testiLogiikka.paivita();
        }    
        assertEquals(testiLogiikka.getPelaaja().getElamat(), 8);
    }
    
    @Test
    public void testaaLopullistaKuolemista() {
        testiLogiikka.getPelaaja().setElamat(0);
        testiLogiikka.getPelaaja().kuole();
        testiLogiikka.paivita();
        assertFalse(testiLogiikka.jatkuu());
    }
    
}
