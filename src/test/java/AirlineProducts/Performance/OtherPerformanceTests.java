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
     * Startup Time test
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws java.lang.InterruptedException
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
