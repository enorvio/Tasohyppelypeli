/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli.kayttoliittyma;

import fi.enorvio.tasohyppelypeli.Pelaaja;
import fi.enorvio.tasohyppelypeli.PeliIkkuna;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author tabby
 */
public class ValikonKuuntelija implements ActionListener {
    
    private JButton uusiPeli;
    private JButton lataaPeli;
    private JButton lopeta;
    private JButton korkeimmatPisteet;
    
    public ValikonKuuntelija(JButton uusiPeli, JButton lataaPeli, JButton lopeta, JButton korkeimmatPisteet) {
        this.uusiPeli = uusiPeli;
        this.lataaPeli = lataaPeli;
        this.lopeta = lopeta;
        this.korkeimmatPisteet = korkeimmatPisteet;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        try {
            if (ae.getSource() == uusiPeli) {
                System.out.println("jee");
                
                } else if (ae.getSource() == lataaPeli) {
                
                } else if (ae.getSource() == lopeta) {
                
                } else {
                
            }
        } catch (Exception e) {
            
        }
    
    }
    
    
}
