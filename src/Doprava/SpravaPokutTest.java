package Doprava;

import java.util.ArrayList;
import java.util.List;

public class SpravaPokutTest {
    @Test
    void testPrekroceniRychlostivZakazu (){
        SpravaPokut sprava = new SpravaPokut();
        Auto auto = new Auto("Pes-666", 70, AkceAuta.JIZDA, Smer.ROVNE);
        Lokace lokace = new Lokace("Město");
        lokace.pridejZnacku(new OmezujiciRychlostZnacka(50));
        List<String> pokuty = sprava.kontrolaPrestupku(auto, lokace);
        assert pokuty.isEmpty(), "Auto dostane pokutu,");


    }
    @Test
    void testPrekroceniRychlostiKdeNeniZakazano (){
        SpravaPokut sprava = new SpravaPokut();
        Auto auto = new Auto("Pes-666", 70, AkceAuta.JIZDA, Smer.ROVNE);
        Lokace lokace = new Lokace("Město");
        lokace.pridejZnacku(new OmezujiciRychlostZnacka(50));
        List<String> pokuty = sprava.kontrolaPrestupku(auto, lokace);
        assert pokuty.isEmpty(), "Auto dostane pokutu,");
}
