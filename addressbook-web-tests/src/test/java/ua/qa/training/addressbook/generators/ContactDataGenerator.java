package ua.qa.training.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ua.qa.training.addressbook.model.ContactData;
import ua.qa.training.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by osoboleva on 19.10.2016.
 */
public class ContactDataGenerator {

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        if (format.equals("csv")) {
            saveAsCsv(contacts, new File(file));
        } else if (format.equals("xml")) {
            saveAsXml(contacts, new File(file));
        } else if (format.equals("json")) {
            saveAsJson(contacts, new File(file));
        } else {
            System.out.println("Unrecognized format " + format);
        }
    }

    private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        Writer writer = new FileWriter(file); //открываем файл на запись
        writer.write(json);
        writer.close();
    }

    private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(GroupData.class);
        String xml = xstream.toXML(contacts);
        Writer writer = new FileWriter(file); //открываем файл на запись
        writer.write(xml);
        writer.close();
    }

    private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file); //открываем файл на запись
        for (ContactData contact : contacts) {
            writer.write(String.format("%s;%s;%s\n",
                    contact.getLastName(),
                    contact.getFirstName(),
                    contact.getAddress(),
                    contact.getHomePhone(),
                    contact.getEmail(),
                    contact.getHomepage(),
                    contact.getBirthdayDay(),
                    contact.getBirthdayMonth(),
                    contact.getBirthdayYear(),
                    contact.getGroup(),
                    contact.getPhoto()));
        }
        writer.close();
    }

    private List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData()
                    .withLastName(String.format("lastname %s", i))
                    .withFirstName(String.format("firstname\n%s", i))
                    .withAddress(String.format("address\n%s", i))
            .withHomePhone(String.format("(123)1\n%s", i))
            .withEmail(String.format("email@email\n%s", i))
            .withHomepage(String.format("homepage\n%s", i))
            .withBirthdayDay(String.format("address\n%s", i))
            .withBirthdayMonth(String.format("address\n%s", i))
            .withBirthdayYear(String.format("address\n%s", i))
            .withGroup(String.format("address\n%s", i))
            .withPhoto(String.format("address\n%s", i)));
        }
        return contacts;
    }


}
