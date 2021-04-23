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
import java.util.Vector;

/**
 *
 * @author alexa
 */
public class DBManager {

    final private Connection connection;

    /**
     * Constructor, takes a sql database connection
     *
     * @param connection
     */
    public DBManager(Connection connection) {
        this.connection = connection;
    }

    /**
     * Gets the max customer ID in the database
     *
     * @return max customer id
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public String getMaxCustomerId() throws SQLException, ClassNotFoundException {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("select MAX(id) from customer;");
        result.next();
        return result.getString("MAX(id)");
    }

    /**
     * Gets an sql result object for a customer search by passport number.
     *
     * @param passport
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ResultSet getCustomersByPassport(String passport) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer WHERE passport = ?;");
        statement.setString(1, passport);
        return statement.executeQuery();
    }

    /**
     * Checks if a passport number is already in the database.
     *
     * @param passport
     * @return Boolean
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean isPassportTaken(String passport) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer WHERE passport = ?;");
        statement.setString(1, passport);
        return statement.executeQuery().next();
    }

    /**
     * inserts a new customer into the database.
     *
     * @param id
     * @param firstname
     * @param lastname
     * @param nic
     * @param passport
     * @param address
     * @param date
     * @param contact
     * @param gender
     * @param userImage
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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

    /**
     * Gets an sql result object for a customer search by customer ID.
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public ResultSet getCustomerById(String id) throws SQLException {
        PreparedStatement pst = connection.prepareStatement("SELECT * FROM customer WHERE id = ?");
        pst.setString(1, id);
        return pst.executeQuery();
    }

    /**
     * Gets a vector containing all the tickets in the database.
     *
     * @return vector containing all the tickets in the database
     * @throws SQLException
     */
    public Vector<Vector<String>> getTicketReportData() throws SQLException {
        Vector<Vector<String>> ticketSalesData = new Vector<>();
        PreparedStatement pst = connection.prepareStatement("SELECT * FROM ticket");
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Vector<String> ticketSale = new Vector<>();
            ticketSale.add(rs.getString("id"));
            ticketSale.add(rs.getString("flightid"));
            ticketSale.add(rs.getString("custid"));
            ticketSale.add(rs.getString("class"));
            ticketSale.add(rs.getString("price"));
            ticketSale.add(rs.getString("seats"));
            ticketSale.add(rs.getString("date"));
            ticketSalesData.add(ticketSale);

        }
        return ticketSalesData;
    }

    /**
     * Adds a new ticket to the database.
     *
     * @param ticketId
     * @param flightId
     * @param custId
     * @param flightClass
     * @param price
     * @param numberOfSeats
     * @param date
     * @return Boolean success/fail
     * @throws SQLException
     */
    public boolean addTicketToDB(String ticketId, String flightId, String custId,
            String flightClass, String price, String numberOfSeats, String date) throws SQLException {

        PreparedStatement pst = connection.prepareStatement("insert into ticket(id,flightid,custid,class,price,seats,date)values(?,?,?,?,?,?,?)");

        pst.setString(1, ticketId);
        pst.setString(2, flightId);
        pst.setString(3, custId);
        pst.setString(4, flightClass);
        pst.setString(5, price);
        pst.setString(6, numberOfSeats);
        pst.setString(7, date);

        return pst.execute();
    }

    /**
     * Updates a customers information in the database.
     *
     * @param id
     * @param firstname
     * @param lastname
     * @param nic
     * @param passport
     * @param address
     * @param date
     * @param contact
     * @param gender
     * @param userImage
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void updateCustomer(String id, String firstname, String lastname, String nic,
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
