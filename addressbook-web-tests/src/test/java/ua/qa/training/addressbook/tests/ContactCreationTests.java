package ua.qa.training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.qa.training.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().createContact(new ContactData("First_name_test", "Last_name_test", "Address_test",
            "123456789", "email@mail.ru", "homepage.com", "20", "April", "1990", "test1"));
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
  }
}
