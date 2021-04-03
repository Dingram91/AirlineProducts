/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineProducts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alexa
 */
public class DBManager {
    
    final private Connection connection;
    
    public DBManager(Connection connection) {
        this.connection = connection;
    }
    
    public String getMaxCustomerId() throws SQLException, ClassNotFoundException {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("select MAX(id) from customer;");
        result.next();
        return result.getString("MAX(id)");
    }
    
    public ResultSet getCustomersByPassport(String passport) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer WHERE passport = ?;");
        statement.setString(1, passport);
        return statement.executeQuery();
    }
    
    public boolean isPassportTaken(String passport) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer WHERE passport = ?;");
        statement.setString(1, passport);
        return statement.executeQuery().next();
    }
    
    public void insertCustomer(String id, String firstname, String lastname, String nic, 
        String passport, String address, String date, String contact, String gender,
        byte[] userImage) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = connection.prepareStatement("insert "
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
