package model.bo;

import java.sql.SQLException;
import model.dao.AccUserDAO;
import java.util.List;
import model.bean.AccUser;


public class AccUserBO {

    AccUserDAO AccuserDAO = new AccUserDAO();

    //kiem tra dang nhap
    public boolean CheckLogin(String userID, String password) throws SQLException {
        return AccuserDAO.CheckLogin(userID, password);
    }
    //them user
    public void addAccUser(String userID, String passwordd, String lastName, String middleName, String firstName,
                           java.util.Date birthday, String gender, String phone, String city, String district, String ware, String address) throws SQLException {
        AccuserDAO.addAccUser(userID, passwordd, lastName, middleName, firstName, birthday, gender, phone, city, district, ware, address);
    }
    // Kiểm tra userID đã tồn tại
    public boolean checkUserIDExists(String userID) throws SQLException {
        return AccuserDAO.checkUserIDExists(userID);
    }
    //sua thong tin user
    public void editProfile(String userID,String lastName, String middleName, String firstName,
                            java.util.Date birthday, String gender, String phone, String city, String district, String ware, String address) {
        AccuserDAO.editProfile(userID, lastName, middleName, firstName, birthday, gender, phone, city, district, ware, address);
    }
    //doi mat khau
    public void changePassword(String userID, String newpassword) {
        AccuserDAO.changePassword(userID, newpassword);
    }
    //xoa user
    public void deleteAccUser(String userID, String passwordd)throws SQLException {AccuserDAO.deleteAccUser(userID, passwordd);}
    // Phương thức lấy tất cả người dùng từ cơ sở dữ liệu

    private AccUserDAO accUserDAO = new AccUserDAO();  // Đối tượng DAO để thực hiện các truy vấn
    // Phương thức lấy tất cả người dùng từ cơ sở dữ liệu
    public List<AccUser> getAllUsers() throws SQLException {
        // Gọi phương thức từ AccUserDAO để lấy danh sách người dùng
        return accUserDAO.getAllUsers();
    }
    //hien thi ds nguoi dung
    public void showAllUsers() throws SQLException {
        AccUserDAO accUserDAO = new AccUserDAO();
        accUserDAO.showAllUsers();
    }
    public void showUserByID(String userID) throws SQLException {
        AccUserDAO accUserDAO = new AccUserDAO();
        accUserDAO.showUserByID(userID);
    }
}