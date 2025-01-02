package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;

public class AdminHomeController {
    @FXML
    private Button adminuser;
    @FXML
    private Button adminsurcharge;
    @FXML
    private Button adminserice;
    @FXML
    private Button adminshipper;
    @FXML
    private Button adminorder;
    @FXML
    private Button adminwarehouse;


    @FXML
    private void handleUser(ActionEvent event) throws IOException {

        // Tải tệp FXML mới (ví dụ, quay lại màn hình chính)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/user_list.fxml"));
        AnchorPane root = loader.load();

        // Lấy stage hiện tại và thay đổi cảnh
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));  // Chuyển đổi cảnh
        stage.show();
    }
    @FXML
    private void handleService(ActionEvent event) throws IOException {

        // Tải tệp FXML mới (ví dụ, quay lại màn hình chính)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/service.fxml"));
        AnchorPane root = loader.load();

        // Lấy stage hiện tại và thay đổi cảnh
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));  // Chuyển đổi cảnh
        stage.show();
    }
    @FXML
    private void handleOrder(ActionEvent event) throws IOException {

        // Tải tệp FXML mới (ví dụ, quay lại màn hình chính)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/order.fxml"));
        BorderPane root = loader.load();

        // Lấy stage hiện tại và thay đổi cảnh
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));  // Chuyển đổi cảnh
        stage.show();
    }
    @FXML
    private void handleSurcharge(ActionEvent event) throws IOException {

        // Tải tệp FXML mới (ví dụ, quay lại màn hình chính)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/home.fxml"));
        AnchorPane root = loader.load();

        // Lấy stage hiện tại và thay đổi cảnh
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));  // Chuyển đổi cảnh
        stage.show();
    }
    @FXML
    private void handleWarehouse(ActionEvent event) throws IOException {

        // Tải tệp FXML mới (ví dụ, quay lại màn hình chính)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/home.fxml"));
        AnchorPane root = loader.load();

        // Lấy stage hiện tại và thay đổi cảnh
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));  // Chuyển đổi cảnh
        stage.show();
    }

    @FXML
    private void handleShipper(ActionEvent event) throws IOException {

        // Tải tệp FXML mới (ví dụ, quay lại màn hình chính)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/user_list.fxml"));
        AnchorPane root = loader.load();

        // Lấy stage hiện tại và thay đổi cảnh
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));  // Chuyển đổi cảnh
        stage.show();
    }
    @FXML
    private void handleDelivery(ActionEvent event) throws IOException {

        // Tải tệp FXML mới (ví dụ, quay lại màn hình chính)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/user_list.fxml"));
        AnchorPane root = loader.load();

        // Lấy stage hiện tại và thay đổi cảnh
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));  // Chuyển đổi cảnh
        stage.show();
    }
    @FXML
    public void initialize() {
        System.out.println("Controller initialized.");
    }
}
