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

    private final TextBlock textBlock;

    public EndMenu(int skore, int celkoveSkore) {
        super();

        this.skore = skore;
        this.celkoveSkore = celkoveSkore;

        this.tlacidloZapisSkore = new Tlacidlo("ZapisSkore");
        this.tlacidloOdist = new Tlacidlo("Odist");

        if (skore != 0) {
            this.textBlock = new TextBlock("Nevadí! Dosiahol si skore: " + skore + " / " + celkoveSkore, 250, 220);
            this.textBlock.changeColor("white");
        } else {
            this.textBlock = new TextBlock("GRATULUJEM! Vyhral si!", 250, 220);
            this.textBlock.changeColor("white");
        }

    }

    public void skry() {
        super.skry();
        this.tlacidloZapisSkore.skry();
        this.tlacidloOdist.skry();
        this.textBlock.makeInvisible();
    }

    public void zobraz() {
        super.zobraz();
        this.tlacidloZapisSkore.zobraz();
        this.tlacidloOdist.zobraz();
        this.textBlock.makeVisible();
    }

    public void vyberSuradnice(int x, int y) {
        if (klikNaTlacidloOdist(x, y)) {
            System.exit(0);
        }

        if (klikNaTlacidloZapisSkore(x, y)) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter format =  DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

            try {
                File subor = new File("zaznam_skore.txt");
                if (subor.exists()) {
                    FileWriter zapisovac = new FileWriter(subor.getName(), true);
                    zapisovac.write( "V case: " + now.format(format) + " bolo dosiahnute skore: "+ skore + " / " + celkoveSkore + "\n" );
                    zapisovac.close();
                } else {
                    FileWriter zapisovac = new FileWriter("zaznam_skore.txt", true);
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

    private boolean klikNaTlacidloOdist(int x, int y) {
        // ODIST - x: [365, 415], y: [270, 370]
        return (x >= this.tlacidloOdist.getX() && x <= this.tlacidloOdist.getX() + 150 &&
                y >= this.tlacidloOdist.getY() && y <= this.tlacidloOdist.getY() + 100);
    }

    private boolean klikNaTlacidloZapisSkore(int x, int y) {
        // ZAPIS_SKORE = x: [125, 275], y: [270, 370]
        return (x >= this.tlacidloZapisSkore.getX() && x <= this.tlacidloZapisSkore.getX() + 150 &&
                y >= this.tlacidloZapisSkore.getY() && y <= this.tlacidloZapisSkore.getY() + 100);
    }
}