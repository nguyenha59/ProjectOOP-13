package model.bean;

import java.util.Date;

public class Admin extends Person {
    private String adminID;   // ID của Admin
    private String passwordd; // Mật khẩu của Admin

    // Constructor không tham số
    public Admin() {
        super();
    }

    // Constructor đầy đủ tham số
    public Admin(String lastName, String middleName, String firstName,
                 String gender, Date birthday, String phone,
                 String adminID, String passwordd) {
        super(lastName, middleName, firstName, gender, birthday, phone);
        this.adminID = adminID;
        this.passwordd = passwordd;
    }

    // Getter và Setter
    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getPasswordd() {
        return passwordd;
    }

    public void setPasswordd(String passwordd) {
        this.passwordd = passwordd;
    }

    // Triển khai phương thức trừu tượng từ lớp Person
    @Override
    public String getRole() {
        return "Admin Account"; // Vai trò của Admin
    }

    // Phương thức toString để hiển thị thông tin
    @Override
    public String toString() {
        return "Admin{" +
                "adminID='" + adminID + '\'' +
                ", passwordd='" + passwordd + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", middleName='" + getMiddleName() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", birthday=" + getBirthday() +
                ", phone='" + getPhone() + '\'' +
                ", role='" + getRole() + '\'' +
                '}';
    }

    // Phương thức equals() để so sánh đối tượng Admin
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Admin admin = (Admin) obj;
        return adminID.equals(admin.adminID); // So sánh adminID
    }

    // Phương thức hashCode() để tính toán giá trị băm
    @Override
    public int hashCode() {
        return adminID.hashCode(); // Tính giá trị băm dựa trên adminID
    }
}



