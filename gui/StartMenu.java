package gui;

/**
 * trieda StartMenu - podtrieda Menu, reprezentuje zaciatocne menu, ktore sa zobrazi po spusteni hry
 *
 * @author Michal Šubert
 */

public class StartMenu extends Menu {
    private final Tlacidlo tlacidloSpustit;
    private final Tlacidlo tlacidloOdist;

    private boolean zapniHru;

    /**
     * konstruktor StartMenu - dedi konstruktor triedy Menu a dotvara tlacidla Spustit a Odist
     */
    public StartMenu() {
        super();

        this.tlacidloSpustit = new Tlacidlo(TlacidloTyp.SPUSTIT);
        this.tlacidloOdist = new Tlacidlo(TlacidloTyp.ODIST);
    }

    /**
     * metoda skry() - dedi z metody skry() z Menu a skryva tlacidla Spustit a Odist
     */
    public void skry() {
        super.skry();
        this.tlacidloSpustit.skry();
        this.tlacidloOdist.skry();
    }

    /**
     * metoda zobraz() - dedi z metody zobraz() z Menu a vykresluje tlacidla Spustit a Odist
     */
    public void zobraz() {
        super.zobraz();
        this.tlacidloSpustit.zobraz();
        this.tlacidloOdist.zobraz();
    }

    /**
     * metoda vyberSuradnice() - na zaklade parametrov x a y zistuje polohu kliknutia, vykonava akciu pre tlacidla Spusit a Odist
     */
    public void vyberSuradnice(int x, int y) {
        if (this.klikNaTlacidloOdist(x, y)) {
            System.exit(0);
        }

        if (this.klikNaTlacidloSpustit(x, y)) {
            this.zapniHru = true;
        }
    }

    /**
     * metoda getZapniHru() - getter pre atribut zapniHru, vracia true/false podla stavu zapnutia hry
     */
    public boolean getZapniHru() {
        return this.zapniHru;
    }

    private boolean klikNaTlacidloOdist(int x, int y) {
        // ODIST - x: [365, 415], y: [270, 370]
        return (x >= this.tlacidloOdist.getX() && x <= this.tlacidloOdist.getX() + 150 &&
                y >= this.tlacidloOdist.getY() && y <= this.tlacidloOdist.getY() + 100);
    }

    private boolean klikNaTlacidloSpustit(int x, int y) {
        // SPUSTIT = x: [125, 275], y: [270, 370]
        return (x >= this.tlacidloSpustit.getX() && x <= this.tlacidloSpustit.getX() + 150 &&
                y >= this.tlacidloSpustit.getY() && y <= this.tlacidloSpustit.getY() + 100);
    }
}
