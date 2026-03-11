package Doprava;

public class Auto {
    private String spz;
    private int rychlost;
    private AkceAuta aktualniAkce;
    private Smer smerJizdy;

    public Auto(String spz, int rychlost) {
        this.spz = spz;
        this.rychlost = rychlost;
        this.aktualniAkce = aktualniAkce;
        this.smerJizdy = smerJizdy;
    }
    public String getSpz() { return spz; }
    public int getRychlost() { return rychlost; }
    public AkceAuta getAktualniAkce() {return aktualniAkce; }
    public Smer getSmerJizdy() { return smerJizdy; }


}

