/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli.kayttoliittyma;

import fi.enorvio.tasohyppelypeli.logiikka.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import fi.enorvio.tasohyppelypeli.tiedostonkasittely.Lukija;

/**
 *
 * @author tabby
 */

/**
 * Luokka sisältää NimenKysyjä-luokan ActionEventien (tekstikentän syöte ja JButtonin klikkaaminen) kuuntelijan.
 */
public class NimenKysyjanKuuntelija implements ActionListener {
    
    private JFrame ikkuna;
    private JButton nappi;
    private JTextField syotekentta;
    private String nimi;
    private int pisteet;
    
    public NimenKysyjanKuuntelija(JFrame ikkuna, int pisteet, JButton nappi, JTextField syotekentta) {
        
        this.ikkuna = ikkuna;
        this.nappi = nappi;
        this.syotekentta = syotekentta;
        this.nimi = "";
        this.pisteet = pisteet;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {

        try {
            if (ae.getSource() == nappi) {
                this.nimi = syotekentta.getText();
                System.out.println(this.nimi);
                Lukija lukija = new Lukija();
                lukija.tallennaPisteet(this.nimi, this.pisteet);
                ikkuna.dispose();
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("virhe");
        }

    }
    
    public String getNimi() {
        return this.nimi;
    }
}
