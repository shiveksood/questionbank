package questionbank;


import lombok.extern.java.Log;

import java.sql.*;
import java.util.logging.Level;


@Log
public class SQLConnection {

    private static SQLConnection sqlConnection = null;
    private static Connection conn = null;


    private SQLConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/questionbank", "root", "root");
        } catch (ClassNotFoundException e) {
            log.log(Level.INFO,"Sql driver class not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static SQLConnection getInstance() {
        if (sqlConnection == null) {
            sqlConnection = new SQLConnection();
        }
        return sqlConnection;
    }

    public boolean execute(String query) {
        try {
            Statement stmt = conn.createStatement();
            return !stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
