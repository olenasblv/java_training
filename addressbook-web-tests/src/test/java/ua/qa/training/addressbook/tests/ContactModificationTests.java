package ua.qa.training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.qa.training.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.Set;

/**
 * Created by osoboleva on 20.09.2016.
 */
public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withLastName("Last_name_test").withFirstName("First_name_test").withAddress("Address_test")
                    .withHomePhone("123456789").withEmail1("email@mail.ru").withHomepage("homepage.com").withBirthdayDay("20")
                    .withBirthdayMonth("April").withBirthdayYear("1990").withGroup("test1"));
        }
    }

    @Test
    public void testContactModification() {
        Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withLastName("Last_name_Mod").withFirstName("First_name_Mod").withAddress("Address_testMod")
                .withHomePhone("123456789").withEmail1("email@mail.ru").withHomepage("homepage.com").withBirthdayDay("20")
                .withBirthdayMonth("April").withBirthdayYear("1990");
        app.contact().modify(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedContact);
        before.add(contact);
        Assert.assertEquals(before, after);
    }


}
