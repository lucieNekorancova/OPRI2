package Doprava;

public class SmerovaZnacka extends DopravniZnacka{
    public Smer povolenySmer;

    public SmerovaZnacka(Smer povolenySmer){
        this.povolenySmer = povolenySmer;
    }
    @Override
    public boolean jePorusena(Auto auto){
        return auto.getSmerJizdy() != povolenySmer;
    }

}
