/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineProducts;

import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Dingr
 */
public class AddFlightTest {

    public AddFlightTest() {
    }

    /**
     * Test of isValidFlightName method, of class AddFlight.
     */
    @Test
    public void testIsValidFlightName() {
        System.out.println("isValidFlightName");
        String name = "";
        AddFlight instance = new AddFlight();
        boolean expResult = false;
        boolean result = instance.isValidFlightName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidateTime method, of class AddFlight.
     */
    @Test
    public void testIsValidateTime() {
        System.out.println("isValidateTime");
        String time = "";
        AddFlight instance = new AddFlight();
        boolean expResult = false;
        boolean result = instance.isValidateTime(time);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidCost method, of class AddFlight.
     */
    @Test
    public void testIsValidCost() {
        System.out.println("isValidCost");
        String cost = "";
        AddFlight instance = new AddFlight();
        boolean expResult = false;
        boolean result = instance.isValidCost(cost);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateDate method, of class AddFlight.
     */
    @Test
    public void testValidateDate() {
        System.out.println("validateDate");
        Date date = null;
        AddFlight instance = new AddFlight();
        String expResult = "";
        String result = instance.validateDate(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
