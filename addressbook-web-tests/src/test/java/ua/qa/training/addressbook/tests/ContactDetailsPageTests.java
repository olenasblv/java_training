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

        assertThat(contactInfoFromDetailsPage.getDetails(), equalTo(mergeInfoFromEditForm(contact)));
    }





    private String mergeInfoFromEditForm(ContactData contact) {
        return Stream.of(
                fullNameAndAddress(contact),
                allPhones(contact),
                allEmails(contact))
                .filter((s) -> s != null && !s.equals(""))
                .map(ContactDetailsPageTests::cleaned)
                .collect(Collectors.joining("\n\n"));
    }

    private String fullName(ContactData contact){
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        return Stream.of(contactInfoFromEditForm.getFirstName(),contactInfoFromEditForm.getLastName())
                .filter((s) -> s != null && !s.equals(""))
                .map(ContactDetailsPageTests::cleaned)
                .collect(Collectors.joining(" "));
    }

    private String fullNameAndAddress(ContactData contact){
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        return Stream.of(fullName(contact),contactInfoFromEditForm.getAddress())
                .filter((s) -> s != null && !s.equals(""))
                .map(ContactDetailsPageTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    private String allPhones(ContactData contact){
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        return Stream.of(
                ("H: "+contactInfoFromEditForm.getHomePhone()),
                ("M: "+ contactInfoFromEditForm.getMobilePhone()),
                ("W: "+contactInfoFromEditForm.getWorkPhone()))
                .filter((s) -> s != null && !s.equals(""))
                .map(ContactDetailsPageTests::cleaned)
                .collect(Collectors.joining("\n"));
    }


    private String allEmails(ContactData contact){
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        return Stream.of(
                (contactInfoFromEditForm.getEmail()+" (www."+contactInfoFromEditForm.getEmail().substring(contactInfoFromEditForm.getEmail().lastIndexOf("@") +1)+")"),
                (contactInfoFromEditForm.getEmail2()+" (www."+contactInfoFromEditForm.getEmail2().substring(contactInfoFromEditForm.getEmail2().lastIndexOf("@") +1)+")"),
                (contactInfoFromEditForm.getEmail3()+" (www."+contactInfoFromEditForm.getEmail3().substring(contactInfoFromEditForm.getEmail3().lastIndexOf("@") +1)+")"))
                .filter((s) -> s != null && !s.equals(""))
                .map(ContactDetailsPageTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String contact) {
        return contact.trim();
    }
}
