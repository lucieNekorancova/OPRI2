package Doprava;

public class OmezujiciRychlostZnacka extends DopravniZnacka {
    private int maxRychlost;

    public OmezujiciRychlostZnacka(int maxRychlost){
        this.maxRychlost = maxRychlost;
    }
    @Override
    public boolean jePorusena(Auto auto){
        return auto.getRychlost() > maxRychlost;
 }
}