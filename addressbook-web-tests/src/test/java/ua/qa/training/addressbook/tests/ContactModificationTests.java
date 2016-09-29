package ua.qa.training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.qa.training.addressbook.model.ContactData;

/**
 * Created by osoboleva on 20.09.2016.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        if(! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("First_name_test", "Last_name_test", "Address_test", "123456789",
                    "email@mail.ru", "homepage.com", "20", "April", "1990", "test1"));
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData(null, null, "Address_test1", null, "email_1@mail.ru",
                "homepage_1.com", "20", "April", "1990", null), false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);
    }
}
