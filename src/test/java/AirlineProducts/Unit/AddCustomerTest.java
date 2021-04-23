/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineProducts.Unit;

import AirlineProducts.AddCustomer;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author alexa
 */
public class AddCustomerTest {
    
    public AddCustomerTest() {
    }

    /**
     * Test Case ID: UnitTest-FirstName-001
     * Requirement: R-6: Users must be required to enter a 
     * valid First name for a new customer record
     * Purpose: To test the input passed to the method isValidName,
     * ensures the name is between 2 and 15 characters
     * Test Setup: assertEquals is used to check if the inputs pass the test
     * Test Strategy: Equivalence Class testing
     * Input: “a” - a name that is too short, “alex” - a name of acceptable length, “alexalexalexalex” - a name that is too long
     * Expected Output: False, True, False
     * Test of isValidName method, of class AddCustomer.
     */
    @Test
    public void testIsValidName() {
        System.out.println("isValidName");
        AddCustomer instance = new AddCustomer();
        
        // Test name that is too short - length = 1
        String name = "j";
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
     * Test Case ID: UnitTest-NIC-002
     * Requirement:R-9 Users must be required to enter a valid (National Identity Card) 
     * number for a new customer record
     * Purpose: To test the input passed to the method isValidNic,
     * this test shows that the user has not left the field 
     * Test Setup: assertEquals is used to check if the inputs pass the test
     * Test Strategy: Equivalence Class Testing
     * Input: "   ", NIC
     * Expected Output: false, true
     * Test of isValidNIC method, of class AddCustomer.
     */
    @Test
    public void testIsValidNIC() {
        System.out.println("isValidNIC");
        AddCustomer instance = new AddCustomer();
        
        // Test empty NIC
        assertEquals(false, instance.isValidNIC(""));
        
        // Test non-empty NIC
        assertEquals(true, instance.isValidNIC("NIC"));
    }

    /**
     * Test Case ID: UnitTest-ID-003
     * Requirement: R-25 A user must be required to enter a valid ID 
     * for a new customer record
     * Purpose: To check if the ID is valid and so customer can be added to the system
     * Test Setup: assertEquals is used to check if the inputs pass the test
     * Test Strategy: Equivalence Class Testing
     * Input: "   ", "ID"
     * Expected Output: false, true
     * Test of hasValidId method, of class AddCustomer.
     */
    @Test
    public void testHasValidID() {
        System.out.println("hasValidID");
        AddCustomer instance = new AddCustomer();
        
        // Test empty ID
        assertEquals(false, instance.hasValidID(""));
        
        // Test non-empty ID
        assertEquals(true, instance.hasValidID("ID"));
    }
    
    /**
     * Test Case ID: UnitTest-Address-004
     * Requirement:R-10 Users must be required to enter 
     * a valid address for a new customer record
     * Purpose: To check if the Address is valid and so customers can be searched 
     * or updated in the system
     * Test Setup: assertEquals is used to check if the inputs pass the test
     * Test Strategy: Equivalence Class Testing
     * Input: "   ", "123 Birch Street"
     * Expected Output: false, true
     * Test of isValidAddress method, of class AddCustomer.
     */
    @Test
    public void testIsValidAddress() {
        System.out.println("isValidAddress");
        AddCustomer instance = new AddCustomer();
        
        // Test empty address
        assertEquals(false, instance.isValidAddress(""));
        
        // Test non-empty address
        assertEquals(true, instance.isValidAddress("my address"));
    }

    /**
     * Test Case ID: UnitTest-Date-005
     * Requirement:R-20 A user shall be able to select a new date of birth in the 
     * graphical interface for a customer record
     * Purpose: To test that the date input is in the correct format
     * Test Setup: assertEquals is used to check if the inputs pass 
     * the test that he field is not null
     * Test Strategy:Equivalence Class Testing
     * Input: "2021-01-20"
     * Expected Output: false, true
     * Test of isValidDate method, of class AddCustomer.
     */
    @Test
    public void testIsValidDate() {
        System.out.println("isValidDate");
        AddCustomer instance = new AddCustomer();
        
        // Test invalid date
        assertEquals(false, instance.isValidDate(null));
        
        // Test valid date
        assertEquals(true, instance.isValidDate(new Date()));
    }

    /**
     * Test Case ID: UnitTest-Contact-006
     * Requirement:R-11 Users must be required to enter a 
     * valid phone number for a new customer record
     * Purpose: To test that the date input is in the correct format
     * Test Setup: assertEquals is used to check if the inputs pass 
     * the test that he field is not null
     * Test Strategy:Equivalence Class Testing
     * Input: 239-555-8877
     * Expected Output: false, true
     * Test of hasValidContact method, of class AddCustomer.
     */
    @Test
    public void testHasValidContact() {
        System.out.println("hasValidContact");
        AddCustomer instance = new AddCustomer();
        
        // Test empty contact
        assertEquals(false, instance.hasValidContact(""));
        
        // Test non-empty contact
        assertEquals(true, instance.hasValidContact("contact"));
    }
}
