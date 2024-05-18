package gui;

import fri.shapesge.TextBlock;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


// TODO: Napisat dokumentacny komentar EndMenu

public class EndMenu extends Menu {

    private final Tlacidlo tlacidloZapisSkore;
    private final Tlacidlo tlacidloOdist;

    private boolean zapniHru;

    private final int skore;

    private final int celkoveSkore;

    private final TextBlock skoreBlok;

    public EndMenu(int skore, int celkoveSkore) {
        super();

        this.skore = skore;
        this.celkoveSkore = celkoveSkore;

        this.tlacidloZapisSkore = new Tlacidlo("ZapisSkore");
        this.tlacidloOdist = new Tlacidlo("Odist");

        this.skoreBlok = new TextBlock("Nevadí! Dosiahol si skore: " + skore + " / " + celkoveSkore, 250, 220);
        this.skoreBlok.changeColor("white");

    }

    public void skry() {
        super.skry();
        this.tlacidloZapisSkore.skry();
        this.tlacidloOdist.skry();
        this.skoreBlok.makeInvisible();
    }

    public void zobraz() {
        super.zobraz();
        this.tlacidloZapisSkore.zobraz();
        this.tlacidloOdist.zobraz();
        this.skoreBlok.makeVisible();
    }

    public void vyberSuradnice(int x, int y) {
        if (x >= this.tlacidloOdist.getX() && x <= this.tlacidloOdist.getX() + 150 &&
                y >= this.tlacidloOdist.getY() && y <= this.tlacidloOdist.getY() + 100) {
            System.exit(0);
        }

        if (x >= this.tlacidloZapisSkore.getX() && x <= this.tlacidloZapisSkore.getX() + 150 && // x: <125, 275>
                y >= this.tlacidloZapisSkore.getY() && y <= this.tlacidloZapisSkore.getY() + 100) { // y: <270, 370>
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter format =  DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

            try {
                File subor = new File("zaznam_skore.txt");
                if (subor.exists()) {
                    FileWriter zapisovac = new FileWriter(subor.getName(), true);
                    zapisovac.write( "V case: " + now.format(format) + " bolo dosiahnute skore: "+ skore + " / " + celkoveSkore + "\n" );
                    zapisovac.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            JOptionPane.showMessageDialog(null, "Tvoje skore bolo zapisane do 'zaznam_skore.txt'");
        }
    }

    public boolean getZapniHru() {
        return this.zapniHru;
    }
}