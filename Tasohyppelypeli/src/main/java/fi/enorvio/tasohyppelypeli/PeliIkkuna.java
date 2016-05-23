/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

/**
 *
 * @author tabby
 */
public class PeliIkkuna extends JPanel implements KeyListener, Runnable {
    public BufferedImage kuva;
    private Pelaaja pelaaja;
    private Thread thread;
    
    
    
    public PeliIkkuna(Pelaaja pelaaja) {
        super();
        this.kuva = new BufferedImage(512, 256, BufferedImage.TYPE_INT_RGB);
        this.pelaaja = pelaaja;
        setFocusable(true);
        requestFocus();
    }
    
    @Override public void addNotify() {
        super.addNotify();
        if(thread==null) {
            thread = new Thread(this);
            thread.start();
        }
        addKeyListener(this);
    }
    
    @Override public void run() {
        
        
        while(true){
            try {
        Thread.sleep(30);                 
        } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
        } 
        this.pelaaja.liiku();
        for (Vihollinen vihollinen : this.pelaaja.getKentta().getViholliset()) {
            vihollinen.liiku();
        }
        this.pelaaja.setOikeaTrue();
        this.pelaaja.hyppaa();
        }
    }
    
    @Override public void keyTyped(KeyEvent key) {}
    
    @Override public void keyPressed(KeyEvent key) {
        int code = key.getKeyCode();
        
        if (code == KeyEvent.VK_LEFT) {
            this.pelaaja.setVasenTrue();
            
        }
        if (code == KeyEvent.VK_RIGHT) {
            this.pelaaja.setOikeaTrue();
        }
        if (code == KeyEvent.VK_SPACE) {
            this.pelaaja.hyppaa();
        }
    }
    
    @Override public void keyReleased(KeyEvent key) {
        
        int code = key.getKeyCode();
        
        if (code == KeyEvent.VK_LEFT) {
            this.pelaaja.setVasenFalse();
        }
        if (code == KeyEvent.VK_RIGHT) {
            this.pelaaja.setOikeaFalse();
        }
    }
    
    @Override public void paintComponent(Graphics g) { 
    
    g.drawImage(kuva, 0, 0, null); 
    g.setColor(Color.red);
    Kentta nykyinenKentta = this.pelaaja.getKentta();
    for (int i=0; i<nykyinenKentta.getKorkeus(); i++){
        for (int j=0; j<nykyinenKentta.getLeveys(); j++){
            if (nykyinenKentta.getLaatta(j, i) == 1){
                g.fillRect(j*16, i*16, 16, 16);
                repaint(); 
        }
        }
    
    }
    g.setColor(Color.green);
    g.fillRect(this.pelaaja.getX(), this.pelaaja.getY(), 16, 16);
    g.setColor(Color.blue);
    for (Vihollinen vihollinen : this.pelaaja.getKentta().getViholliset()) {
        g.fillRect(vihollinen.getX(), vihollinen.getY(), 16, 16);
    }
    repaint();
    
    
    
    
  } 
    

  
 
 

    
}
