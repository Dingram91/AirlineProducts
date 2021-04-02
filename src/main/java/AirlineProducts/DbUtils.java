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
    
    private static String DB_PASSWORD = "";
    
    private static Connection connection;
    
    public static Connection getDbConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/airline","root", DB_PASSWORD);
        }
        return connection;
    }
    
    public static String getMaxCustomerId() throws SQLException, ClassNotFoundException {
        Statement statement = getDbConnection().createStatement();
        ResultSet result = statement.executeQuery("select MAX(id) from user;");
        result.next();
        return result.getString("MAX(id)");
    }
    
    public static ResultSet getCustomersByPassport(String passport) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = getDbConnection().prepareStatement("SELECT * FROM customer WHERE passport = ?;");
        statement.setString(1, passport);
        return statement.executeQuery();
    }
    
    public static void insertCustomer(String id, String firstname, String lastname, String nic, 
            String passport, String address, String date, String contact, String gender,
            byte[] userImage) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = getDbConnection().prepareStatement("insert "
            + "into customer(id,firstname,lastname,nic,passport,address,"
            + "dob,gender,contact,photo)values(?,?,?,?,?,?,?,?,?,?)");
            
        statement.setString(1, id);
        statement.setString(2, firstname);
        statement.setString(3, lastname);
        statement.setString(4, nic);
        statement.setString(5, passport);
        statement.setString(6, address);
        statement.setString(7, date);
        statement.setString(8, gender);
        statement.setString(9, contact);
        statement.setBytes(10, userImage);
        statement.executeUpdate();
    }
}
