import fri.shapesge.Kruh;

public class Lopticka {
    private int priemer = 15;
    
    private Kruh kruh; // shapesGE default x = 20, y = 60
    private Poloha poloha;
    
    public Lopticka(Poloha poloha) {
        this.kruh = new Kruh(0, 0);
        this.kruh.zmenPriemer(this.priemer);
        this.kruh.zobraz();
            
        this.kruh.posunVodorovne(poloha.getX());
        this.kruh.posunZvisle(poloha.getY());
                
        this.poloha = new Poloha(poloha.getX(), poloha.getY()); // startovacia poloha
    }
    
    public Poloha getPoloha() {
        return this.poloha;
    } 
    
    public int getLoptickaX() {
        return this.poloha.getX();
    }
    
    public int getLoptickaY() {
        return this.poloha.getY();
    }
    
    public void pohniNaNovuPoziciu(SmerLopticky smerLopticky) {
        if (smerLopticky.getUhol() == 225) { // Posun Vpravo Dole
            // manualny posun na platne
            int vzdialenost = 1;
            this.kruh.posunVodorovne(vzdialenost);
            this.kruh.posunZvisle(vzdialenost);
            
            //zmena v atribute poloha
            this.poloha = new Poloha(this.poloha.getX() + vzdialenost, this.poloha.getY() + vzdialenost );
        } else if (smerLopticky.getUhol() == 315) { // Posun Vlavo Dole
            // manualny posun na platne
            int vzdialenostX = -1;
            int vzdialenostY = 1;
            this.kruh.posunVodorovne(vzdialenostX);
            this.kruh.posunZvisle(vzdialenostY);
            
            //zmena v atribute poloha
            this.poloha = new Poloha(this.poloha.getX() + vzdialenostX, this.poloha.getY() + vzdialenostY );
        } else if (smerLopticky.getUhol() == 45) { // Posun Vlavo Hore
            // manualny posun na platne
            int vzdialenost = -1;
            this.kruh.posunVodorovne(vzdialenost);
            this.kruh.posunZvisle(vzdialenost); 
            
            // zmena v atribute poloha
            this.poloha = new Poloha(this.poloha.getX() + vzdialenost, this.poloha.getY() + vzdialenost );
        } else if (smerLopticky.getUhol() == 135) { // Posun Vpravo Hore
            // manualny posun na platne
            int vzdialenostX = 1;
            int vzdialenostY = -1;
            this.kruh.posunVodorovne(vzdialenostX);
            this.kruh.posunZvisle(vzdialenostY);
            
            //zmena v atribute poloha
            this.poloha = new Poloha(this.poloha.getX() + vzdialenostX, this.poloha.getY() + vzdialenostY );
        } 
    }
    
    public void setPoloha(Poloha poloha) {
        //vyresetuj povodnu polohu na platne
        this.kruh.posunVodorovne(-this.poloha.getX());
        this.kruh.posunZvisle(-this.poloha.getY());
        
        //posun o zadanu polohu na platne
        this.kruh.posunVodorovne(poloha.getX());
        this.kruh.posunZvisle(poloha.getY());
        
        //setnutie novej polohy, ktora je zadana
        this.poloha.setX(poloha.getX());
        this.poloha.setY(poloha.getY());
    }
    
    public void zobraz() {
        this.kruh.zobraz();
    }
    
    public void zmenPriemer(int novyPriemer) {
        this.kruh.zmenPriemer(novyPriemer);
    }
}
