/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineProducts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alexander
 */
public class DbUtils {
    
    private static String DB_PASSWORD = "blink4141";
    
    private static Connection connection;
    
    private static DBManager dbManager;
    
    public static Connection getDbConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/airline","root", DB_PASSWORD);
        }
        return connection;
    }
    
    public static DBManager getDBManager() throws SQLException, ClassNotFoundException {
        if (dbManager == null) {
            dbManager = new DBManager(getDbConnection());
        }
        return dbManager;
    }
}
