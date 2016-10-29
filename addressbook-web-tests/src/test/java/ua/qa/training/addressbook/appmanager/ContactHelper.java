package ua.qa.training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ua.qa.training.addressbook.model.ContactData;
import ua.qa.training.addressbook.model.Contacts;
import ua.qa.training.addressbook.model.GroupData;
import ua.qa.training.addressbook.model.Groups;

import java.util.List;

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
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("email"), contactData.getEmail());
        type(By.name("homepage"), contactData.getHomepage());
        type(By.name("byear"), Integer.toString(contactData.getBirthdayYear()));
        attach(By.name("photo"), contactData.getPhoto());

        if (contactData.getBirthdayDay() != 0) {
            Select birthdayDay = new Select(wd.findElement(By.name("bday")));
            birthdayDay.selectByIndex(contactData.getBirthdayDay());
        }

        if (contactData.getBirthdayMonth() != null) {
            Select birthdayMonth = new Select(wd.findElement(By.name("bmonth")));
            birthdayMonth.selectByVisibleText(contactData.getBirthdayMonth());
        }

        if (creation) {
            if (contactData.getGroups().size() > 0) {
                Assert.assertTrue(contactData.getGroups().size() == 1);
                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
            }
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    private void selectGroup(GroupData groupData) {
        new Select(wd.findElement(By.name("to_group"))).selectByValue(Integer.toString(groupData.getId()));
    }

    public void initContactModification(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector("input[value='" + id + "']"));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        row.findElement(By.xpath(".//td[8]/a")).click();
    }

    private void initContactModificationById(int id) {
        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();

        /*WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();*/

        //wd.findElement(By.xpath(String.format("//input[value='%s']./../../td[8]/a",id))).click();
        //wd.findElement(By.xpath(String.format("//tr[.//input[value='%s']]/td[8]/a"))).click();

    }

    private void openContactDetailsById(int id) {
        wd.findElement(By.cssSelector(String.format("a[href='view.php?id=%s']", id))).click();

        //wd.findElement(By.xpath(String.format("//input[value='%s']./../../td[7]/a",id))).click();
        //wd.findElement(By.xpath(String.format("//tr[.//input[value='%s']]/td[7]/a"))).click();
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void submitContactAdditionToGroup() {
        click(By.name("add"));
    }

    public void removeContactFromGroupBtn() {
        click(By.name("add"));
    }

    public void goToCurrentGroupPage() {
        wd.findElement(By.xpath(".//*[@id='content']/div/i/a")).click();
    }

    public void deleteSelectedContacts() {
        click(By.xpath(".//*[@id='content']/form[2]/div[2]/input"));
    }

    public void submitContactDeletion() {
        wd.switchTo().alert().accept();
        navigation.homePage();
    }

    public void create(ContactData contact) {
        navigation.goToAddNewContact();
        fillContactForm(contact, true);
        submitContactCreation();
        contactCache = null;
        navigation.homePage();
    }

    public void modify(ContactData contact) {
        initContactModification(contact.getId());
        fillContactForm(contact, false);
        submitContactModification();
        contactCache = null;
        navigation.homePage();
    }

    public void delete(ContactData сontact) {
        selectContactById(сontact.getId());
        deleteSelectedContacts();
        submitContactDeletion();
        contactCache = null;
    }

    public void addContactToGroup(ContactData contact, GroupData group) {
        selectContactById(contact.getId());
        selectGroup(group);
        submitContactAdditionToGroup();
        goToCurrentGroupPage();
    }

    public void removeContactFromGroup(ContactData contact) {
        selectContactById(contact.getId());
        removeContactFromGroupBtn();
        goToCurrentGroupPage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            String address = cells.get(3).getText();
            String allEmails = cells.get(4).getText();
            String allPhones = cells.get(5).getText();
            ContactData contact = new ContactData().withId(id).withLastName(lastName).withFirstName(firstName)
                    .withAddress(address).withAllPhones(allPhones).withAllEmails(allEmails);
            contactCache.add(contact);
        }
        return new Contacts(contactCache);
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
                .withAddress(address)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
                .withEmail(email).withEmail2(email2).withEmail3(email3);
    }


    public ContactData infoFromDetailsPage(ContactData contact) {
        openContactDetailsById(contact.getId());
        String contactDetails = wd.findElement(By.id("content")).getText();
        wd.navigate().back();
        return new ContactData().withDetails(contactDetails);
    }

}

