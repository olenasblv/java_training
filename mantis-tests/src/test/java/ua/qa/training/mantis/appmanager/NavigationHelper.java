package ua.qa.training.mantis.appmanager;

import org.openqa.selenium.By;
import org.testng.Assert;
import ua.qa.training.mantis.model.Users;

/**
 * Created by osoboleva on 11/6/2016.
 */
public class NavigationHelper extends HelperBase{

    public NavigationHelper(ApplicationManager app) {
        super(app);
    }

    public void login(String username, String password) {
        wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
        type(By.name("username"),username);
        type(By.name("password"),password);
        click(By.cssSelector("input[value='Login']"));
    }

    public boolean isLoggedInAs(String username) {
        String user = wd.findElement(By.id("logged-in-user")).getText();
        return (user.equals(username));
    }

    public void manageUsers() {
        click(By.cssSelector("a.manage-menu-link"));
        click(By.linkText("Manage Users"));
        Assert.assertTrue(isElementPresent(By.cssSelector("input[value='Manage User']")));
    }

    public void chooseUser(Users user) {
        click(By.linkText(user.getName()));
    }

    public void resetPassword() {
        click(By.cssSelector("input[value='Reset Password']"));
    }

}
