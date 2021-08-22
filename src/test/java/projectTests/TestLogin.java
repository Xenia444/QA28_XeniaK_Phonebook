package projectTests;

import application.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        logger.info("Test passed");
    }

    @DataProvider
    public Iterator<Object[] > validDataLogin(){
        List<Object[]> list= new ArrayList<>();
        list.add(new Object[]{"sam@gmail.com","Sam1234$"});
        list.add(new Object[]{"sam@gmail.com","Sam1234$"});
        list.add(new Object[]{"sam@gmail.com","Sam1234$"});

        return list.iterator();
    }


    @Test(dataProvider = "validDataLogin")
    public void loginTestPositiveProvider(String email, String password) {
        User user = new User()
                .withEmail(email)
                .withPassword(password);
        app.helperUser().openLoginFrom();
        app.helperUser().fillLoginRegForm(user);
        app.helperUser().submitLogin();

        boolean SingOutIsDisplayed = app.helperUser().SignOutButton();
        Assert.assertTrue(SingOutIsDisplayed);
        logger.info("Test passed");
    }

    @Test(dataProvider = "validDataLogin", dataProviderClass = MyDataProvider.class)
    public void loginTestPositiveProviderClass(String email, String password) {
        User user = new User()
                .withEmail(email)
                .withPassword(password);
        app.helperUser().openLoginFrom();
        app.helperUser().fillLoginRegForm(user);
        app.helperUser().submitLogin();

        boolean SingOutIsDisplayed = app.helperUser().SignOutButton();
        Assert.assertTrue(SingOutIsDisplayed);
        logger.info("Test passed");
    }

    @Test(dataProvider = "dataFileCSV", dataProviderClass = MyDataProvider.class)
    public void loginTestDP(User user) {
        app.helperUser().openLoginFrom();
        app.helperUser().pause(1500);
        app.helperUser().fillLoginRegForm(user);
        app.helperUser().submitLogin();

        boolean SingOutIsDisplayed = app.helperUser().SignOutButton();
        Assert.assertTrue(SingOutIsDisplayed);
        logger.info("Test passed");
    }

    @Test
    public void loginTestPositive2() {
        User user = new User()
                .withEmail("sam@gmail.com")
                .withPassword("Sam1234$");
        app.helperUser().openLoginFrom();
        app.helperUser().fillLoginRegForm(user);
        app.helperUser().submitLogin();

        boolean SingOutIsDisplayed = app.helperUser().SignOutButton();
        Assert.assertTrue(SingOutIsDisplayed);
        logger.info("Test passed");
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
        logger.info("Test passed");
    }

}
