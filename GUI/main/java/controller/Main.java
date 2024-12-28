package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            // Tải file FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/adminhome.fxml"));
            Scene scene = new Scene(loader.load());

            // Thiết lập tiêu đề và giao diện chính
            primaryStage.setTitle("Admin Home");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading adminhome.fxml");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
