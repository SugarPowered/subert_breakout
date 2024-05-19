package gui;

import fri.shapesge.TextBlock;

import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * trieda EndMenu - podtrieda Menu, reprezentuje koncove menu, ktore sa zobrazi po odohrati hry
 *
 * @author Michal Šubert
 */


public class EndMenu extends Menu {

    private final Tlacidlo tlacidloZapisSkore;
    private final Tlacidlo tlacidloOdist;

    private boolean zapniHru;

    private final int skore;

    private final int celkoveSkore;

    private final TextBlock textBlock;

    /**
     * konstruktor EndMenu - dedi konstruktor triedy Menu a dotvara tlacidla ZapisSkore a Odist,
     * zaznamenava parametre skore a celkoveSkore a tvori z nich atributy
     */
    public EndMenu(int skore, int celkoveSkore) {
        super();

        this.skore = skore;
        this.celkoveSkore = celkoveSkore;

        this.tlacidloZapisSkore = new Tlacidlo(TlacidloTyp.ZAPIS_SKORE);
        this.tlacidloOdist = new Tlacidlo(TlacidloTyp.ODIST);

        if (skore != 0) {
            this.textBlock = new TextBlock("Nevadí! Dosiahol si skore: " + skore + " / " + celkoveSkore, 250, 220);
            this.textBlock.changeColor("white");
        } else {
            this.textBlock = new TextBlock("GRATULUJEM! Vyhral si!", 250, 220);
            this.textBlock.changeColor("white");
        }

    }

    /**
     * metoda skry() - dedi z metody skry() z Menu a skryva tlacidla ZapisSkore a Odist
     */
    public void skry() {
        super.skry();
        this.tlacidloZapisSkore.skry();
        this.tlacidloOdist.skry();
        this.textBlock.makeInvisible();
    }

    /**
     * metoda zobraz() - dedi z metody zobraz() z Menu a vykresluje tlacidla ZapisSkore a Odist
     */
    public void zobraz() {
        super.zobraz();
        this.tlacidloZapisSkore.zobraz();
        this.tlacidloOdist.zobraz();
        this.textBlock.makeVisible();
    }

    /**
     * metoda vyberSuradnice() - na zaklade parametrov x a y zistuje polohu kliknutia, vykonava akciu pre tlacidla ZapisSkore a Odist
     */
    public void vyberSuradnice(int x, int y) {
        if (this.klikNaTlacidloOdist(x, y)) {
            System.exit(0);
        }

        if (this.klikNaTlacidloZapisSkore(x, y)) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter format =  DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

            try {
                File subor = new File("zaznam_skore.txt");
                if (subor.exists()) {
                    FileWriter zapisovac = new FileWriter(subor.getName(), true);
                    zapisovac.write( "V case: " + now.format(format) + " bolo dosiahnute skore: " + this.skore + " / " + this.celkoveSkore + "\n" );
                    zapisovac.close();
                } else {
                    FileWriter zapisovac = new FileWriter("zaznam_skore.txt", true);
                    zapisovac.write( "V case: " + now.format(format) + " bolo dosiahnute skore: " + this.skore + " / " + this.celkoveSkore + "\n" );
                    zapisovac.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            JOptionPane.showMessageDialog(null, "Tvoje skore bolo zapisane do 'zaznam_skore.txt'");
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

    private boolean klikNaTlacidloZapisSkore(int x, int y) {
        // ZAPIS_SKORE = x: [125, 275], y: [270, 370]
        return (x >= this.tlacidloZapisSkore.getX() && x <= this.tlacidloZapisSkore.getX() + 150 &&
                y >= this.tlacidloZapisSkore.getY() && y <= this.tlacidloZapisSkore.getY() + 100);
    }
}