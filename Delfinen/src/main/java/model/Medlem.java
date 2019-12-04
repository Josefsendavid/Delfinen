package model;

public class Medlem {
   int alder;
   int CPR;
   int medlemsID;
   double svømmeresultat;
   String diciplin;
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
    
    public Medlem(int medlemsID, String aldersgruppe, String diciplin, double svømmeresultat) {
        this.medlemsID = medlemsID;
        this.aldersgruppe = aldersgruppe;
        this.diciplin = diciplin;
        this.svømmeresultat = svømmeresultat;
    }

    public int getMedlemsID() {
        return medlemsID;
    }

    public void setMedlemsID(int medlemsID) {
        this.medlemsID = medlemsID;
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

    @Override
    public String toString() {
        return "Medlem: " + "alder=" + alder + ", CPR=" + CPR + ", aldersgruppe=" + aldersgruppe + ", navn=" + navn + ", svømmeniveau=" + svømmeniveau + ", aktivtmedlemsskab=" + aktivtmedlemsskab;
    }
    
}