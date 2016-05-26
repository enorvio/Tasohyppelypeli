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
public class Vihollinen extends Hahmo {

    private int reitinOsuus;
    private char[] suunnat;
    private int[] kaannospisteet;

    public Vihollinen(int x, int y, char[] suunnat, int[] kaannospisteet) {
        super(x, y);
        this.reitinOsuus = 0;
        this.suunnat = suunnat;
        this.kaannospisteet = kaannospisteet;
    }
    
    public void liiku(Kentta kentta) {
        if (this.suunnat[reitinOsuus] == 'd') {
            if (this.getY() > this.kaannospisteet[reitinOsuus]) {
                this.setAlas(false);
                this.setYlos(true);
                this.setOikea(false);
                this.setVasen(false);
            } else {
                if (reitinOsuus < this.suunnat.length - 1) {
                    this.reitinOsuus++;
                } else {
                    this.reitinOsuus = 0;
                }

            }
        } else if (this.suunnat[reitinOsuus] == 'u') {
            if (this.getY() < this.kaannospisteet[reitinOsuus]) {
                this.setAlas(true);
                this.setYlos(false);
                this.setOikea(false);
                this.setVasen(false);
            } else {
                if (reitinOsuus < this.suunnat.length - 1) {
                    this.reitinOsuus++;
                } else {
                    this.reitinOsuus = 0;
                }

            }
        } else if (this.suunnat[reitinOsuus] == 'r') {
            if (this.getX() < this.kaannospisteet[reitinOsuus]) {
                this.setAlas(false);
                this.setYlos(false);
                this.setOikea(true);
                this.setVasen(false);
            } else {
                if (reitinOsuus < this.suunnat.length - 1) {
                    this.reitinOsuus++;
                } else {
                    this.reitinOsuus = 0;
                }

            }
        } else if (this.suunnat[reitinOsuus] == 'l') {
            if (this.getX() > this.kaannospisteet[reitinOsuus]) {
                this.setAlas(false);
                this.setYlos(false);
                this.setOikea(false);
                this.setVasen(true);
            } else {
                if (reitinOsuus < this.suunnat.length - 1) {
                    this.reitinOsuus++;
                } else {
                    this.reitinOsuus = 0;
                }

            }
        }
        super.liiku(kentta);
        
    }

}
