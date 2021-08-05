package firstTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTest {

    WebDriver wd;

    @BeforeMethod
    public void openChrome() {
        wd = new ChromeDriver();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
    }

    @Test
    public void AboutTest() {
        List<WebElement> list = wd.findElements(By.tagName("a"));
        WebElement element = list.get(1);
        element.click();
        WebElement element2 = list.get(0);
        element2.click();
    }

    @AfterMethod
    public void closeChrome() {
        wd.quit();
    }
}