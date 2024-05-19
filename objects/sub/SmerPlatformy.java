package objects.sub;

/**
 * enum trieda SmerPlatformy - uchovava mozne smery Platformy a ich uhly, X a Y vektory
 *
 * @author Michal Šubert
 */

public enum SmerPlatformy {
    VPRAVO (180, 1, 0),
    VLAVO (0, -1, 0);
    
    SmerPlatformy(int uhol, int vektorX, int vektorY) { }
}