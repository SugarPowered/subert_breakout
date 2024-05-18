package gui;

import fri.shapesge.Manazer;
import fri.shapesge.Obdlznik;
import fri.shapesge.Obrazok;

// TODO: Napisat dokumentacny komentar StartMenu

public class StartMenu extends Menu {

    private Obdlznik pozadie;
    private Obrazok titulnaFotka;
    private final Tlacidlo tlacidloSpustit;
    private final Tlacidlo tlacidloOdist;

    private Manazer manazer;

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
        if (x >= this.tlacidloOdist.getX() && x <= this.tlacidloOdist.getX() + 150 && // x: <365, 415>
            y >= this.tlacidloOdist.getY() && y <= this.tlacidloOdist.getY() + 100) { // y: <270, 370>
            System.exit(0);
        }

        if (x >= this.tlacidloSpustit.getX() && x <= this.tlacidloSpustit.getX() + 150 && // x: <125, 275>
                y >= this.tlacidloSpustit.getY() && y <= this.tlacidloSpustit.getY() + 100) { // y: <270, 370>
            this.zapniHru = true;
        }
    }

    public boolean getZapniHru() {
        return this.zapniHru;
    }
}
