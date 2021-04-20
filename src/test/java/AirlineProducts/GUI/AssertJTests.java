package AirlineProducts.GUI;

import AirlineProducts.Main;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JMenuItemFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Dingr
 */
public class AssertJTests {

    private FrameFixture window;

    @Before
    public void setUp() {
        Main frame = GuiActionRunner.execute(() -> new Main());
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
    }

    @Test
    public void firstTest() {
        System.out.println("test");

        JMenuItemFixture addCustomer = window.menuItem("mi_add_customer");

//        ComponentFinder finder = BasicComponentFinder.finderWithNewAwtHierarchy();
//        finder.findByName("mi_add_customer");
//        window.menuItem("Search Customer").click();
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }

}
