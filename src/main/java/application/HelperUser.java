package application;
//Lesson 30
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginFrom() {
        click(By.xpath("//a[.='LOGIN']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath("//input[@placeholder='Email']"), email);
        type(By.xpath("//input[@placeholder='Password']"), password);
    }

    public void submitLogin() {
        click(By.xpath("//button[.=' Login']"));
    }

    public boolean SignOutButton() {
        return wd.findElement(By.xpath("//button[.='Sign Out']")).isDisplayed();
    }

    public Boolean isLogged() {
        return wd.findElements(By.xpath("//a[.='LOGIN']")).size() > 0;
    }

    public void logOut() {
        click(By.xpath("//button[.='Sign Out']"));
    }

    public void acceptAlert() {
        wd.switchTo().alert().accept();
    }
}
