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

    private static String DB_PASSWORD = "";

    private static Connection connection;

    private static DBManager dbManager;

    /**
     * Gets a sql connection.
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Connection getDbConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", DB_PASSWORD);
        }
        return connection;
    }

    /**
     * Gets a database manager.
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static DBManager getDBManager() throws SQLException, ClassNotFoundException {
        if (dbManager == null) {
            dbManager = new DBManager(getDbConnection());
        }
        return dbManager;
    }
}
