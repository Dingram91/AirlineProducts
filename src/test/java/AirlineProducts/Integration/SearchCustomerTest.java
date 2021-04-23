/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineProducts.Integration;

import AirlineProducts.AddCustomer;
import AirlineProducts.AddFlight;
import AirlineProducts.DBManager;
import AirlineProducts.DbUtils;
import AirlineProducts.FileUtils;
import AirlineProducts.Login;
import AirlineProducts.Main;
import AirlineProducts.SearchCustomer;
import AirlineProducts.SecurityUtils;
import AirlineProducts.UserCreation;
import AirlineProducts.ticket;
import AirlineProducts.ticketreport;
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
     * Test Case ID: IntegrationTest-isValidPassport-
     * Requirement: R-8 Users must be required to enter a valid passport 
     * number for a new customer record
     * Test Setup: Verify that the SearchCustomer class interacts with the DBManager and only 
     * requests to add a new customer if the inputs are valid
     * Test Strategy: Mock
     * Input: SearchCustomer class and DBManager mock
     * Expected Output: true, true, false, false
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

    public void testMain() throws SQLException, ClassNotFoundException {
        AddCustomer ac = new AddCustomer();

        Main m = new Main();
        AddFlight af = new AddFlight();
        SearchCustomer sc = new SearchCustomer();
        ticket t = new ticket();
        t.show();
        ticketreport tr = new ticketreport();
        DbUtils utils = new DbUtils();
        DBManager manager = new DBManager(utils.getDbConnection());
        Login l = new Login();
        FileUtils fu = new FileUtils();
        UserCreation uc = new UserCreation();
        SecurityUtils su = new SecurityUtils();

    }

}
