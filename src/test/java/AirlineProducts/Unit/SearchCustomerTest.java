/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineProducts.Unit;

import AirlineProducts.SearchCustomer;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author kcamp
 */
public class SearchCustomerTest {

    public SearchCustomerTest() {
    }

  /**
     * Test Case ID: UnitTest-FirstName-013
     * Requirement: R-4: Users shall be able to search the centralized database for 
     * customer information via customer ID or passport
     * Purpose: To test the inputs passed to the method hasValidInputs,
     * ensures all inputs are in the correct format
     * Test Setup: assertEquals is used to check if the inputs pass the test
     * Test Strategy: Equivalence Class testing
     * Input: "CS999", "john", "smith", "14145", "235235235", "123 somplace, nm 31313", new Date(), "5555555555")
     * Expected Output: True, False, False, False, False, False, False
     * Test of isValidName method, of class SearchCustomer.
     */
    @Test
    public void testhasValidInputs() {
        SearchCustomer instance = new SearchCustomer();
        assertEquals(instance.hasValidInputs("CS999", "john", "smith", "14145", "235235235", "123 somplace, nm 31313", new Date(), "5555555555"), true);

        assertEquals(instance.hasValidInputs("", "john", "smith", "14145", "235235235", "123 somplace, nm 31313", new Date(), "5555555555"), false);
        assertEquals(instance.hasValidInputs("CS999", "", "smith", "14145", "235235235", "123 somplace, nm 31313", new Date(), "5555555555"), false);
        assertEquals(instance.hasValidInputs("CS999", "john", "", "14145", "235235235", "123 somplace, nm 31313", new Date(), "5555555555"), false);
        assertEquals(instance.hasValidInputs("CS999", "john", "smith", "", "235235235", "123 somplace, nm 31313", new Date(), "5555555555"), false);
        assertEquals(instance.hasValidInputs("CS999", "john", "smith", "14145", "235235235", "", new Date(), "5555555555"), false);
        assertEquals(instance.hasValidInputs("CS999", "john", "smith", "14145", "235235235", "123 somplace, nm 31313", new Date(), ""), false);
    }

        /**
     * Test Case ID: UnitTest-FirstName-014
     * Requirement: R-8: Users must be required to enter a 
     * valid First name for a new customer record
     * Purpose: To test the input passed to the method isValidName,
     * ensures the name is between 2 and 15 characters
     * Test Setup: assertEquals is used to check if the inputs pass the test
     * Test Strategy: Equivalence Class testing
     * Input: “a” - a name that is too short, “alex” - a name of acceptable length, “alexalexalexalex” - a name that is too long
     * Expected Output: False, True, False
     * Test of isValidName method, of class SearchCustomer.
     */
    @Test
    public void testIsValidName() {
        System.out.println("isValidName");
        SearchCustomer instance = new SearchCustomer();

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
     * Test Case ID: UnitTest-NIC-015
     * Requirement:R-9 Users must be required to enter a valid (National Identity Card) 
     * number for a new customer record
     * Purpose: To test the input passed to the method isValidNic,
     * this test shows that the user has not left the field 
     * Test Setup: assertEquals is used to check if the inputs pass the test
     * Test Strategy: Equivalence Class Testing
     * Input: "   ", NIC
     * Expected Output: false, true
     * Test of isValidNIC method, of class SearchCustomer.
     */
    @Test
    public void testIsValidNIC() {
        System.out.println("isValidNIC");
        SearchCustomer instance = new SearchCustomer();

        // Test empty NIC
        assertEquals(false, instance.isValidNIC(""));

        // Test non-empty NIC
        assertEquals(true, instance.isValidNIC("NIC"));
    }

    /**
     * Test Case ID: UnitTest-ID-016
     * Requirement: R-25 A user must be required to enter a valid ID 
     * for a new customer record
     * Purpose: To check if the ID is valid and so customer can be searched in the system
     * Test Setup: assertEquals is used to check if the inputs pass the test
     * Test Strategy: Equivalence Class Testing
     * Input: "   ", "ID"
     * Expected Output: false, true
     * Test of hasValidId method, of class AddCustomer.
     */
    @Test
    public void testHasValidID() {
        System.out.println("hasValidID");
        SearchCustomer instance = new SearchCustomer();

        // Test empty ID
        assertEquals(false, instance.hasValidID(""));

        // Test non-empty ID
        assertEquals(true, instance.hasValidID("ID"));
    }

    /**
     * Test Case ID: UnitTest-ID-017
     * Requirement: R-19 A user shall be able to enter a new Customer Address 
     * into the graphical interface for a customer record
     * Purpose: To check if the Address is valid and so customers can be searched 
     * or updated in the system
     * Test Setup: assertEquals is used to check if the inputs pass the test
     * Test Strategy: Equivalence Class Testing
     * Input: "   ", "123 Birch Street"
     * Expected Output: false, true
     * Test of isValidAddress method, of class SearchCustomer.
     */
    @Test
    public void testIsValidAddress() {
        System.out.println("isValidAddress");
        SearchCustomer instance = new SearchCustomer();

        // Test empty address
        assertEquals(false, instance.isValidAddress(""));

        // Test non-empty address
        assertEquals(true, instance.isValidAddress("my address"));
    }

    /**
     * Test Case ID: UnitTest-Date-018
     * Requirement:R-20 A user shall be able to select a new date of birth in the 
     * graphical interface for a customer record
     * Purpose: To test that the date input is in the correct format
     * Test Setup: assertEquals is used to check if the inputs pass 
     * the test that he field is not null
     * Test Strategy:Equivalence Class Testing
     * Input: "2021-01-20"
     * Expected Output: false, true
     * Test of isValidDate method, of class SearchCustomer.
     */
    @Test
    public void testIsValidDate() {
        System.out.println("isValidDate");
        SearchCustomer instance = new SearchCustomer();

        // Test invalid date
        assertEquals(false, instance.isValidDate(null));

        // Test valid date
        assertEquals(true, instance.isValidDate(new Date()));
    }

    
        /**
     * Test Case ID: UnitTest-Contact-019
     * Requirement:R-12 Users must be required to select a gender for a
     * new customer record
     * Purpose: To test that a gender is selected
     * Test Setup: assertEquals is used to check if the gender is selected
     * Test Strategy:Equivalence Class Testing
     * Input: select male
     * Expected Output: true
     * Test of hasValidContact method, of class SearchCustomer.
     */
    @Test
    public void checkHasValidGener() {
        SearchCustomer instance = new SearchCustomer();
        assertEquals(instance.hasSelectedGender(), false);
    }

    /**
     * Test Case ID: UnitTest-Contact-020
     * Requirement:R-11 Users must be required to enter a 
     * valid phone number for a new customer record
     * Purpose: To test that the date input is in the correct format
     * Test Setup: assertEquals is used to check if the inputs pass 
     * the test that he field is not null
     * Test Strategy:Equivalence Class Testing
     * Input: 239-555-8877
     * Expected Output: false, true
     * Test of hasValidContact method, of class SearchCustomer.
     */
    @Test
    public void testHasValidContact() {
        System.out.println("hasValidContact");
        SearchCustomer instance = new SearchCustomer();

        // Test empty contact
        assertEquals(false, instance.hasValidContact(""));

        // Test non-empty contact
        assertEquals(true, instance.hasValidContact("contact"));
    }

}
