/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author aapo
 */
public abstract class KPSPeli implements Kps {

    protected Tekoaly tekoaly;
    protected String pelimuoto;
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void pelaa() {
        asetaPelimuoto();
        
        Tuomari tuomari = new Tuomari();

        String ekanSiirto = null;
        String tokanSiirto = null;

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            ekanSiirto = LuePelaajanSiirto("Ensimmäisen pelaajan siirto: ");
            if (pelimuoto.equals("tekoaly")) {
                tokanSiirto = LueTekoalynSiirto(ekanSiirto);
            } else {
                tokanSiirto = LuePelaajanSiirto("Toisen pelaajan siirto: ");
            }

            Kirjaa(tuomari, ekanSiirto, tokanSiirto);

        }

        Lopeta(tuomari);
    }

    private String LuePelaajanSiirto(String teksti) {
        String ekanSiirto;
        System.out.print(teksti);
        ekanSiirto = scanner.nextLine();
        return ekanSiirto;
    }

    private void Kirjaa(Tuomari tuomari, String ekanSiirto, String tokanSiirto) {
        tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
        System.out.println(tuomari);
        System.out.println();
    }

    private void Lopeta(Tuomari tuomari) {
        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    private String LueTekoalynSiirto(String ekanSiirto) {

        String tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        tekoaly.asetaSiirto(ekanSiirto);

        return tokanSiirto;
    }

    private static boolean onkoOkSiirto(String siirto) {
        return siirto == null || "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    protected abstract void asetaPelimuoto();

}
