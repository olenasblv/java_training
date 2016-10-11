package ua.qa.training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.qa.training.addressbook.model.GroupData;
import ua.qa.training.addressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by osoboleva on 9/18/2016.
 */
public class GroupHelper extends HelperBase {


    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void create(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        groupCache = null;
        returnToGroupPage();
    }

    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        groupCache = null;
        returnToGroupPage();
    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        deleteSelectedGroups();
        groupCache = null;
        returnToGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Groups groupCache = null;

    public Groups all() {
        if (groupCache != null){
            return new Groups(groupCache);
        }
        groupCache = new Groups();      // создаем множество типа GroupData
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));      // извлечение информации со страницы
        for (WebElement element : elements) {      // переменная element пробегает по списку elements
            String name = element.getText();      // из каждого элемента получаем текст, который будет именем группы
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupCache.add(new GroupData().withId(id).withName(name));       // добавляем созданный объект в список
        }
        return new Groups(groupCache);
    }
}
