/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineProducts.GUI;

import AirlineProducts.AddCustomer;
import AirlineProducts.AddFlight;
import AirlineProducts.Main;
import AirlineProducts.SearchCustomer;
import AirlineProducts.UserCreation;
import AirlineProducts.ticket;
import AirlineProducts.ticketreport;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author AliT
 */
public class MainTest {

    private Main main;

    /**
     * Test Case ID: GUITest-MenusShow-001 Requirement: R-39: Windows should be
     * accessible through the menu at all times. Purpose: To test that menus are
     * always accessible. Test Setup: Run the application and check that windows
     * are accessible through the menu. Strategy: White Box Testing Input: Mouse
     * and keyboard commands. Expected Output: N/A
     */
    @Before
    public void startMain() {
        main = new Main();
        main.addCustomer = new AddCustomer();
        main.searchCustomer = new SearchCustomer();
        main.addFlight = new AddFlight();
        main.ticket = new ticket();
        main.ticketReport = new ticketreport();
        main.userCreation = new UserCreation();
        main.setVisible(true);
    }

    /**
     * Test Case ID: GUITest-MenusShow-002 Requirement: R-39: Windows should be
     * accessible through the menu at all times. Purpose: To test that menus are
     * always accessible. Test Setup: Run the application and check that windows
     * are accessible through the menu. Strategy: White Box Testing Input: Mouse
     * and keyboard commands. Expected Output: N/A
     */
    @Test
    public void testAddCustomer() {
        main.mi_add_customer.doClick();
        assertEquals(true, main.addCustomer.isShowing());
        assertEquals(false, main.searchCustomer.isShowing());
        assertEquals(false, main.addFlight.isShowing());
        assertEquals(false, main.ticket.isShowing());
        assertEquals(false, main.ticketReport.isShowing());
        assertEquals(false, main.userCreation.isShowing());
    }

    /**
     * Test Case ID: GUITest-MenusShow-003 Requirement: R-39: Windows should be
     * accessible through the menu at all times. Purpose: To test that menus are
     * always accessible. Test Setup: Run the application and check that windows
     * are accessible through the menu. Strategy: White Box Testing Input: Mouse
     * and keyboard commands. Expected Output: N/A
     */
    @Test
    public void testSearchCustomer() {
        main.mi_search_customer.doClick();
        assertEquals(false, main.addCustomer.isShowing());
        assertEquals(true, main.searchCustomer.isShowing());
        assertEquals(false, main.addFlight.isShowing());
        assertEquals(false, main.ticket.isShowing());
        assertEquals(false, main.ticketReport.isShowing());
        assertEquals(false, main.userCreation.isShowing());
    }

    /**
     * Test Case ID: GUITest-MenusShow-004 Requirement: R-39: Windows should be
     * accessible through the menu at all times. Purpose: To test that menus are
     * always accessible. Test Setup: Run the application and check that windows
     * are accessible through the menu. Strategy: White Box Testing Input: Mouse
     * and keyboard commands. Expected Output: N/A
     */
    @Test
    public void testAddFlight() {
        main.mi_add_flight.doClick();
        assertEquals(false, main.addCustomer.isShowing());
        assertEquals(false, main.searchCustomer.isShowing());
        assertEquals(true, main.addFlight.isShowing());
        assertEquals(false, main.ticket.isShowing());
        assertEquals(false, main.ticketReport.isShowing());
        assertEquals(false, main.userCreation.isShowing());
    }

    /**
     * Test Case ID: GUITest-MenusShow-005 Requirement: R-39: Windows should be
     * accessible through the menu at all times. Purpose: To test that menus are
     * always accessible. Test Setup: Run the application and check that windows
     * are accessible through the menu. Strategy: White Box Testing Input: Mouse
     * and keyboard commands. Expected Output: N/A
     */
    @Test
    public void testBookTicket() {
        main.mi_book_ticket.doClick();
        assertEquals(false, main.addCustomer.isShowing());
        assertEquals(false, main.searchCustomer.isShowing());
        assertEquals(false, main.addFlight.isShowing());
        assertEquals(true, main.ticket.isShowing());
        assertEquals(false, main.ticketReport.isShowing());
        assertEquals(false, main.userCreation.isShowing());
    }

    /**
     * Test Case ID: GUITest-MenusShow-006 Requirement: R-39: Windows should be
     * accessible through the menu at all times. Purpose: To test that menus are
     * always accessible. Test Setup: Run the application and check that windows
     * are accessible through the menu. Strategy: White Box Testing Input: Mouse
     * and keyboard commands. Expected Output: N/A
     */
    @Test
    public void testTicketReport() {
        main.mi_ticket_report.doClick();
        assertEquals(false, main.addCustomer.isShowing());
        assertEquals(false, main.searchCustomer.isShowing());
        assertEquals(false, main.addFlight.isShowing());
        assertEquals(false, main.ticket.isShowing());
        assertEquals(true, main.ticketReport.isShowing());
        assertEquals(false, main.userCreation.isShowing());
    }

    /**
     * Test Case ID: GUITest-MenusShow-007 Requirement: R-39: Windows should be
     * accessible through the menu at all times. Purpose: To test that menus are
     * always accessible. Test Setup: Run the application and check that windows
     * are accessible through the menu. Strategy: White Box Testing Input: Mouse
     * and keyboard commands. Expected Output: N/A
     */
    @Test
    public void testUserCreation() {
        main.mi_user_creation.doClick();
        assertEquals(false, main.addCustomer.isShowing());
        assertEquals(false, main.searchCustomer.isShowing());
        assertEquals(false, main.addFlight.isShowing());
        assertEquals(false, main.ticket.isShowing());
        assertEquals(false, main.ticketReport.isShowing());
        assertEquals(true, main.userCreation.isShowing());
    }

}
