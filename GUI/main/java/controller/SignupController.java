package controller;

import java.sql.SQLException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.bo.AccUserBO;

public class SignupController {

    private AccUserBO accUserBO = new AccUserBO(); // Biến accUserBO đã được khai báo ở cấp lớp

    @FXML
    private TextField userIDTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField middlenameTextField;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField birthdayTextField;
    @FXML
    private TextField genderTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField cityTextField;
    @FXML
    private TextField districtTextField;
    @FXML
    private TextField wareTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private Label errorSignup;

    // Hàm xử lý sự kiện khi nhấn nút Đăng Ký
    @FXML
    protected void handleSignupButtonAction(ActionEvent event) {
        // Lấy thông tin từ các TextField
        String userID = userIDTextField.getText().trim();
        String password = passwordTextField.getText().trim();
        String lastName = lastnameTextField.getText().trim();
        String middleName = middlenameTextField.getText().trim();
        String firstName = firstnameTextField.getText().trim();
        String birthdayString = birthdayTextField.getText().trim();  // Lưu ngày tháng ở dạng String
        String gender = genderTextField.getText().trim();
        String phone = phoneTextField.getText().trim();
        String city = cityTextField.getText().trim();
        String district = districtTextField.getText().trim();
        String ware = wareTextField.getText().trim();
        String address = addressTextField.getText().trim();

        // Kiểm tra xem các trường bắt buộc có bị thiếu hay không
        if (userID.isEmpty() || password.isEmpty() || lastName.isEmpty() || firstName.isEmpty() ||
                birthdayString.isEmpty() || gender.isEmpty() || phone.isEmpty() || city.isEmpty() ||
                district.isEmpty() || ware.isEmpty() || address.isEmpty()) {
            errorSignup.setText("Vui lòng điền đầy đủ thông tin.");
            errorSignup.setVisible(true);
            return;
        }

        // Chuyển đổi birthdayString thành đối tượng Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày tháng (ví dụ: 2024-12-25)
        Date birthday = null;
        try {
            birthday = sdf.parse(birthdayString); // Chuyển đổi chuỗi thành đối tượng Date
        } catch (Exception e) {
            errorSignup.setText("Ngày sinh không hợp lệ.");
            errorSignup.setVisible(true);
            return;
        }

        try {
            // Kiểm tra xem UserID đã tồn tại trong hệ thống hay chưa
            if (accUserBO.checkUserIDExists(userID)) {
                errorSignup.setText("UserID đã tồn tại. Vui lòng chọn UserID khác.");
                errorSignup.setVisible(true);
                return; // Dừng lại ở đây nếu UserID đã tồn tại
            }

            // Thêm tài khoản người dùng vào cơ sở dữ liệu
            accUserBO.addAccUser(userID, password, lastName, middleName, firstName, birthday, gender, phone, city, district, ware, address);

            // Nếu thành công, chuyển sang màn hình Home
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/home.fxml"));
            Parent homeRoot = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(homeRoot));
            stage.show();
        } catch (SQLException e) {
            // Xử lý SQLException
            errorSignup.setText("Lỗi khi kết nối đến cơ sở dữ liệu. Vui lòng thử lại.");
            errorSignup.setVisible(true);
            e.printStackTrace(); // In thông tin chi tiết lỗi ra console
        } catch (IOException e) {
            // Xử lý IOException
            errorSignup.setText("Lỗi khi chuyển màn hình. Vui lòng thử lại.");
            errorSignup.setVisible(true);
            e.printStackTrace(); // In thông tin chi tiết lỗi ra console
        }
    }
}
