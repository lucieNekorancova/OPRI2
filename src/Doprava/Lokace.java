package Doprava;
import java.util.ArrayList;
import java.util.List;

public class Lokace {
    private String nazev;
    private List<DopravniZnacka> znacky;

    public Lokace(String nazev){
        this.nazev = nazev;
        znacky = new ArrayList<>();
    }
    public void pridejZnacku (DopravniZnacka znacka) {
        znacky.add(znacka);
    }
    public List<DopravniZnacka> getZnacky() {
        return znacky;
    }
    public String getNazev() {
        return nazev;
    }
}
