import fri.shapesge.Manazer;
import fri.shapesge.Obdlznik;
import fri.shapesge.Obrazok;

public class EndMenu extends Menu {
    private Obdlznik pozadie;
    private Obrazok titulnaFotka;
    private Obrazok restartTlacidlo;
    private Obrazok odistTlacidlo;

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

        this.manazer = new Manazer();
        this.manazer.spravujObjekt(this);
        this.zapniHru = false;

        this.titulnaFotka = new Obrazok("img/title.png");
        this.titulnaFotka.posunVodorovne(-100);
        this.titulnaFotka.posunZvisle(-100);

        this.restartTlacidlo = new Obrazok("img/restart.png");
        this.restartTlacidlo.posunVodorovne(25);
        this.restartTlacidlo.posunZvisle(170);

        this.odistTlacidlo = new Obrazok("img/odist.png");
        this.odistTlacidlo.posunVodorovne(265);
        this.odistTlacidlo.posunZvisle(170);
    }

    public void skry() {
        this.restartTlacidlo.skry();
        this.odistTlacidlo.skry();
    }

    public void zobraz() {
        this.restartTlacidlo.zobraz();
        this.odistTlacidlo.zobraz();
    }
}
