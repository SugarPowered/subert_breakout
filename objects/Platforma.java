package objects;

import fri.shapesge.Obdlznik;
import objects.sub.Poloha;
import objects.sub.SmerPlatformy;

/**
 * trieda Platforma - reprezentuje objekt Platformy
 *
 * @author Michal Šubert
 */

public class Platforma {
    public static final int DLZKA = 90;
    public static final int VYSKA = 10;

    private final Poloha poloha;
    private final Obdlznik obdlznik; // shapesGE default x = 60, y = 50

    /**
     * konstruktor Platforma - vykresli Obdlznik z ShapesGE reprezentujuci platformu a priradzuje polohu z parame
     */
    public Platforma(Poloha poloha) {
        this.obdlznik = new Obdlznik(0, 0);
        this.obdlznik.zmenStrany(DLZKA, VYSKA);
        this.obdlznik.zmenFarbu("red");
        
        this.obdlznik.posunVodorovne(poloha.getX());
        this.obdlznik.posunZvisle(poloha.getY());

        this.obdlznik.zobraz();
        
        this.poloha = new Poloha(poloha.getX(), poloha.getY()); // priradenie polohy
    }

    /**
     * metoda pohniNaNovuPoziciu() - na zaklade parametra smerPlatformy pohne na novu poziciu
     */
    public void pohniNaNovuPoziciu(SmerPlatformy smerPlatformy) {
        switch (smerPlatformy) {
            case VPRAVO -> {
                int vzdialenost = 1;
                this.poloha.setX(this.poloha.getX() + vzdialenost);  // posun atributu poloha
                this.obdlznik.posunVodorovne(vzdialenost);
            } case VLAVO -> {
                int vzdialenost = -1;
                this.poloha.setX(this.poloha.getX() + vzdialenost);  // posun atributu poloha
                this.obdlznik.posunVodorovne(vzdialenost);
            }
        }
    }

    /**
     * metoda getPlatformaX() - vracia X suradnicu platformy
     */
    public int getPlatformaX() {
        return this.poloha.getX();
    }
}
