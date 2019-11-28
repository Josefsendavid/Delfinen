package model;

import datasource.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySystem {

    private Scanner scan = new Scanner(System.in);
    private DBMapper db = new DBMapper();
    private Statement stmt;
    private Connection conn;

    public void runDelfinen() {

        int input = 0;
        try {
            while (input < 4) {
                System.out.println("1 = Opret medlem");
                System.out.println("2 = Vis medlemmer");
                System.out.println("3 = Søg på medlem");
                System.out.println("4 = Afslut og gem");
                input = scan.nextInt();

                if (input == 1) {
                    nytMedlem();
                } else if (input == 2) {
                    System.out.println("Du valgte menupunkt 2");
                    db.getMedlemmer();
                } else if (input == 3) {
                    System.out.println("Du valgte menupunkt 3");
                } else if (input == 4) {
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

        Medlem member = new Medlem(cpr, navn, alder, aldersgruppe, svømmeniveau, aktivtMedlemsskab);
        db.indsætMedlem(member);
        return "";
    }
}
