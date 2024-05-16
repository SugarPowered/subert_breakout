package gui;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class EndMenu extends Menu {

    private Tlacidlo tlacidloSkore;
    private Tlacidlo tlacidloOdist;

    private boolean zapniHru;

    private int skore;

    private int celkoveSkore;


    public EndMenu() {
        super();

        this.tlacidloSkore = new Tlacidlo("Skore");
        this.tlacidloOdist = new Tlacidlo("Odist");
    }

    public EndMenu(int skore, int celkoveSkore) {
        super();

        this.skore = skore;
        this.celkoveSkore = celkoveSkore;

        this.tlacidloSkore = new Tlacidlo("Skore");
        this.tlacidloOdist = new Tlacidlo("Odist");
    }

    public void skry() {
        super.skry();
        this.tlacidloSkore.skry();
        this.tlacidloOdist.skry();
    }

    public void zobraz() {
        super.zobraz();
        this.tlacidloSkore.zobraz();
        this.tlacidloOdist.zobraz();
    }

    public void vyberSuradnice(int x, int y) {
        if (x >= this.tlacidloOdist.getX() && x <= this.tlacidloOdist.getX() + 150 &&
                y >= this.tlacidloOdist.getY() && y <= this.tlacidloOdist.getY() + 100) {
            System.exit(0);
        }

        if (x >= this.tlacidloSkore.getX() && x <= this.tlacidloSkore.getX() + 150 && // x: <125, 275>
                y >= this.tlacidloSkore.getY() && y <= this.tlacidloSkore.getY() + 100) { // y: <270, 370>
            JOptionPane.showMessageDialog(null, "Tvoje skore je " + skore + "/" + celkoveSkore);
        }
    }

    public boolean getZapniHru() {
        return this.zapniHru;
    }
}