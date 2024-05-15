package gui;

import fri.shapesge.Manazer;
import fri.shapesge.Obdlznik;
import fri.shapesge.Obrazok;

public class EndMenu extends Menu {

    private Obdlznik pozadie;
    private Obrazok titulnaFotka;
    private Tlacidlo tlacidloRestart;
    private Tlacidlo tlacidloOdist;

    private boolean zapniHru;

    private boolean restartuj;

    public EndMenu() {
        super();

        this.tlacidloRestart = new Tlacidlo("Restart");
        this.tlacidloOdist = new Tlacidlo("Odist");
    }

    public void skry() {
        super.skry();
        this.tlacidloRestart.skry();
        this.tlacidloOdist.skry();
    }

    public void zobraz() {
        super.zobraz();
        this.tlacidloRestart.zobraz();
        this.tlacidloOdist.zobraz();
    }

    public void vyberSuradnice(int x, int y) {
        if (x >= this.tlacidloOdist.getX() && x <= this.tlacidloOdist.getX() + 150 &&
                y >= this.tlacidloOdist.getY() && y <= this.tlacidloOdist.getY() + 100) {
            System.exit(0);
        }

        if (x >= this.tlacidloRestart.getX() && x <= this.tlacidloRestart.getX() + 150 && // x: <125, 275>
                y >= this.tlacidloRestart.getY() && y <= this.tlacidloRestart.getY() + 100) { // y: <270, 370>
            this.zapniHru = true;
        }
    }

    public boolean getZapniHru() {
        return this.zapniHru;
    }

    public boolean getRestartuj() {
        return this.restartuj;
    }
}