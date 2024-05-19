package objects;

import fri.shapesge.TextBlock;

/**
 * trieda Pocitadlo - reprezentuje objekt pocitadla skore v hre
 *
 * @author Michal Šubert
 */

public class Pocitadlo {

    private int skore;

    private final int celkovyPocetTehiel;

    private TextBlock textBlock;

    /**
     * konstruktor Pocitadlo - zaznamenava z parametra celkovy pocet skore
     * a vytvara textBlok na ktorom skore zobrazuje v porovnani s celkovym skore
     */
    public Pocitadlo(int celkovyPocetTehiel) {
        this.celkovyPocetTehiel = celkovyPocetTehiel;
        this.skore = celkovyPocetTehiel;

        this.textBlock = new TextBlock(this.skore + "/" + celkovyPocetTehiel, 600, 20);
        this.textBlock.changeColor("white");
        this.textBlock.makeVisible();
    }

    /**
     * metoda updateSkore() - odpocitava pocet skore po kazdej rozbitej tehle, vykresluje textBlok nanovo
     */
    public void updateSkore() {
        this.skore = this.skore - 1;

        this.textBlock.makeInvisible();
        this.textBlock = new TextBlock(this.skore + "/" + this.celkovyPocetTehiel, 600, 20);
        this.textBlock.changeColor("white");
        this.textBlock.makeVisible();
    }

    /**
     * metoda getSkore() - getter pre atribut skore
     */
    public int getSkore() {
        return this.skore;
    }

    /**
     * metoda getCelkovyPocetTehiel() - getter pre atribut celkovyPocetTehiel
     */
    public int getCelkovyPocetTehiel() {
        return this.celkovyPocetTehiel;
    }
}


