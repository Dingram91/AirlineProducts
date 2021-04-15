/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineProducts.Integration;

import AirlineProducts.DBManager;
import AirlineProducts.SearchCustomer;
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
public class SearchCustomerTest {
    
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
