package ohtu.kivipaperisakset;

import java.util.Scanner;

import java.util.Scanner;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KPSPeli{

    private static final Scanner scanner = new Scanner(System.in);

    

   
    @Override
    protected void asetaPelimuoto() {
        super.pelimuoto = "tekoaly";
        super.tekoaly = new TekoalyParannettu(20);
    }
    
}
