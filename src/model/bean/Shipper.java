package model.bean;

import java.util.Date;

public class Shipper extends Person {
    private String employeeID;   // EmployeeID (CHAR(5))
    private String homeTown;     // HomeTown (VARCHAR(45), NOT NULL)

    public Shipper() {
        super();
    }

    // Constructor đầy đủ tham số
    public Shipper(String employeeID, String lastName, String middleName, String firstName,
                   String gender, Date birthday, String phone, String homeTown) {
        super(lastName, middleName, firstName, gender, birthday, phone);
        this.employeeID = employeeID;
        this.homeTown = homeTown;
    }

    // Getter và Setter cho employeeID và homeTown
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    // Triển khai phương thức trừu tượng từ lớp Person
    @Override
    public String getRole() {
        return "Shipper"; // Vai trò của đối tượng Shipper
    }

    @Override
    public String toString() {
        return "Shipper{" +
                "employeeID='" + employeeID + '\'' +
                ", homeTown='" + homeTown + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", middleName='" + getMiddleName() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", birthday=" + getBirthday() +
                ", phone='" + getPhone() + '\'' +
                ", role='" + getRole() + '\'' +
                '}';
    }

    // Phương thức equals() để so sánh đối tượng
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Shipper shipper = (Shipper) obj;
        return employeeID.equals(shipper.employeeID);
    }

    // Phương thức hashCode() để tính toán giá trị băm
    @Override
    public int hashCode() {
        return employeeID.hashCode();
    }
}



