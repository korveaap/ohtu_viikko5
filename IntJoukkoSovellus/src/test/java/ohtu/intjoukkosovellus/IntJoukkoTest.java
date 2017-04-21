package ohtu.intjoukkosovellus;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntJoukkoTest {

    IntJoukko joukko;

    @Before
    public void setUp() {
        joukko = new IntJoukko();
        joukko.lisaa(10);
        joukko.lisaa(3);
    }

    @Test
    public void lukujaLisattyMaara() {
        joukko.lisaa(4);
        assertEquals(3, joukko.mahtavuus());
    }

    @Test
    public void samaLukuMeneeJoukkoonVaanKerran() {
        joukko.lisaa(10);
        joukko.lisaa(3);
        assertEquals(2, joukko.mahtavuus());
    }

    @Test
    public void vainLisatytLuvutLoytyvat() {
        assertTrue(joukko.lukuOnJoukossa(10));
        assertFalse(joukko.lukuOnJoukossa(5));
        assertTrue(joukko.lukuOnJoukossa(3));
    }

    @Test
    public void poistettuEiOleEnaaJoukossa() {
        joukko.poista(3);
        assertFalse(joukko.lukuOnJoukossa(3));
        assertEquals(1, joukko.mahtavuus());
    }
    
    @Test
    public void palautetaanOikeaTaulukko() {
        int[] odotettu = {3, 55, 99};
        
        joukko.lisaa(55);
        joukko.poista(10);
        joukko.lisaa(99);

        int[] vastaus = joukko.toIntArray();
        Arrays.sort(vastaus);
        assertArrayEquals(odotettu, vastaus);
    }
    
    
    @Test
    public void toimiiKasvatuksenJalkeen(){
        int[] lisattavat = {1,2,4,5,6,7,8,9,11,12,13,14};
        for (int luku : lisattavat) {
            joukko.lisaa(luku);
        }
        assertEquals(14, joukko.mahtavuus());
        assertTrue(joukko.lukuOnJoukossa(11));
        joukko.poista(11);
        assertFalse(joukko.lukuOnJoukossa(11));
        assertEquals(13, joukko.mahtavuus());
    }
    
    @Test
    public void toStringToimii(){
        assertEquals("{10, 3}", joukko.toString());
    }
    
    @Test
    public void toStringToimiiYhdenKokoiselleJoukolla(){
        joukko = new IntJoukko();
        joukko.lisaa(1);
        assertEquals("{1}", joukko.toString());
    }

    @Test
    public void toStringToimiiTyhjallaJoukolla(){
        joukko = new IntJoukko();
        assertEquals("{}", joukko.toString());
    }     
    
    @Test
    public void yhdiste() {
        IntJoukko joukko1 = new IntJoukko();
        IntJoukko joukko2 = new IntJoukko();
        joukko1.lisaa(1);
        joukko1.lisaa(2);
        joukko2.lisaa(1);
        joukko2.lisaa(2);
        joukko2.lisaa(3);
        
        IntJoukko joukko3 = IntJoukko.yhdiste(joukko1, joukko2);
        assertEquals(3,joukko3.mahtavuus());
        
        
    }
    
    @Test
    public void leikkaus() {
        IntJoukko joukko1 = new IntJoukko();
        IntJoukko joukko2 = new IntJoukko();
        joukko1.lisaa(1);
        joukko1.lisaa(2);
        joukko2.lisaa(1);
        joukko2.lisaa(2);
        joukko2.lisaa(3);
        
        IntJoukko joukko3 = IntJoukko.leikkaus(joukko1, joukko2);
        assertEquals(2,joukko3.mahtavuus());
        
        
    }
    
    @Test
    public void erotus() {
        IntJoukko joukko1 = new IntJoukko();
        IntJoukko joukko2 = new IntJoukko();
        joukko1.lisaa(1);
        joukko1.lisaa(2);
        joukko2.lisaa(1);
        joukko2.lisaa(4);
        joukko2.lisaa(3);
        
        IntJoukko joukko3 = IntJoukko.erotus(joukko1, joukko2);
        assertEquals(1,joukko3.mahtavuus());
        
        
    }
}
