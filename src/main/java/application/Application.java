package application;
//Lesson 30
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;


public class Application {

    WebDriver wd;
    HelperUser helperUser;
    String browser;
    Logger logger = LoggerFactory.getLogger(Application.class);

    public Application(String browser) {
        this.browser = browser;
    }

    public void init() {
        if(browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
            logger.info("Start browser CHROME");
        }else if(browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
            logger.info("Start browser FIREFOX");
        }

        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://contacts-app.tobbymarshall815.vercel.app/about");
        logger.info("Navigate to: " + wd.getCurrentUrl());
        helperUser = new HelperUser(wd);
    }

    public HelperUser helperUser() {
        return helperUser;
    }

    public void stop() {
        wd.quit();
    }
}
