package application;
//Lesson 30
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Application {

    WebDriver wd;
    HelperUser helperUser;

    public void init() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://contacts-app.tobbymarshall815.vercel.app/about");
        helperUser = new HelperUser(wd);
    }

    public HelperUser helperUser() {
        return helperUser;
    }

    public void stop() {
        wd.quit();
    }
}
