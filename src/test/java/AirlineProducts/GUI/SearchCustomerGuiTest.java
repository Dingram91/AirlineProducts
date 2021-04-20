package AirlineProducts.GUI;

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

    // Calculates the relative luminance (birghtness based on the human eye)
    double calculateColorLuminance(Color c) {

        double normRed = c.getRed() / 255;
        double normGreen = c.getGreen() / 255;
        double normBlue = c.getBlue() / 255;

        double r = (normRed <= 0.03928) ? (normRed * 12.92) : (Math.pow((normRed + 0.055) / 1.055, 2.4));
        double g = (normGreen <= 0.03928) ? (normGreen * 12.92) : (Math.pow((normGreen + 0.055) / 1.055, 2.4));
        double b = (normBlue <= 0.03928) ? (normBlue * 12.92) : (Math.pow((normBlue + 0.055) / 1.055, 2.4));
//        return ((normRed * 0.299) + (normGreen * 0.587)
//                + (normBlue * 0.114));
        return (0.2126 * r) + (0.7152 * g) + (0.0722 * b);
    }

    double calculateContrast(Color c1, Color c2) {
        double c1Luminance = calculateColorLuminance(c1) + 0.05;
        double c2Luminance = calculateColorLuminance(c2) + 0.05;
        System.out.println("c1 lum = " + c1Luminance);
        System.out.println("c2 lum = " + c2Luminance);
        double larger = Math.max(c1Luminance, c2Luminance);
        double smaller = Math.min(c1Luminance, c2Luminance);
        double ratio = larger / smaller;
        return ratio;

    }

}
