import fri.shapesge.Obdlznik;
import fri.shapesge.Obrazok;
import fri.shapesge.Manazer;

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Menu {
    private Obdlznik pozadie;
    
    private Manazer manazer;

    private Obrazok titulnaFotka;
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
    }
    
    public void zobraz() {
        this.pozadie.zobraz();
        this.titulnaFotka.zobraz();
    }

}
