package Doprava;

import java.util.ArrayList;
import java.util.List;

public class SpravaPokut {

    public List<String> kontrolaPrestupku(Auto auto, Lokace lokace){
        List<String> pokuty = new ArrayList<>();

        for (DopravniZnacka znacka : lokace.getZnacky()){
            if (znacka.jePorusena(auto)){
                pokuty.add("Pokuta v lokaci" + lokace.getNazev() + "Pro auto" + auto.getSpz() + "Důvod:" + znacka.getClass().getSimpleName());
            }
        }
    return pokuty;
    }
}
