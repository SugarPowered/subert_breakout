package gui;
import fri.shapesge.Obrazok;

/**
 * trieda Tlacidlo - reprezentuje tlacidla zobrazovane v triedach Menu
 *
 * @author Michal Šubert
 */

public class Tlacidlo {
    private int x;
    private int y;

    private Obrazok obrazok;

    /**
     * konstruktor Tlacidlo - tvori obrazok na zaklade enumu TlacidloTyp
     */
    public Tlacidlo(TlacidloTyp tlacidloTyp) {
        switch (tlacidloTyp) {
            case SPUSTIT -> {
                this.obrazok = new Obrazok("src//resources//spustit.png");
                this.x = 125;
                this.y = 270;
                this.obrazok.posunVodorovne(25);
                this.obrazok.posunZvisle(170);
            }
            case ODIST -> {
                this.obrazok = new Obrazok("src//resources//odist.png");
                this.x = 365;
                this.y = 270;
                this.obrazok.posunVodorovne(265);
                this.obrazok.posunZvisle(170);
            }
            case ZAPIS_SKORE -> {
                this.obrazok = new Obrazok("src//resources//zapis_skore.png");
                this.x = 125;
                this.y = 270;
                this.obrazok.posunVodorovne(25);
                this.obrazok.posunZvisle(170);
            }
        }
    }

    /**
     * metoda skry() - skryva obrazok reprezentujuci tlacidlo z shapesGE
     */
    public void skry() {
        this.obrazok.skry();
    }

    /**
     * metoda zobraz() - zobrazuje obrazok reprezentujuci tlacidlo z shapesGE
     */
    public void zobraz() {
        this.obrazok.zobraz();
    }

    /**
     * metoda getX() - vracia X suradnicu tlacidla
     */
    public int getX() {
        return this.x;
    }

    /**
     * metoda getY() - vracia Y suradnicu tlacidla
     */
    public int getY() {
        return this.y;
    }
}
