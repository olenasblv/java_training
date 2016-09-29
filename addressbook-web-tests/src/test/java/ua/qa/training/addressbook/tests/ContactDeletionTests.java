package ua.qa.training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.qa.training.addressbook.model.ContactData;
import ua.qa.training.addressbook.model.GroupData;

/**
 * Created by osoboleva on 20.09.2016.
 */
public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("First_name_test", "Last_name_test", "Address_test", "123456789",
                    "email@mail.ru", "homepage.com", "20", "April", "1990", "test1"));
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact(before - 1);
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().submitContactDeletion();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before - 1);
    }
}
