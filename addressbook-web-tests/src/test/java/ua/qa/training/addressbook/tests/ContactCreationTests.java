package ua.qa.training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.qa.training.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData("First_name_test", "Last_name_test", "Address_test",
                "123456789", "email@mail.ru", "homepage.com", "20", "April", "1990", "test1");
        app.getContactHelper().createContact(contact);
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

       /* int max = 0;
        for (ContactData c: after){
            if (c.getId() > max) {
                max = c.getId();
            }
        }*/

        before.add(contact);
        Comparator<? super ContactData> byId = ((c1, c2) -> Integer.compare(c1.getId(),c2.getId()));
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
