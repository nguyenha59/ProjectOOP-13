package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class LoginApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // Tải giao diện đăng nhập từ FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
            Parent loginRoot = loader.load();
            Scene scene = new Scene(loginRoot);

            // Hiển thị màn hình đăng nhập
            primaryStage.setScene(scene);
            primaryStage.setTitle("Login Application");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();  // Xử lý ngoại lệ nếu có lỗi khi tải giao diện
        }
    }

    public static void main(String[] args) {
        launch(args);  // Khởi động ứng dụng JavaFX
    }
}


