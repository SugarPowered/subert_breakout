
/**
 * Enumeration class Smer - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

public enum Smer {
    HORE (90, 0, -1),
    DOLU (270, 0, 1),
    VPRAVO (180, 1, 0),
    VLAVO (0, -1, 0);
    
    private int uhol;
    private int vektorX;
    private int vektorY;
    
    Smer(int uhol, int vektorX, int vektorY) {
        this.uhol = uhol;
        this.vektorX = vektorX;
        this.vektorY = vektorY;
    }
    
    public int getVektorX() {
        return this.vektorX;
    }
    
    public int getVektorY() {
        return this.vektorY;
    }
    
    public int getUhol() {
        return this.uhol;
    }
    
    public void setVektorX(int x) {
        this.vektorX = x;
    }
    
    public void setVektorY(int y) {
        this.vektorY = y;
    }
    
    public void setUhol(int uhol) {
        this.uhol = uhol;
    }
}