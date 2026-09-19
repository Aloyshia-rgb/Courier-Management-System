package com.aec.model;

public class Payment {

    private int paymentId;
    private int courierId;
    private double amount;
    private String paymentMethod;
    private String paymentStatus;

    public Payment() {
    }

    public Payment(int courierId,
                   double amount,
                   String paymentMethod,
                   String paymentStatus) {

        this.courierId = courierId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getCourierId() {
        return courierId;
    }

    public void setCourierId(int courierId) {
        this.courierId = courierId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {

        return "\n========== PAYMENT ==========" +
               "\nPayment ID     : " + paymentId +
               "\nCourier ID     : " + courierId +
               "\nAmount         : ₹" + amount +
               "\nPayment Method : " + paymentMethod +
               "\nPayment Status : " + paymentStatus +
               "\n=============================";
    }
}