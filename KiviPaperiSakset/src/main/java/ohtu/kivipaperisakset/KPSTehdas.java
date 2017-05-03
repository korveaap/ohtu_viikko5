/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.HashMap;

/**
 *
 * @author aapo
 */
public class KPSTehdas {
    
    private static HashMap<String, Kps> pelimuodot = new HashMap();

    public KPSTehdas() {
        pelimuodot.put("a", new KPSPelaajaVsPelaaja());
        pelimuodot.put("b", new KPSTekoaly());
        pelimuodot.put("c", new KPSParempiTekoaly() );
    }
    
    
    
    public static Kps hae(String pelimuoto) {
        return pelimuodot.get(pelimuoto);
    }
}
