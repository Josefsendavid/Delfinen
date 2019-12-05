package model;

public class MedlemsResultater {

    int medlemsCPR;
    int dato;
    int placering;
    double svømmeresultat;
    String diciplin;
    String navn;
    String konkurrence;
    String stævne;

    public MedlemsResultater(int medlemsCPR, String navn, int dato, int placering, String diciplin, double svømmeresultat, String konkurrence, String stævne) {
        this.medlemsCPR = medlemsCPR;
        this.navn = navn;
        this.dato = dato;
        this.placering = placering;
        this.diciplin = diciplin;
        this.svømmeresultat = svømmeresultat;
        this.konkurrence = konkurrence;
        this.stævne = stævne;
    }

    public int getMedlemsCPR() {
        return medlemsCPR;
    }

    public void setMedlemsCPR(int medlemsCPR) {
        this.medlemsCPR = medlemsCPR;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public int getPlacering() {
        return placering;
    }

    public void setPlacering(int placering) {
        this.placering = placering;
    }

    public String getDiciplin() {
        return diciplin;
    }

    public void setDiciplin(String diciplin) {
        this.diciplin = diciplin;
    }

    public double getSvømmeresultat() {
        return svømmeresultat;
    }

    public void setSvømmeresultat(double svømmeresultat) {
        this.svømmeresultat = svømmeresultat;
    }

    public String getKonkurrence() {
        return konkurrence;
    }

    public void setKonkurrence(String konkurrence) {
        this.konkurrence = konkurrence;
    }

    public String getStævne() {
        return stævne;
    }

    public void setStævne(String stævne) {
        this.stævne = stævne;
    }

    @Override
    public String toString() {
        return "MedlemsResultater:\n" + "medlemsCPR=" + medlemsCPR + ", navn=" + navn + ", dato=" + dato + ", placering=" + placering + ", diciplin=" + diciplin + ", svømmeresultat=" + svømmeresultat + ", konkurrence=" + konkurrence + ", stævne=" + stævne + "\n";
    }

}
