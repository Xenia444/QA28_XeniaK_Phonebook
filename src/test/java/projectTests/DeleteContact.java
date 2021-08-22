package projectTests;

import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContact extends TestBase{
    @BeforeMethod
    public void precondition() {
        if(app.helperUser().isLogged()) {
            app.helperUser().login(new User().withEmail("sam@gmail.com").withPassword("Sam1234$"));
        }
    }

    @Test
    public void removeOneContact() {
        app.contactHelper().removeContact();

    }

    @Test
    public void removeAllContacts() {
        app.contactHelper().removeAllContacts();

    }
}
