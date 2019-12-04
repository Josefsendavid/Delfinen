package model;

public class Kontingent {
    //Medlem medlem = new Medlem();

    
    
    public int erDetBetalt(Medlem medlem) {
      //ArrayList<Medlem> medlemmer = new ArrayList();
      int betaling = 0;
      int under18 = 1000;
      int over18 = 1600;  
      int passivtMedlemsskab = 500;
      int over60 = (1600 / 100) * 75;
      
      if (medlem.getAlder() < 18 && medlem.isAktivtmedlemsskab() == true) {
          betaling += under18;
          //System.out.println("Personen skylder: " + under18);
      } else if (medlem.getAlder() >= 18 && medlem.getAlder() < 60 && medlem.isAktivtmedlemsskab() == true) {
          betaling += over18;
          //System.out.println("Personen skylder: " + over18);
      } else if (medlem.getAlder() >= 60 && medlem.isAktivtmedlemsskab() == true) {
          betaling += over60;
          //System.out.println("Personen skylder: " + over60);
      } else if (medlem.isAktivtmedlemsskab() == false) {
          betaling+= passivtMedlemsskab;
          //System.out.println("Personen skylder: " + passivtMedlemsskab);
      }
      
        return betaling;
    } 
}


