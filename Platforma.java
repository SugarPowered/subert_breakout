import fri.shapesge.Obdlznik;

public class Platforma {
    public static final int DLZKA = 90;
    public static final int VYSKA = 10;
    
    private String farba; 
    
    private Poloha poloha; 
    private Obdlznik obdlznik; // shapesGE default x = 60, y = 50
    
    public Platforma(Poloha poloha) {
        this.obdlznik = new Obdlznik(0, 0);
        this.obdlznik.zmenStrany(this.DLZKA, this.VYSKA);
        this.obdlznik.zmenFarbu("red");
        
        this.obdlznik.posunVodorovne(poloha.getX());
        this.obdlznik.posunZvisle(poloha.getY());
        
        this.obdlznik.zobraz();
        
        this.poloha = new Poloha(poloha.getX(), poloha.getY()); // priradenie polohy
    }
    
    public void pohniNaNovuPoziciu(Smer smer) {
        if (smer.getVektorX() == 1) { //smer posunu vpravo
            int vzdialenost = 1;
            this.poloha.setX(this.poloha.getX() + vzdialenost);  // posun atributu poloha
            this.obdlznik.posunVodorovne(vzdialenost);
        } else if (smer.getVektorX() == -1) { //smer posun vlavo
            int vzdialenost = -1;
            this.poloha.setX(this.poloha.getX() + vzdialenost);  // posun atributu poloha
            this.obdlznik.posunVodorovne(vzdialenost);
        }
    }
    
    public int getPlatformaX() {
        return this.poloha.getX();
    }
    
    public int getPlatformaY() {
        return this.poloha.getY();
    }
    
    public void setPlatformuX(int x) {
        this.obdlznik.posunVodorovne(x - this.poloha.getX());        
        this.poloha.setX(x);
    }
    
    public void zobrazPlatformu() {
        this.obdlznik.zobraz();
    }
    
    public void skryPlatformu() {
        this.obdlznik.skry();
    }
    
    public void zmenFarbu(String farba) {
        this.farba = farba;
    }
}
