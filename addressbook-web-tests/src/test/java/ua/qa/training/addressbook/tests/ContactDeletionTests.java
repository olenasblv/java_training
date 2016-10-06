package ua.qa.training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.qa.training.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by osoboleva on 20.09.2016.
 */
public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData().withLastName("Last_name_test").withFirstName("First_name_test").withAddress("Address_test")
                    .withHomePhone("123456789").withEmail1("email@mail.ru").withHomepage("homepage.com").withBirthdayDay("20")
                    .withBirthdayMonth("April").withBirthdayYear("1990").withGroup("test1"));
        }
    }

    @Test
    public void testContactDeletion() {
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().delete(index);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before,after);
    }
}
