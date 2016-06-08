/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli.logiikka;

/**
 *
 * @author enorvio
 */
public class Hahmo {

    private int x;
    private int y;
    private boolean onElossa;
    private boolean tormaaEsteisiin;
    private int dx;
    private int dy;
    private Kentta kentta;
    private final int TYHJA = 0;
    private final int ESTE = 1;
    private final int PISTE = 2;
    private final int PELAAJA = 3;

    public Hahmo(int x, int y) {
        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = 0;
        this.onElossa = true;
        this.tormaaEsteisiin = false;
    }
    
    public Hahmo(int x, int y, Kentta kentta) {
        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = 0;
        this.onElossa = true;
        this.tormaaEsteisiin = false;
        this.kentta = kentta;
    }

    
    public Kentta getKentta() {
        return this.kentta;
    }
    
    public void setKentta(Kentta kentta) {
        this.kentta = kentta;
    }
    
    public void setTormaaEsteisiin(boolean tormaaEsteisiin) {
        this.tormaaEsteisiin = tormaaEsteisiin;
    }

    public boolean onElossa() {
        return this.onElossa;
    }

    public void ela() {
        this.onElossa = true;
    }

    public void kuole() {
        this.onElossa = false;
        System.out.println("kuolit");
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int uusiX) {
        this.x = uusiX;
    }

    public void setY(int uusiY) {
        this.y = uusiY;
    }

    public void pysahdy() {
        this.dx = 0;
        this.dy = 0;
    }

    public int getDx() {
        return this.dx;
    }

    public int getDy() {
        return this.dy;
    }

    public void setDx(int uusiDx) {
        this.dx = uusiDx;
    }

    public void setDy(int uusiDy) {
        this.dy = uusiDy;
    }

//    public boolean pelaajaOnIlmassa(Kentta kentta) {
//        if (kentta.kuuluukoPikseliEsteeseen(this.x, this.y + 16)) {
//            return false;
//        }
//        if (kentta.kuuluukoPikseliEsteeseen(this.x + 15, this.y + 16)) {
//            return false;
//        }
//        return true;
//    }
    
    public boolean pelaajaOnIlmassa() {
        if (this.kentta.selvitaPikselinTyyppi(this.x, this.y + 16) == ESTE) {
            return false;
        }
        if (this.kentta.selvitaPikselinTyyppi(this.x + 15, this.y + 16) == ESTE) {
            return false;
        }
        return true;
    }

//    public boolean ylhaallaOnEste(Kentta kentta) {
//        if (kentta.kuuluukoPikseliEsteeseen(this.x, this.y)) {
//            return true;
//        }
//        if (kentta.kuuluukoPikseliEsteeseen(this.x + 15, this.y)) {
//            return true;
//        }
//        return false;
//    }
    
    public boolean ylhaallaOnEste() {
        if (this.kentta.selvitaPikselinTyyppi(x, y) == ESTE) {
            return true;
        }
        if (this.kentta.selvitaPikselinTyyppi(this.x + 15, this.y) == ESTE) {
            return true;
        }
        return false;
    }
    
//    public void liiku(Kentta kentta) {
//        int uusiX = this.x + this.dx;
//        int uusiY = this.y + this.dy;
//        if (!this.tormaaEsteisiin) {
//            this.x = uusiX;
//            this.y = uusiY;
//        } else if (voiLiikkuaPisteeseen(kentta, uusiX, uusiY)) {
//            this.x = uusiX;
//            this.y = uusiY;
//        } else if (voiLiikkuaPisteeseen(kentta, this.x, uusiY)) {
//            this.y = uusiY;
//        } else if (voiLiikkuaPisteeseen(kentta, uusiX, this.y)) {
//            this.x = uusiX;
//        }
//
//    }
    
    public void liiku() {
        int uusiX = this.x + this.dx;
        int uusiY = this.y + this.dy;
        if (!this.tormaaEsteisiin) {
            this.x = uusiX;
            this.y = uusiY;
        } else if (voiLiikkuaPisteeseen(uusiX, uusiY)) {
            this.x = uusiX;
            this.y = uusiY;
        } else if (voiLiikkuaPisteeseen(this.x, uusiY)) {
            this.y = uusiY;
        } else if (voiLiikkuaPisteeseen(uusiX, this.y)) {
            this.x = uusiX;
        }
    }

//    public boolean voiLiikkuaPisteeseen(Kentta kentta, int a, int b) {
//        if ((a < 0) || (b < 0) || (a > 496) || (b > 240)) {
//            return false;
//        }
//        if (kentta.kuuluukoPikseliEsteeseen(a, b)) {
//            return false;
//        }
//        if (kentta.kuuluukoPikseliEsteeseen(a, b + 15)) {
//            return false;
//        }
//        if (kentta.kuuluukoPikseliEsteeseen(a + 15, b + 15)) {
//            return false;
//        }
//        if (kentta.kuuluukoPikseliEsteeseen(a + 15, b)) {
//            return false;
//        }
//        return true;
//
//    }

    public boolean voiLiikkuaPisteeseen(int a, int b) {
        if ((a < 0) || (b < 0) || (a > 496) || (b > 240)) {
            return false;
        }
        if (this.kentta.selvitaPikselinTyyppi(a, b) == ESTE) {
            return false;
        }
        if (this.kentta.selvitaPikselinTyyppi(a, b + 15) == ESTE) {
            return false;
        }
        if (this.kentta.selvitaPikselinTyyppi(a + 15, b + 15) == ESTE) {
            return false;
        }
        if (this.kentta.selvitaPikselinTyyppi(a + 15, b) == ESTE) {
            return false;
        }
        return true;

    }
    
    public boolean kuuluukoPikseliHahmoon(int a, int b) {
        if (a >= this.x && b >= this.y) {
            if (a - this.x < 16 && b - this.y < 16) {
                return true;
            }
        }
        return false;
    }

}
