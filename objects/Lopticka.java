package objects;

import fri.shapesge.Kruh;
import objects.sub.Poloha;
import objects.sub.SmerLopticky;

// TODO: Napisat dokumentacny komentar Lopticka

public class Lopticka {

    private final Kruh kruh; // shapesGE default x = 20, y = 60
    private Poloha poloha;
    
    public Lopticka(Poloha poloha) {
        int priemer = 15;

        this.kruh = new Kruh(0, 0);
        this.kruh.zmenPriemer(priemer);
        this.kruh.zobraz();
            
        this.kruh.posunVodorovne(poloha.getX());
        this.kruh.posunZvisle(poloha.getY());
                
        this.poloha = new Poloha(poloha.getX(), poloha.getY()); // startovacia poloha
    }
    
    public int getLoptickaX() {
        return this.poloha.getX();
    }
    
    public int getLoptickaY() {
        return this.poloha.getY();
    }

    public void pohniNaNovuPoziciu(SmerLopticky smerLopticky) {
        Poloha posun = vypocitajPosun(smerLopticky);
        this.kruh.posunVodorovne(posun.getX());
        this.kruh.posunZvisle(posun.getY());
        this.poloha = new Poloha(this.poloha.getX() + posun.getX(), this.poloha.getY() + posun.getY());
    }

    private Poloha vypocitajPosun(SmerLopticky smerLopticky) {
        return switch (smerLopticky) {
            case VLAVO_HORE -> new Poloha(-1, -1);
            case VLAVO_DOLU -> new Poloha(-1, 1);
            case VPRAVO_HORE -> new Poloha(1, -1);
            case VPRAVO_DOLU -> new Poloha(1, 1);
        };
    }
}
