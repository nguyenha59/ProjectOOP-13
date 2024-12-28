package model.test;

import model.bean.Admin;
import model.bean.AccUser;
import model.bean.Shipper;

import java.util.Date;

public class EqualTest {

    public static void main(String[] args) {
        // Tạo đối tượng Admin
        Admin admin1 = new Admin("Nguyen", "Thi", "Mai", "Female", new Date(), "0123456789", "admin123", "password123");
        Admin admin2 = new Admin("Nguyen", "Thi", "Mai", "Female", new Date(), "0123456789", "admin123", "password123");
        System.out.println("Vai trò: " + admin1.getRole());

        // Kiểm tra equals() và hashCode() của Admin
        if (admin1.equals(admin2)) {
            System.out.println("Các đối tượng là bằng nhau.");
        } else {
            System.out.println("Các đối tượng không bằng nhau.");
        }

        if (admin1.hashCode() == admin2.hashCode()) {
            System.out.println("Giá trị băm là giống nhau.");
        } else {
            System.out.println("Giá trị băm không giống nhau.");
        }

        // Tạo đối tượng AccUser
        AccUser accUser1 = new AccUser("user123", "password123", "Nguyen", "Thi", "Mai", new Date(), "Female", "0123456789", "Hanoi", "Ba Dinh", "Warehouse1", "123 Main St");
        AccUser accUser2 = new AccUser("user123", "password123", "Nguyen", "Thi", "Mai", new Date(), "Female", "0123456789", "Hanoi", "Ba Dinh", "Warehouse1", "123 Main St");
        System.out.println("Vai trò: " + accUser1.getRole());

        // Kiểm tra equals() và hashCode() của AccUser
        if (accUser1.equals(accUser2)) {
            System.out.println("Các đối tượng là bằng nhau.");
        } else {
            System.out.println("Các đối tượng không bằng nhau.");
        }

        if (accUser1.hashCode() == accUser2.hashCode()) {
            System.out.println("Giá trị băm là giống nhau.");
        } else {
            System.out.println("Giá trị băm không giống nhau.");
        }

        // Tạo đối tượng Shipper
        Shipper shipper1 = new Shipper("S123", "Nguyen", "Thi", "Mai", "Female", new Date(), "0123456789", "Hanoi");
        Shipper shipper2 = new Shipper("S123", "Nguyen", "Thi", "Mai", "Female", new Date(), "0123456789", "Hanoi");
        System.out.println("Vai trò: " + shipper1.getRole());

        // Kiểm tra equals() và hashCode() của Shipper
        if (shipper1.equals(shipper2)) {
            System.out.println("Các đối tượng là bằng nhau.");
        } else {
            System.out.println("Các đối tượng không bằng nhau.");
        }

        if (shipper1.hashCode() == shipper2.hashCode()) {
            System.out.println("Giá trị băm là giống nhau.");
        } else {
            System.out.println("Giá trị băm không giống nhau.");
        }

        // Tạo đối tượng có sự khác biệt để kiểm tra
        Shipper shipper3 = new Shipper("S124", "Nguyen", "Thi", "Mai", "Female", new Date(), "0123456789", "Hanoi");
        if (!shipper1.equals(shipper3)) {
            System.out.println("Các đối tượng không bằng nhau.");
        } else {
            System.out.println("Các đối tượng là bằng nhau.");
        }

        if (shipper1.hashCode() != shipper3.hashCode()) {
            System.out.println("Giá trị băm không giống nhau.");
        } else {
            System.out.println("Giá trị băm là giống nhau.");
        }
    }
}


