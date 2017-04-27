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
public class Nollaa extends Operaatio {

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(sovellus, tuloskentta, syotekentta);
    }

    @Override
    protected int laske() {
        arvo = sovellus.tulos();
        sovellus.nollaa();
        return 0;
    }
    protected int peruuta() {
        sovellus.plus(arvo);
        return sovellus.tulos();
    }

}
