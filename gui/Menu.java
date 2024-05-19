package gui;

import fri.shapesge.Obdlznik;
import fri.shapesge.Obrazok;
import fri.shapesge.Manazer;

/**
 * Abstraktna trieda Menu - vytvara zaklad pre dalsie typy Menu v hre
 * 
 * @author Michal Šubert
 */
public abstract class Menu {
    private final Obdlznik pozadie;
    private final Manazer manazer;
    private Obrazok titulnaFotka;
    private boolean zapniHru;

    
    /**
     * Konstruktor Menu() - vytvara a vykresuje pozadie a titulnu fotku menu
     */
    public Menu() {
        this.manazer = new Manazer();
        this.manazer.spravujObjekt(this);
        this.zapniHru = false;
       
        this.pozadie = new Obdlznik(0, 0);
        this.pozadie.zmenStrany(640, 480);
        this.pozadie.zmenFarbu("black");
        this.pozadie.skry();

        this.titulnaFotka = new Obrazok("src//resources//title.png");
        this.titulnaFotka.posunVodorovne(-100);
        this.titulnaFotka.posunZvisle(-100);
    }

    /**
     * metoda getZapniHru() - getter pre atribut zapniHru vracia true/false podla stavu zapnutia hry
     */
    public boolean getZapniHru() {
        return this.zapniHru;
    }

    /**
     * metoda skry() - skryva vykreslene pozadie a titulnu fotku z ShapesGE
     */
    public void skry() {
        this.pozadie.skry();
        this.titulnaFotka.skry();
    }

    /**
     * metoda zobraz() - vykresluje pozadie a titulnu fotku cez ShapeGE
     */
    public void zobraz() {
        this.pozadie.zobraz();
        this.titulnaFotka.zobraz();
    }

    /**
     * metoda vyberSuradnice() - metoda, kde sa v podtriedach tvoria akcie k tlacidlach menu
     */
    public void vyberSuradnice(int x, int y) { }

    /**
     * metoda getTitulnaFotka() - getter pre atribut titulnaFotka, vracia Obrazok
     */
    public Obrazok getTitulnaFotka() {
        return this.titulnaFotka;
    }
}
