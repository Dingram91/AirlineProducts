/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineProducts;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Dingr
 */
// TEMPLATE---------------------------------------------------------------------
public class AddFlightTest {

    public AddFlightTest() {
    }

    @Test
    public void testIsValidFlightName() {
//        boolean expResult = Boolean.parseBoolean(exp);
        assertEquals(false, AddFlight.isValidFlightName(" "));
        assertEquals(true, AddFlight.isValidFlightName("aa"));
        assertEquals(false, AddFlight.isValidFlightName("!"));
        assertEquals(false, AddFlight.isValidFlightName("\n"));
        assertEquals(false, AddFlight.isValidFlightName("\t"));

    }

    /**
     * Test of isValidateTime method, of class AddFlight.
     */
    @Test
    public void testIsValidateTime() {
        assertEquals(false, AddFlight.isValidateTime(""));
        assertEquals(true, AddFlight.isValidateTime("12:00 am"));
        assertEquals(false, AddFlight.isValidateTime("12:00"));
        assertEquals(false, AddFlight.isValidateTime("\n"));
        assertEquals(true, AddFlight.isValidateTime("6:00 pm"));
        assertEquals(false, AddFlight.isValidateTime("12:60 am"));
    }
//

    /**
     * Test of isValidCost method, of class AddFlight.
     */
    @Test
    public void testIsValidCost() {
        assertEquals(false, AddFlight.isValidCost(" "));
        assertEquals(false, AddFlight.isValidCost(" "));
        assertEquals(false, AddFlight.isValidCost(" "));

    }
//
//    /**
//     * Test of validateDate method, of class AddFlight.
//     */
//    @Test
//    public void testValidateDate() {
//        System.out.println("validateDate");
//        Date date = null;
//        AddFlight instance = new AddFlight();
//        String expResult = "";
//        String result = instance.validateDate(date);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
