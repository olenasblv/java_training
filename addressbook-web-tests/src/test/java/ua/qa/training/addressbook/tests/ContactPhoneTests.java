package ua.qa.training.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.qa.training.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by osoboleva on 11.10.2016.
 */
public class ContactPhoneTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withLastName("Last_name_test").withFirstName("First_name_test").withAddress("Address_test")
                    .withHomePhone("111-111").withMobilePhone("22 22").withWorkPhone("(3)33").withEmail("email@mail.ru").withEmail2("2email@mail.ru")
                    ); //.withGroup("[none]")
        }
    }

    @Test
    public void testContactPhones() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next(); //загружаем множество контактов, выбираем контакт случайным образом
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact); //загрузка инфо о контакте из формы редактирования

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }

    private String mergePhones(ContactData contact) {
        return Stream.of(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                .filter((s) -> !s.equals("")) //выбрасываем строки, которые пустые
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n")); //коллектор, склеивает все элементы потока в одну большую строку. "\n" - разделитель. строчка, которая будет вставляться между склеиваемыми фрагментами
    }

    // функция удаляет ненужные символы
    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}

//   \\s - пробелный символ,   a-z - заменить любую букву, которая находится между a и z