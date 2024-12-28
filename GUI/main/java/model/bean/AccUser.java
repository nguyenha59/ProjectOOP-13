package model.bean;

import java.util.Date;

public class AccUser extends Person {
    private String userID; // UserID (CHAR(5))
    private String passwordd; // Password thêm vào
    private String city; // City (VARCHAR(30))
    private String district; // District (VARCHAR(45))
    private String ware; // Ware (VARCHAR(45))
    private String address; // Address (VARCHAR(45))

    // Constructor không tham số
    public AccUser() {
        super();
    }

    // Constructor đầy đủ tham số
    public AccUser(String userID, String passwordd, String lastName, String middleName, String firstName,
                   Date birthday, String gender, String phone, String city,
                   String district, String ware, String address) {
        super(lastName, middleName, firstName, gender, birthday, phone);
        this.userID = userID;
        this.passwordd = passwordd;
        this.city = city;
        this.district = district;
        this.ware = ware;
        this.address = address;
    }

    // Getter và Setter
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return passwordd;
    }

    public void setPassword(String password) {
        this.passwordd = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWare() {
        return ware;
    }

    public void setWare(String ware) {
        this.ware = ware;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Phương thức toString để in thông tin đối tượng
    @Override
    public String toString() {
        return "AccUser{" +
                "userID:'" + userID + '\'' +
                ", password:'" + passwordd + '\'' +
                ", lastName:'" + getLastName() + '\'' +
                ", middleName:'" + getMiddleName() + '\'' +
                ", firstName:'" + getFirstName() + '\'' +
                ", birthday:" + getBirthday() +
                ", gender:'" + getGender() + '\'' +
                ", phone:'" + getPhone() + '\'' +
                ", city:'" + city + '\'' +
                ", district:'" + district + '\'' +
                ", ware:'" + ware + '\'' +
                ", address:'" + address + '\'' +
                '}';
    }
    // Phương thức equals() và hashCode() để so sánh đối tượng
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AccUser accUser = (AccUser) obj;
        return userID.equals(accUser.userID);
    }

    @Override
    public int hashCode() {
        return userID.hashCode();
    }
}
