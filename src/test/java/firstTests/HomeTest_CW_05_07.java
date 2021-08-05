package firstTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class HomeTest_CW_05_07 {

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

    @Test
    public void LocatorTest() {
        List<WebElement> list = wd.findElements(By.tagName("a"));
        list.get(2).click();
        //By.tagName()
        wd.findElement(By.tagName("a"));
        wd.findElement(By.tagName("h1"));
        wd.findElement(By.tagName("input"));
        wd.findElement(By.tagName("button"));

     //   wd.findElement(By.cssSelector("a");
     //   wd.findElement(By.cssSelector("button");

        //By.id
        wd.findElement(By.id("root"));

        wd.findElement(By.cssSelector("#root"));
        wd.findElement(By.cssSelector("[id='root']"));

        //By.classname
        wd.findElement(By.className("container"));
        wd.findElement(By.className("active"));

        wd.findElement(By.cssSelector(".container"));
        wd.findElement(By.cssSelector(".active"));
        wd.findElement(By.cssSelector("[class='active']"));

        //By.name()
        //   wd.findElement(By.name("namename"));
        //wd.findElement(By.cssSelector("[name='namename']"));

        //By.linkText()
        wd.findElement(By.linkText("HOME"));
        wd.findElement(By.linkText("ABOUT"));
        wd.findElement(By.partialLinkText("HO"));
        wd.findElement(By.cssSelector("[href='/home']"));

        wd.findElement(By.cssSelector("[placeholder='Password']"));
        //начинается ^=
        wd.findElement(By.cssSelector("[placeholder^='Pas']"));
        //заканчивается $=
        wd.findElement(By.cssSelector("[placeholder$='ord']"));
        //содержит *=
     //   wd.findElement(By.cssSelector("[placeholder$='swo']"));

    }

    @Test
    public void LoginTest() {
        wd.findElement(By.linkText("LOGIN")).click();
        List<WebElement> list = wd.findElements(By.tagName("input"));
        WebElement email = list.get(0);
        WebElement password = list.get(1);
        email.click();
        email.clear();
        email.sendKeys("sam@gmail.com");
        password.click();
        password.clear();
        password.sendKeys("Sam1234$");
        List<WebElement> buttons = wd.findElements(By.tagName("button"));
        buttons.get(0).click();
    }


    @AfterMethod
    public void closeChrome() {
        wd.quit();
    }
}
