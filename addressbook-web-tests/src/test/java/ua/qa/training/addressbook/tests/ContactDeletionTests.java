package ua.qa.training.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by osoboleva on 20.09.2016.
 */
public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().submitContactDeletion();
    }
}
