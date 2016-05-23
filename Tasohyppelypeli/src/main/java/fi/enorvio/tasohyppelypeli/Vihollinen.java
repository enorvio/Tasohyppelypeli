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
public class Vihollinen {
    private int x;
    private int y;
    private int reitinOsuus;
    private char[] suunnat;
    private int[] kaannospisteet;


    public Vihollinen(int x, int y, char[] suunnat, int[] kaannospisteet) {
        this.x = x;
        this.y = y;
        this.reitinOsuus = 0;
        this.suunnat = suunnat;
        this.kaannospisteet = kaannospisteet;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void liiku(){
        
        if(this.suunnat[reitinOsuus]=='d'){
            if(this.y>this.kaannospisteet[reitinOsuus]){
                this.y--;
            } else {
                if (reitinOsuus<this.suunnat.length-1){
                    this.reitinOsuus++;
                } else {
                    this.reitinOsuus = 0;
                }
                
            }
        }
        if (this.suunnat[reitinOsuus]=='u'){
            if(this.y<this.kaannospisteet[reitinOsuus]){
                this.y++;
            } else {
                if (reitinOsuus<this.suunnat.length-1){
                    this.reitinOsuus++;
                } else {
                    this.reitinOsuus = 0;
                }
                
            }
        }
        
        if (this.suunnat[reitinOsuus]=='r'){
            if(this.x<this.kaannospisteet[reitinOsuus]){
                this.x++;
            } else {
                if (reitinOsuus<this.suunnat.length-1){
                    this.reitinOsuus++;
                } else {
                    this.reitinOsuus = 0;
                }
                
            }
        }
        
        if (this.suunnat[reitinOsuus]=='l'){
            if(this.x>this.kaannospisteet[reitinOsuus]){
                this.x--;
            } else {
                if (reitinOsuus<this.suunnat.length-1){
                    this.reitinOsuus++;
                } else {
                    this.reitinOsuus = 0;
                }
                
            }
        }
        
    }
    
}