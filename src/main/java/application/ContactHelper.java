package application;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void openFormContact() {
        click(By.xpath("//a[.='ADD']"));
    }

    public void fillFormContact(Contact contact) {
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());
    }

    public void saveContact() {
        click(By.xpath("//button/b"));
    }

    public boolean isContactAdded(String name) {
        List<WebElement> contacts = wd.findElements(By.xpath("//h3"));
        for (WebElement el: contacts) {
            if(el.getText().contains(name)) {
                System.out.println(el.getText());
                return true;
            }
        }
        return false;
    }

    public void removeContact() {
        if(wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size() > 0) {
            WebElement contact = wd.findElement(By.cssSelector(".contact-item_card__2SOIM"));
            contact.click();
            click(By.xpath("//button[.='Remove']"));
        }
    }

    public void removeAllContacts() {
    //    List<WebElement> contacts = wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));
//        for (WebElement el: contacts) {
//            el.click();
//            click(By.xpath("//button[.='Remove']"));
//        }
        if(wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size() > 0) {
            while (wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size() != 0) {
                removeContact();
                pause(1000);
            }
        }
    }

    public void goToContactPage() {
        click(By.xpath("//*[@href='/contacts']"));
    }

    public void clearAllFields() {
        click(By.cssSelector("[placeholder='Name']"));
        clear(By.cssSelector("[placeholder='Name']"));
        click(By.cssSelector("[placeholder='Last Name']"));
        clear(By.cssSelector("[placeholder='Last Name']"));
        click(By.cssSelector("[placeholder='Phone']"));
        clear(By.cssSelector("[placeholder='Phone']"));
        click(By.cssSelector("[placeholder='email']"));
        clear(By.cssSelector("[placeholder='email']"));
        click(By.cssSelector("[placeholder='Address']"));
        clear(By.cssSelector("[placeholder='Address']"));
    }

}
