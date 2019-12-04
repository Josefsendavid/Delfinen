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

public class DBMapper {

    //public class DBMapper implements Datasource {
    Connection con = null;

    private ArrayList<Medlem> medlemmer = new ArrayList();
    private Medlem medlem;
    private Statement stmt;

    public ArrayList<Medlem> getMedlemmer() {

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
//                if (!medlem.equals(medlem)) {
                    medlemmer.add(medlem);
                //}
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medlemmer;
    }

    public ArrayList<Medlem> getTop5() {

        try {

            con = DatabaseConnector.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT medlemsID, aldersgruppe, dicisplin, svømmeresultat FROM delfinen.svømmeresultater ORDER BY svømmeresultat DESC LIMIT 5");

            while (rs.next()) {
                int medlemsID = rs.getInt("medlemsID");
                String aldersgruppe = rs.getString("aldersgruppe");
                String dicisplin = rs.getString("dicisplin");
                double svømmeresultat = rs.getDouble("svømmeresultat");
                medlem = new Medlem(medlemsID, aldersgruppe, dicisplin, svømmeresultat);
                medlemmer.add(medlem);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medlemmer;
    }

    public ArrayList<Medlem> findMedlem(int cpr) {
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

            stmt.executeUpdate("DELETE FROM delfinen.medlemmer WHERE cpr = " + cpr);

        } catch (SQLException ex) {
            Logger.getLogger(DBMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void indsætResultat(Medlem medlem) {
        try {
            String SQL = "INSERT INTO delfinen.svømmeresultater (medlemsID, aldersgruppe, diciplin, svømmeresultat) VALUES (?, ?, ?, ?)";
            con = DatabaseConnector.getConnection();

            try (PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, medlem.getMedlemsID());
                ps.setString(2, medlem.getAldersgruppe());
                ps.setString(3, medlem.getDiciplin());
                ps.setDouble(4, medlem.getSvømmeresultat());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Medlem> seResultater() {
        try {
            con = DatabaseConnector.getConnection();
            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM delfinen.svømmeresultat ORDER BY medlemsID");
            while (rs.next()) {
                int medlemsID = rs.getInt("medlemsID");
                String aldersgruppe = rs.getString("aldersgruppe");
                String dicisplin = rs.getString("dicisplin");
                double svømmeresultat = rs.getDouble("svømmeresultat");
                medlem = new Medlem(medlemsID, aldersgruppe, dicisplin, svømmeresultat);
                medlemmer.add(medlem);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medlemmer;
    }
}
