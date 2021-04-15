/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineProducts.Integration;

import AirlineProducts.AddCustomer;
import AirlineProducts.DBManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author AliT
 */
public class AddCustomerTest {
    
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
     * Test of insertCustomer method, of class AddCustomer.
     */
    @Test
    public void testInsertCustomer() throws SQLException, ClassNotFoundException {
        System.out.println("insertCustomer");
        AddCustomer instance = new AddCustomer();
        DBManager dbManager = mock(DBManager.class);
        instance.setDBManager(dbManager);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
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
