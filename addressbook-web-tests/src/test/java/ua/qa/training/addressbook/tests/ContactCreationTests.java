package ua.qa.training.addressbook.tests;

import org.testng.annotations.Test;
import ua.qa.training.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().goToAddNewContact();
    app.getContactHelper().fillContactForm(new ContactData("First_name_test", "Last_name_test", "Address_test", "123456789", "email@mail.ru", "homepage.com", "20", "April", "1990", "test1"), true);
    app.getContactHelper().submitContactCreation();
  }

}
