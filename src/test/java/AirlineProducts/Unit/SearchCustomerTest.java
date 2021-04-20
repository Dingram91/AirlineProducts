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
     * Test of hasValidID method, of class SearchCustomer.
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

    @Test
    public void checkHasValidGener() {
        SearchCustomer instance = new SearchCustomer();
        assertEquals(instance.hasSelectedGender(), false);
    }

    /**
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
