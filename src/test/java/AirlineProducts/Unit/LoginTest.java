/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineProducts.Unit;

import AirlineProducts.Login;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexa
 */
public class LoginTest {

    /**
     * Test Case ID: UnitTest-Date-011
     * Requirement: R-2 Users shall be required to enter a valid username and password before being allowed to access the various system tools
     * Purpose: This test will check that both the username and password have a valid character inputs
     * Test Strategy: Equivalence Class Testing
     * Input: Username: Joe  Password: 098, Username:   Password: 098, Username:   Password: , Username: Joe  Password: 
     * Expected Output: True, False, False, False
     * Test of hasValidInputs method, of class Login.
     */
    @Test
    public void testHasValidInputs() {
        System.out.println("hasValidInputs");
        Login instance = new Login();
        
        // Test empty username & password
        String username = "";
        String password = "";
        assertEquals(false, instance.hasValidInputs(username, password));
        
        // Test non-empty username & empty password
        username = "joe";
        password = "";
        assertEquals(false, instance.hasValidInputs(username, password));
        
        // Test empty username & non-empty password
        username = "";
        password = "098";
        assertEquals(false, instance.hasValidInputs(username, password));
        
        // Test non-empty username & password
        username = "joe";
        password = "098";
        assertEquals(true, instance.hasValidInputs(username, password));
    }

        /**
     * Test Case ID: UnitTest-Date-012
     * Requirement: R-2 Users shall be required to enter a valid username and password before being allowed to access the various system tools
     * Purpose: This test will check that both the username and password are valid to access system
     * Test Strategy: Equivalence Class Testing
     * Input: Username: Joe  Password: 123,  Username: Password: 098, Username: Password: , Username: Joe Password: 
     * Expected Output: True, False, False, False
     * Test of isValidUser method, of class Login.
     */
    @Test
    public void testIsValidUser() throws Exception {
        System.out.println("isValidUser");
        Login instance = new Login();
        
        // Test invalid username & password
        String username = "joe";
        String password = "098";
        assertEquals(false, instance.isValidUser(username, password));
        
        // Test valid username & invalid password
        username = "john";
        password = "098";
        assertEquals(false, instance.isValidUser(username, password));
        
        // Test invalid username & valid password
        username = "joe";
        password = "123";
        assertEquals(false, instance.isValidUser(username, password));
        
        // Test valid username & password
        username = "john";
        password = "123";
        assertEquals(true, instance.isValidUser(username, password));
    }
    
}
