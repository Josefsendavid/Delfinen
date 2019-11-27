package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnector {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/delfinen";
    private static final String USER = "root";
    private static final String PASSWORD = "Mathias1501clausen";
    private static Connection con = null;
    
    DatabaseConnector() {
        
    }
    
    public static Connection getConnection() {

        if (con == null) {
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASSWORD);


        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return con;
    }
    public static void main(String[] args) {
        new DatabaseConnector().getConnection();
    }
}