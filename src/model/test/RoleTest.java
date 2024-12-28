package model.test;

import model.bean.Admin;
import model.bean.AccUser;
import model.bean.Shipper;

import java.util.Date;

public class RoleTest {

    public static void main(String[] args) {
        // Tạo đối tượng Admin
        Admin admin = new Admin("Nguyen", "Thi", "Mai", "Female", new Date(), "0123456789", "admin123", "password123");
        System.out.println("Admin Role: " + admin.getRole());
        if ("Admin Account".equals(admin.getRole())) {
            System.out.println("Admin role is correct.");
        } else {
            System.out.println("Admin role is incorrect.");
        }

        // Tạo đối tượng AccUser
        AccUser accUser = new AccUser("user123", "password123", "Nguyen", "Thi", "Mai", new Date(), "Female", "0123456789", "Hanoi", "Ba Dinh", "Warehouse1", "123 Main St");
        System.out.println("AccUser Role: " + accUser.getRole());
        if ("User Account".equals(accUser.getRole())) {
            System.out.println("AccUser role is correct.");
        } else {
            System.out.println("AccUser role is incorrect.");
        }

        // Tạo đối tượng Shipper
        Shipper shipper = new Shipper("S123", "Nguyen", "Thi", "Mai", "Female", new Date(), "0123456789", "Hanoi");
        System.out.println("Shipper Role: " + shipper.getRole());
        if ("Shipper".equals(shipper.getRole())) {
            System.out.println("Shipper role is correct.");
        } else {
            System.out.println("Shipper role is incorrect.");
        }
    }
}
