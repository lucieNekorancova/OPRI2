package Doprava;

public class ZakazovaZnacka extends DopravniZnacka {
    private AkceAuta zakazaneAkce;

    public ZakazovaZnacka(AkceAuta zakazanaAkce){
        this.zakazaneAkce = zakazanaAkce;
    }
 @Override
    public boolean jePorusena(Auto auto){
        return auto.getAktualniAkce() == zakazaneAkce;
 }

}

