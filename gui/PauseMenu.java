package gui;

import fri.shapesge.Obdlznik;
import fri.shapesge.Obrazok;
import fri.shapesge.TextBlock;

import java.awt.Font;

// TODO: Napisat dokumentacny komentar PauseMenu

/**
 * Write a description of class BlackScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PauseMenu extends Menu {

    private final int skore;
    private final int celkoveSkore;
    /**
     * Constructor for objects of class BlackScreen
     */
    private final TextBlock nadpis;

    private final Obdlznik pozadie;
    
    public PauseMenu(int skore, int celkoveSkore) {

        this.skore = skore;
        this.celkoveSkore = celkoveSkore;

        this.pozadie = new Obdlznik(0, 0);
        this.pozadie.zmenStrany(640, 240);
        this.pozadie.zmenFarbu("black");
        this.pozadie.skry();

        this.nadpis = new TextBlock("PAUZA - Stlac MEZDERNIK a hraj dalej \n Zatial mas skore: " + this.skore + " / " + this.celkoveSkore + " Let's go!" , 225, 250);
        this.nadpis.changeColor("white");
        // TODO: preskumat Font a fontstyle

    }
    
    public void skry() {
        this.pozadie.skry();
        this.getTitulnaFotka().skry();
        this.nadpis.makeInvisible();
    }
    
    public void zobraz() {
        this.pozadie.zobraz();
        this.getTitulnaFotka().zobraz();
        this.nadpis.makeVisible();
    }
}
