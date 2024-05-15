
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

    SmerLopticky(int uhol, int vektorX, int vektorY) {}
}

