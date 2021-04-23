/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineProducts.Unit;

import AirlineProducts.DbUtils;
import AirlineProducts.UserCreation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author alexa
 */
public class UserCreationTest {

    public UserCreationTest() {
    }

    @Before
    public void insertTestUser() {
        System.out.println("insertTestUser");
        try {
            Connection connection = DbUtils.getDbConnection();
            PreparedStatement statement = connection.prepareStatement("insert "
                    + "into user(id,firstname,lastname,username,password)values(?,?,?,?,?)");
            statement.setString(1, "UO99999");
            statement.setString(2, "testfirstname");
            statement.setString(3, "testlastname");
            statement.setString(4, "testusername");
            statement.setString(5, "testpassword#");
            statement.executeUpdate();

            statement = connection.prepareStatement("SELECT * FROM user WHERE id = ?");
            statement.setString(1, "UO99999");
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                System.out.println("Inserted user with id " + result.getString(1));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserCreation.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Unable to connect to database");
        } catch (SQLException ex) {
            Logger.getLogger(UserCreation.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("An error occurred interacting with the database");
        }
    }


    /**
     * UnitTest-AirlineProduct-022
     * REQ-R-25 The program shall generate a valid user ID based on the last maximum value 
     * Purpose- To ensure that the ID is incremented correctly 
     * TestSetup-A UserCreation object is created and a string containing
     * the sudo previous user id of “UO999” is passed to “generateID” 
     * TestStrategy- Boundary Value Testing 
     * Input- In this case “UO999” 
     * The expected output is the string “UO1000”
     * Test of generateID method, of class UserCreation.
     */
    @Test
    public void testGenerateID() {
        System.out.println("generateID");
        UserCreation instance = new UserCreation();

        // Test null ID
        String maxID = null;
        assertEquals("UO001", instance.generateID(maxID));

        // Test for range UO001 - UO999
        maxID = "UO001";
        assertEquals("UO002", instance.generateID(maxID));

        // Test at boundary UO999
        maxID = "UO999";
        assertEquals("UO1000", instance.generateID(maxID));
        maxID = "UO1000";
        assertEquals("UO1001", instance.generateID(maxID));
    }


    /**
     * Test Case ID: UnitTest-Name-021
     * Requirement: R-2 The user shall enter a valid username
     * Purpose: To ensure that the name between 2 *and 15 characters Test
     * Setup: A UserCreation object is created and a string containing a single
     * character is passed to its “isValidName” method 
     * TestStrategy: Equivalence class testing 
     * Input: A string containing the letter “a” 
     * Expected output: False
     * Test of isValidName method, of class UserCreation.
     */
    @Test
    public void testIsValidName() {
        System.out.println("isValidName");
        UserCreation instance = new UserCreation();

        // Test name that is too short - length = 1
        String name = "a";
        assertEquals(false, instance.isValidName(name));

        // Test name that is too long - length = 16
        name = "johnjohnjohnjohn";
        assertEquals(false, instance.isValidName(name));

        // Test contains characters that are not letters
        name = "jo hn234";
        assertEquals(false, instance.isValidName(name));

        // Test valid name
        name = "john";
        assertEquals(true, instance.isValidName(name));
    }

    /**
     * Test Case ID: UnitTest-Name-023
     * Requirement: R-2 The user shall enter a valid username
     * Purpose: To ensure that the name between 2 *and 15 characters Test
     * Setup: A UserCreation object is created and a string containing a single
     * character is passed to its “isValidName” method 
     * TestStrategy: Equivalence class testing 
     * Input: A string containing the letter “a” 
     * Expected output: False
     * Test of isValidUsername method, of class UserCreation.
     */
    @Test
    public void testIsValidUsername() {
        System.out.println("isValidUsername");
        UserCreation instance = new UserCreation();

        // Test username that is too short - length = 1
        String name = "j";
        assertEquals(false, instance.isValidUsername(name));

        // Test username that is too long - length = 16
        name = "johnjohnjohnjohn";
        assertEquals(false, instance.isValidUsername(name));

        // Test username contains non-letter & non-digit character
        name = "john&";
        assertEquals(false, instance.isValidUsername(name));

        // Test username is already taken
        name = "testusername";
        assertEquals(false, instance.isValidUsername(name));

        // Test username is valid
        name = "john123";
        assertEquals(true, instance.isValidUsername(name));
    }


    /**
    +UnitTest-AirlineProduct-024
    *REQ-R-30 The user password shall require one  *special character
    *Purpose- To ensure the password contains a *special character
    *TestSetup- A UserCreation object is created and a string containing 
    * a special character is passed to it’s “isValidPassword” method
    *TestStrategy- Decision Table Testing
    *Inputs 1) The user enters a password 2) In this *case “abc123#”
    *The expected output is true
    *Test of isValidPassword method, of class UserCreation.
     */
    @Test
    public void testIsValidPassword() {
        System.out.println("isValidPassword");
        UserCreation instance = new UserCreation();

        // Test username that is too short - length = 5
        String password = "123#a";
        assertEquals(false, instance.isValidPassword(password));

        // Test username that is too long - length = 16
        password = "123#a12312312312";
        assertEquals(false, instance.isValidPassword(password));

        // Test username contains space
        password = "abc 123";
        assertEquals(false, instance.isValidPassword(password));

        // Test username does not contain special character
        password = "abc123";
        assertEquals(false, instance.isValidPassword(password));

        // Test valid password
        password = "abc123#";
        assertEquals(true, instance.isValidPassword(password));
    }

    /**
     * Test Case ID: UnitTest-ID-025
     * Requirement: R-25 A user must be required to enter a valid ID 
     * for a new customer record
     * Purpose: To check if the ID is valid and so customer can be searched in the system
     * Test Setup: assertEquals is used to check if the inputs pass the test
     * Test Strategy: Equivalence Class Testing
     * Input: "   ", "ID"
     * Expected Output: false, true
     * Test of hasValidID method, of class UserCreation.
     */
    @Test
    public void testHasValidID() {
        System.out.println("hasValidID");
        UserCreation instance = new UserCreation();

        // Test ID is empty
        String id = "";
        assertEquals(false, instance.hasValidID(id));

        // Test ID is not empty
        id = "UO001";
        assertEquals(true, instance.hasValidID(id));
    }

    @After
    public void deleteTestUser() {
        System.out.println("deleteTestUser");
        try {
            Connection connection = DbUtils.getDbConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE "
                    + "FROM user WHERE id = ?");
            statement.setString(1, "UO99999");
            statement.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserCreation.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Unable to connect to database");
        } catch (SQLException ex) {
            Logger.getLogger(UserCreation.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("An error occurred interacting with the database");
        }
    }
}
