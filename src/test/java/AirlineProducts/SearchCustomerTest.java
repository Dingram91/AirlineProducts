/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineProducts;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import junit.framework.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 *
 * @author kcamp
 */
public class SearchCustomerTest {
    
        public SearchCustomerTest() {
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
     * Test of isValidPassport method, of class SearchCustomer.
     */
    @Test
    public void testIsValidPassport() throws SQLException, ClassNotFoundException {
        System.out.println("isValidPassport");
        SearchCustomer instance = new SearchCustomer();
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
    
        /**
     * Test of insertCustomer method, of class SearchCustomer.
     */
    @Test
    public void testUpdateCustomer() throws SQLException, ClassNotFoundException {
        System.out.println("Updated Customer");
        SearchCustomer instance = new SearchCustomer();
        DBManager dbManager = mock(DBManager.class);
        instance.setDBManager(dbManager);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        System.out.println("About to call update customer");
        instance.updateCustomer("CS1000", "john", "doe", "nic", "02345", "address",
                new Date(), "michael", "male", null);
        verify(dbManager, times(1)).updateCustomer("CS1000", "john", "doe", "nic", "02345", "address",
                formatter.format(new Date()), "michael", "male", null);
        
        instance.updateCustomer("", "", "", "", "", "",
                new Date(), "", "", null);
        verify(dbManager, times(0)).updateCustomer(null, null, null, null, null, null,
                null, null, null, null);
        
    }
}
