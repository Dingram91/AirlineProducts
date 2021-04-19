/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineProducts.Performance;

import AirlineProducts.AddCustomer;
import AirlineProducts.AddFlight;
import AirlineProducts.Main;
import AirlineProducts.SearchCustomer;
import AirlineProducts.UserCreation;
import AirlineProducts.ticket;
import AirlineProducts.ticketreport;
import java.io.File;
import java.time.Duration;
import java.time.Instant;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author AliT
 */
public class AddCustomerTest {
    
    private Main main;
    
    @Before
    public void startMain() {
        main = new Main();
        main.addCustomer = new AddCustomer();
        main.setVisible(true);
        main.mi_add_customer.doClick();
    }
    
    @Test
    public void test480pImage() throws InterruptedException {
        main.addCustomer.setVisible(true);
        
        // Test 480p picture
        File size480 = new File("./TestPhotos/480p.jpg");
        Instant start = Instant.now();
        main.addCustomer.processPicture(size480);
        Instant end = Instant.now();
        assertEquals(true, Duration.between(start, end).toMillis() < 1000);
    }
    
    @Test
    public void test720pImage() throws InterruptedException {
        main.addCustomer.setVisible(true);
        
        // Test 720p picture
        File size720 = new File("./TestPhotos/720p.jpg");
        Instant start = Instant.now();
        main.addCustomer.processPicture(size720);
        Instant end = Instant.now();
        assertEquals(true, Duration.between(start, end).toMillis() < 1000);
    }
    
    @Test
    public void test1080pImage() throws InterruptedException {
        main.addCustomer.setVisible(true);

        // Test 1080p picture
        File size1080 = new File("./TestPhotos/1080p.jpg");
        Instant start = Instant.now();
        main.addCustomer.processPicture(size1080);
        Instant end = Instant.now();
        assertEquals(true, Duration.between(start, end).toMillis() < 1000);
    }
    
    @Test
    public void test1440pImage() throws InterruptedException {
        main.addCustomer.setVisible(true);
        
        // Test 1440p picture
        File size1440 = new File("./TestPhotos/1440p.jpg");
        Instant start = Instant.now();
        main.addCustomer.processPicture(size1440);
        Instant end = Instant.now();
        assertEquals(true, Duration.between(start, end).toMillis() < 1000);
    }
}
