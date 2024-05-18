package objects;

import fri.shapesge.TextBlock;

// TODO: Napisat dokumentacny komentar Pocitadlo

public class Pocitadlo {

    private int skore;

    private final int celkovyPocetTehiel;

    private TextBlock textBlock;

    public Pocitadlo(int celkovyPocetTehiel) {
        this.celkovyPocetTehiel = celkovyPocetTehiel;
        this.skore = celkovyPocetTehiel;

        this.textBlock = new TextBlock(this.skore + "/" + celkovyPocetTehiel, 600, 20);
        this.textBlock.changeColor("white");
        this.textBlock.makeVisible();
    }

    public void updateSkore() {
        this.skore = this.skore - 1;

        this.textBlock.makeInvisible();
        this.textBlock = new TextBlock(this.skore + "/" + this.celkovyPocetTehiel, 600, 20);
        this.textBlock.changeColor("white");
        this.textBlock.makeVisible();
    }

    public int getSkore() {
        return this.skore;
    }

    public int getCelkoveSkore() {
        return this.celkovyPocetTehiel;
    }
}


