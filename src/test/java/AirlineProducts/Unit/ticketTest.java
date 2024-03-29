/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineProducts.Unit;

import AirlineProducts.DBManager;
import AirlineProducts.ticket;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Dingr
 */
public class ticketTest {

    public ticketTest() {
    }

    /**
     * Test Case ID: UnitTest-AutoId-026
     * Requirement:
     * Purpose: To check that the number part of the
     * flight ID is an actual number
     * Test Setup: Check that the field is not null, then check that the number
     * part is an actual number
     * Test Strategy: Equivalence Class Testing
     * Input: FO003
     * Expected Output: FO003
     * Test of autoID method, of class ticket
     */
    @Test
    public void testAutoID() {
        System.out.println("autoID");
        ticket instance = new ticket();
        instance.autoID();

        String ticketNumber = instance.txtTicketNum.getText();
        assertEquals("TO", ticketNumber.subSequence(0, 2));

        int ticketInt = Integer.parseInt(ticketNumber.substring(2));
        Assert.assertNotNull(ticketInt); // check that the number part of the
        // flightID is an actual number

    }

     /**
     * Test Case ID: UnitTest-CustomerSearchExceptionTest-027
     * Requirement:
     * Purpose:
     * Test Setup: 
     * Test Strategy: 
     * Input:
     * Expected Output: 
     * 
     */
    @Test(expected = SQLException.class) // bad connection should throw an SQLException
    public void doCustomerSearchExceptionTest() throws SQLException, ClassNotFoundException {
        ticket instance = new ticket();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection dummyConnection = DriverManager.getConnection("\"jdbc:mysql://localhost/airline\"", "FAKE", "CREDENTIALS");
        DBManager dBManager = new DBManager(dummyConnection);
        instance.setManager(dBManager);

        instance.doCustomerSearch("CS001"); // should throw a SQLException

    }


    /**
     * Test Case ID: UnitTest-Buttons-030
     * Purpose: To ensure the buttons are working 
     * Test Setup: This test will check the activity of the buttons
     * Test Strategy: Whitebox 
     * 
     */
    @Test
    public void testButtons() {
        ticket instance = new ticket();
        instance.BtnClickedSearchFlights.getActionListeners()[0].actionPerformed(new ActionEvent(instance, 0, ""));
        instance.BtnClickedSearchCustomer.getActionListeners()[0].actionPerformed(new ActionEvent(instance, 0, ""));
        instance.CancelButton.getActionListeners()[0].actionPerformed(new ActionEvent(instance, 0, ""));
        Assert.assertFalse(instance.isVisible()); // Check that window is no longer visible
    }

}
