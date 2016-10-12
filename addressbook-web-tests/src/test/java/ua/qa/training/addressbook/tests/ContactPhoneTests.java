package ua.qa.training.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ua.qa.training.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by osoboleva on 11.10.2016.
 */
public class ContactPhoneTests extends TestBase{

    @Test
    public void testContactPhones(){
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getHomePhone(), equalTo(cleaned(contactInfoFromEditForm.getHomePhone())));
        assertThat(contact.getMobilePhone(), equalTo(cleaned(contactInfoFromEditForm.getMobilePhone())));
        assertThat(contact.getWorkPhone(), equalTo(cleaned(contactInfoFromEditForm.getWorkPhone())));
    }

    public String cleaned(String phone){
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
    }
}

//   \\s - пробелный символ,   a-z - заменить любую букву, которая находится между a и z