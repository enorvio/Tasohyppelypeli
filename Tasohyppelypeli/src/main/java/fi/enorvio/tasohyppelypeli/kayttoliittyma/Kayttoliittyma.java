/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.enorvio.tasohyppelypeli.kayttoliittyma;

/**
 *
 * @author tabby
 */
import fi.enorvio.tasohyppelypeli.Pelaaja;
import fi.enorvio.tasohyppelypeli.PeliIkkuna;
import java.awt.Container;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class Kayttoliittyma implements Runnable{
    
    private JFrame ikkuna;
    private JLabel statuspaneeli;
    private GridLayout asettelija; 
    private JButton uusiPeli;
    private JButton lataaPeli;
    private JButton lopeta;
    private JButton korkeimmatPisteet;
    
    
    public Kayttoliittyma() {
        
    }
    
    
    
    @Override public void run() {
        
        ikkuna.setPreferredSize(new Dimension(300, 200));
        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(ikkuna.getContentPane());

        ikkuna.pack();
        ikkuna.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        GridLayout asettelija = new GridLayout(3, 1);
        container.setLayout(asettelija);
        JPanel paneeli = new JPanel(new GridLayout(1, 3));
        paneeli.setFocusable(true);
        JButton nappi1 = new JButton("New game");
        paneeli.add(nappi1);
        JButton nappi2 = new JButton("Load");
        paneeli.add(nappi2);
        JButton nappi3 = new JButton("High score");
        paneeli.add(nappi3);
        JButton nappi4 = new JButton("Quit");
        paneeli.add(nappi4);
        container.add(paneeli);
        //kuuntelija = new valikonKuuntelija(tekstikentta, syotekentta, nappi1, nappi2, nappi3);
        ValikonKuuntelija kuuntelija = (new ValikonKuuntelija(nappi1, nappi2, nappi3, nappi4));
        nappi1.addActionListener(kuuntelija);
        nappi2.addActionListener(kuuntelija);
        nappi3.addActionListener(kuuntelija);
        nappi4.addActionListener(kuuntelija);
        
    }
    
    
    
}
