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
public class Pelaaja {
    
    private int x;
    private int y;
    private int hyppy;
    private Kentta kentta;
    private boolean vasen;
    private boolean oikea;
    private boolean elossa;
    
    public Pelaaja(Kentta kentta) {
        this.x = 0;
        this.y = 0;
        this.hyppy = 0;
        this.kentta = kentta;
        this.oikea = false;
        this.vasen = false;
        this.elossa = true;
    }
    
    public Kentta getKentta() {
        return this.kentta;
    }
    
    public boolean onElossa() {
        return this.elossa;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setX(int uusiX){
        this.x = uusiX;
    }
    
    public void setY(int uusiY){
        this.y = uusiY;
    }
    
    public void setVasenTrue(){
        this.vasen = true;
        this.oikea = false;
    }
    
    public void setVasenFalse() {
        this.vasen = false;
    }
    
    public void setOikeaFalse(){
        this.oikea = false;
    }
    
    public void setOikeaTrue(){
        this.oikea = true;
        this.vasen = false;
    }
    
    private void havaitseTormaysViholliseen(Vihollinen[] viholliset) {
        for (Vihollinen vihollinen: viholliset) {
            if (Math.abs(vihollinen.getX()-this.x)<16) {
                if (Math.abs(vihollinen.getY()-this.y)<16){
                    this.elossa = false; // Pelaaja törmäsi viholliseen ja kuoli. 
                    System.out.println("kuolit");
                }
            }
        }
    }
    
    public boolean pelaajaOnIlmassa(){
        if(this.kentta.kuuluukoPikseliEsteeseen(this.x, this.y+16)){
            return false;
        }
        if(this.kentta.kuuluukoPikseliEsteeseen(this.x+15, this.y+16)){
            return false;
        }
        return true;
}
    
    public boolean oikeallaOnEste(){
        if(this.kentta.kuuluukoPikseliEsteeseen(this.x+16, this.y)){
            return true;
        }
        return false;
    }
    
    public boolean vasemmallaOnEste(){
       if(this.kentta.kuuluukoPikseliEsteeseen(this.x, this.y)){
            return true;
        }
        return false; 
    }
    
    public boolean ylhaallaOnEste(){
        if(this.kentta.kuuluukoPikseliEsteeseen(this.x, this.y)){
            return true;
        }
        if(this.kentta.kuuluukoPikseliEsteeseen(this.x+15, this.y)){
            return true;
        }
        return false;
    }
    
  
    
    public void hyppaa(int korkeus) {
        if(!pelaajaOnIlmassa()){
            this.hyppy = korkeus;
        }
    }
    
    public void hyppaa() {
        if(!pelaajaOnIlmassa()){
            this.hyppy = 40;
        }
    }
    
    public void liiku(){
            havaitseTormaysViholliseen(this.kentta.getViholliset());
            if (this.y>238) {
                this.elossa = false; //Pelaaja putosi kuiluun ja kuoli.
            }        
            else if (pelaajaOnIlmassa()){
                if (!this.oikea && !this.vasen){
                    if(this.hyppy==0){
                        this.y++;
                    }
                    else{
                        if(ylhaallaOnEste()){
                            this.hyppy = 0;
                        } else {
                            this.y--;
                            this.hyppy--;
                        }
                    }
                }
                else if (this.oikea){
                    if(this.hyppy==0){
                        if (oikeallaOnEste()){
                            this.y++;
                        }
                        else{
                            this.y++;
                            this.x++;
                        }
                    }
                    else{
                        if(ylhaallaOnEste()){
                            this.hyppy = 0;
                        } else {
                            if (oikeallaOnEste()){
                                this.hyppy = 0;
                            } else{
                               this.y--;
                               this.hyppy--; 
                               this.x++;
                            }
                            
                        }
                    }                    
                }
                else {
                    if(this.hyppy==0){
                        if (vasemmallaOnEste()){
                            this.y++;
                        }
                        else{
                            this.y++;
                            this.x--;
                        }
                    }
                    else{
                        if(ylhaallaOnEste()){
                            this.hyppy = 0;
                        } else {
                            if (vasemmallaOnEste()){
                                this.hyppy = 0;
                            } else{
                               this.y--;
                               this.hyppy--; 
                               this.x--;
                            }
                            
                        }
                    } 
                }
                
        } else {
                if (this.vasen) {
                    if (vasemmallaOnEste()) {
                        this.vasen = false;
                    } else {
                        this.x--;
                        this.vasen = false;
                    }
                }
                else if (this.oikea) {
                    if(oikeallaOnEste()) {
                        this.oikea = false;
                    } else {
                        this.x++;
                        this.oikea = false;
                    }
                }
                if (this.hyppy>0) {
                    if (!this.ylhaallaOnEste()) {
                        this.y--;
                        this.hyppy--;
                    }
                }
            }
            
    }
    
}

