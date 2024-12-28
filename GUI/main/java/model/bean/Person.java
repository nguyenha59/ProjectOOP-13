package model.bean;

import java.util.Date;

public class Person {
    private String lastName;
    private String middleName;
    private String firstName;
    private String gender;
    private Date birthday;
    private String phone;

    // Constructor không tham số
    public Person() {
        super();
    }

    // Constructor đầy đủ tham số
    public Person(String lastName, String middleName, String firstName,
                  String gender, Date birthday, String phone) {
        this.lastName = lastName;
        this.middleName = middleName;
        this.firstName = firstName;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
    }

    // Getter và Setter
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                '}';
    }
}
