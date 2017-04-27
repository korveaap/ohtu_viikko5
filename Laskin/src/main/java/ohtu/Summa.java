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
public class Summa extends Operaatio {

    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(sovellus, tuloskentta, syotekentta);
        
    }

    @Override
    protected int laske() {
        try {
            this.arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        sovellus.plus(arvo);
        return  sovellus.tulos(); 
    }
    
    protected int peruuta() {
        sovellus.miinus(arvo);
        return sovellus.tulos();
    }
        

}
