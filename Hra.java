import java.awt.*;
import java.util.Random;
import fri.shapesge.Manazer;
import gui.PauseMenu;
import gui.EndMenu;
import gui.Menu;
import gui.StartMenu;
import objects.*;
import objects.sub.Poloha;
import objects.sub.SmerLopticky;
import objects.sub.SmerPlatformy;

// TODO: Napisat dokumentacny komentar Hra

/**
 * Write a description of class Menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Hra extends Component {
    private final int sirkaObrazovky;
    private final int vyskaObrazovky;

    private SmerPlatformy smerPlatformy;
    private SmerLopticky smerLopticky;
    
    private final Platforma platforma;
    private final Lopticka lopticka;
    private final Tehla[][] stenaTehiel;

    private final Pocitadlo pocitadlo;
    
    private final Manazer manazer;
    private Menu menu;

    private int tikCounter;
    private boolean hraBezi;
    private boolean hraPaused;


    // Hra() vykresli zaciatocny stav hry
    public Hra() {
        //default poloha platformy + konstruktor
        Poloha defaultPolohaPlatformy = new Poloha(275, 430);
        this.platforma = new Platforma(defaultPolohaPlatformy);
        
        //default poloha lopticky + konstruktor
        Poloha defaultPolohaLopticky = new Poloha(310, 415);
        this.lopticka = new Lopticka(defaultPolohaLopticky);

        //rozlisenie obrazovky
        this.sirkaObrazovky = 640;
        this.vyskaObrazovky = 480;

        // dlzka a sirka steny
        int vyska = 7;
        int sirka = 14;

        // dlzka a sirka jednej tehly   
        int dlzkaTehly = 40;
        int vyskaTehly = 30;
        
        //generovanie tehelnej steny z random farieb
        this.stenaTehiel = new Tehla[vyska][sirka];
        for (int i = 0; i < this.stenaTehiel.length; i++) { 
            for (int j = 0; j < this.stenaTehiel[i].length; j++) {
                Random generator = new Random(); // vykreslovanie podla random farieb
                int cisloFarby = generator.nextInt(6);
                this.stenaTehiel[i][j] = new Tehla(new Poloha((j * dlzkaTehly) + 40, (i * vyskaTehly) + 30), dlzkaTehly - 1, vyskaTehly - 1);
                this.stenaTehiel[i][j].zmenCislomFarbu(cisloFarby);
            }
        }

        // pocitadlo rozbitych tehiel
        this.pocitadlo = new Pocitadlo(vyska*sirka);

        //incializacia menu a manazera
        this.menu = new StartMenu();
        this.manazer = new Manazer();
        this.manazer.spravujObjekt(this);
        this.hraPaused = false;
    }
    
    public void posunVlavo() { // trigger sipkaVlavo
        this.smerPlatformy = SmerPlatformy.VLAVO;
    }
    
    public void posunVpravo() { // trigger sipkaVpravo
        this.smerPlatformy = SmerPlatformy.VPRAVO;
    }
    
    public void tik() { //posiela sa kazde 2ms
        if (!this.hraBezi) {
            this.start();
        }

        // pohyb lopticky
        if (this.hraBezi && this.smerLopticky != null) {
            if (jeLoptickaNaObrazovke()) {
                // odraz od lavej steny
                if (this.lopticka.getLoptickaX() <= 0) {
                    //vzdy sa odrazi vlavo dole
                    if (this.smerLopticky == SmerLopticky.VLAVO_DOLU) {
                        this.zmenSmerLopticky(SmerLopticky.VPRAVO_DOLU);
                    } else {
                        this.zmenSmerLopticky(SmerLopticky.VPRAVO_HORE);
                    }

                // odraz od stropu
                } else if (this.lopticka.getLoptickaY() <= 0) {
                    //vzdy sa odrazi vlavo hore
                    if (this.smerLopticky == SmerLopticky.VLAVO_HORE) {
                        this.zmenSmerLopticky(SmerLopticky.VLAVO_DOLU);
                    } else {
                        this.zmenSmerLopticky(SmerLopticky.VPRAVO_DOLU);
                    }

                // odraz od pravej steny
                } else if (this.lopticka.getLoptickaX() >= (this.sirkaObrazovky - 10)) {
                    //vzdy sa odrazi do lava dole
                    if (this.smerLopticky == SmerLopticky.VPRAVO_HORE) {
                        this.zmenSmerLopticky(SmerLopticky.VLAVO_HORE);
                    } else {
                        this.zmenSmerLopticky(SmerLopticky.VLAVO_DOLU);
                    }

                // odraz od platformy
                } else if (this.jeKoliziaSPlatformou()) {
                    switch (this.smerLopticky) {
                        case VPRAVO_DOLU -> this.zmenSmerLopticky(SmerLopticky.VPRAVO_HORE); //ak lopticka leti z lava smerom dole
                        case VLAVO_DOLU -> this.zmenSmerLopticky(SmerLopticky.VLAVO_HORE); //ak lopticka leti z prava smerom dolu
                        default -> this.zmenSmerLopticky(this.smerLopticky);
                    }
                //ak sa nachadza na obrazovke, je odrazena platformou, tak dalej leti
                } else {
                    this.zmenSmerLopticky(this.smerLopticky);
                }

                // odraz od tehiel
                for (Tehla[] riadokTehliel : this.stenaTehiel) {
                    for (Tehla tehla : riadokTehliel) {
                        int minXvzdialenost = Math.min(Math.abs(this.lopticka.getLoptickaX() - tehla.getTehlaX()),
                                Math.abs(this.lopticka.getLoptickaX() - (tehla.getTehlaX() + tehla.getDlzka())));
                        int minYvzdialenost = Math.min(Math.abs(this.lopticka.getLoptickaY() - tehla.getTehlaY()),
                                Math.abs(this.lopticka.getLoptickaY() - (tehla.getTehlaY() + tehla.getVyska())));

                        if (minXvzdialenost <= 15 && minYvzdialenost <= 15) {
                            switch (this.smerLopticky) {
                                case VLAVO_HORE, VPRAVO_DOLU -> {
                                    tehla.zmenFarbu("black");
                                    this.pocitadlo.updateSkore();
                                    tehla.setPoloha(0,0);
                                    this.zmenSmerLopticky(SmerLopticky.VLAVO_DOLU);
                                }
                                case VPRAVO_HORE, VLAVO_DOLU -> {
                                    tehla.zmenFarbu("black");
                                    this.pocitadlo.updateSkore();
                                    tehla.setPoloha(0,0);
                                    this.zmenSmerLopticky(SmerLopticky.VPRAVO_DOLU);
                                }
                            }
                        }
                    }
                }
            // lopticka sa zastavi ak prekroci obrazovku, hra tiez
            } else if (this.hraBezi) { 
                this.hraBezi = false;
                this.menu = new EndMenu(this.pocitadlo.getSkore(), this.pocitadlo.getCelkoveSkore());
            }
        }
    }

    public void tak() {
        // pohyb platformy
        if (this.hraBezi && this.smerPlatformy != null) {
            if (this.platforma.getPlatformaX() < 0) { // ak narazi do lavej steny
                this.zmenSmerPlatformy(SmerPlatformy.VPRAVO);
            } else if (this.platforma.getPlatformaX() > 570) { // ak narazi do pravej steny
                this.zmenSmerPlatformy(SmerPlatformy.VLAVO);
            } else {
                this.zmenSmerPlatformy(this.smerPlatformy);
            }
        }
    }

    public void start() { // metoda ktorou spustis hru, lopticka ide vlavo hore
        if (this.menu == null) {
            this.menu = new StartMenu();
        }

        if (this.menu.getZapniHru()) {
            this.menu.skry();
            if (!this.hraBezi) {
                this.hraBezi = true;
                this.zmenSmerLopticky(SmerLopticky.VLAVO_HORE);
            }

        } else {
            this.menu.zobraz();
        }
    }

    public void zrus() { // pause trigger ESC Key
        if (this.hraBezi) {
            this.hraBezi = false;
            this.hraPaused = true;
            this.menu = new PauseMenu(this.pocitadlo.getSkore(), this.pocitadlo.getCelkoveSkore());
            this.menu.zobraz();
        }
    }

    public void aktivuj() { //unpause trigger Space Key
        if (this.hraPaused) {
            this.menu.skry();
            this.hraPaused = false;
            this.hraBezi = true;
        }
    }

    public void vyberSuradnice(int x, int y) { // myska kliknutim vyberie suradnice
        if (!this.hraBezi) {
            this.menu.vyberSuradnice(x, y); // TODO: zistit kde je problem s dvojtym zavolanim vyberSuradnice()
        }
    }

    private void zmenSmerLopticky(SmerLopticky novySmer) {
        this.smerLopticky = novySmer;
        this.lopticka.pohniNaNovuPoziciu(this.smerLopticky);
    }

    private void zmenSmerPlatformy(SmerPlatformy novySmer) {
        this.smerPlatformy = novySmer;
        this.platforma.pohniNaNovuPoziciu(this.smerPlatformy);
    }

    private boolean jeKoliziaSPlatformou() {
        return (this.lopticka.getLoptickaY() >= 415 && this.lopticka.getLoptickaY() <= 430 )
                && (this.lopticka.getLoptickaX() >= this.platforma.getPlatformaX())
                && (this.lopticka.getLoptickaX() <= this.platforma.getPlatformaX() + Platforma.DLZKA);
    }

    private boolean jeLoptickaNaObrazovke() { // rozlisenie 640 x 480
        return (this.lopticka.getLoptickaX() <= (this.sirkaObrazovky - 10)) && (this.lopticka.getLoptickaX() >= 0)
                && (this.lopticka.getLoptickaY() <= (this.vyskaObrazovky - 10)) && (this.lopticka.getLoptickaY() >= 0);
    }
}
