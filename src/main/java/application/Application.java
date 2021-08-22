package application;
//Lesson 30
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Application {

    EventFiringWebDriver wd;
    HelperUser helperUser;
    String browser;
    Logger logger = LoggerFactory.getLogger(Application.class);
    ContactHelper contactHelper;

    public Application(String browser) {
        this.browser = browser;
    }

    public void init() {
        if(browser.equals(BrowserType.CHROME)) {
            wd = new EventFiringWebDriver(new ChromeDriver());
            logger.info("Start browser CHROME");
        }else if(browser.equals(BrowserType.FIREFOX)) {
            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("Start browser FIREFOX");
        }
        wd.register(new MyListener());
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://contacts-app.tobbymarshall815.vercel.app/about");
        logger.info("Navigate to: " + wd.getCurrentUrl());
        helperUser = new HelperUser(wd);
        contactHelper = new ContactHelper(wd);
    }

    public HelperUser helperUser() {
        return helperUser;
    }

    public ContactHelper contactHelper() {
        return contactHelper;
    }

    public void stop() {
        wd.quit();
    }

    public String getUrl() {
       return wd.getCurrentUrl();
    }
}
