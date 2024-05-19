package objects.sub;

/**
 * trieda Poloha - zakladna trieda ktora drzi x a y suradnice objektov
 *
 * @author Michal Šubert
 */

public class Poloha {
    private int x;
    private int y;

    /**
     * konstruktor Poloha - uklada parametre x a y do atributov x a y
     */
    public Poloha(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * metoda getX() - getter, vracia X suradnicu typu integer
     */
    public int getX() {
        return this.x;
    }

    /**
     * metoda getY() - getter, vracia Y suradnicu typu integer
     */
    public int getY() {
        return this.y;
    }

    /**
     * metoda setX() - setter, meni atribut x na zaklade parametra x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * metoda setY() - setter, meni atribut y na zaklade parametra y
     */
    public void setY(int y) {
        this.y = y;
    }
}
