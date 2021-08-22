package projectTests;

import application.MyDataProvider;
import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactClass extends TestBase {
    @BeforeMethod
    public void precondition() {
        if (app.helperUser().isLogged()) {
            app.helperUser().login(new User().withEmail("sam@gmail.com").withPassword("Sam1234$"));
        }
    }

    @Test(invocationCount = 3)
    public void addContactTestBase() {
        int i = (int) (System.currentTimeMillis()) / 1000 % 3600;
        Contact contact = Contact.builder()
                .name("Contact")
                .lastName("Add")
                .email("add" + i + "@gmail.com")
                .phone("178" + i)
                .address("Haifa")
                .description("friend")
                .build();
        app.contactHelper().openFormContact();
        app.contactHelper().fillFormContact(contact);
        app.contactHelper().saveContact();
        Assert.assertTrue(app.contactHelper().isContactAdded(contact.getPhone()));
    }

    @Test(dataProvider = "dataContactCSV", dataProviderClass = MyDataProvider.class)
    public void addContactTestBaseCSV(Contact contact) {
        app.contactHelper().openFormContact();
        app.contactHelper().fillFormContact(contact);
        app.contactHelper().saveContact();
        Assert.assertTrue(app.contactHelper().isContactAdded(contact.getPhone()));
    }

    @Test(dataProvider = "dataContactDP", dataProviderClass = MyDataProvider.class)
    public void addContactTestDataProvider(String name, String lastname, String phone, String email, String address, String description) {
        Contact contact = Contact.builder()
                .name(name)
                .lastName(lastname)
                .email(email)
                .phone(phone)
                .address(address)
                .description(description)
                .build();

        app.contactHelper().openFormContact();
        app.contactHelper().fillFormContact(contact);
        app.contactHelper().saveContact();
        Assert.assertTrue(app.contactHelper().isContactAdded(contact.getPhone()));
    }

    @Test(dataProvider = "negativeDataContactCSV", dataProviderClass = MyDataProvider.class)
    public void negativeAddContactTestBaseCSV(Contact contact) {
        app.contactHelper().openFormContact();
        app.contactHelper().fillFormContact(contact);
        app.contactHelper().saveContact();
        String currUrl = app.getUrl();
        Assert.assertTrue(currUrl.contains("https://contacts-app.tobbymarshall815.vercel.app/add"), "Current URL: " + app.getUrl());
        if (currUrl.contains("https://contacts-app.tobbymarshall815.vercel.app/add")) {
            app.contactHelper().clearAllFields();
        }
    }
}