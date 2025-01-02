package model.bean;

public class PriceTotal {
    private String orderID;
    private String serviceID;
    private double shipPrice;
    private double orderPrice;
    private double orderCod;
    private double shipSurcharge;
    private double total;
    private double recipientPay;

    public PriceTotal(String orderID, String serviceID, double shipPrice, double orderPrice,
                      double orderCod, double shipSurcharge, double total, double recipientPay) {
        this.orderID = orderID;
        this.serviceID = serviceID;
        this.shipPrice = shipPrice;
        this.orderPrice = orderPrice;
        this.orderCod = orderCod;
        this.shipSurcharge = shipSurcharge;
        this.total = total;
        this.recipientPay = recipientPay;
    }

    // Getters và Setters
    public String getOrderID() { return orderID; }
    public void setOrderID(String orderID) { this.orderID = orderID; }

    public String getServiceID() { return serviceID; }
    public void setServiceID(String serviceID) { this.serviceID = serviceID; }

    public double getShipPrice() { return shipPrice; }
    public void setShipPrice(double shipPrice) { this.shipPrice = shipPrice; }

    public double getOrderPrice() { return orderPrice; }
    public void setOrderPrice(double orderPrice) { this.orderPrice = orderPrice; }

    public double getOrderCod() { return orderCod; }
    public void setOrderCod(double orderCod) { this.orderCod = orderCod; }

    public double getShipSurcharge() { return shipSurcharge; }
    public void setShipSurcharge(double shipSurcharge) { this.shipSurcharge = shipSurcharge; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public double getRecipientPay() { return recipientPay; }
    public void setRecipientPay(double recipientPay) { this.recipientPay = recipientPay; }
}

