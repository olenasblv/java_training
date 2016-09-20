package ua.qa.training.addressbook.tests;

import org.testng.annotations.Test;
import ua.qa.training.addressbook.model.ContactData;

/**
 * Created by osoboleva on 20.09.2016.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().initContactModifiction();
        app.getContactHelper().fillContactForm(new ContactData("Olena1", "Evgenievna1", "Soboleva1", "osoboleva1", "QA1", "Exadel1", "City1, " +
                "street, house,appartments", "1234567891", "987654311", "1234561", "0987651", "123456@mail.ru1", "09876@mail.ru1",
                "qwerty@mail.ru1", "qwerty.com1", "19901", "19901", "City21, street2, house2", "123445665451", "nvjfusdoflfd,d1"));
        app.getContactHelper().submitContactModification();
    }
}
