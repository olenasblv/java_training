package ua.qa.training.addressbook.tests;

import org.testng.annotations.Test;
import ua.qa.training.addressbook.model.GroupData;

/**
 * Created by osoboleva on 20.09.2016.
 */
public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("test4", "test5", "test6"));
        app.getGroupHelper().submitGroupModofocation();
        app.getGroupHelper().returnToGroupPage();
    }
}
