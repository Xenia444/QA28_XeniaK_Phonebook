package tests;
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

}
