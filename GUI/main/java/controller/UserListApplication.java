package controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UserListApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Tải FXML và tạo giao diện
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/user_list.fxml"));
        AnchorPane root = loader.load();

        // Tạo Scene và hiển thị
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("User List");
        primaryStage.show();

        // Khởi tạo controller và hiển thị danh sách người dùng
        UserListController controller = loader.getController();
        controller.showUserList();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

