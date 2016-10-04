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

  @Override
  public String toString() {
    return "ContactData{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", address='" + address + '\'' +
            ", homePhone='" + homePhone + '\'' +
            ", email1='" + email1 + '\'' +
            ", homepage='" + homepage + '\'' +
            ", birthdayYear='" + birthdayYear + '\'' +
            ", birthdayDay='" + birthdayDay + '\'' +
            ", birthdayMonth='" + birthdayMonth + '\'' +
            ", group='" + group + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    if (homePhone != null ? !homePhone.equals(that.homePhone) : that.homePhone != null) return false;
    if (email1 != null ? !email1.equals(that.email1) : that.email1 != null) return false;
    if (homepage != null ? !homepage.equals(that.homepage) : that.homepage != null) return false;
    if (birthdayYear != null ? !birthdayYear.equals(that.birthdayYear) : that.birthdayYear != null) return false;
    if (birthdayDay != null ? !birthdayDay.equals(that.birthdayDay) : that.birthdayDay != null) return false;
    if (birthdayMonth != null ? !birthdayMonth.equals(that.birthdayMonth) : that.birthdayMonth != null) return false;
    return group != null ? group.equals(that.group) : that.group == null;

  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
    result = 31 * result + (email1 != null ? email1.hashCode() : 0);
    result = 31 * result + (homepage != null ? homepage.hashCode() : 0);
    result = 31 * result + (birthdayYear != null ? birthdayYear.hashCode() : 0);
    result = 31 * result + (birthdayDay != null ? birthdayDay.hashCode() : 0);
    result = 31 * result + (birthdayMonth != null ? birthdayMonth.hashCode() : 0);
    result = 31 * result + (group != null ? group.hashCode() : 0);
    return result;
  }
}
