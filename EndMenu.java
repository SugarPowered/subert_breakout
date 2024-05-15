import fri.shapesge.Manazer;
import fri.shapesge.Obdlznik;
import fri.shapesge.Obrazok;

public class EndMenu extends Menu {

    private Obdlznik pozadie;
    private Obrazok titulnaFotka;
    private Tlacidlo tlacidloRestart;
    private Tlacidlo tlacidloOdist;

    private Manazer manazer;

    private boolean zapniHru;

    EndMenu() {
        this.manazer = new Manazer();
        this.manazer.spravujObjekt(this);
        this.zapniHru = false;

        this.pozadie = new Obdlznik(0, 0);
        this.pozadie.zmenStrany(640, 480);
        this.pozadie.zmenFarbu("black");
        this.pozadie.skry();

        this.titulnaFotka = new Obrazok("subert_breakout//img//title.png");
        this.titulnaFotka.posunVodorovne(-100);
        this.titulnaFotka.posunZvisle(-100);

        this.tlacidloRestart = new Tlacidlo("Restart");
        this.tlacidloOdist = new Tlacidlo("Odist");
    }

    public void skry() {
        super.skry();
        this.tlacidloRestart.skry();
        this.tlacidloOdist.skry();
    }

    public void zobraz() {
        super.zobraz();
        this.tlacidloRestart.zobraz();
        this.tlacidloOdist.zobraz();
    }

    public void vyberSuradnice(int x, int y) {
        if (x >= this.tlacidloOdist.getX() && x <= this.tlacidloOdist.getX() + 150 ||
                y >= this.tlacidloOdist.getY() && y <= this.tlacidloOdist.getY() + 100) {

        }

        if (x >= this.tlacidloRestart.getX() && x <= this.tlacidloRestart.getX() + 150 && // x: <125, 275>
                y >= this.tlacidloRestart.getY() && y <= this.tlacidloRestart.getY() + 100) { // y: <270, 370>
            this.zapniHru = true;
        }
    }

    public boolean getZapniHru() {
        return this.zapniHru;
    }
}