package ua.qa.training.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.qa.training.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
        if (format.equals("json")) {
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

    private List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData()
                    .withLastName(String.format("lastname %s", i))
                    .withFirstName(String.format("firstname %s", i))
                    .withAddress(String.format("address %s", i))
                    .withHomePhone(String.format("(123)%s", i))
                    .withEmail(String.format("email%s@email.com", i))
                    .withHomepage(String.format("homepage%s.com", i))
                    .withBirthdayMonth(getRandomMonth())
                    .withBirthdayDay(r.nextInt(32))
                    .withBirthdayYear(r.nextInt(116) + 1900));
        }
        return contacts;
    }

    private String getRandomMonth() {
        List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        Random r = new Random();
        return months.get(r.nextInt(months.size()));
    }
}


