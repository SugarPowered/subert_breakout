package gui;

import fri.shapesge.Obdlznik;
import fri.shapesge.TextBlock;

import java.awt.Font;

/**
 * Write a description of class BlackScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PauseMenu extends Menu {
    
    /**
     * Constructor for objects of class BlackScreen
     */
    private Obdlznik obdlznik;
    private TextBlock nadpis;
    private TextBlock podnadpis;
    
    public PauseMenu(String stavHry) {
        this.obdlznik = new Obdlznik(0, 0);
        this.obdlznik.zmenStrany(640, 480);
        this.obdlznik.zmenFarbu("black");
        
        this.podnadpis = null;
        if (stavHry.equals("pauza")) {
            this.nadpis = new TextBlock("Pauza", 300, 220);
            this.nadpis.changeColor("white");
            
            this.podnadpis = new TextBlock("Stlac MEZDERNIK a hraj dalej", 245, 245);
            this.podnadpis.changeColor("white");
        } else if (stavHry.equals("prehra")) {
            this.nadpis = new TextBlock("Smola :(", 300, 220);
            this.nadpis.changeColor("white");
            
            this.podnadpis = new TextBlock("neboj sa, vyjde to nabuduce!", 255, 245);
            this.podnadpis.changeColor("white");
            
        } 
    }
    
    public void skry() {
        this.obdlznik.skry();
        this.nadpis.makeInvisible();
        this.podnadpis.makeInvisible();
    }
    
    public void zobraz() {
        this.obdlznik.zobraz();
        this.nadpis.makeVisible();
        this.podnadpis.makeVisible();
    }
}
