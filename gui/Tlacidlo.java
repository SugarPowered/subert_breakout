package gui;
import fri.shapesge.Obrazok;

/**
 * Write a description of class Menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Tlacidlo {
    private int x;
    private int y;

    private Obrazok obrazok;

    public Tlacidlo(String typ) {
        if (typ.equals("Odist")) {
            this.obrazok = new Obrazok("subert_breakout//img//odist.png");
            this.x = 365;
            this.y = 270;
            this.obrazok.posunVodorovne(265);
            this.obrazok.posunZvisle(170);
        }
        if (typ.equals("Spustit")) {
            this.obrazok = new Obrazok("subert_breakout//img//spustit.png");
            this.x = 125;
            this.y = 270;
            this.obrazok.posunVodorovne(25);
            this.obrazok.posunZvisle(170);
        }
        if (typ.equals("Restart")) {
            this.obrazok = new Obrazok("subert_breakout//img//restart.png");
            this.x = 125;
            this.y = 270;
            this.obrazok.posunVodorovne(25);
            this.obrazok.posunZvisle(170);
        }
    }

    public void skry() {
        this.obrazok.skry();
    }

    public void zobraz() {
        this.obrazok.zobraz();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
