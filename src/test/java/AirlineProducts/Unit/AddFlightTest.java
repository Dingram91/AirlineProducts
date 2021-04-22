/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineProducts.Unit;

import AirlineProducts.AddFlight;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Dingr
 */
public class AddFlightTest {

    public AddFlightTest() {
    }

    /**
     * Test Case ID: UnitTest-FlightName-007
     * Requirement: R-27: Users must be required to enter a 
     * valid Flight Name for a new flight
     * Purpose: To test the input passed to the method isValidFlightName,
     * ensures the name does not include escape sequence
     * Test Setup: assertEquals is used to check if the conditions are true or false
     * Test Strategy:Condition Test
     * Input: Jet Blue
     * Expected Output: True, true, true, true, true
     * Test of isValidFlightName method, of class AddFlight.
     */
    @Test
    public void testIsValidFlightName() {
        assertEquals(false, AddFlight.isValidFlightName(" "));
        assertEquals(true, AddFlight.isValidFlightName("aa"));
        assertEquals(false, AddFlight.isValidFlightName("!"));
        assertEquals(false, AddFlight.isValidFlightName("\n"));
        assertEquals(false, AddFlight.isValidFlightName("\t"));

    }

    /**
     * Test Case ID: UnitTest-Time-008
     * Requirement: R-27: Users must be required to enter a 
     * valid Flight Time for a new flight
     * Purpose: To test the input passed to the method isValidateTime,
     * ensures the time entered is valid and accurate
     * Test Setup: 
     * Test Strategy:
     * Input: 
     * Expected Output:
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
     * Test Case ID: UnitTest-Cost-009
     * Requirement: 
     * Purpose: 
     * Test Setup: 
     * Test Strategy:
     * Input: 
     * Expected Output:
     * Test of isValidCost method, of class AddFlight.
     */
    @Test
    public void testIsValidCost() {
        assertEquals(false, AddFlight.isValidCost(" "));
        assertEquals(true, AddFlight.isValidCost("200"));
        assertEquals(false, AddFlight.isValidCost("asd"));

    }

    /**
     * Test Case ID: UnitTest-Date-010
     * Requirement: 
     * Purpose: 
     * Test Setup: 
     * Test Strategy:
     * Input: 
     * Expected Output:
     * Test of validateDate method, of class AddFlight.
     */
    @Test
    public void testValidateDate() {
        AddFlight instance = new AddFlight();
        String expResult = "2021-01-20";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date testDate = new Date();
        try {
            testDate = df.parse("2021-01-20");
        } catch (ParseException ex) {
            Logger.getLogger(AddFlightTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        String result = instance.validateDate(testDate);
        assertEquals(expResult, result);
    }

}
