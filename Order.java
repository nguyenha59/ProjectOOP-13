package model.bean;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Order {

    private final StringProperty orderId;
    private final StringProperty customerName;
    private final StringProperty product;
    private final StringProperty quantity;

    // Constructor
    public Order(String orderId, String customerName, String product, String quantity) {
        this.orderId = new SimpleStringProperty(orderId);
        this.customerName = new SimpleStringProperty(customerName);
        this.product = new SimpleStringProperty(product);
        this.quantity = new SimpleStringProperty(quantity);
    }

    // Getters
    public String getOrderId() {
        return orderId.get();
    }

    public String getCustomerName() {
        return customerName.get();
    }

    public String getProduct() {
        return product.get();
    }

    public String getQuantity() {
        return quantity.get();
    }

    // Setters
    public void setOrderId(String orderId) {
        this.orderId.set(orderId);
    }

    public void setCustomerName(String customerName) {
        this.customerName.set(customerName);
    }

    public void setProduct(String product) {
        this.product.set(product);
    }

    public void setQuantity(String quantity) {
        this.quantity.set(quantity);
    }

    // Property getters for TableView bindings
    public StringProperty orderIdProperty() {
        return orderId;
    }

    public StringProperty customerNameProperty() {
        return customerName;
    }

    public StringProperty productProperty() {
        return product;
    }

    public StringProperty quantityProperty() {
        return quantity;
    }
}
