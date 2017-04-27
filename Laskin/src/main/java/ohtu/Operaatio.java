/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author aapo
 */
public abstract class Operaatio implements Komento {
    protected Sovelluslogiikka sovellus;
    protected JTextField tuloskentta;
    protected JTextField syotekentta;
    protected int arvo;
    protected Sovelluslogiikka edSovellus;
    
    
    public Operaatio(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        
        
    }
        
    
    @Override
    public void suorita() {
        
        edSovellus = sovellus;
        
        int tulos = laske(); //To change body of generated methods, choose Tools | Templates.      
        
        syotekentta.setText("");
        tuloskentta.setText("" + tulos);
        
    }

    @Override
    public void peru() {
        int tulos = peruuta();
        syotekentta.setText("");
        tuloskentta.setText("" + tulos);
    }
    
    protected abstract int laske();
    protected abstract int peruuta();
}
