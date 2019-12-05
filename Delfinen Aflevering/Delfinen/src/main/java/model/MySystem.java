package model;

import datasource.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MySystem {

    private Scanner scan = new Scanner(System.in);
    private Kontingent kon;
    private Datasource db;
    private MedlemsResultater medlemsResultat;

    public MySystem(Datasource datasource) {
        db = datasource;
    }

    public void runDelfinen() {

        int input = 0;
        try {
            while (input < 5) {
                System.out.println("1 = Opret medlem");
                System.out.println("2 = Vis medlemmer");
                System.out.println("3 = Resultater");
                System.out.println("4 = Søg på medlem");
                System.out.println("5 = Afslut og gem");
                input = scan.nextInt();

                if (input == 1) {
                    nytMedlem();
                } else if (input == 2) {
                    seMedlemmer();
                } else if (input == 3) {
                    resultater();
                } else if (input == 4) {
                    findMedlem();
                } else if (input == 5) {
                    System.out.println("Du valgte at afslutte og gemme");
                }
            }
        } catch (InputMismatchException ex) {

            System.out.println("Dette er ikke et gyldigt heltal\n" + ex);

        }
    }

    public String nytMedlem() {
        int cpr, alder;
        String navn, svømmeniveau, aldersgruppe;
        boolean aktivtMedlemsskab;
        System.out.println("Indtast CPR-nummer: ");
        cpr = scan.nextInt();

        System.out.println("Indtast navn: ");
        navn = scan.next();

        System.out.println("Indtast alder: ");
        alder = scan.nextInt();

        System.out.println("Indtast aldersgruppe");
        aldersgruppe = scan.next();

        System.out.println("Indtast svømmeniveau(Motionist eller konkurrencesvømmer): ");
        svømmeniveau = scan.next();

        System.out.println("Skriv True for aktivt, skriv False for inaktivt: ");
        aktivtMedlemsskab = scan.nextBoolean();

        Medlem medlem = new Medlem(cpr, navn, alder, aldersgruppe, svømmeniveau, aktivtMedlemsskab);
        db.indsætMedlem(medlem);
        return "";
    }

    public void seMedlemmer() {
        int input = 0;

        while (input < 4) {
            System.out.println("1 = Alle medlemmer");
            System.out.println("2 = Top 5 svømmere");
            System.out.println("3 = Fjern medlem");
            System.out.println("4 = Tilbage");
            input = scan.nextInt();
            if (input == 1) {
                ArrayList<Medlem> medlemsListe = db.getMedlemmer();
                for (Medlem medlem : medlemsListe) {
                    System.out.print(medlem);
                    System.out.println(", Kontingent = " + kon.kontingentBetaling(medlem));
                }
            } else if (input == 2) {
                ArrayList<MedlemsResultater> medlemsListe = db.getTop5();
                for (MedlemsResultater medlem : medlemsListe) {
                    System.out.println(medlem);
                }
            } else if (input == 3) {
                System.out.println("Indtast CPR for at slette: ");
                int CPR = scan.nextInt();

                db.fjernMedlem(CPR);
            }
        }
    }

    public void findMedlem() {
        System.out.println("Indtast CPR: ");
        int CPR = scan.nextInt();
        ArrayList<Medlem> medlemsListe = db.findMedlem(CPR);
        for (Medlem medlem : medlemsListe) {
            System.out.println(medlem);
        }
    }

    public void resultater() {
        int input = 0;
        while (input <= 3) {
            System.out.println("1 = Tjek resultater");
            System.out.println("2 = Indsæt resultater");
            System.out.println("3 = Opdater resultater");
            System.out.println("4 = Gå tilbage");
            input = scan.nextInt();
            if (input == 1) {
                ArrayList<MedlemsResultater> medlemsListe = db.seResultater();
                for (MedlemsResultater medlemsResultater : medlemsListe) {
                    System.out.println(medlemsResultater);
                }
            } else if (input == 2) {
                int placering, dato, medlemsCPR;
                double svømmeresultat;
                String diciplin, konkurrence, stævne, navn;
                System.out.println("Indtast medlemsCPR: ");
                medlemsCPR = scan.nextInt();

                System.out.println("Indtast navn: ");
                navn = scan.next();

                System.out.println("Indtast diciplin: ");
                diciplin = scan.next();

                System.out.println("Indtast placering: ");
                placering = scan.nextInt();

                System.out.println("Indtast svømmeresultat: ");
                svømmeresultat = scan.nextDouble();

                System.out.println("Indtast dato: ");
                dato = scan.nextInt();

                System.out.println("Er det konkurrenceresultat: ");
                konkurrence = scan.next();

                System.out.println("Stævne: ");
                stævne = scan.next();

                medlemsResultat = new MedlemsResultater(medlemsCPR, navn, dato, placering, diciplin, svømmeresultat, konkurrence, stævne);
                db.indsætResultat(medlemsResultat);

            } else if (input == 3) {
                System.out.println("Indtast CPR for medlemmet: ");
                int cpr = scan.nextInt();

                System.out.println("Indtast nyt resultat: ");
                double resultat = scan.nextDouble();

                db.opdaterResultat(cpr, resultat);
            }

        }
    }
}
