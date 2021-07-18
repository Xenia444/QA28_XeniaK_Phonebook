package tests;
//Lesson 30
import application.Application;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
    protected static Application app = new Application();

    @BeforeClass
    public void setUp() {
        app.init();
    }

    @AfterClass
    public void tearDown() {
        app.stop();
    }
}
