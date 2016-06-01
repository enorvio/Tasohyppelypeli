/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli;

/**
 *
 * @author enorvio
 */
public class Hahmo {
    private int x;
    private int y;
    private boolean vasen;
    private boolean oikea;
    private boolean ylos;
    private boolean alas;
    private boolean onElossa;
    private boolean tormaaEsteisiin;
    
    public Hahmo(int x, int y) {
        this.x = x;
        this.y = y;
        this.onElossa = true;
        this.tormaaEsteisiin = false;
    }
    
    public void setTormaaEsteisiin(boolean tormaaEsteisiin) {
        this.tormaaEsteisiin = tormaaEsteisiin;
    }
    
    public boolean onElossa() {
        return this.onElossa;
    }
    
    public void ela(){
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
    
    public boolean getVasen() {
        return this.vasen;
    }
    
    public void setVasen(boolean vasen) {
        this.vasen = vasen;
    }
    
    public boolean getOikea() {
        return this.oikea;
    }
    
    public void setOikea(boolean oikea) {
        this.oikea = oikea;
    }
    
    public boolean getYlos(){
        return this.ylos;
    }
    
    public void setYlos(boolean ylos){
        this.ylos = ylos;
    }
    
    public boolean getAlas(){
        return this.alas;
    }
    
    public void setAlas(boolean alas){
        this.alas = alas;
    }
    
    public boolean pelaajaOnIlmassa(Kentta kentta) {
        if (kentta.kuuluukoPikseliEsteeseen(this.x, this.y + 16)) {
            return false;
        }
        if (kentta.kuuluukoPikseliEsteeseen(this.x + 15, this.y + 16)) {
            return false;
        }
        return true;
    }

    public boolean oikeallaOnEste(Kentta kentta) {
        if (kentta.kuuluukoPikseliEsteeseen(this.x + 16, this.y)) {
            return true;
        }
        if (kentta.kuuluukoPikseliEsteeseen(this.x + 16, this.y + 15)) {
            return true;
        }
        return false;
    }

    public boolean vasemmallaOnEste(Kentta kentta) {
        if (kentta.kuuluukoPikseliEsteeseen(this.x, this.y)) {
            return true;
        }
        if (kentta.kuuluukoPikseliEsteeseen(this.x, this.y + 15)) {
            return true;
        }
        return false;
    }

    public boolean ylhaallaOnEste(Kentta kentta) {
        if (kentta.kuuluukoPikseliEsteeseen(this.x, this.y)) {
            return true;
        }
        if (kentta.kuuluukoPikseliEsteeseen(this.x + 15, this.y)) {
            return true;
        }
        return false;
    }
    
    public void liikuVasemmalle(Kentta kentta) {
        if ((!this.vasemmallaOnEste(kentta) || !this.tormaaEsteisiin) && this.x > 0) {
            this.x--;
        }
    }
    
    public void liikuOikealle(Kentta kentta) {
        if (!this.oikeallaOnEste(kentta) || !this.tormaaEsteisiin) {
            this.x++;
        }
    }
    
    public void liikuAlas(Kentta kentta) {
        if (pelaajaOnIlmassa(kentta) || !this.tormaaEsteisiin) {
            this.y++;
        }
    }
    
    public void liikuYlos(Kentta kentta) {
        if ((!this.ylhaallaOnEste(kentta) || !this.tormaaEsteisiin) && this.y > 0) {
            this.y--;
        }
    }
    
    public void liiku(Kentta kentta) {
        if (this.vasen) {
            this.liikuVasemmalle(kentta);
        } else if (this.oikea) {
            this.liikuOikealle(kentta);
        }
        if (this.alas) {
            this.liikuAlas(kentta);
        } else if (this.ylos) {
            this.liikuYlos(kentta);
        }
    }
    
    public boolean kuuluukoPikseliHahmoon(int a, int b) {
        if (a >= this.x && b>= this.y) {
            if (a-this.x < 16 && b-this.y < 16) {
                return true;
            }
        }
        return false;
    }
    
}
