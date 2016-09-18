package ua.qa.training.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    goToAddNewContact();
    fillContactForm(new ContactData("Olena", "Evgenievna", "Soboleva", "osoboleva", "QA", "Exadel", "City, " +
            "street, house,appartments", "123456789", "98765431", "123456", "098765", "123456@mail.ru", "09876@mail.ru",
            "qwerty@mail.ru", "qwerty.com", "1990", "1990", "City2, street2, house2", "12344566545", "nvjfusdoflfd,d"));
    submitContactCreation();
  }

}
