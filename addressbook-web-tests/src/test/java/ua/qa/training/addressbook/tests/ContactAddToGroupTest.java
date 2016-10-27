package ua.qa.training.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.qa.training.addressbook.appmanager.ContactHelper;
import ua.qa.training.addressbook.model.ContactData;
import ua.qa.training.addressbook.model.GroupData;
import ua.qa.training.addressbook.model.Groups;

/**
 * Created by osoboleva on 27.10.2016.
 */
public class ContactAddToGroupTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditionsGroups() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @BeforeMethod
    public void ensurePreconditionsContacts() {
        if (app.db().contacts().size() == 0) {
            Groups groups = app.db().groups();
            app.goTo().homePage();
            app.contact().create(new ContactData().withLastName("Last_name_test").withFirstName("First_name_test").withAddress("Address_test")
                    .withHomePhone("123456789").withEmail("email@mail.ru").withHomepage("homepage.com").withBirthdayDay(5)
                    .withBirthdayMonth("April").withBirthdayYear(1990).inGroup(groups.iterator().next()));
        }
    }


    @Test
    public void testContactAddToGroup(ContactData contact){
        app.goTo().homePage();
        app.contact().selectContactById(contact.getId());

    }

}
