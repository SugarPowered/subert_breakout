
/**
 * Enumeration class Smer - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

public enum SmerLopticky {
    VPRAVO_HORE (135, 1, -1),
    VLAVO_HORE (45, -1, -1),
    VLAVO_DOLU (315, -1, 1),
    VPRAVO_DOLU (225, 1, 1);
    
    private int uhol;
    private int vektorX;
    private int vektorY;
    
    SmerLopticky(int uhol, int vektorX, int vektorY) {
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
}

