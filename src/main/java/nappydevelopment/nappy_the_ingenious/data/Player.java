package nappydevelopment.nappy_the_ingenious.data;

/**
 * Created by Marc on 04.04.2016.
 */
public class Player {

    private String anzeigeName;
    private int gesamtPunktzahl;
    private int fragen_nappy;
    private int fragen_spieler;


    public Player(String anzeigename, int fragen_nappy, int fragen_spieler, int gesamtpunktzahl) {
        this.anzeigeName = anzeigename;
        this.fragen_nappy = fragen_nappy;
        this.fragen_spieler = fragen_spieler;
        this.gesamtPunktzahl = gesamtpunktzahl;
    }

    public String getAnzeigeName() {
        return anzeigeName;
    }

    public void setAnzeigeName(String anzeigeName) {
        anzeigeName = anzeigeName;
    }

    public int getFragen_nappy() {
        return fragen_nappy;
    }

    public void setFragen_nappy(int fragen_nappy) {
        this.fragen_nappy = fragen_nappy;
    }

    public int getFragen_spieler() {
        return fragen_spieler;
    }

    public void setFragen_spieler(int fragen_spieler) {
        this.fragen_spieler = fragen_spieler;
    }

    public int getGesamtPunktzahl() {
        return gesamtPunktzahl;
    }

    public void setGesamtPunktzahl(int gesamtPunktzahl) {
        this.gesamtPunktzahl = gesamtPunktzahl;
    }

}
