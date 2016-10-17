package ua.qa.training.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.qa.training.addressbook.appmanager.ContactHelper;
import ua.qa.training.addressbook.model.ContactData;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by osoboleva on 13.10.2016.
 */
public class ContactDetailsPageTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withLastName("Last_name_test").withFirstName("First_name_test").withAddress("Address_test")
                    .withHomePhone("111-111").withMobilePhone("22 22").withWorkPhone("(3)33").withEmail("email@mail.ru").withEmail2("2email@mail.ru")
                    .withGroup("[none]"));
        }
    }

    @Test
    public void testDetailsPage() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromDetailsPage = app.contact().infoFromDetailsPage(contact);

        assertThat(mergeInfoFromEditForm(contact), equalTo(contactInfoFromDetailsPage.getDetails()));

    }

    private String mergeInfoFromEditForm(ContactData contact) {
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        return Stream.of(
                contactInfoFromEditForm.getFirstName(), contactInfoFromEditForm.getLastName(),
                contactInfoFromEditForm.getAddress(),
                contactInfoFromEditForm.getEmail(), contactInfoFromEditForm.getEmail2(),contactInfoFromEditForm.getEmail3(),
                contactInfoFromEditForm.getHomePhone(), contactInfoFromEditForm.getMobilePhone(), contactInfoFromEditForm.getWorkPhone())
                .filter((s) -> s != null && !s.equals(""))
                .map(ContactDetailsPageTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String details) {
        return details
                .replaceAll("[-()]", "")
                .replaceAll("www.test.com", "")
                .replaceAll("H: ", "")
                .replaceAll("M: ", "")
                .replaceAll("W: ", "")
                .replaceAll("\n\n", "\n")
                .replaceFirst(" ","\n")
                .replaceAll(" ","");
    }
}
