/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class ticketGuiTest {

    private FrameFixture window;

    @Before
    public void setUp() {
        Main frame = GuiActionRunner.execute(() -> new Main());
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        window.maximize();
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }

    /**
     * Test Case ID: GUITest-Contrast-002 Requirement: R-36: The GUI shall use
     * colors that make text easily legible and different parts of the current
     * screen distinguishable. Purpose: To test that the screen background and
     * font colors. input passed to the method mouse and keyboard commands,
     * ensures the font and background have a sufficient amount of contrast.
     * Test Setup: This test is setup to determine if the font and background
     * have a sufficient level of contrast. Test Strategy: Equivalence Class
     * Testing Input: Mouse and keyboard commands. Expected Output: true
     */
    @Test
    public void checkTextContrast() {
        window.menuItem("bookTickitMI").click();
        JInternalFrameFixture searchCustomerFrame = window.internalFrame("TicketFrame");
        Color backgroundColor = searchCustomerFrame.panel("ticketPanel1").background().target();
        Color firstNameColor = searchCustomerFrame.panel("ticketPanel1").foreground().target();

        double contrastRatio = calculateContrast(firstNameColor, backgroundColor);

        /**
         * good contrast should have a value > 3 for large text and > 4.5 for
         * small text
         */
        Assert.assertTrue((contrastRatio >= 4.5));
    }
}
