import java.util.Random;
import fri.shapesge.Manazer;
import fri.shapesge.TextBlock;
import gui.BlackScreen;
import gui.EndMenu;
import gui.Menu;
import gui.StartMenu;

/**
 * Write a description of class Menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Hra {
    private final int sirkaObrazovky;
    private final int vyskaObrazovky;

    private SmerPlatformy smerPlatformy; // Smer Platformy
    private SmerLopticky smerLopticky;
    
    private final Platforma platforma;
    private final Lopticka lopticka;
    private Tehla tehla;
    private BlackScreen blackScreen;
    private final Tehla[][] stenaTehiel;
    private int pocetTehiel;
    
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
        this.pocetTehiel = vyska * sirka;
        int celkovyPocetTehiel = vyska * sirka;
        TextBlock pocitadlo = new TextBlock(this.pocetTehiel + "/" + celkovyPocetTehiel, 600, 20);
        pocitadlo.changeColor("white");
        pocitadlo.makeVisible();

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
            // je lopticka na obrazovke? 640 x 480
            if ((this.lopticka.getLoptickaX() <= (this.sirkaObrazovky - 10)) && (this.lopticka.getLoptickaX() >= 0)
                && (this.lopticka.getLoptickaY() <= (this.vyskaObrazovky - 10)) && (this.lopticka.getLoptickaY() >= 0)) {
                
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
                } else if ((this.lopticka.getLoptickaY() >= 415 && this.lopticka.getLoptickaY() <= 430 )
                        && (this.lopticka.getLoptickaX() >= this.platforma.getPlatformaX())
                            && (this.lopticka.getLoptickaX() <= this.platforma.getPlatformaX() + Platforma.DLZKA)) {
                    //ak lopticka leti z lava smerom dole
                    if (this.smerLopticky == SmerLopticky.VPRAVO_DOLU) {
                        this.zmenSmerLopticky(SmerLopticky.VPRAVO_HORE);
                    //ak lopticka leti z prava smerom dolu
                    } else if (this.smerLopticky == SmerLopticky.VLAVO_DOLU) {
                        this.zmenSmerLopticky(SmerLopticky.VLAVO_HORE);
                    //ak z toho nic neplati, lopticka leti dalej
                    } else {
                        this.lopticka.pohniNaNovuPoziciu(this.smerLopticky);
                    }
                //ak sa nachadza na obrazovke, je odrazena platformou, tak dalej leti
                } else {
                    this.lopticka.pohniNaNovuPoziciu(this.smerLopticky);
                }

                // odraz od tehiel
                for (Tehla[] riadokTehliel : this.stenaTehiel) {
                    for (Tehla tehla : riadokTehliel) {
                        // ab. hodnota rozdielu x suradnice lopticky a lavej hornej suradnice tehly
                        int rozdielLHX = Math.abs(this.lopticka.getLoptickaX() - tehla.getTehlaX());
                        // ab. hodnota rozdielu x suradnice lopticky a pravej hornej suradnice tehly
                        int rozdielPHX = Math.abs(this.lopticka.getLoptickaX() - (tehla.getTehlaX() + tehla.getDlzka()));
                        // ab. hodnota rozdielu y suradnice lopticky a y suradnice tehly
                        int rozdielLHY = Math.abs(this.lopticka.getLoptickaY() - tehla.getTehlaY());
                        // ab. hodnota rozdielu y suradnice lopticky a y suradnice tehly
                        int rozdielLDY = Math.abs(this.lopticka.getLoptickaY() - (tehla.getTehlaY() + tehla.getVyska()));

                        if (rozdielLHX >= 12 && rozdielPHX <= 12 && rozdielLHY >= 12 && rozdielLDY <= 12) {
                            switch (this.smerLopticky) {
                                case VLAVO_HORE, VPRAVO_DOLU -> {
                                    tehla.zmenFarbu("black");
                                    this.pocetTehiel--;
                                    tehla.setPoloha(0,0);
                                    this.zmenSmerLopticky(SmerLopticky.VLAVO_DOLU);
                                }
                                case VPRAVO_HORE, VLAVO_DOLU -> {
                                    tehla.zmenFarbu("black");
                                    this.pocetTehiel--;
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
                this.menu = new EndMenu();

                if (this.menu.getRestartuj()) {
                    this.hraBezi = true;
                }
            }
        }
    }

    private void zmenSmerLopticky(SmerLopticky novySmer) {
        this.smerLopticky = novySmer;
        this.lopticka.pohniNaNovuPoziciu(this.smerLopticky);
    }

    public void tak() {
        if (!this.hraBezi) {
            this.start();
        }
        
        // pohyb platformy
        if (this.hraBezi && this.smerPlatformy != null) {
            if (this.platforma.getPlatformaX() < 0) { // ak narazi do lavej steny
                this.smerPlatformy = SmerPlatformy.VPRAVO;
                this.platforma.pohniNaNovuPoziciu(this.smerPlatformy);
            } else if (this.platforma.getPlatformaX() > 570) { // ak narazi do pravej steny
                this.smerPlatformy =  SmerPlatformy.VLAVO;
                this.platforma.pohniNaNovuPoziciu(this.smerPlatformy);
            } else {
                this.platforma.pohniNaNovuPoziciu(this.smerPlatformy); //ak sa volne hybe
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
                this.smerLopticky = SmerLopticky.VLAVO_HORE;
                this.lopticka.pohniNaNovuPoziciu(this.smerLopticky);
            }
        } else {
            this.menu.zobraz();
        }
    }

    public void zrus() { // pause trigger ESC Key
        if (this.hraBezi) {
            this.hraBezi = false;
            this.hraPaused = true;
            this.blackScreen = new BlackScreen("pauza");
            this.blackScreen.zobraz();
        }
    }

    public void aktivuj() { //unpause trigger Space Key
        if (this.hraPaused) {
            this.hraBezi = true;
            this.blackScreen.skry();
        }
    }

    public void vyberSuradnice(int x, int y) { // myska kliknutim vyberie suradnice
        if (!this.hraBezi) {
            this.menu.vyberSuradnice(x, y);
            if (this.menu.getZapniHru()) {
                this.start();
                this.hraBezi = true;
            }

            if (this.menu.getRestartuj()) {
                this.hraBezi = true;
                this.menu.skry();
            }
        }
    }
}
