/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineProducts;

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
     * Test of generateID method, of class AddCustomer.
     */
    @Test
    public void testGenerateID() throws SQLException, ClassNotFoundException {
        System.out.println("generateID");
        AddCustomer instance = new AddCustomer();
        DBManager dbManager = mock(DBManager.class);
        
        // Test null ID
        when(dbManager.getMaxCustomerId()).thenReturn(null);       
        assertEquals("CS001", instance.generateID(dbManager.getMaxCustomerId()));
        
        // Test for range UO001 - UO999
        when(dbManager.getMaxCustomerId()).thenReturn("CS001");       
        assertEquals("CS002", instance.generateID(dbManager.getMaxCustomerId()));
        
        // Test at boundary UO999
        when(dbManager.getMaxCustomerId()).thenReturn("CS999");       
        assertEquals("CS1000", instance.generateID(dbManager.getMaxCustomerId()));
        when(dbManager.getMaxCustomerId()).thenReturn("CS1000");       
        assertEquals("CS1001", instance.generateID(dbManager.getMaxCustomerId()));
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
     * Test of isValidPassport method, of class AddCustomer.
     */
    @Test
    public void testIsValidPassport() throws SQLException, ClassNotFoundException {
        System.out.println("isValidPassport");
        AddCustomer instance = new AddCustomer();
        DBManager dbManager = mock(DBManager.class);
        instance.setDBManager(dbManager);
        
        // Test passport unavailable with valid passport
        when(dbManager.isPassportTaken("123")).thenReturn(true);       
        assertEquals(false, instance.isValidPassport("123"));
        
        // Test passport unavailable with invalid passport
        when(dbManager.isPassportTaken("")).thenReturn(true);       
        assertEquals(false, instance.isValidPassport(""));
        
        // Test passport available with valid passport
        when(dbManager.isPassportTaken("123")).thenReturn(false);       
        assertEquals(true, instance.isValidPassport("123"));
        
        // Test passport available with invalid passport
        when(dbManager.isPassportTaken("")).thenReturn(false);       
        assertEquals(false, instance.isValidPassport(""));
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
    
    /**
     * Test of insertCustomer method, of class AddCustomer.
     */
    @Test
    public void testInsertCustomer() throws SQLException, ClassNotFoundException {
        System.out.println("insertCustomer");
        AddCustomer instance = new AddCustomer();
        DBManager dbManager = mock(DBManager.class);
        instance.setDBManager(dbManager);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        System.out.println("About to call insert customer");
        instance.insertCustomer("CS1000", "john", "doe", "nic", "02345", "address",
                new Date(), "michael", "male", null);
        verify(dbManager, times(1)).insertCustomer("CS1000", "john", "doe", "nic", "02345", "address",
                formatter.format(new Date()), "michael", "male", null);
        
        instance.insertCustomer("", "", "", "", "", "",
                new Date(), "", "", null);
        verify(dbManager, times(0)).insertCustomer(null, null, null, null, null, null,
                null, null, null, null);
        
    }
}
