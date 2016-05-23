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
public class PelaajaTest {
    
    
    int[][] laatat = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
    Kentta testiKentta = new Kentta(laatat);
    Pelaaja testiPelaaja = new Pelaaja(testiKentta);
    
    public PelaajaTest() {
    }

    
   
    @Test
    public void testPelaajaOnIlmassa() {
        testiPelaaja.setX(48);
        for (int i=15; i>2; i--) {
            testiKentta.setLaatta(3, i, 1);
            while (testiPelaaja.pelaajaOnIlmassa()){
                testiPelaaja.liiku();
                }        
        assertEquals(testiPelaaja.getX(), 48);
        assertEquals(testiPelaaja.getY()+16, i*16);
        testiPelaaja.setY(0);
        testiKentta.setLaatta(3, i, 0);
    }  
        
    }
    
    @Test
    public void testOikeallaOnEste() {
        testiPelaaja.setX(0);
        testiPelaaja.setY(224);
        for (int i=30; i>0; i--) {
            testiKentta.setLaatta(i, 14, 1);
            while (!testiPelaaja.oikeallaOnEste()) {
                testiPelaaja.setOikeaTrue();
                testiPelaaja.liiku();
            }
            assertEquals(testiPelaaja.getX()+16, i*16);
            testiKentta.setLaatta(i, 14, 0);
            testiPelaaja.setX(0);
        }        
    }
    
    @Test
    public void testVasemmallaOnEste() {
        testiPelaaja.setX(496);
        testiPelaaja.setY(224);
        for (int i=0; i<31; i++) {
            testiKentta.setLaatta(i, 14, 1);
            while (!testiPelaaja.vasemmallaOnEste()) {
                testiPelaaja.setVasenTrue();
                testiPelaaja.liiku();
            }
            assertEquals(testiPelaaja.getX(), i*16+15);
            testiKentta.setLaatta(i, 14, 0);
            testiPelaaja.setX(496);
        }
    }
    
    @Test
    public void testYlhaallaOnEste() {
        testiPelaaja.setX(16);
        testiPelaaja.setY(224);
        for (int i=0; i<14; i++){
            testiKentta.setLaatta(1, i, 1);
            while (!testiPelaaja.ylhaallaOnEste()){
                testiPelaaja.setY(testiPelaaja.getY()-1);
            }
            assertEquals(testiPelaaja.getY(), i*16+15);
            testiKentta.setLaatta(2, i, 0);
            testiPelaaja.setY(224);
        }
    }
    
    @Test
    public void PelaajaMahtuuRaostaSivuttain(){
        testiPelaaja.setX(0);
        testiPelaaja.setY(224);
        testiKentta.setLaatta(6, 13, 1);
        testiKentta.setLaatta(31, 14, 1);
        while (!testiPelaaja.oikeallaOnEste()) {
                testiPelaaja.setOikeaTrue();
                testiPelaaja.liiku();
            }
        assertEquals(testiPelaaja.getX()+16, 496);
        testiKentta.setLaatta(6, 13, 0);
        testiKentta.setLaatta(31, 14, 0);
    }
    
    @Test
    public void PelaajaMahtuuRaostaPoikittain(){
        testiPelaaja.setX(16);
        testiPelaaja.setY(0);
        testiKentta.setLaatta(2, 6, 1);
        while (testiPelaaja.pelaajaOnIlmassa()){
                testiPelaaja.liiku();
                }  
        assertEquals(240, testiPelaaja.getY()+16);
        testiKentta.setLaatta(2, 6, 0);
    }
    
    
}
