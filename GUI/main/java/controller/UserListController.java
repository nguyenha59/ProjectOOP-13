package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.bean.AccUser;
import model.bo.AccUserBO;
import java.sql.SQLException;

public class UserListController {

    @FXML
    private TableView<AccUser> userTable;

    @FXML
    private TableColumn<AccUser, String> colUserID;

    @FXML
    private TableColumn<AccUser, String> colLastName;

    @FXML
    private TableColumn<AccUser, String> colMiddleName;

    @FXML
    private TableColumn<AccUser, String> colFirstName;

    @FXML
    private TableColumn<AccUser, String> colPhone;

    @FXML
    private TableColumn<AccUser, String> colGender;

    @FXML
    private TableColumn<AccUser, String> colBirthday;

    @FXML
    private TableColumn<AccUser, String> colCity;


    @FXML
    private TableColumn<AccUser, String> colDistrict;

    @FXML
    private TableColumn<AccUser, String> colWare;

    @FXML
    private TableColumn<AccUser, String> colAddress;

    // Khai báo đối tượng AccUserBO để truy vấn dữ liệu
    private AccUserBO accUserBO = new AccUserBO();

    private ObservableList<AccUser> userList = FXCollections.observableArrayList();

    // Phương thức để hiển thị danh sách người dùng
    public void showUserList() {
        try {
            // Gọi phương thức để lấy danh sách người dùng
            loadUserData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Tạo phương thức để load dữ liệu từ AccUser vào TableView
    private void loadUserData() throws SQLException {
        // Clear dữ liệu cũ trước khi load lại
        userTable.getItems().clear();

        // Lấy danh sách người dùng từ AccUserBO
        for (AccUser user : accUserBO.getAllUsers()) {
            userList.add(user);
        }

        userTable.setItems(userList);

        // Hiển thị thông tin người dùng trong các cột
        colUserID.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUserID()));
        colLastName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLastName()));
        colMiddleName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMiddleName()));
        colFirstName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFirstName()));
        colCity.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCity()));
        colPhone.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPhone()));
        colAddress.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress()));
        colGender.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGender()));
        colDistrict.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDistrict()));
        colWare.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getWare()));
}
}