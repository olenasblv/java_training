package ua.qa.training.addressbook.tests;

import org.testng.annotations.Test;
import ua.qa.training.addressbook.model.GroupData;
import ua.qa.training.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test2");
        app.group().create(group);
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size() + 1));

        //потом groupdata превратим в поток чисел. Анонимная функция в качестве параметров принимает группу g, а в качестве рез-та выдает id
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
}
