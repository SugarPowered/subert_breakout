package objects;

import fri.shapesge.Obdlznik;
import objects.sub.Poloha;

// TODO: Napisat dokumentacny komentar Tehla

/**
 * Write a description of class Menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Tehla {
    private int dlzka;
    private int vyska;

    private final Obdlznik obdlznik; // shapesGE default x = 60, y = 50
    private final Poloha poloha;
    
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
    
    public int getTehlaX() {
        return this.poloha.getX();
    }
    
    public int getTehlaY() {
        return this.poloha.getY();
    }
    
    public int getDlzka() {
        return this.dlzka;
    }
    
    public int getVyska() {
        return this.vyska;
    }

    public void setPoloha(int x, int y) {
        this.obdlznik.posunVodorovne(x - this.poloha.getX());
        this.poloha.setX(x);

        this.obdlznik.posunVodorovne(y - this.poloha.getY());
        this.poloha.setY(y);
    }
    
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
    
    public void zmenFarbu(String farba) {
        this.obdlznik.zmenFarbu(farba);
    }



}
