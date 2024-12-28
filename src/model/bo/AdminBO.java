package model.bo;

import java.sql.SQLException;
import model.dao.AdminDAO;

public class AdminBO {

    AdminDAO adminDAO = new AdminDAO();

    // Kiểm tra đăng nhập
    public boolean CheckLogin(String adminID, String passwordd) throws SQLException {
        return adminDAO.CheckLogin(adminID, passwordd);
    }

    // Hiển thị danh sách admin
    public void showAllAdmins() throws SQLException {
        adminDAO.showAllAdmins();
    }

    // Hiển thị thông tin admin theo ID
    public void showAdminByID(String adminID) throws SQLException {
        adminDAO.showAdminByID(adminID);
    }
}

