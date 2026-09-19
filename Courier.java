package com.aec.model;

public class Courier {

    private int courierId;
    private int customerId;

    private String receiverName;
    private String receiverPhone;

    private String source;
    private String destination;

    private String courierType;
    private double weight;

    private String status;

    public Courier() {
    }

    public Courier(int customerId,
                   String receiverName,
                   String receiverPhone,
                   String source,
                   String destination,
                   String courierType,
                   double weight) {

        this.customerId = customerId;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.source = source;
        this.destination = destination;
        this.courierType = courierType;
        this.weight = weight;
        this.status = "Booked";
    }

    public int getCourierId() {
        return courierId;
    }

    public void setCourierId(int courierId) {
        this.courierId = courierId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCourierType() {
        return courierType;
    }

    public void setCourierType(String courierType) {
        this.courierType = courierType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return "\n========== COURIER DETAILS ==========" +
               "\nCourier ID     : " + courierId +
               "\nCustomer ID    : " + customerId +
               "\nReceiver Name  : " + receiverName +
               "\nReceiver Phone : " + receiverPhone +
               "\nSource         : " + source +
               "\nDestination    : " + destination +
               "\nCourier Type   : " + courierType +
               "\nWeight         : " + weight + " kg" +
               "\nStatus         : " + status +
               "\n=====================================";
    }
}