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
public class ticketReportGuiTest {

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

    @Test
    public void checkTextContrast() {
        window.menuItem("ticketReportMI").click();
        JInternalFrameFixture searchCustomerFrame = window.internalFrame("ticketReportFrame");
        Color backgroundColor = searchCustomerFrame.button("cancelButton").background().target();
        Color firstNameColor = searchCustomerFrame.button("cancelButton").foreground().target();

        System.out.println(backgroundColor + ", " + firstNameColor);

        double contrastRatio = calculateContrast(firstNameColor, backgroundColor);

        System.out.println(contrastRatio);
        /**
         * good contrast should have a value > 3 for large text and > 4.5 for
         * small text
         */
        Assert.assertTrue((contrastRatio >= 4.5));
    }
}
