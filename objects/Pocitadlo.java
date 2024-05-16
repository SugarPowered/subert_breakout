package objects;

import fri.shapesge.TextBlock;

public class Pocitadlo {

    private int skore;

    private final int celkovyPocetTehiel;

    private TextBlock text;

    public Pocitadlo(int celkovyPocetTehiel) {
        this.celkovyPocetTehiel = celkovyPocetTehiel;
        this.skore = celkovyPocetTehiel;

        this.text = new TextBlock(this.skore + "/" + celkovyPocetTehiel, 600, 20);
        this.text.changeColor("white");
        this. text.makeVisible();
    }

    public void updateSkore() {
        this.skore = this.skore - 1;

        this.text.makeInvisible();
        this.text = new TextBlock(this.skore + "/" + this.celkovyPocetTehiel, 600, 20);
        this.text.changeColor("white");
        this.text.makeVisible();
    }

    public int getSkore() {
        return this.skore;
    }
}


