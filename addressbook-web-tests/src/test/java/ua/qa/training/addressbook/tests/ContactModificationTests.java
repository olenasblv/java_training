package ua.qa.training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;
import ua.qa.training.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by osoboleva on 20.09.2016.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("First_name_test", "Last_name_test", "Address_test", "123456789",
                    "email@mail.ru", "homepage.com", "20", "April", "1990", "test1"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactModification(before.size() - 1);
        ContactData contact = new ContactData(null, null, "Address_test1", null, "email_1@mail.ru",
                "homepage_1.com", "20", "April", "1990", null);
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
