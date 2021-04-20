/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineProducts.GUI;

import AirlineProducts.Main;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author AliT
 */
public class MainTest {
    
    private FrameFixture window;
    
    @Before
    public void startMain() {
        Main main = GuiActionRunner.execute(() -> new Main());
        window = new FrameFixture(main);
        window.show();
    }
    
    @Test
    public void testAddCustomer() {
        window.menuItem("addCustomerComp").click();
        window.internalFrame("AddCustomerFrame").requireVisible();
    }
    
    @Test
    public void testSearchCustomer() {
        window.menuItem("searchCustomerMI").click();
        window.internalFrame("searchCustomerFrame").requireVisible();
    }
    
    @Test
    public void testAddFlight() {
        window.menuItem("mi_add_flight").click();
        window.internalFrame("add_flight").requireVisible();
    }
    
    @Test
    public void testBookTicket() {
        window.menuItem("mi_book_ticket").click();
        window.internalFrame("ticket").requireVisible();
    }
    
    @Test
    public void testTicketReport() {
        window.menuItem("mi_ticket_report").click();
        window.internalFrame("ticket_report").requireVisible();
    }
    
    @Test
    public void testUserCreation() {
        window.menuItem("mi_user_creation").click();
        window.internalFrame("user_creation").requireVisible();
    }
    
    @After
    public void tearDown() {
        window.cleanUp();
    }
    
}
