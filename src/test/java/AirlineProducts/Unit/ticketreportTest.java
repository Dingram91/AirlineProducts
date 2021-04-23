/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineProducts.Unit;

import AirlineProducts.DBManager;
import AirlineProducts.ticketreport;
import java.sql.SQLException;
import java.util.Vector;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Dingr
 */
public class ticketreportTest {

/**
     * Test Case ID: UnitTest-LoadData-029
     * Requirement: R-33 The system shall allow a user to generate a ticket report
     * Purpose: To ensure the report pulled in in the correct format
     * Test Setup: The system will test the amount of rows to make sure all
     * data can be diplayed correctly
     * Test Strategy: Whitebox Testing
     * Input:"CS999", "FO500", "First", "990", "1", "2021-05-04"
     * Expected Output: True
     * 
     */
    @Test
    public void LoadDataTest() throws SQLException {
        System.out.println("Load Data Test");
        ticketreport instance = new ticketreport();
        DBManager dbManager = mock(DBManager.class);
        instance.setManager(dbManager);

        // Test 0 rows
        when(dbManager.getTicketReportData()).thenReturn(new Vector<>());
        instance.LoadData();
        assertEquals(0, instance.jTable1.getModel().getRowCount());

        // Test 1 row
        Vector<Vector<String>> testWrapperVector = new Vector<>();
        Vector test1Data = new Vector();
        test1Data.add("CS999");
        test1Data.add("FO500");
        test1Data.add("First");
        test1Data.add("990");
        test1Data.add("1");
        test1Data.add("2021-05-04");
        testWrapperVector.add(test1Data);
        when(dbManager.getTicketReportData()).thenReturn(testWrapperVector);
        instance.LoadData();
        assertEquals(1, instance.jTable1.getModel().getRowCount());

        //test 50 rows
        testWrapperVector.clear();
        for (int x = 0; x < 50; x++) {
            Vector vect = new Vector();
            test1Data.add("CS0" + x);
            test1Data.add("FO5" + x);
            test1Data.add(x % 2 == 0 ? "Coach" : "First");
            test1Data.add(String.valueOf(x * 100));
            test1Data.add(String.valueOf(x));
            test1Data.add("2021-05-" + (x % 30));
            testWrapperVector.add(vect);
        }
        when(dbManager.getTicketReportData()).thenReturn(testWrapperVector);
        instance.LoadData();
        assertEquals(50, instance.jTable1.getModel().getRowCount());

    }
  /**
     * Test Case ID: UnitTest-LoadData-028
     * Requirement: R-34 The system shall allow a user to generate a ticket report
     * Purpose: To check that the data is loaded from DBanger 
     * Test Setup: Throw an exception when the DBManager is called
     * Test Strategy:Mock
     * Input: Mock of DB manager
     * Expected Output: SQL Exception
     * 
     */
    @Test()
    public void testLoadDataException() throws SQLException {
        ticketreport instance = new ticketreport();
        DBManager dbManager = mock(DBManager.class);
        instance.setManager(dbManager);

        when(dbManager.getTicketReportData()).thenThrow(SQLException.class);
        instance.LoadData();

    }

}
