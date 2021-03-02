/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineProducts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alexander
 */
public class DbUtils {
    
    public static String DB_PASSWORD = "blink4141";
    
    private static Connection connection;
    
    public static Connection getDbConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/airline","root", DB_PASSWORD);
        }
        return connection;
    }
    
}
