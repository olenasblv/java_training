package ua.qa.training.mantis.tests;

import org.testng.annotations.Test;

/**
 * Created by osoboleva on 11/1/2016.
 */
public class RegistrationTests  extends TestBase{

    @Test
    public void testRegistration(){
        app.registration().start("user1","user1@localhost.localdomain");

    }
}
