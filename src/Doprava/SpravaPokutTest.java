package Doprava;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class SpravaPokutTest {

    @Test
    void testPrekroceniRychlostiVZakazu() {
        SpravaPokut sprava = new SpravaPokut();
        Auto auto = new Auto("Pes-666", 70, AkceAuta.JIZDA, Smer.ROVNE);
        Lokace lokace = new Lokace("Mesto");
        lokace.pridejZnacku(new OmezujiciRychlostZnacka(50));

        List<String> pokuty = sprava.kontrolaPrestupku(auto, lokace);
        assertFalse(pokuty.isEmpty(), "Auto dostane pokutu.");
    }

    @Test
    void testPrekroceniRychlostiKdeNeniZakazano() {
        SpravaPokut sprava = new SpravaPokut();
        Auto auto = new Auto("Slepice-999", 100, AkceAuta.JIZDA, Smer.ROVNE);
        Lokace lokace = new Lokace("Venkov");
        lokace.pridejZnacku(new ZakazovaZnacka(AkceAuta.PARKOVANI));

        List<String> pokuty = sprava.kontrolaPrestupku(auto, lokace);
        assertTrue(pokuty.isEmpty(), "Zadna pokuta");
    }

    @Test
    void testSpatnySmerJizdy() {
        SpravaPokut sprava = new SpravaPokut();
        Auto auto = new Auto("Kocka-677", 30, AkceAuta.JIZDA, Smer.VLEVO);
        Lokace lokace = new Lokace("Krizovatka");
        lokace.pridejZnacku(new SmerovaZnacka(Smer.ROVNE));

        List<String> pokuty = sprava.kontrolaPrestupku(auto, lokace);
        assertEquals(1, pokuty.size());
    }
}