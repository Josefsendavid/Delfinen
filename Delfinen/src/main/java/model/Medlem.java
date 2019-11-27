
package model;

public class Medlem {
   int alder;
   int CPR;
   int medlemsskab;
   String navn;
   String hold;
   String aktivitetsform;

    public Medlem(int alder, int CPR, int medlemsskab, String navn, String hold, String aktivitetsform) {
        this.alder = alder;
        this.CPR = CPR;
        this.medlemsskab = medlemsskab;
        this.navn = navn;
        this.hold = hold;
        this.aktivitetsform = aktivitetsform;
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public int getCPR() {
        return CPR;
    }

    public void setCPR(int CPR) {
        this.CPR = CPR;
    }

    public int getMedlemsskab() {
        return medlemsskab;
    }

    public void setMedlemsskab(int medlemsskab) {
        this.medlemsskab = medlemsskab;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getHold() {
        return hold;
    }

    public void setHold(String hold) {
        this.hold = hold;
    }

    public String getAktivitetsform() {
        return aktivitetsform;
    }

    public void setAktivitetsform(String aktivitetsform) {
        this.aktivitetsform = aktivitetsform;
    }
   
}
