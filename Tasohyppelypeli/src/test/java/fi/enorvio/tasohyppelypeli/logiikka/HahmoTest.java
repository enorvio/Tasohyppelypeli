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
public class HahmoTest {
    
    int[][] laatat = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
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
    Hahmo testiHahmo = new Hahmo(0, 0, testiKentta);
    
    public HahmoTest() {
    }

    @Test
    public void testaaEttaPysahtyyAlareunaan() {
        System.out.println("Testataan ettei hahmo voi liikkua yläreunan ulkopuolelle.");
        assertFalse(testiHahmo.voiLiikkuaPisteeseen(8, -1));
    }

    @Test
    public void testaaEttaPysahtyyVasempaanReunaan() {
        System.out.println("Testataan ettei hahmo voi liikkua vasemman reunan ulkopuolelle.");
        assertFalse(testiHahmo.voiLiikkuaPisteeseen(-1, 12));
    }

    @Test
    public void testaaEttaPysahtyyOikeaanReunaan() {
        System.out.println("Testataan ettei hahmo voi liikkua oikean reunan ulkopuolelle.");
        assertFalse(testiHahmo.voiLiikkuaPisteeseen(993, 0));
    }

    @Test
    public void testVoiLiikkuaPisteeseen() {
        System.out.println("Testataan ettei hahmo voi liikkua laatan sisään.");
        testiHahmo.setTormaaEsteisiin(true);
        testiKentta.setLaatta(0, 0, 1);
        for (int x = 1; x < 30; x++) {
            for (int y = 1; y < 30; y++) {
                if (x < 32 && y < 32) {
                    assertFalse(testiHahmo.voiLiikkuaPisteeseen(x, y));
                } else {
                    assertTrue(testiHahmo.voiLiikkuaPisteeseen(x, y));
                }
            }
        }
        testiKentta.setLaatta(0, 0, 0);
    }

    @Test
    public void testaaEttaHahmoVoiMennaVasemmanReunanJaLaatanValiseenRakoon() {
        System.out.println("Testataan että hahmo voi liikkua ahtaimmassa mahdollisessa raossa vasemman reunan vieressä.");
        testiHahmo.setTormaaEsteisiin(true);
        testiHahmo.setX(0);
        testiHahmo.setY(0);
        for (int i = 0; i < 14; i++) {
            testiKentta.setLaatta(1, i, 1);
            assertTrue(testiHahmo.voiLiikkuaPisteeseen(0, i * 32));
            assertTrue(testiHahmo.voiLiikkuaPisteeseen(0, i * 32 + 3));
        }
        testiHahmo.setDy(1);
        for (int i = 0; i < 500; i++) {
            testiHahmo.liiku();
        }
        assertEquals(testiHahmo.getY(), 448);
        testiHahmo.setDy(0);
        for (int i = 0; i < 14; i++) {
            testiKentta.setLaatta(1, i, 0);
        }
    }

    @Test
    public void testaaEttaHahmoVoiMennaYlaReunanJaLaatanValiseenRakoon() {
        System.out.println("Testataan että hahmo voi liikkua ahtaimmassa mahdollisessa raossa yläreunan vieressä.");
        testiHahmo.setTormaaEsteisiin(true);
        testiHahmo.setX(0);
        testiHahmo.setY(0);
        for (int i = 0; i < 29; i++) {
            testiKentta.setLaatta(i, 1, 1);
            assertTrue(testiHahmo.voiLiikkuaPisteeseen(i * 32, 0));
            assertTrue(testiHahmo.voiLiikkuaPisteeseen(i * 32 + 3, 0));
        }
        testiHahmo.setDx(1);
        for (int i = 0; i < 1000; i++) {
            testiHahmo.liiku();
        }
        assertEquals(testiHahmo.getX(), 992);
        testiHahmo.setDx(0);
        for (int i = 0; i < 29; i++) {
            testiKentta.setLaatta(i, 1, 0);
        }
    }

    @Test
    public void testaaEttaHahmoVoiMennaKahdenLaatanValiseenRakoon() {
        System.out.println("Testataan että hahmo voi liikkua ahtaimmassa mahdollisessa kahden laatan välisessä raossa.");
        testiHahmo.setTormaaEsteisiin(true);
        testiHahmo.setX(32);
        testiHahmo.setY(0);
        testiHahmo.setDy(1);
        for (int i = 1; i < 13; i++) {
            testiKentta.setLaatta(0, i, 1);
            testiKentta.setLaatta(2, i, 1);
            assertTrue(testiHahmo.voiLiikkuaPisteeseen(32, i));
        }
        for (int i = 0; i < 500; i++) {
            testiHahmo.liiku();

        }
        assertEquals(testiHahmo.getY(), 448);
        for (int i = 1; i < 13; i++) {
            testiKentta.setLaatta(0, i, 0);
            testiKentta.setLaatta(2, i, 0);
        }
        testiHahmo.setDy(0);
    }

    @Test
    public void TestaaVinottaistaLiiketta() {
        testiHahmo.setX(0);
        testiHahmo.setY(0);
        testiHahmo.setDx(1);
        testiHahmo.setDy(1);
        for (int i = 0; i < 30; i++) {
            testiHahmo.liiku();
            assertEquals(testiHahmo.getX(), i + 1);
            assertEquals(testiHahmo.getY(), i + 1);
        }
        testiHahmo.setDx(0);
        testiHahmo.setDy(0);
    }


    @Test
    public void testKuuluukoPikseliHahmoon() {
        for (int i = 0; i < 32; i++) {
            for (int j = 0; i < 32; i++) {
                assertTrue(testiHahmo.kuuluukoPikseliHahmoon(testiHahmo.getX() + i, testiHahmo.getY() + j));
            }
        }
        for (int i = 0; i < 32; i++) {
            assertFalse(testiHahmo.kuuluukoPikseliHahmoon(testiHahmo.getX() + i, testiHahmo.getY() + 32));
            assertFalse(testiHahmo.kuuluukoPikseliHahmoon(testiHahmo.getX() + 32, testiHahmo.getY() + i));
        }
    }
    
    @Test
    public void testPelaajaOnIlmassa() {
        testiHahmo.setX(1);
        testiHahmo.setY(1);
        testiHahmo.setDy(1);
        testiHahmo.setTormaaEsteisiin(true);
        while (testiHahmo.pelaajaOnIlmassa()) {
            testiHahmo.liiku();
        }
        assertEquals(testiHahmo.getY(), 448);
    }
    
    @Test
    public void testYlhaallaOnEste() {
        testiHahmo.setX(1);
        testiHahmo.setY(448);
        testiHahmo.setDy(-1);
        testiHahmo.setTormaaEsteisiin(true);
        testiKentta.setLaatta(0, 0, 1);
        while (!testiHahmo.ylhaallaOnEste()) {
            testiHahmo.liiku();
        }
        assertEquals(testiHahmo.getY(), 32);
    }
    
}
