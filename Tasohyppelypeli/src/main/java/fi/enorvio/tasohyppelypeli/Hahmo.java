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
    private boolean onElossa;
    
    public Hahmo(int x, int y) {
        this.x = x;
        this.y = y;
        this.onElossa = true;
    }
    
}
