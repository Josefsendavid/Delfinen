package model;

import datasource.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MySystem {

    private Scanner scan = new Scanner(System.in);
    private DBMapper db = new DBMapper();
    private Kontingent kon = new Kontingent();

    public void runDelfinen() {

        int input = 0;
        try {
            while (input < 4) {
                System.out.println("1 = Opret medlem");
                System.out.println("2 = Vis medlemmer");
                System.out.println("3 = Opdater resultater");
                System.out.println("4 = Søg på medlem");
                System.out.println("5 = Afslut og gem");
                input = scan.nextInt();

                if (input == 1) {
                    nytMedlem();
                } else if (input == 2) {
                    seMedlemmer();
                } else if (input == 3) {
                    opdaterResultater();
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
                    System.out.println(", Kontingent = " + kon.erDetBetalt(medlem));
                }
            } else if (input == 2) {
                ArrayList<Medlem> medlemsListe = db.getTop5();
                for (Medlem medlem : medlemsListe) {
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
        System.out.println(medlemsListe);
    }

    public void opdaterResultater() {
        int input = 0;
        while (input <= 2) {
            System.out.println("1 = Tjek resultater");
            System.out.println("2 = Rediger resultater");
            System.out.println("3 = Gå tilbage");
            input = scan.nextInt();
            if (input == 1) {
                System.out.println("Du valgte at tjekke resultater");
                db.seResultater();
            } else if (input == 2) {
                int medlemsID;
                double svømmeresultat;
                String diciplin, aldersgruppe;
                System.out.println("Indtast medlemsID: ");
                medlemsID = scan.nextInt();

                System.out.println("Indtast aldersgruppe: ");
                aldersgruppe = scan.next();

                System.out.println("Indtast diciplin: ");
                diciplin = scan.next();

                System.out.println("Indtast svømmeresultat: ");
                svømmeresultat = scan.nextDouble();
                Medlem medlem = new Medlem(medlemsID, aldersgruppe, diciplin, svømmeresultat);
                db.indsætResultat(medlem);

            }

        }
    }
}
