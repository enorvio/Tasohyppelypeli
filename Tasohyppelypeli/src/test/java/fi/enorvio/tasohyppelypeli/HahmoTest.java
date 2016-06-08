/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli;

import fi.enorvio.tasohyppelypeli.logiikka.Kentta;
import fi.enorvio.tasohyppelypeli.logiikka.Hahmo;
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
    Hahmo testiHahmo = new Hahmo(0, 0);

    public HahmoTest() {

    }

    @Test
    public void testKuuluukoPikseliHahmoon() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; i < 16; i++) {
                assertTrue(testiHahmo.kuuluukoPikseliHahmoon(testiHahmo.getX() + i, testiHahmo.getY() + j));
            }
        }
        for (int i = 0; i < 16; i++) {
            assertFalse(testiHahmo.kuuluukoPikseliHahmoon(testiHahmo.getX() + i, testiHahmo.getY() + 16));
            assertFalse(testiHahmo.kuuluukoPikseliHahmoon(testiHahmo.getX() + 16, testiHahmo.getY() + i));
        }
    }

    @Test
    public void testaaEttaPysahtyyAlareunaan() {
        System.out.println("Testataan ettei hahmo voi liikkua yläreunan ulkopuolelle.");
        assertFalse(testiHahmo.voiLiikkuaPisteeseen(testiKentta, 8, -1));
    }

    @Test
    public void testaaEttaPysahtyyVasempaanReunaan() {
        System.out.println("Testataan ettei hahmo voi liikkua vasemman reunan ulkopuolelle.");
        assertFalse(testiHahmo.voiLiikkuaPisteeseen(testiKentta, -1, 12));
    }

    @Test
    public void testaaEttaPysahtyyOikeaanReunaan() {
        System.out.println("Testataan ettei hahmo voi liikkua oikean reunan ulkopuolelle.");
        assertFalse(testiHahmo.voiLiikkuaPisteeseen(testiKentta, 497, 0));
    }

    @Test
    public void testVoiLiikkuaPisteeseen() {
        System.out.println("Testataan ettei hahmo voi liikkua laatan sisään.");
        testiHahmo.setTormaaEsteisiin(true);
        testiKentta.setLaatta(0, 0, 1);
        for (int x = 1; x < 30; x++) {
            for (int y = 1; y < 30; y++) {
                if (x < 16 && y < 16) {
                    assertFalse(testiHahmo.voiLiikkuaPisteeseen(testiKentta, x, y));
                } else {
                    assertTrue(testiHahmo.voiLiikkuaPisteeseen(testiKentta, x, y));
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
            assertTrue(testiHahmo.voiLiikkuaPisteeseen(testiKentta, 0, i * 16));
            assertTrue(testiHahmo.voiLiikkuaPisteeseen(testiKentta, 0, i * 16 + 3));
        }
        testiHahmo.setDy(1);
        for (int i = 0; i < 500; i++) {
            testiHahmo.liiku(testiKentta);
        }
        assertEquals(testiHahmo.getY(), 224);
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
            assertTrue(testiHahmo.voiLiikkuaPisteeseen(testiKentta, i * 16, 0));
            assertTrue(testiHahmo.voiLiikkuaPisteeseen(testiKentta, i * 16 + 3, 0));
        }
        testiHahmo.setDx(1);
        for (int i = 0; i < 500; i++) {
            testiHahmo.liiku(testiKentta);
        }
        assertEquals(testiHahmo.getX(), 496);
        testiHahmo.setDx(0);
        for (int i = 0; i < 29; i++) {
            testiKentta.setLaatta(i, 1, 0);
        }
    }

    @Test
    public void testaaEttaHahmoVoiMennaKahdenLaatanValiseenRakoon() {
        System.out.println("Testataan että hahmo voi liikkua ahtaimmassa mahdollisessa kahden laatan välisessä raossa.");
        testiHahmo.setTormaaEsteisiin(true);
        testiHahmo.setX(16);
        testiHahmo.setY(0);
        testiHahmo.setDy(1);
        for (int i = 1; i < 13; i++) {
            testiKentta.setLaatta(0, i, 1);
            testiKentta.setLaatta(2, i, 1);
            assertTrue(testiHahmo.voiLiikkuaPisteeseen(testiKentta, 16, i));
        }
        for (int i = 0; i < 500; i++) {
            testiHahmo.liiku(testiKentta);

        }
        assertEquals(testiHahmo.getY(), 224);
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
            testiHahmo.liiku(testiKentta);
            assertEquals(testiHahmo.getX(), i + 1);
            assertEquals(testiHahmo.getY(), i + 1);
        }
        testiHahmo.setDx(0);
        testiHahmo.setDy(0);
    }

}
