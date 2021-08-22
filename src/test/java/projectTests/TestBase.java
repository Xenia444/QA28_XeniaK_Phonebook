package projectTests;
//Lesson 30
import application.Application;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;


public class TestBase {
    protected static Application app = new Application(System.getProperty("browser", BrowserType.CHROME));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

    @BeforeMethod(alwaysRun = true)
    public void startLogger(Method m, Object[] p) {

        logger.info("Start method: " + m.getName());
        logger.info("Test Start with Data -->"+ Arrays.asList(p) );
        logger.info( "==================================================================");
    }

    @AfterMethod(alwaysRun = true)
    public void endOfLogger(Method m) {

        logger.info("End of method: " + m.getName());
    }
}
