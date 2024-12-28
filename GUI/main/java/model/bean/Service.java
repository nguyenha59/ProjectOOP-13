package model.bean;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Service {
    private final StringProperty serviceID;
    private final StringProperty serviceName;
    private final StringProperty price;  // Giá sẽ là String
    private final StringProperty maxDistance;

    // Constructor sử dụng String cho price
    public Service(String serviceID, String serviceName, String maxDistance, String price) {
        this.serviceID = new SimpleStringProperty(serviceID);
        this.serviceName = new SimpleStringProperty(serviceName);
        this.maxDistance = new SimpleStringProperty(maxDistance);
        this.price = new SimpleStringProperty(price);
    }

    // Getter và setter cho các thuộc tính
    public String getServiceID() {
        return serviceID.get();
    }

    public void setServiceID(String serviceID) {
        this.serviceID.set(serviceID);
    }

    public String getServiceName() {
        return serviceName.get();
    }

    public void setServiceName(String serviceName) {
        this.serviceName.set(serviceName);
    }

    public String getPrice() {
        return price.get();
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getMaxDistance() {
        return maxDistance.get();
    }

    public void setMaxDistance(String maxDistance) {
        this.maxDistance.set(maxDistance);
    }

    // Các method cần thiết để sử dụng trong TableView
    public StringProperty serviceIDProperty() {
        return serviceID;
    }

    public StringProperty serviceNameProperty() {
        return serviceName;
    }

    public StringProperty priceProperty() {
        return price;
    }

    public StringProperty maxDistanceProperty() {
        return maxDistance;
    }

@Override
    public String toString() {
        return "Service{" +
                "serviceID='" + serviceID.get() + '\'' +
                ", serviceName='" + serviceName.get() + '\'' +
                ", price=" + price.get() +
                ", maxDistance='" + maxDistance.get() + '\'' +
                '}';
    }
}


