package objects;

import fri.shapesge.Obdlznik;
import objects.sub.Poloha;

/**
 * trieda Tehla - reprezentuje objekt Tehly v hre
 *
 * @author Michal Šubert
 */

public class Tehla {
    private final int dlzka;
    private final int vyska;

    private final Obdlznik obdlznik; // shapesGE default x = 60, y = 50
    private final Poloha poloha;

    /**
     * konstruktor Tehla - vykresli Obdlznik podla parametrov dlzka, vyska z ShapesGE a priradzuje polohu z parametra
     */
    public Tehla(Poloha poloha, int dlzka, int vyska) {
        this.dlzka = dlzka;
        this.vyska = vyska;
        String farba = "blue";
        
        this.obdlznik = new Obdlznik(0, 0);
        this.obdlznik.zmenStrany(this.dlzka, this.vyska);
        this.obdlznik.posunVodorovne(poloha.getX()); 
        this.obdlznik.posunZvisle(poloha.getY()); 
        this.obdlznik.zmenFarbu(farba);
        this.obdlznik.zobraz();

        this.poloha = new Poloha(poloha.getX(), poloha.getY()); // nova default Poloha platformy
    }

    /**
     * metoda getTehlaX() - getter pre X suradnicu tehly
     */
    public int getTehlaX() {
        return this.poloha.getX();
    }

    /**
     * metoda getTehlaY() - getter pre Y suradnicu tehly
     */
    public int getTehlaY() {
        return this.poloha.getY();
    }

    /**
     * metoda getDlzka() - getter pre atribut dlzky tehly
     */
    public int getDlzka() {
        return this.dlzka;
    }

    /**
     * metoda getVyska() - getter pre atribut vysky tehly
     */
    public int getVyska() {
        return this.vyska;
    }

    /**
     * metoda setPoloha() - setter pre polohu tehly na zaklade parametrov x a y
     */
    public void setPoloha(int x, int y) {
        this.obdlznik.posunVodorovne(x - this.poloha.getX());
        this.poloha.setX(x);

        this.obdlznik.posunVodorovne(y - this.poloha.getY());
        this.poloha.setY(y);
    }

    /**
     * metoda zmenCislomFarbu() - na zaklade zadaneho cisla v parametri zmeni farbu danej tehly
     */
    public void zmenCislomFarbu(int cislo) {
        switch (cislo) {
            case 0 -> this.obdlznik.zmenFarbu("red");
            case 1 -> this.obdlznik.zmenFarbu("blue");
            case 2 -> this.obdlznik.zmenFarbu("yellow");
            case 3 -> this.obdlznik.zmenFarbu("green");
            case 4 -> this.obdlznik.zmenFarbu("magenta");
            case 5 -> this.obdlznik.zmenFarbu("white");
            case 6 -> this.obdlznik.zmenFarbu("brown");
        }
        
    }

    /**
     * metoda zmenFarbu() - na zaklade zadaneho Stringu v parametri zmeni farbu danej tehly v ShapesGE
     */
    public void zmenFarbu(String farba) {
        this.obdlznik.zmenFarbu(farba);
    }
}
