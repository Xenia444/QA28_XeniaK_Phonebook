import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class w3schools {

    WebDriver wd;

    @BeforeMethod
    public void openChrome() {
        wd = new ChromeDriver();
        wd.navigate().to("https://www.w3schools.com/css/css_table.asp");
    }

    @Test
    public void Italy() {
        wd.findElement(By.cssSelector("[id='customers'] tr:last-child td:last-child"));
    }

    @AfterMethod
    public void closeChrome() {
        wd.quit();
    }
}
