package AirlineProducts.GUI;

import static AirlineProducts.GUI.GuiTestHelperUtils.calculateContrast;
import AirlineProducts.Main;
import java.awt.Color;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JInternalFrameFixture;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Dingr
 */
public class SearchCustomerGuiTest {

    private FrameFixture window;

    @Before
    public void setUp() {
        Main frame = GuiActionRunner.execute(() -> new Main());
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        window.maximize();
    }

    /**
     * Test Case ID: GUITest-MenusShow-001 Requirement: R-4: Users shall be able
     * to search the centralized database for customer information via customer
     * ID or passport. Purpose: To test that user information can be searched
     * for by user ID. Test Setup: Run the application and attempt to search for
     * a user by id. Strategy: White Box Testing Input: Mouse and keyboard
     * commands. Expected Output: N/A
     */
    @Test
    public void customerSearchTest() throws InterruptedException {
        System.out.println("Testing searching for a customer");

        window.menuItem("searchCustomerMI").click();
        JInternalFrameFixture searchCustomerFrame = window.internalFrame("searchCustomerFrame");
        searchCustomerFrame.textBox("customerIDBox").enterText("CS001");
        searchCustomerFrame.button("findButton").click();
        Thread.sleep(100); // wait for the customer to load

        // check that all fields match the customer CS001 in the database
        Assert.assertEquals("john", searchCustomerFrame.textBox("firstNameBox").text());
        Assert.assertEquals("Alex", searchCustomerFrame.textBox("lastNameBox").text());
        Assert.assertEquals("34232222", searchCustomerFrame.textBox("nicNoBox").text());
        Assert.assertEquals("3443", searchCustomerFrame.textBox("passportIdBox").text());
        Assert.assertEquals("Uk", searchCustomerFrame.textBox("addressBox").text());
        Assert.assertEquals("34324234", searchCustomerFrame.textBox("contactBox").text());
        searchCustomerFrame.radioButton("maleRadioButton").requireSelected(true);
        searchCustomerFrame.radioButton("femaleRadioButton").requireSelected(false);

    }

    /**
     * Test Case ID: GUITest-MenusShow-001 Requirement: R-32: Users should be
     * able to choose one gender. Purpose: To test that user can select only one
     * gender. Test Setup: Run the application and attempt to select multiple
     * genders. Strategy: White Box Testing Input: Mouse and keyboard commands.
     * Expected Output: N/A
     */
    @Test
    public void onlyOneGenerSelectable() throws InterruptedException {
        System.out.println("Testing searching for a customer");

        window.menuItem("searchCustomerMI").click();
        JInternalFrameFixture searchCustomerFrame = window.internalFrame("searchCustomerFrame");

        searchCustomerFrame.radioButton("maleRadioButton").click();

        searchCustomerFrame.radioButton("maleRadioButton").requireSelected();
        searchCustomerFrame.radioButton("femaleRadioButton").requireNotSelected();

        searchCustomerFrame.radioButton("femaleRadioButton").click();

        searchCustomerFrame.radioButton("maleRadioButton").requireNotSelected();
        searchCustomerFrame.radioButton("femaleRadioButton").requireSelected();

    }

    // just test that pressing the close button hides the window
    @Test
    public void checkCancelButton() {
        System.out.println("Testing Cancel Button for search customer window");

        window.menuItem("searchCustomerMI").click();
        JInternalFrameFixture searchCustomerFrame = window.internalFrame("searchCustomerFrame");
        searchCustomerFrame.requireVisible();
        searchCustomerFrame.button("cancelButton").click();
        searchCustomerFrame.requireNotVisible();
    }

    /**
     * Test Case ID: GUITest-Contrast-003 Requirement: R-33: Windows should no
     * longer be visible after selecting cancel. Purpose: To test that the
     * cancel button closes the window. Test Setup: Runs the application, opens
     * the window, then clicks cancel and checks for visibility. Test Strategy:
     * Equivalence Class Testing Input: Mouse and keyboard commands. Expected
     * Output: true
     */
    @Test
    public void checkTextContrast() {
        window.menuItem("searchCustomerMI").click();
        JInternalFrameFixture searchCustomerFrame = window.internalFrame("searchCustomerFrame");
        Color backgroundColor = searchCustomerFrame.panel("textPanel1").background().target();
        Color firstNameColor = searchCustomerFrame.label("firstNameLabel").foreground().target();

        double contrastRatio = calculateContrast(firstNameColor, backgroundColor);

        /**
         * good contrast should have a value > 3 for large text and > 4.5 for
         * small text
         */
        Assert.assertTrue((contrastRatio >= 4.5));
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }

}
