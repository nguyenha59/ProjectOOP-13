package controller;

import java.sql.SQLException;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import model.bo.AccUserBO;

public class LoginController {
    private AccUserBO accUserBO;

    public LoginController() {
        accUserBO = new AccUserBO();
    }

    @FXML
    private TextField userIDTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Label errorLogin;

    @FXML
    protected void handleLoginButtonAction(ActionEvent event) {
        String userID = userIDTextField.getText().trim();
        String password = passwordTextField.getText().trim();

        try {
            if (accUserBO.CheckLogin(userID, password)) {
                // Nếu đăng nhập thành công, chuyển sang màn hình home
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/home.fxml"));
                Parent homeRoot = loader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(homeRoot));
                stage.show();
            } else {
                // Nếu đăng nhập thất bại, hiển thị thông báo lỗi
                errorLogin.setVisible(true); // Hiển thị Label errorlogin
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void handleSignupButtonAction(ActionEvent event) {
        try {
            // Chuyển sang màn hình đăng ký tài khoản
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/signup.fxml"));
            Parent signupRoot = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(signupRoot));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
