package ua.qa.training.addressbook.tests;

import org.testng.annotations.Test;
import ua.qa.training.addressbook.model.ContactData;

/**
 * Created by osoboleva on 20.09.2016.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData(null, null, "Address_test1", null, "email_1@mail.ru", "homepage_1.com", "20", "April", "1990", null), false);
        app.getContactHelper().submitContactModification();
    }
}
