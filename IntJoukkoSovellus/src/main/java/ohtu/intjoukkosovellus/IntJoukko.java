package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko = OLETUSKASVATUS;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] luvut;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm = 0;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        luvut = new int[KAPASITEETTI];           
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        luvut = new int[kapasiteetti];
        
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            return;
        }
        luvut = new int[kapasiteetti]; 
        
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {

        if (!lukuOnJoukossa(luku)) {
            luvut[alkioidenLkm++] = luku;
            if (alkioidenLkm % luvut.length == 0) {
                kasvataTaulukkoa();
            }
            return true;
        }
        return false;
    }

    private void kasvataTaulukkoa() {
        int[] tempTaulukko = new int[luvut.length];
        kopioiTaulukko(luvut, tempTaulukko);
        luvut = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(tempTaulukko, luvut);
    }

    public boolean lukuOnJoukossa(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == luvut[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {        
        int poistettavaIndeksi = haeIndeksi(luku);        
        if (poistettavaIndeksi != -1) {
            luvut[poistettavaIndeksi] = 0;
            siirraVasemmalle(poistettavaIndeksi);
            alkioidenLkm--;
            return true;
        }
        return false;
    }

    private int haeIndeksi(int luku) {
        int luvunIndeksi = -1;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == luvut[i]) {
                luvunIndeksi = i; //siis luku löytyy tuosta kohdasta :D               
                break;
            }
        }
        return luvunIndeksi;
    }

    private void siirraVasemmalle(int poistettavaIndeksi) {
        int apuMuuttuja;
        for (int j = poistettavaIndeksi; j < alkioidenLkm - 1; j++) {
            apuMuuttuja = luvut[j];
            luvut[j] = luvut[j + 1];
            luvut[j + 1] = apuMuuttuja;
        }
        
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + luvut[0] + "}";
        } else {
            return muodostaMerkkijono();
        }
    }

    private String muodostaMerkkijono() {
        String merkkiJono = "{";
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            merkkiJono += luvut[i];
            merkkiJono += ", ";
        }
        merkkiJono += luvut[alkioidenLkm - 1];
        merkkiJono += "}";
        return merkkiJono;
    }

    public int[] toIntArray() {
        int[] paluuTaulukko = new int[alkioidenLkm];
        for (int i = 0; i < paluuTaulukko.length; i++) {
            paluuTaulukko[i] = luvut[i];
        }
        return paluuTaulukko;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdisteJoukko = new IntJoukko();
        lisaaJoukko(a, yhdisteJoukko);
        lisaaJoukko(b, yhdisteJoukko);
        return yhdisteJoukko;
    }

    private static void lisaaJoukko(IntJoukko lisattavaJoukko, IntJoukko tulosJoukko) {
        for (int i = 0; i < lisattavaJoukko.alkioidenLkm; i++) {
            tulosJoukko.lisaa(lisattavaJoukko.luvut[i]);
        }
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkausJoukko = new IntJoukko();
        for (int i = 0; i < a.alkioidenLkm; i++) {
            if (b.lukuOnJoukossa(a.luvut[i])) {
                leikkausJoukko.lisaa(a.luvut[i]);
            }
        }
        return leikkausJoukko;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko erotusJoukko = new IntJoukko();
        lisaaJoukko(a, erotusJoukko);
        for (int i = 0; i < b.alkioidenLkm; i++) {
            erotusJoukko.poista(b.luvut[i]);
        }
        return erotusJoukko;
    }

}
