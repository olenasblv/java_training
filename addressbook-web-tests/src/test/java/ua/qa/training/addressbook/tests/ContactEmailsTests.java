package ua.qa.training.addressbook.tests;

import org.testng.annotations.Test;
import ua.qa.training.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by osoboleva on 12.10.2016.
 */
public class ContactEmailsTests extends TestBase {

    @Test
    public void testContactEmails() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    }

    private String mergeEmails(ContactData contact) {
        return Stream.of(contact.getEmail(), contact.getEmail2(), contact.getEmail3()).filter((s) -> !s.equals("")).collect(Collectors.joining("\n"));
    }

    /*public static String cleaned(String phone){
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
    }*/
}
//kkkjmjpj