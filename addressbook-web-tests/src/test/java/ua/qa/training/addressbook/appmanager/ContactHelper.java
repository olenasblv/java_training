package ua.qa.training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ua.qa.training.addressbook.model.ContactData;

/**
 * Created by osoboleva on 9/18/2016.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickName());
    //click(By.name("photo"));
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("fax"), contactData.getFax());
    type(By.name("email"), contactData.getEmail1());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
    type(By.name("homepage"), contactData.getHomePage());

    Select birthdayDay = new Select(wd.findElement(By.xpath("//div[@id='content']/form/select[1]")));
    birthdayDay.selectByVisibleText("12");

    Select birthdayMonth = new Select(wd.findElement(By.xpath("//div[@id='content']/form/select[2]")));
    birthdayMonth.selectByVisibleText("April");

    type(By.name("byear"), contactData.getBirthdayYear());

    Select anniversaryDay = new Select(wd.findElement(By.xpath("//div[@id='content']/form/select[3]")));
    anniversaryDay.selectByVisibleText("10");

    Select anniversaryMonth = new Select(wd.findElement(By.xpath("//div[@id='content']/form/select[4]")));
    anniversaryMonth.selectByVisibleText("December");

    type(By.name("ayear"), contactData.getAnniversaryYear());

    Select group = new Select(wd.findElement(By.xpath("//div[@id='content']/form/select[5]")));
    group.selectByIndex(2);

    type(By.name("address2"), contactData.getAddress2());
    type(By.name("phone2"), contactData.getPhone2());
    type(By.name("notes"), contactData.getNotes());
  }
}
