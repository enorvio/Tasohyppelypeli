/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli;

/**
 *
 * @author tabby
 */
public class Pelaaja extends Hahmo {
    
    private Kentta kentta;
    private int hyppy;
    
    public Pelaaja(Kentta kentta) {
        super(0, 0);
        this.hyppy = 0;
        this.kentta = kentta;
        super.setTormaaEsteisiin(true);
    }
    
    public Kentta getKentta() {
        return this.kentta;
    }
    
    private void havaitseTormaysViholliseen(Vihollinen[] viholliset) {
        for (Vihollinen vihollinen : viholliset) {
            if (Math.abs(vihollinen.getX() - this.getX()) < 16) {
                if (Math.abs(vihollinen.getY() - this.getY()) < 16) {
                    super.kuole();
                    System.out.println("kuolit");
                }
            }
        }
    }
    
    public void hyppaa() {
        if (!super.pelaajaOnIlmassa(this.kentta)) {
            this.hyppy = 40;
        }
    }
    
    public void liiku() {
        if (super.ylhaallaOnEste(kentta)) {
            this.hyppy = 0;
            super.setYlos(false);
        }
        if (this.hyppy == 0 && super.pelaajaOnIlmassa(kentta)) {
            super.setAlas(true);
            super.setYlos(false);
        }
        if (this.hyppy > 0) {
            super.setYlos(true);
            super.setAlas(false);
            this.hyppy--;
        }
        super.liiku(kentta);
    }
    
}
