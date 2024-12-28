package controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.bean.Service;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ServiceController {

    // ObservableList lưu trữ danh sách dịch vụ
    private ObservableList<Service> serviceList = FXCollections.observableArrayList();

    // Các thành phần giao diện
    @FXML
    private TableView<Service> servicetable;
    @FXML
    private TableColumn<Service, String> serviceidcol;
    @FXML
    private TableColumn<Service, String> servicenamecol;
    @FXML
    private TableColumn<Service, String> pricecol;
    @FXML
    private TableColumn<Service, String> maxdistancol;

    @FXML
    private TextField serviceidfield;
    @FXML
    private TextField sericenamefield;
    @FXML
    private TextField pricefield;
    @FXML
    private TextField maxdistancefield;

    @FXML
    private Button addbutton;
    @FXML
    private Button editbutton;
    @FXML
    private Button deletebutton;
    @FXML
    private Button comebackbutton;

    // Khởi tạo bảng khi ứng dụng bắt đầu
    @FXML
    public void initialize() {
        // Cấu hình các cột trong TableView
        serviceidcol.setCellValueFactory(cellData -> cellData.getValue().serviceIDProperty());
        servicenamecol.setCellValueFactory(cellData -> cellData.getValue().serviceNameProperty());
        pricecol.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
        maxdistancol.setCellValueFactory(cellData -> cellData.getValue().maxDistanceProperty());

        serviceList.add(new Service("S101", "Economy", "50", "10000"));
        serviceList.add(new Service("S102", "Economy", "100", "18000"));
        serviceList.add(new Service("S103", "Economy", "200", "22000"));
        serviceList.add(new Service("S104", "Economy", "300", "28000"));
        serviceList.add(new Service("S105", "Economy", "500", "34000"));
        serviceList.add(new Service("S106", "Economy", "800", "40000"));
        serviceList.add(new Service("S107", "Economy", ">800", "47000"));
        serviceList.add(new Service("S201", "Fast", "50", "15000"));
        serviceList.add(new Service("S202", "Fast", "100", "23000"));
        serviceList.add(new Service("S203", "Fast", "200", "29000"));
        serviceList.add(new Service("S204", "Fast", "300", "35000"));
        serviceList.add(new Service("S205", "Fast", "500", "41000"));
        serviceList.add(new Service("S206", "Fast", "800", "47000"));
        serviceList.add(new Service("S207", "Fast", ">800", "54000"));
        serviceList.add(new Service("S301", "Express", "50", "35000"));
        serviceList.add(new Service("S302", "Express", "100", "49000"));
        serviceList.add(new Service("S303", "Express", "200", "63000"));
        serviceList.add(new Service("S304", "Express", "300", "77000"));
        serviceList.add(new Service("S305", "Express", "500", "91000"));
        serviceList.add(new Service("S306", "Express", "800", "105000"));
        serviceList.add(new Service("S307", "Express", ">800", "119000"));


        // Đưa danh sách vào bảng
        servicetable.setItems(serviceList);
    }

    // Sự kiện khi chọn một dịch vụ trong bảng
    @FXML
    public void handleRowSelect(MouseEvent event) {
        Service selectedService = servicetable.getSelectionModel().getSelectedItem();
        if (selectedService != null) {
            serviceidfield.setText(selectedService.getServiceID());
            sericenamefield.setText(selectedService.getServiceName());
            pricefield.setText(selectedService.getPrice());
            maxdistancefield.setText(selectedService.getMaxDistance());
        }
    }

    // Thêm dịch vụ mới
    @FXML
    public void handleAdd(ActionEvent event) {
        String serviceID = serviceidfield.getText();
        String serviceName = sericenamefield.getText();
        String price = pricefield.getText();
        String maxDistance = maxdistancefield.getText();

        if (serviceID.isEmpty() || serviceName.isEmpty() || price.isEmpty() || maxDistance.isEmpty()) {
            showAlert("Lỗi", "Vui lòng nhập đầy đủ thông tin dịch vụ!", AlertType.ERROR);
        } else {
            Service newService = new Service(serviceID, serviceName, maxDistance, price);
            serviceList.add(newService);
            clearFields();
            showAlert("Thông báo", "Dịch vụ đã được thêm thành công!", AlertType.INFORMATION);
        }
    }

    // Sửa dịch vụ đã chọn
    @FXML
    public void handleEdit(ActionEvent event) {
        Service selectedService = servicetable.getSelectionModel().getSelectedItem();
        if (selectedService != null) {
            selectedService.setServiceID(serviceidfield.getText());
            selectedService.setServiceName(sericenamefield.getText());
            selectedService.setPrice(pricefield.getText());
            selectedService.setMaxDistance(maxdistancefield.getText());
            servicetable.refresh();
            clearFields();
            showAlert("Thông báo", "Dịch vụ đã được sửa thành công!", AlertType.INFORMATION);
        } else {
            showAlert("Lỗi", "Vui lòng chọn một dịch vụ để sửa!", AlertType.ERROR);
        }
    }

    // Xóa dịch vụ đã chọn
    @FXML
    public void handleDelete(ActionEvent event) {
        Service selectedService = servicetable.getSelectionModel().getSelectedItem();
        if (selectedService != null) {
            serviceList.remove(selectedService);
            clearFields();
            showAlert("Thông báo", "Dịch vụ đã được xóa thành công!", AlertType.INFORMATION);
        } else {
            showAlert("Lỗi", "Vui lòng chọn một dịch vụ để xóa!", AlertType.ERROR);
        }
    }


    // Hiển thị hộp thoại thông báo
    private void showAlert(String title, String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Làm sạch các trường nhập liệu
    private void clearFields() {
        serviceidfield.clear();
        sericenamefield.clear();
        pricefield.clear();
        maxdistancefield.clear();
    }

    @FXML
    private void handleBack(ActionEvent event) throws IOException {
        // Logic xử lý khi nhấn nút "Quay lại"
        System.out.println("Quay lại");

        // Tải tệp FXML mới (ví dụ, quay lại màn hình chính)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/adminhome.fxml"));
        AnchorPane root = loader.load();

        // Lấy stage hiện tại và thay đổi cảnh
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));  // Chuyển đổi cảnh
        stage.show();
    }
}



