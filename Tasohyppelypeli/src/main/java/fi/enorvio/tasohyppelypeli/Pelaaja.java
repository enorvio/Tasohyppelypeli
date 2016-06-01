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
    private int elamat;
    private int pisteet;
    private int kentanNumero;
    private String[] kenttienTiedostonimet;
    
    public Pelaaja(Kentta kentta) {
        super(1, 1);
        this.hyppy = 0;
        this.kentta = kentta;
        super.setTormaaEsteisiin(true);
        String[] nimet = {"src/main/resources/esimerkkiTaso1.txt", "src/main/resources/esimerkkiTaso.txt"}; 
        this.kenttienTiedostonimet = nimet;
        this.elamat = 9;
        this.pisteet = 0;
        this.kentanNumero = 0;
        
    }
    
    public Pelaaja(String[] kenttienTiedostonimet) {
        super(1, 1);
        super.setTormaaEsteisiin(true);
        this.hyppy = 0;
        this.kenttienTiedostonimet = kenttienTiedostonimet;    
        this.elamat = 9;
        this.pisteet = 0;
        this.kentanNumero = 0;
        this.kentta = new Kentta(this.kenttienTiedostonimet[kentanNumero]);      
    }
    
    public Kentta getKentta() {
        return this.kentta;
    }
    
    public void setKentta(Kentta kentta) {
        this.kentta = kentta;
    }
    
    
    public int getElamat() {
        return this.elamat;
    }
    
    public int getPisteet() {
        return this.pisteet;
    }
    
    public void hyppaa() {
        if (!super.pelaajaOnIlmassa(this.kentta)) {
            this.hyppy = 40;
        }
    }
    
    public int getHyppy() {
        return this.hyppy;
    }
    
    public void kuole() {
        super.kuole();
        this.elamat--;
        if (this.elamat > 0) {
            this.resetoiKentta();
            ela();
        }
    }
    
    public void resetoiKentta(){
        super.setX(1);
        super.setY(1);
        this.setKentta(new Kentta(this.kenttienTiedostonimet[kentanNumero]));
    }
    
    public void liiku() {
        if (super.ylhaallaOnEste(kentta)) {
            this.hyppy = 0;
            super.setYlos(false);
        }
        if (this.hyppy == 0 && super.pelaajaOnIlmassa(kentta)) {
            super.setAlas(true);
            super.setYlos(false);
            if (super.getY()>=239) {
                kuole();
            }
        }
        if (this.hyppy > 0) {
            super.setYlos(true);
            super.setAlas(false);
            this.hyppy--;
        }
        super.liiku(kentta);
        if(super.getX() >= 495) {
            this.kentanNumero++;
            this.pisteet += this.kentta.getPisteet();
            this.resetoiKentta();
        }
    }
    
}
