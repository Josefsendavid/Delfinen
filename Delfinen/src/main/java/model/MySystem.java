package model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MySystem {
    Scanner scan = new Scanner(System.in);
    
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
                    opretMedlem();
                } else if (input == 2) {
                    System.out.println("Du valgte menupunkt 2");
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
    
    
    
    public void opretMedlem() {
        ArrayList<Medlem> medlemmer = new ArrayList();
        
        
    }
}
