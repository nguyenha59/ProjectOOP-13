package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.bean.Order;

public class OrderController {

    // ObservableList to store order data
    private ObservableList<Order> orderList = FXCollections.observableArrayList();

    // UI components
    @FXML
    private TableView<Order> orderTable;
    @FXML
    private TableColumn<Order, String> orderIdCol;
    @FXML
    private TableColumn<Order, String> customerNameCol;
    @FXML
    private TableColumn<Order, String> productCol;
    @FXML
    private TableColumn<Order, String> quantityCol;

    @FXML
    private TextField orderIdField;
    @FXML
    private TextField customerNameField;
    @FXML
    private TextField productField;
    @FXML
    private TextField quantityField;

    @FXML
    private Button addButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;

    // Initialize the table with data and set up columns
    @FXML
    public void initialize() {
        orderIdCol.setCellValueFactory(cellData -> cellData.getValue().orderIdProperty());
        customerNameCol.setCellValueFactory(cellData -> cellData.getValue().customerNameProperty());
        productCol.setCellValueFactory(cellData -> cellData.getValue().productProperty());
        quantityCol.setCellValueFactory(cellData -> cellData.getValue().quantityProperty());

        // Add some sample data
        orderList.add(new Order("O001", "John Doe", "Laptop", "1"));
        orderList.add(new Order("O002", "Jane Smith", "Smartphone", "2"));

        orderTable.setItems(orderList);
    }

    // Handle row selection
    @FXML
    public void handleRowSelect(MouseEvent event) {
        Order selectedOrder = orderTable.getSelectionModel().getSelectedItem();
        if (selectedOrder != null) {
            orderIdField.setText(selectedOrder.getOrderId());
            customerNameField.setText(selectedOrder.getCustomerName());
            productField.setText(selectedOrder.getProduct());
            quantityField.setText(selectedOrder.getQuantity());
        }
    }

    // Add a new order
    @FXML
    public void handleAdd(ActionEvent event) {
        String orderId = orderIdField.getText();
        String customerName = customerNameField.getText();
        String product = productField.getText();
        String quantity = quantityField.getText();

        if (orderId.isEmpty() || customerName.isEmpty() || product.isEmpty() || quantity.isEmpty()) {
            showAlert("Error", "Please fill in all fields!", Alert.AlertType.ERROR);
        } else {
            Order newOrder = new Order(orderId, customerName, product, quantity);
            orderList.add(newOrder);
            clearFields();
            showAlert("Success", "Order added successfully!", Alert.AlertType.INFORMATION);
        }
    }

    // Edit selected order
    @FXML
    public void handleEdit(ActionEvent event) {
        Order selectedOrder = orderTable.getSelectionModel().getSelectedItem();
        if (selectedOrder != null) {
            selectedOrder.setOrderId(orderIdField.getText());
            selectedOrder.setCustomerName(customerNameField.getText());
            selectedOrder.setProduct(productField.getText());
            selectedOrder.setQuantity(quantityField.getText());
            orderTable.refresh();
            clearFields();
            showAlert("Success", "Order updated successfully!", Alert.AlertType.INFORMATION);
        } else {
            showAlert("Error", "Please select an order to edit!", Alert.AlertType.ERROR);
        }
    }

    // Delete selected order
    @FXML
    public void handleDelete(ActionEvent event) {
        Order selectedOrder = orderTable.getSelectionModel().getSelectedItem();
        if (selectedOrder != null) {
            orderList.remove(selectedOrder);
            clearFields();
            showAlert("Success", "Order deleted successfully!", Alert.AlertType.INFORMATION);
        } else {
            showAlert("Error", "Please select an order to delete!", Alert.AlertType.ERROR);
        }
    }

    // Show alert dialog
    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Clear input fields
    private void clearFields() {
        orderIdField.clear();
        customerNameField.clear();
        productField.clear();
        quantityField.clear();
    }
}
