package ua.qa.training.mantis.appmanager;

import org.openqa.selenium.By;

/**
 * Created by osoboleva on 11/1/2016.
 */
public class RegistrationHelper extends HelperBase {

    public RegistrationHelper(ApplicationManager app) {
        super(app);
    }

    public void start(String username, String email) {
        wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
        type(By.name("username"), username);
        type(By.name("email"), email);
        click(By.cssSelector("input[value='Signup']"));
    }
}
