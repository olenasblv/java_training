package ua.qa.training.addressbook.model;

public class ContactData {

  private final String firstName;
  private final String lastName;
  private final String address;
  private final String homePhone;
  private final String email1;
  private final String homepage;
  private final String birthdayYear;
  private final String birthdayDay;
  private final String birthdayMonth;
  private String group;

  public ContactData(String firstName, String lastName, String address, String homePhone,
                     String email1, String homepage, String birthdayDay, String birthdayMonth, String birthdayYear, String group) {

    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.homePhone = homePhone;
    this.email1 = email1;
    this.homepage = homepage;
    this.birthdayDay = birthdayDay;
    this.birthdayMonth = birthdayMonth;
    this.birthdayYear = birthdayYear;
    this.group = group;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getEmail1() {
    return email1;
  }

  public String getHomepage() {
    return homepage;
  }

  public String getBirthdayYear() {
    return birthdayYear;
  }

  public String getBirthdayDay() {
    return birthdayDay;
  }

  public String getBirthdayMonth() {
    return birthdayMonth;
  }

  public String getGroup() {
    return group;
  }
}
