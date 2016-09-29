package ua.qa.training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.qa.training.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        int before = app.getGroupHelper().getGroupCount();
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before + 1);
    }

}
