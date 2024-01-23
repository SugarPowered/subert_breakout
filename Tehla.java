import fri.shapesge.Obdlznik;

public class Tehla {
    private int dlzka;
    private int vyska;
    private String farba;
    
    private Obdlznik obdlznik; // shapesGE default x = 60, y = 50
    private Poloha poloha;
    
    public Tehla(Poloha poloha, int dlzka, int vyska) {
        this.dlzka = dlzka;
        this.vyska = vyska;
        this.farba = "blue";
        
        this.obdlznik = new Obdlznik(0, 0);
        this.obdlznik.zmenStrany(this.dlzka, this.vyska);
        this.obdlznik.posunVodorovne(poloha.getX()); 
        this.obdlznik.posunZvisle(poloha.getY()); 
        this.obdlznik.zmenFarbu(this.farba);
        
        this.obdlznik.zobraz();
        this.poloha = new Poloha(poloha.getX(), poloha.getY()); // nova default Poloha platformy
    }
    
    public void zobraz() {
        this.obdlznik.zobraz();
    }
    
    public void skry() {
        this.obdlznik.skry();
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
    
    public void setTehlaX(int x) {
        this.obdlznik.posunVodorovne(x - this.poloha.getX());        
        this.poloha.setX(x);
    }
    
    public void setTehlaY(int y) {
        this.obdlznik.posunVodorovne(y - this.poloha.getY());        
        this.poloha.setY(y);
    }
    
    public void setDlzka(int dlzka) {
        this.dlzka = dlzka;
    }
    
    public void setVyska(int vyska) {
        this.vyska = vyska;
    }
    
    public void posunVodorovne(int vzdialenost) {
        this.obdlznik.posunVodorovne(vzdialenost);
    }
    
    public void posunZvisle(int vzdialenost) {
        this.obdlznik.posunZvisle(vzdialenost);
    }
    
    public void zmenCislomFarbu(int cislo) {
        switch (cislo) {
            case 0:
                this.obdlznik.zmenFarbu("red");
                break;
            case 1:
                this.obdlznik.zmenFarbu("blue");
                break;
            case 2:
                this.obdlznik.zmenFarbu("yellow");
                break;
            case 3:
                this.obdlznik.zmenFarbu("green");
                break;
            case 4:
                this.obdlznik.zmenFarbu("magenta");
                break;
            case 5:
                this.obdlznik.zmenFarbu("white");
                break;
            case 6:
                this.obdlznik.zmenFarbu("brown");
                break;
        }
        
    }
    
    public void zmenFarbu(String farba) {
        this.obdlznik.zmenFarbu(farba);
    }
    
    public void odstranTehlu(Poloha poloha) {
        this.obdlznik.zmenFarbu("black");
    }
}
