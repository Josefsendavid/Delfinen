package model;

public class Kontingent {

    public int kontingentBetaling(Medlem medlem) {
        int betaling = 0;
        int under18 = 1000;
        int over18 = 1600;
        int passivtMedlemsskab = 500;
        int over60 = (over18 / 100) * 75;

        if (medlem.getAlder() < 18 && medlem.isAktivtmedlemsskab() == true) {
            betaling += under18;
        } else if (medlem.getAlder() >= 18 && medlem.getAlder() < 60 && medlem.isAktivtmedlemsskab() == true) {
            betaling += over18;
        } else if (medlem.getAlder() >= 60 && medlem.isAktivtmedlemsskab() == true) {
            betaling += over60;
        } else if (medlem.isAktivtmedlemsskab() == false) {
            betaling += passivtMedlemsskab;
        }

        return betaling;
    }
}
