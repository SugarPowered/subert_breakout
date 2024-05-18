package gui;

// TODO: Napisat dokumentacny komentar StartMenu

public class StartMenu extends Menu {
    private final Tlacidlo tlacidloSpustit;
    private final Tlacidlo tlacidloOdist;

    private boolean zapniHru;

    public StartMenu() {
        super();

        this.tlacidloSpustit = new Tlacidlo("Spustit");
        this.tlacidloOdist = new Tlacidlo("Odist");
    }

    public void skry() {
        super.skry();
        this.tlacidloSpustit.skry();
        this.tlacidloOdist.skry();
    }

    public void zobraz() {
        super.zobraz();
        this.tlacidloSpustit.zobraz();
        this.tlacidloOdist.zobraz();
    }

    public void vyberSuradnice(int x, int y) {
        if (klikNaTlacidloOdist(x, y)) {
            System.exit(0);
        }

        if (klikNaTlacidloSpustit(x, y)) {
            this.zapniHru = true;
        }
    }

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
