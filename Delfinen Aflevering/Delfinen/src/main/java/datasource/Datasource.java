package datasource;

import java.util.ArrayList;
import model.Medlem;
import model.MedlemsResultater;

public interface Datasource {

    public ArrayList<Medlem> getMedlemmer();

    public ArrayList<MedlemsResultater> getTop5();

    public ArrayList<Medlem> findMedlem(int cpr);

    public void indsætMedlem(Medlem medlem);

    public void fjernMedlem(int cpr);

    public void indsætResultat(MedlemsResultater medlem);

    public ArrayList<MedlemsResultater> seResultater();

    public void opdaterResultat(int cpr, double resultat);
}
