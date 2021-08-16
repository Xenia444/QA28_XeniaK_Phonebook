package application;
//Lesson 30
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class HelperBase {

    WebDriver wd;
    Logger logger = LoggerFactory.getLogger(HelperBase.class);

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if(text != null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    void clear(By locator) {
        String text = wd.findElement(locator).getText();
        if(text != null) {
            wd.findElement(locator).clear();
        }
    }

    public void pause(int millise) {
        try {
            Thread.sleep(millise);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void  takeScreenshot(String pathFile) {
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(pathFile);
        try {
            Files.copy(tmp,screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
