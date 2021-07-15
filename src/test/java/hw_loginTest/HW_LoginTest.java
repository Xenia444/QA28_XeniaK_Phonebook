package hw_loginTest;
//Homework for the lesson 29
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW_LoginTest extends TestBase {

    @Test
    public void loginTest() {
        click(By.xpath("//a[@href='/login']"));

        type(By.xpath("//input[@placeholder='Email']"), "sam@gmail.com");
        type(By.xpath("//input[@placeholder='Password']"), "Sam1234$");

        click(By.xpath("//button[text()=' Login']"));

        Assert.assertTrue(wd.findElement(By.xpath("//button[text()='Sign Out']")).isDisplayed());
    }
}
