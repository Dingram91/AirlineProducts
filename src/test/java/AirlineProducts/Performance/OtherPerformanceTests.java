/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineProducts.Performance;

import AirlineProducts.*;
import java.sql.SQLException;
import org.junit.Test;

/**
 *
 * @author Dingr
 */
public class OtherPerformanceTests {

    /**
     * Test Case ID: GUITest-Contrast-001 Requirement: R-40: TOpening windows
     * should take less than 1 second. Purpose: To test that opening windows
     * takes less than a minutes. Test Setup: This test opening windows takes
     * less than a second. Test Strategy: White box Testing Input: Mouse and
     * keyboard commands. Expected Output: N/A
     */
    @Test(timeout = 10000)
    public void testMain() throws SQLException, ClassNotFoundException, InterruptedException {
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

        Thread.sleep(1000);
    }

}
