package objects.sub;

/**
 * enum trieda SmerLopticky - uchovava mozne smery Lopticky a ich uhly, X a Y vektory
 *
 * @author Michal Šubert
 */

public enum SmerLopticky {
    VPRAVO_HORE (135, 1, -1),
    VLAVO_HORE (45, -1, -1),
    VLAVO_DOLU (315, -1, 1),
    VPRAVO_DOLU (225, 1, 1);

    SmerLopticky(int uhol, int vektorX, int vektorY) { }
}

