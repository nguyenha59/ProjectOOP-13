package model.dao;

import model.bean.Admin;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class AdminDAO extends DBconnect {

    // Đăng nhập
    public boolean CheckLogin(String adminID, String passwordd) throws SQLException {
        connect();
        String sql = "SELECT adminID, passwordd FROM Admin WHERE adminID = ? AND passwordd = ?";

        // Sử dụng PreparedStatement để thay thế String.format
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, adminID);  // Gán giá trị cho tham số adminID
        stmt.setString(2, passwordd); // Gán giá trị cho tham số passwordd

        ResultSet rs = stmt.executeQuery(); // Sử dụng executeQuery để thực thi câu truy vấn

        if (rs.next()) {
            return true;
        }
        return false;
    }

    // Hiển thị tất cả Admin
    public void showAllAdmins() throws SQLException {
        connect();  // Kết nối đến cơ sở dữ liệu
        String sql = "SELECT * FROM Admin";  // Câu lệnh SQL để lấy toàn bộ Admin

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Tạo đối tượng Admin từ kết quả của ResultSet
                String adminID = rs.getString("adminID");
                String passwordd = rs.getString("passwordd");
                String lastName = rs.getString("lastName");
                String middleName = rs.getString("middleName");
                String firstName = rs.getString("firstName");
                java.sql.Date sqlDate = rs.getDate("birthday");
                Date birthday = new Date(sqlDate.getTime());
                String gender = rs.getString("gender");
                String phone = rs.getString("phone");

                // Tạo đối tượng Admin
                Admin admin = new Admin(lastName, middleName, firstName, gender, birthday, phone, adminID, passwordd);

                // In thông tin Admin ra màn hình
                System.out.println(admin.toString());
                System.out.println("-----------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Hiển thị thông tin Admin theo adminID
    public void showAdminByID(String adminID) throws SQLException {
        connect();  // Kết nối đến cơ sở dữ liệu
        String sql = "SELECT * FROM Admin WHERE adminID = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, adminID);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String passwordd = rs.getString("passwordd");
                    String lastName = rs.getString("lastName");
                    String middleName = rs.getString("middleName");
                    String firstName = rs.getString("firstName");
                    Date birthday = rs.getDate("birthday");
                    String gender = rs.getString("gender");
                    String phone = rs.getString("phone");

                    // Tạo đối tượng Admin
                    Admin admin = new Admin(lastName, middleName, firstName, gender, birthday, phone, adminID, passwordd);

                    // In thông tin Admin
                    System.out.println(admin.toString());
                } else {
                    System.out.println("Không tìm thấy Admin với adminID: " + adminID);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

