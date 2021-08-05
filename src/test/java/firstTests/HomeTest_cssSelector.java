package firstTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTest_cssSelector {

    WebDriver wd;

    @BeforeMethod
    public void openChrome() {
        wd = new ChromeDriver();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/login");
    }

    @Test
    public void login() {
       WebElement email = wd.findElement(By.cssSelector("[placeholder='Email']"));
        email.click();
        email.clear();
        email.sendKeys("sam@gmail.com");
        WebElement password = wd.findElement(By.cssSelector("[placeholder='Password']"));
        password.click();
        password.clear();
        password.sendKeys("Sam1234$");
        WebElement buttonLogin = wd.findElement(By.cssSelector("[class='login_login__3EHKB'] button:nth-child(4)"));
        buttonLogin.click();
    }

    @AfterMethod
    public void closeChrome() {
        wd.quit();
    }
}