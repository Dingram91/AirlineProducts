/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineProducts;

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
        assertEquals(true, AddFlight.isValidCost("200"));
        assertEquals(false, AddFlight.isValidCost("asd"));

    }

    /**
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
