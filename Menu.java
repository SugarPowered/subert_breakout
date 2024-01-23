import fri.shapesge.Obdlznik;
import fri.shapesge.Obrazok;
import fri.shapesge.Manazer;

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu {
    private Obdlznik pozadie;
    private Obrazok titulnaFotka;
    private Obrazok spustitTlacidlo;
    private Obrazok odistTlacidlo;
    
    private Manazer manazer;
    private boolean zapniHru;
    
    /**
     * Constructor for objects of class Menu
     */
    public Menu() {
        this.manazer = new Manazer();
        this.manazer.spravujObjekt(this);
        this.zapniHru = false;
       
        this.pozadie = new Obdlznik(0, 0);
        this.pozadie.zmenStrany(640, 480);
        this.pozadie.zmenFarbu("black");
        this.pozadie.skry();
        
        this.titulnaFotka = new Obrazok("img/title.png");
        this.titulnaFotka.posunVodorovne(-100);
        this.titulnaFotka.posunZvisle(-100);
        
        this.spustitTlacidlo = new Obrazok("img/spustit.png");
        this.spustitTlacidlo.posunVodorovne(25);
        this.spustitTlacidlo.posunZvisle(170);
        
        this.odistTlacidlo = new Obrazok("img/odist.png");
        this.odistTlacidlo.posunVodorovne(265);
        this.odistTlacidlo.posunZvisle(170);
    }
    
    public boolean getZapniHru() {
        return this.zapniHru;
    }
    
    public void setZapniHru(boolean zapni) {
        this.zapniHru = zapni;
    }
    
    public void skry() {
        this.pozadie.skry();
        this.titulnaFotka.skry();
        this.spustitTlacidlo.skry();
        this.odistTlacidlo.skry();
    }
    
    public void zobraz() {
        this.pozadie.zobraz();
        this.titulnaFotka.zobraz();
        this.spustitTlacidlo.zobraz();
        this.odistTlacidlo.zobraz();
    }
    
    public void vyberSuradnice(int x, int y) {
        // klik suradnicne tlacidla spusti a odist - 150x100 
        if (x >= 125 && x <= 275 && y >= 270 && y <= 370 ) {
            this.zapniHru = true;
            this.skry();
        } else if (x >= 390 && x <= 540 && y >= 270 && y <= 370 ) {
            System.exit(0);
        }
    }
}
