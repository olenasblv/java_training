package ua.qa.training.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.qa.training.addressbook.model.ContactData;
import ua.qa.training.addressbook.model.Contacts;
import ua.qa.training.addressbook.model.GroupData;
import ua.qa.training.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContactsFromJson() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
            }.getType());
            return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test 1"));
        }
    }


    @Test(dataProvider = "validContactsFromJson")
    public void testContactCreation(ContactData contact) {
        Contacts before = app.db().contacts();
        Groups groups = app.db().groups();
        app.goTo().homePage();
        File photo = new File("src/test/resources/cat.jpg");
        app.contact().create(contact.withPhoto(photo).inGroup(groups.iterator().next()));
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.withAdded(
                contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
        verifyContactListInUI();
    }

    @Test //(enabled = false)
    public void testBadContactCreation() {
        Contacts before = app.db().contacts();
        Groups groups = app.db().groups();
        app.goTo().homePage();
        ContactData contact = new ContactData().withLastName("Last_name_test'").withFirstName("First_name_test").withAddress("Address_test")
                .withHomePhone("123456789").withEmail("email@mail.ru").withHomepage("homepage.com").withBirthdayDay(5)
                .withBirthdayMonth("April").withBirthdayYear(1990).inGroup(groups.iterator().next());
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before));
        verifyContactListInUI();
    }

    @Test(enabled = false)
    public void testCurrentDir() {
        File currentDir = new File("."); // текущая директория
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/cat.jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }
}
