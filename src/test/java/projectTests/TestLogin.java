package projectTests;
//Lesson 30
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin extends TestBase {

    @BeforeMethod
    public void precondition() {
        if(!app.helperUser().isLogged()) {
            app.helperUser().logOut();
        }
    }

    @Test
    public void loginTestPositive() {
        app.helperUser().openLoginFrom();
        app.helperUser().fillLoginForm("sam@gmail.com", "Sam1234$");
        app.helperUser().submitLogin();

        boolean SingOutIsDisplayed = app.helperUser().SignOutButton();
        Assert.assertTrue(SingOutIsDisplayed);
    }

    @Test
    public void loginTestNegative() {
        app.helperUser().openLoginFrom();
        app.helperUser().fillLoginForm("sam@gmail.com", "Sam12387987$");
        app.helperUser().submitLogin();
        app.helperUser().pause(2000);
        app.helperUser().acceptAlert();
        boolean SingOutIsNotDisplayed = app.helperUser().isLogged();
        Assert.assertTrue(SingOutIsNotDisplayed);
    }

}
