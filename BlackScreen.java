import fri.shapesge.Obdlznik;
import fri.shapesge.Text;
import java.awt.Font;

/**
 * Write a description of class BlackScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackScreen {
    
    /**
     * Constructor for objects of class BlackScreen
     */
    private Font font;
    private Obdlznik obdlznik;
    private Text nadpis;
    private Text podnadpis;
    
    public BlackScreen(String stavHry) {
        this.obdlznik = new Obdlznik(0, 0);
        this.obdlznik.zmenStrany(640, 480);
        this.obdlznik.zmenFarbu("black");
        
        this.podnadpis = null;
        if (stavHry.equals("pauza")) {
            this.nadpis = new Text("Pauza", 300, 220);
            this.nadpis.changeColor("white");
            
            this.podnadpis = new Text("Stlac MEZDERNIK a hraj dalej", 245, 245);
            this.podnadpis.changeColor("white");
        } else if (stavHry.equals("prehra")) {
            this.nadpis = new Text("Smola :(", 300, 220);
            this.nadpis.changeColor("white");
            
            this.podnadpis = new Text("neboj sa, vyjde to nabuduce!", 255, 245);
            this.podnadpis.changeColor("white");
            
        } 
    }
    
    public void skry() {
        this.obdlznik.skry();
        this.nadpis.makeInvisible();
        this.podnadpis.makeInvisible();
    }
    
    public void zobraz() {
        this.obdlznik.zobraz();
        this.nadpis.makeVisible();
        this.podnadpis.makeVisible();
    }
}
