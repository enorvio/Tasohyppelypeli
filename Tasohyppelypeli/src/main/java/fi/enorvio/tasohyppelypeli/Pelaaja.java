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
        super(1, 1, kentta);
        this.hyppy = 0;
        super.setTormaaEsteisiin(true);
        String[] nimet = {"src/main/resources/esimerkkiTaso1.txt", "src/main/resources/esimerkkiTaso.txt"};
        this.kenttienTiedostonimet = nimet;
        this.elamat = 9;
        this.pisteet = 0;
        this.kentanNumero = 0;

    }

    public Pelaaja(String[] kenttienTiedostonimet) {
        super(1, 1, new Kentta(kenttienTiedostonimet[0]));
        super.setTormaaEsteisiin(true);
        this.hyppy = 0;
        this.kenttienTiedostonimet = kenttienTiedostonimet;
        this.elamat = 9;
        this.pisteet = 0;
        this.kentanNumero = 0;
    }

    public Kentta getKentta() {
        return super.getKentta();
    }

    public void setKentta(Kentta kentta) {
        super.setKentta(kentta);
    }

    public int getElamat() {
        return this.elamat;
    }

    public int getPisteet() {
        return this.pisteet;
    }
    
    public void setPisteet(int uudetPisteet) {
        this.pisteet = uudetPisteet;
    }

    public void hyppaa() {
        if (!super.pelaajaOnIlmassa()) {
            this.hyppy = 40;
        }
    }

    public int getHyppy() {
        return this.hyppy;
    }

    public void kuole() {
        super.kuole();
        this.elamat--;
//        if (this.elamat > 0) {
//            this.resetoiKentta();
//            ela();
//        }
    }

//    public void resetoiKentta() {
//        super.setX(1);
//        super.setY(1);
//        super.setKentta(new Kentta(this.kenttienTiedostonimet[kentanNumero]));
//    }

//    public void liiku1() {
//        if (this.hyppy == 0) {
//            super.setDy(1);
//            if (super.getY() >= 239) {
//                kuole();
//            }
//        }
//        if (super.ylhaallaOnEste()) {
//            this.hyppy = 0;
//        } else if (this.hyppy > 0) {
//            super.setDy(-1);
//            this.hyppy--;
//        }
//        super.liiku();
//        super.getKentta().poistaPiste(super.getX(), super.getY());
//        if (super.getX() >= 495) {
//            this.kentanNumero++;
//            this.pisteet += super.getKentta().getPisteet();
//            this.resetoiKentta();
//        }
//    }
    
    public void liiku() {
        if (this.hyppy == 0) {
            super.setDy(1);
            if (super.getY() >= 239) {
                kuole();
            }
        }
        if (super.ylhaallaOnEste()) {
            this.hyppy = 0;
        } else if (this.hyppy > 0) {
            super.setDy(-1);
            this.hyppy--;
        }
        super.liiku();
        super.getKentta().poistaPiste(super.getX(), super.getY());
    }

}
