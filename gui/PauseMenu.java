package gui;

import fri.shapesge.Obdlznik;
import fri.shapesge.TextBlock;

/**
 * trieda PauseMenu - podtrieda Menu, reprezentuje menu, ktore sa zobrazi pocas pauzy hry
 *
 * @author Michal Šubert
 */
public class PauseMenu extends Menu {

    private final TextBlock nadpis;

    private final Obdlznik pozadie;

    /**
     * konstruktor PauseMenu - narozdiel od StartMenu a EndMenu nededi konstruktor triedy Menu
     * vykresluje nadpis, ktory zobrazuje aktualne skore/celkoveSkore
     */
    public PauseMenu(int skore, int celkoveSkore) {
        this.pozadie = new Obdlznik(0, 0);
        this.pozadie.zmenStrany(640, 240);
        this.pozadie.zmenFarbu("black");
        this.pozadie.skry();

        this.nadpis = new TextBlock("PAUZA - Stlac MEZDERNIK a hraj dalej \n Zatial mas skore: " + skore + " / " + celkoveSkore + " Let's go!" , 225, 250);
        this.nadpis.changeColor("white");
    }

    /**
     * metoda skry() - skryva pozadie, nadpis a titulnu fotku z Menu
     */
    public void skry() {
        this.pozadie.skry();
        this.getTitulnaFotka().skry();
        this.nadpis.makeInvisible();
    }

    /**
     * metoda zobraz() - zobrazuje pozadie, titulnu fotku z Menu a nadpis
     */
    public void zobraz() {
        this.pozadie.zobraz();
        this.getTitulnaFotka().zobraz();
        this.nadpis.makeVisible();
    }
}
