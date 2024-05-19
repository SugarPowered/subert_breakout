package objects;

import fri.shapesge.Kruh;
import objects.sub.Poloha;
import objects.sub.SmerLopticky;

/**
 * trieda Lopticka - reprezentuje objekt Lopticky
 * @author Michal Šubert
 */

public class Lopticka {

    private final Kruh kruh; // shapesGE default x = 20, y = 60
    private Poloha poloha;

    /**
     * konstruktor Lopticka() vytvara novu instanciu lopticky s parametrom polohy
     */
    public Lopticka(Poloha poloha) {
        int priemer = 15;

        this.kruh = new Kruh(0, 0);
        this.kruh.zmenPriemer(priemer);
        this.kruh.zobraz();
            
        this.kruh.posunVodorovne(poloha.getX());
        this.kruh.posunZvisle(poloha.getY());
                
        this.poloha = new Poloha(poloha.getX(), poloha.getY()); // startovacia poloha
    }

    /**
     * metoda getLoptickaX() getter pre Y suradnicu lopticky
     */
    public int getLoptickaX() {
        return this.poloha.getX();
    }

    /**
     * metoda getLoptickaY() getter pre Y suradnicu lopticky
     */
    public int getLoptickaY() {
        return this.poloha.getY();
    }

    /**
     * metoda pohniNaNovuPoziciu() na zaklade parametra smerLopticky vykresli Lopticku na novom mieste
     */
    public void pohniNaNovuPoziciu(SmerLopticky smerLopticky) {
        Poloha posun = this.vypocitajPosun(smerLopticky);
        this.kruh.posunVodorovne(posun.getX());
        this.kruh.posunZvisle(posun.getY());
        this.poloha = new Poloha(this.poloha.getX() + posun.getX(), this.poloha.getY() + posun.getY());
    }

    /**
     * metoda vypocitajPosun() na zaklade parametra smerLopticky vrati Polohu do ktorej sa ma lopticka pohnut
     */
    private Poloha vypocitajPosun(SmerLopticky smerLopticky) {
        return switch (smerLopticky) {
            case VLAVO_HORE -> new Poloha(-1, -1);
            case VLAVO_DOLU -> new Poloha(-1, 1);
            case VPRAVO_HORE -> new Poloha(1, -1);
            case VPRAVO_DOLU -> new Poloha(1, 1);
        };
    }
}
