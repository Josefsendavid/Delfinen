package datasource;

import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBMapper implements Datasource {

    private Connection con = null;
    private MedlemsResultater medlemsResultat;
    private Medlem medlem;
    private Statement stmt;

    public ArrayList<Medlem> getMedlemmer() {
        ArrayList<Medlem> medlemmer = new ArrayList();
        try {

            con = DatabaseConnector.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT cpr, navn, alder, aldersgruppe, svømmeniveau, aktivtmedlemsskab FROM delfinen.medlemmer ORDER BY alder DESC");

            while (rs.next()) {

                int cpr = rs.getInt("cpr");
                String navn = rs.getString("navn");
                int alder = rs.getInt("alder");
                String aldersgruppe = rs.getString("aldersgruppe");
                String svømmeniveau = rs.getString("svømmeniveau");
                boolean aktivtMedlemsskab = rs.getBoolean("aktivtmedlemsskab");
                medlem = new Medlem(cpr, navn, alder, aldersgruppe, svømmeniveau, aktivtMedlemsskab);
                medlemmer.add(medlem);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medlemmer;
    }

    public ArrayList<MedlemsResultater> getTop5() {
        ArrayList<MedlemsResultater> medlemmer = new ArrayList();
        try {

            con = DatabaseConnector.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT medlemsCPR, navn, dato, placering, diciplin, svømmeresultat, konkurrence, stævne FROM delfinen.svømmeresultater JOIN medlemmer ON medlemmer.cpr = svømmeresultater.medlemsCPR ORDER BY svømmeresultat ASC LIMIT 5");

            while (rs.next()) {
                int medlemsCPR = rs.getInt("medlemsCPR");
                String navn = rs.getString("navn");
                String diciplin = rs.getString("diciplin");
                int placering = rs.getInt("placering");
                double svømmeresultat = rs.getDouble("svømmeresultat");
                int dato = rs.getInt("dato");
                String konkurrence = rs.getString("konkurrence");
                String stævne = rs.getString("stævne");
                medlemsResultat = new MedlemsResultater(medlemsCPR, navn, dato, placering, diciplin, svømmeresultat, konkurrence, stævne);
                medlemmer.add(medlemsResultat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medlemmer;
    }

    public ArrayList<Medlem> findMedlem(int cpr) {
        ArrayList<Medlem> medlemmer = new ArrayList();
        try {
            con = DatabaseConnector.getConnection();
            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM delfinen.medlemmer WHERE cpr = " + cpr);

            while (rs.next()) {
                int cpr1 = rs.getInt("cpr");
                String navn = rs.getString("navn");
                int alder = rs.getInt("alder");
                String aldersgruppe = rs.getString("aldersgruppe");
                String svømmeniveau = rs.getString("svømmeniveau");
                boolean aktivtMedlemsskab = rs.getBoolean("aktivtmedlemsskab");
                medlem = new Medlem(cpr, navn, alder, aldersgruppe, svømmeniveau, aktivtMedlemsskab);
                medlemmer.add(medlem);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medlemmer;
    }

    public void indsætMedlem(Medlem medlem) {
        try {
            String SQL = "INSERT INTO delfinen.medlemmer (cpr, navn, alder, aldersgruppe, svømmeniveau, aktivtmedlemsskab) VALUES (?, ?, ?, ?, ?, ?)";
            con = DatabaseConnector.getConnection();

            try (PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, medlem.getCPR());
                ps.setString(2, medlem.getNavn());
                ps.setInt(3, medlem.getAlder());
                ps.setString(4, medlem.getAldersgruppe());
                ps.setString(5, medlem.getSvømmeniveau());
                ps.setBoolean(6, medlem.isAktivtmedlemsskab());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fjernMedlem(int cpr) {
        try {
            con = DatabaseConnector.getConnection();
            stmt = con.createStatement();

            stmt.executeUpdate("DELETE FROM svømmeresultater WHERE medlemsCPR = " + cpr);
            stmt.executeUpdate("DELETE FROM delfinen.medlemmer WHERE cpr = " + cpr);

        } catch (SQLException ex) {
            Logger.getLogger(DBMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void indsætResultat(MedlemsResultater medlem) {
        try {
            String SQL = "INSERT INTO delfinen.svømmeresultater (medlemsCPR, diciplin, placering, svømmeresultat, dato, konkurrence, stævne) VALUES (?, ?, ?, ?, ?, ?, ?)";
            con = DatabaseConnector.getConnection();

            try (PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, medlem.getMedlemsCPR());
                ps.setString(2, medlem.getDiciplin());
                ps.setInt(3, medlem.getPlacering());
                ps.setDouble(4, medlem.getSvømmeresultat());
                ps.setInt(5, medlem.getDato());
                ps.setString(6, medlem.getKonkurrence());
                ps.setString(7, medlem.getStævne());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<MedlemsResultater> seResultater() {
        ArrayList<MedlemsResultater> medlemmer = new ArrayList();
        try {
            con = DatabaseConnector.getConnection();
            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM delfinen.svømmeresultater JOIN delfinen.medlemmer ON svømmeresultater.medlemsCPR = medlemmer.cpr;");
            while (rs.next()) {
                int medlemsCPR = rs.getInt("medlemsCPR");
                String navn = rs.getString("navn");
                String diciplin = rs.getString("diciplin");
                int placering = rs.getInt("placering");
                double svømmeresultat = rs.getDouble("svømmeresultat");
                int dato = rs.getInt("dato");
                String konkurrence = rs.getString("konkurrence");
                String stævne = rs.getString("stævne");
                medlemsResultat = new MedlemsResultater(medlemsCPR, navn, dato, placering, diciplin, svømmeresultat, konkurrence, stævne);
                medlemmer.add(medlemsResultat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medlemmer;
    }

    public void opdaterResultat(int cpr, double resultat) {
        try {
            con = DatabaseConnector.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE delfinen.svømmeresultater SET svømmeresultat = " + resultat + "WHERE medlemsCPR = " + cpr);

        } catch (SQLException ex) {
            Logger.getLogger(DBMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
