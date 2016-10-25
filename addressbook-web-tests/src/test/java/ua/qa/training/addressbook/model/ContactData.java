package ua.qa.training.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name = "addressbook")
public class ContactData {

    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;

    @Expose
    @Column(name = "lastname")
    private String lastName;

    @Expose
    @Column(name = "firstname")
    private String firstName;

    @Expose
    @Column(name = "address")
    @Type(type = "text")
    private String address;

    @Expose
    @Column(name = "home")
    @Type(type = "text")
    private String homePhone;

    @Column(name = "mobile")
    @Type(type = "text")
    private String mobilePhone;

    @Column(name = "work")
    @Type(type = "text")
    private String workPhone;

    @Expose
    @Column(name = "email")
    @Type(type = "text")
    private String email;

    @Column(name = "email2")
    @Type(type = "text")
    private String email2;

    @Column(name = "email3")
    @Type(type = "text")
    private String email3;

    @Expose
    @Column(name = "homepage")
    @Type(type = "text")
    private String homepage;

    @Expose
    @Transient
    private int birthdayYear;

    @Expose
    @Transient
    private int birthdayDay;

    @Expose
    @Transient
    private String birthdayMonth;

    @Expose
    @Transient
    private String group;

    @Transient
    private String allPhones;

    @Transient
    private String allEmails;

    @Column(name = "photo")
    @Type(type = "text")
    private String photo;

    @Transient
    private String details;


    public int getId() {
        return id;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public String getEmail2() {
        return email2;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public String getEmail3() {
        return email3;
    }

    public ContactData withHomepage(String homepage) {
        this.homepage = homepage;
        return this;
    }

    public String getHomepage() {
        return homepage;
    }

    public ContactData withBirthdayYear(int birthdayYear) {
        this.birthdayYear = birthdayYear;
        return this;
    }

    public int getBirthdayYear() {
        return birthdayYear;
    }

    public ContactData withBirthdayDay(int birthdayDay) {
        this.birthdayDay = birthdayDay;
        return this;
    }

    public int getBirthdayDay() {
        return birthdayDay;
    }

    public ContactData withBirthdayMonth(String birthdayMonth) {
        this.birthdayMonth = birthdayMonth;
        return this;
    }

    public String getBirthdayMonth() {
        return birthdayMonth;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public String getGroup() {
        return group;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public ContactData withDetails(String details) {
        this.details = details;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    public File getPhoto() {
        return new File(photo);
    }


    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        return firstName != null ? firstName.equals(that.firstName) : that.firstName == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        return result;
    }
}
