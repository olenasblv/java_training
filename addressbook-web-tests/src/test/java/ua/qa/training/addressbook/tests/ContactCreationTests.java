package ua.qa.training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.qa.training.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData().withLastName("Last_name_test").withFirstName("First_name_test").withAddress("Address_test")
                .withHomePhone("123456789").withEmail1("email@mail.ru").withHomepage("homepage.com").withBirthdayDay("20")
                .withBirthdayMonth("April").withBirthdayYear("1990").withGroup("test1");
        app.contact().create(contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byId = ((c1, c2) -> Integer.compare(c1.getId(),c2.getId()));
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
