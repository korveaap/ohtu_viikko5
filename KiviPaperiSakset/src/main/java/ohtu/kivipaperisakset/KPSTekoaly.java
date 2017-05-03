package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends KPSPeli {

    private static final Scanner scanner = new Scanner(System.in);

   

    @Override
    protected void asetaPelimuoto() {
       super.pelimuoto = "tekoaly";
        super.tekoaly = new TekoalyPerus();
    }
}