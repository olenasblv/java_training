package ua.qa.training.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.qa.training.addressbook.model.ContactData;
import ua.qa.training.addressbook.model.Contacts;
import ua.qa.training.addressbook.model.GroupData;
import ua.qa.training.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by osoboleva on 27.10.2016.
 */
public class ContactGroupAnotherTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        // groups
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName());
        }

        // contacts
        if (app.db().contacts().size() == 0) {
            app.goTo().homePage();
            app.contact().create(new ContactData().withLastName("Last_name_test").withFirstName("First_name_test").withAddress("Address_test")
                    .withHomePhone("123456789").withEmail("email@mail.ru").withHomepage("homepage.com").withBirthdayDay(5)
                    .withBirthdayMonth("April").withBirthdayYear(1990));
        }

        // create group if contact presents in all groups
        Groups contactGroups = app.db().contacts().iterator().next().getGroups();
        Groups allGroups = app.db().groups();
        if (contactGroups.equals(allGroups)) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName());
        }
    }


    @Test
    public void testContactAddToGroup() {
        Contacts beforeContacts = app.db().contacts();
        ContactData contact = beforeContacts.iterator().next();

        Groups groups = app.db().groups();
        groups.removeAll(contact.getGroups());
        GroupData group = groups.iterator().next();

        app.goTo().homePage();
        app.contact().addContactToGroup(contact, group);

        Contacts afterContacts = app.db().contacts();
        ContactData contactWithGroup = afterContacts.iterator().next();

        assertThat(contactWithGroup.getGroups(), equalTo(contact.getGroups().withAdded(group)));
    }
}


