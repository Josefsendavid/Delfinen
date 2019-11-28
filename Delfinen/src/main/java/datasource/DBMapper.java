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
            ResultSet rs = stmt.executeQuery("SELECT * FROM delfinen.medlemmer");

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
}
