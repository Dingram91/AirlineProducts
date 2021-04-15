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
     * Test of hasValidID method, of class AddCustomer.
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
