package model;

public class Medlem {
   int alder;
   int CPR;
   String aldersgruppe;
   String navn;
   String svømmeniveau;
   boolean aktivtmedlemsskab;

    public Medlem(int CPR, String navn, int alder, String aldersgruppe, String svømmeniveau, Boolean /*String*/ aktivtmedlemsskab) {
        this.alder = alder;
        this.CPR = CPR;
        this.aldersgruppe = aldersgruppe;
        this.navn = navn;
        this.svømmeniveau = svømmeniveau;
        //setAktivtmedlemsskab()
        this.aktivtmedlemsskab = aktivtmedlemsskab;
    }

    public String getAldersgruppe() {
        return aldersgruppe;
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

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getSvømmeniveau() {
        return svømmeniveau;
    }

    public void setSvømmeniveau(String svømmeniveau) {
        this.svømmeniveau = svømmeniveau;
    }

    public boolean isAktivtmedlemsskab() {
        return aktivtmedlemsskab;
    }

    public void setAktivtmedlemsskab(boolean aktivtmedlemsskab) {
        this.aktivtmedlemsskab = aktivtmedlemsskab;
    }
    public void setAktivtmedlemsskab(String aktivtmedlemsskab) {
        boolean res = false;
        if(aktivtmedlemsskab.toLowerCase().equals("ja"))
            res = true;
        this.aktivtmedlemsskab = res;
    }
    
}