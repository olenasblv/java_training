package ua.qa.training.addressbook.model;

public class ContactData {

    private int id;
    private final String lastName;
    private final String firstName;
    private final String address;
    private final String homePhone;
    private final String email1;
    private final String homepage;
    private final String birthdayYear;
    private final String birthdayDay;
    private final String birthdayMonth;
    private String group;

    public ContactData(String lastName, String firstName, String address, String homePhone,
                       String email1, String homepage, String birthdayDay, String birthdayMonth, String birthdayYear, String group) {

        this.id = Integer.MAX_VALUE;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.homePhone = homePhone;
        this.email1 = email1;
        this.homepage = homepage;
        this.birthdayDay = birthdayDay;
        this.birthdayMonth = birthdayMonth;
        this.birthdayYear = birthdayYear;
        this.group = group;
    }

    public ContactData(int id, String lastName, String firstName, String address, String homePhone,
                       String email1, String homepage, String birthdayDay, String birthdayMonth, String birthdayYear, String group) {

        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.homePhone = homePhone;
        this.email1 = email1;
        this.homepage = homepage;
        this.birthdayDay = birthdayDay;
        this.birthdayMonth = birthdayMonth;
        this.birthdayYear = birthdayYear;
        this.group = group;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
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

        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        return firstName != null ? firstName.equals(that.firstName) : that.firstName == null;

    }

    @Override
    public int hashCode() {
        int result = lastName != null ? lastName.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        return result;
    }
}
