package nappydevelopment.nappy_the_ingenious.data;

/**
 * Created by Marc on 04.04.2016.
 */
public class Spieler {

    private String anzeigeName;
    private int gesamtPunktzahl;


    Spieler(String anzeigename, int gesamtpunktzahl) {
        this.anzeigeName = anzeigename;
        this.gesamtPunktzahl = gesamtpunktzahl;
    }

    public String getAnzeigeName() {
        return anzeigeName;
    }

    public void setAnzeigeName(String anzeigeName) {
        anzeigeName = anzeigeName;
    }

    public int getGesamtpunktzahl() {
        return gesamtPunktzahl;
    }

    public void setGesamtpunktzahl(int gesamtpunktzahl) {
        gesamtPunktzahl = gesamtpunktzahl;
    }
}
