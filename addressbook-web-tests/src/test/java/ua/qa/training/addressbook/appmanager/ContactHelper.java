package ua.qa.training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ua.qa.training.addressbook.model.ContactData;

/**
 * Created by osoboleva on 9/18/2016.
 */
public class ContactHelper extends HelperBase {

    NavigationHelper navigation = new NavigationHelper(wd);

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("email"), contactData.getEmail1());
        type(By.name("homepage"), contactData.getHomepage());

        Select birthdayDay = new Select(wd.findElement(By.xpath("//div[@id='content']/form/select[1]")));
        birthdayDay.selectByVisibleText(contactData.getBirthdayDay());

        Select birthdayMonth = new Select(wd.findElement(By.xpath("//div[@id='content']/form/select[2]")));
        birthdayMonth.selectByVisibleText(contactData.getBirthdayMonth());

        type(By.name("byear"), contactData.getBirthdayYear());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }


    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void initContactModification() {
        click(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void deleteSelectedContacts() {
        click(By.xpath(".//*[@id='content']/form[2]/div[2]/input"));
    }

    public void submitContactDeletion() {
        wd.switchTo().alert().accept();
    }

    public void createContact(ContactData contact) {
        navigation.goToAddNewContact();
        fillContactForm(contact, true);
        submitContactCreation();
        navigation.goToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }
}

