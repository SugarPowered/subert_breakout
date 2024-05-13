import java.util.Random;
import fri.shapesge.Manazer;

public class Hra {
    private int sirkaObrazovky;
    private int vyskaObrazovky;

    private Smer smer; // Smer Platformy
    private SmerLopticky smerLopticky;
    private Poloha poloha; 
    
    private Platforma platforma;
    private Lopticka lopticka;
    private Tehla tehla;
    private BlackScreen blackScreen;
    private Tehla[][] stenaTehiel;
    private int pocetTehiel;
    
    private Manazer manazer;
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
        this.pocetTehiel = vyska * sirka;
        
        // dlzka a sirka jednej tehly   
        int dlzkaTehly = 40;
        int vyskaTehly = 30;
        
        //vykreslovanie tehliciek
        this.stenaTehiel = new Tehla[vyska][sirka];
        
        //generovanie tehelnej steny z random farieb
        for (int i = 0; i < this.stenaTehiel.length; i++) { 
            for (int j = 0; j < this.stenaTehiel[i].length; j++) {
                Random generator = new Random(); // vykreslovanie podla random farieb
                int cisloFarby = generator.nextInt(6);
                this.stenaTehiel[i][j] = new Tehla(new Poloha((j * dlzkaTehly) + 40, (i * vyskaTehly) + 30), dlzkaTehly - 1, vyskaTehly - 1);
                this.stenaTehiel[i][j].zmenCislomFarbu(cisloFarby);
            }
        }
        
        this.menu = new StartMenu();
        this.manazer = new Manazer();
        this.manazer.spravujObjekt(this);
        this.hraPaused = false;
    }
    
    public void posunVlavo() { // trigger sipkaVlavo
        this.smer = Smer.VLAVO;
    }
    
    public void posunVpravo() { // trigger sipkaVpravo
        this.smer = Smer.VPRAVO;
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
                        this.smerLopticky = SmerLopticky.VPRAVO_DOLU;
                        this.lopticka.pohniNaNovuPoziciu(this.smerLopticky);
                    } else {
                        this.smerLopticky = SmerLopticky.VPRAVO_HORE;
                        this.lopticka.pohniNaNovuPoziciu(this.smerLopticky);
                    }
                    
                // odraz od stropu
                } else if (this.lopticka.getLoptickaY() <= 0) {  
                    //vzdy sa odrazi vlavo hore
                    if (this.smerLopticky == SmerLopticky.VLAVO_HORE) {
                        this.smerLopticky = SmerLopticky.VLAVO_DOLU;
                        this.lopticka.pohniNaNovuPoziciu(this.smerLopticky);
                    } else {
                        this.smerLopticky = SmerLopticky.VPRAVO_DOLU;
                        this.lopticka.pohniNaNovuPoziciu(this.smerLopticky);
                    }
                    
                // odraz od pravej steny
                } else if (this.lopticka.getLoptickaX() >= (this.sirkaObrazovky - 10)) {
                    //vzdy sa odrazi do lava dole
                    if (this.smerLopticky == SmerLopticky.VPRAVO_HORE) {
                        this.smerLopticky = SmerLopticky.VLAVO_HORE;
                        this.lopticka.pohniNaNovuPoziciu(this.smerLopticky);
                    } else {
                        this.smerLopticky = SmerLopticky.VLAVO_DOLU;
                        this.lopticka.pohniNaNovuPoziciu(this.smerLopticky);
                    }
                    
                // odraz od platformy    
                } else if ((this.lopticka.getLoptickaY() >= 415 && this.lopticka.getLoptickaY() <= 430 )
                        && (this.lopticka.getLoptickaX() >= this.platforma.getPlatformaX()) 
                            && (this.lopticka.getLoptickaX() <= this.platforma.getPlatformaX() + this.platforma.DLZKA)) {
                    //ak lopticka leti z lava smerom dole
                    if (this.smerLopticky == SmerLopticky.VPRAVO_DOLU) {
                        this.smerLopticky = SmerLopticky.VPRAVO_HORE;
                        this.lopticka.pohniNaNovuPoziciu(this.smerLopticky);
                    //ak lopticka leti z prava smerom dolu
                    } else if (this.smerLopticky == SmerLopticky.VLAVO_DOLU) {
                        this.smerLopticky = SmerLopticky.VLAVO_HORE;
                        this.lopticka.pohniNaNovuPoziciu(this.smerLopticky);
                    //ak z toho nic neplati, lopticka leti dalej
                    } else {
                        this.lopticka.pohniNaNovuPoziciu(this.smerLopticky);
                    }
                    
                //ak sa nachadza na obrazovke, je odrazena platformou, tak dalej leti
                } else {
                    this.lopticka.pohniNaNovuPoziciu(this.smerLopticky);
                }
                
                // odraz od kociek
                for (int i = 0; i < this.stenaTehiel.length; i++) { 
                    for (int j = 0; j < this.stenaTehiel[i].length; j++) {
                        // ab. hodnota rozdielu x suradnice lopticky a lavej hornej suradnice tehly
                        int rozdielLHX = Math.abs(this.lopticka.getLoptickaX() - this.stenaTehiel[i][j].getTehlaX());
                        // ab. hodnota rozdielu x suradnice lopticky a pravej hornej suradnice tehly
                        int rozdielPHX = Math.abs(this.lopticka.getLoptickaX() - (this.stenaTehiel[i][j].getTehlaX() + this.stenaTehiel[i][j].getDlzka()));
                        // ab. hodnota rozdielu y suradnice lopticky a y suradnice tehly
                        int rozdielLHY = Math.abs(this.lopticka.getLoptickaY() - this.stenaTehiel[i][j].getTehlaY());
                        // ab. hodnota rozdielu y suradnice lopticky a y suradnice tehly
                        int rozdielLDY = Math.abs(this.lopticka.getLoptickaY() - (this.stenaTehiel[i][j].getTehlaY() + this.stenaTehiel[i][j].getVyska()));
                        
                        if (rozdielLHX >= 15 && rozdielPHX <= 15 && rozdielLHY >= 15 && rozdielLDY <= 15) {
                            if (this.smerLopticky == SmerLopticky.VLAVO_HORE ) {
                                this.stenaTehiel[i][j].zmenFarbu("black");                                
                                this.stenaTehiel[i][j].setTehlaX(0);
                                this.stenaTehiel[i][j].setTehlaY(0);
                                this.smerLopticky = SmerLopticky.VLAVO_DOLU;
                                this.lopticka.pohniNaNovuPoziciu(this.smerLopticky);
                            } else if (this.smerLopticky == SmerLopticky.VPRAVO_HORE) {
                                this.stenaTehiel[i][j].zmenFarbu("black");
                                this.stenaTehiel[i][j].setTehlaX(0);
                                this.stenaTehiel[i][j].setTehlaY(0);
                                this.smerLopticky = SmerLopticky.VPRAVO_DOLU;
                                this.lopticka.pohniNaNovuPoziciu(this.smerLopticky);
                            } else if (this.smerLopticky == SmerLopticky.VLAVO_DOLU) {
                                this.stenaTehiel[i][j].zmenFarbu("black");
                                this.stenaTehiel[i][j].setTehlaX(0);
                                this.stenaTehiel[i][j].setTehlaY(0);
                                this.smerLopticky =  SmerLopticky.VPRAVO_DOLU;
                                this.lopticka.pohniNaNovuPoziciu(this.smerLopticky);
                            }  else if (this.smerLopticky == SmerLopticky.VPRAVO_DOLU) {
                                this.stenaTehiel[i][j].zmenFarbu("black");
                                this.stenaTehiel[i][j].setTehlaX(0);
                                this.stenaTehiel[i][j].setTehlaY(0);
                                this.smerLopticky = SmerLopticky.VLAVO_DOLU;
                                this.lopticka.pohniNaNovuPoziciu(this.smerLopticky);
                            }  else {
                                this.lopticka.pohniNaNovuPoziciu(this.smerLopticky);
                            }
                        }
                    }
                }
            // lopticka sa zastavi ak prekroci obrazovku, hra tiez    
            } else if (this.hraBezi) { 
                this.hraBezi = false;
                this.blackScreen = new BlackScreen("prehra");
                this.blackScreen.zobraz();
            }
        }
    }
    
    public void tak() {
        if (!this.hraBezi) {
            this.start();
        }
        
        // pohyb platformy
        if (this.hraBezi && this.smer != null) {
            if (this.platforma.getPlatformaX() < 0) { // ak narazi do lavej steny
                this.smer = Smer.VPRAVO;
                this.platforma.pohniNaNovuPoziciu(this.smer);
            } else if (this.platforma.getPlatformaX() > 570) { // ak narazi do pravej steny
                this.smer =  Smer.VLAVO;
                this.platforma.pohniNaNovuPoziciu(this.smer);
            } else {
                this.platforma.pohniNaNovuPoziciu(this.smer); //ak sa volne hybe
            }
        }
    }
    
    public void start() { // metoda ktorou spustis hru, lopticka ide vlavo hore
        if (this.menu == null) {
            this.menu = new StartMenu();
        }

        if (this.menu.getZapniHru()) {
            if (this.menu.getZapniHru()) {
                this.menu.skry();
                if (!this.hraBezi) {
                    this.hraBezi = true;
                    this.smerLopticky = SmerLopticky.VLAVO_HORE;
                    this.lopticka.pohniNaNovuPoziciu(this.smerLopticky);
                }
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
            this.hraPaused = false;
            this.blackScreen.skry();
        }
    }
}
