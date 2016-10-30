package ua.qa.training.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.qa.training.addressbook.model.ContactData;
import ua.qa.training.addressbook.model.Contacts;
import ua.qa.training.addressbook.model.GroupData;
import ua.qa.training.addressbook.model.Groups;

import javax.persistence.Table;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by osoboleva on 10/30/2016.
 */
public class ContactRemoveGroupTest extends TestBase {

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
    }

    @Test
    public void testContactRemoveGroup() {

        Groups groups = app.db().groups();
        GroupData group = groups.iterator().next();

        Contacts beforeContacts = app.db().contacts();
        ContactData contact;

        List<ContactData> contactsWithGroups = beforeContacts.stream().filter(c -> c.getGroups().size() != 0).collect(Collectors.toList());
        if (contactsWithGroups.size() == 0) {
            app.goTo().homePage();
            app.contact().addContactToGroup(beforeContacts.iterator().next(), group);

            beforeContacts = app.db().contacts();
            contact = beforeContacts.iterator().next();
        } else {
            contact = contactsWithGroups.iterator().next();
        }

        groups.retainAll(contact.getGroups());
        GroupData groupWithContact = groups.iterator().next();

        app.goTo().homePage();
        app.contact().removeContactFromGroup(contact, groupWithContact);

        Contacts afterContacts = app.db().contacts();
        ContactData afterContact = afterContacts.iterator().next();

        assertThat(afterContact.getGroups(), equalTo(contact.getGroups().without(groupWithContact)));
    }
}