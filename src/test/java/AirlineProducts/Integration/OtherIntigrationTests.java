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

/**
 *
 * @author Dingr
 */
public class OtherIntigrationTests {

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
