package ua.qa.training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by osoboleva on 9/18/2016.
 */
public class NavigationHelper extends HelperBase {


  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void goToGroupPage() {
    click(By.linkText("groups"));
  }

  public void goToAddNewContact() {
    click(By.linkText("add new"));
  }

    public void goToHomePage() {
      click(By.linkText("home"));
    }
}
