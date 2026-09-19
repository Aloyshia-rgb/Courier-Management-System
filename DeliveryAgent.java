package com.aec.model;

public class DeliveryAgent {

    private int agentId;
    private String agentName;
    private String phone;
    private String vehicleNumber;
    private String availability;

    public DeliveryAgent() {
    }

    public DeliveryAgent(String agentName,
                         String phone,
                         String vehicleNumber,
                         String availability) {

        this.agentName = agentName;
        this.phone = phone;
        this.vehicleNumber = vehicleNumber;
        this.availability = availability;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {

        return "\n========== DELIVERY AGENT ==========" +
               "\nAgent ID       : " + agentId +
               "\nAgent Name     : " + agentName +
               "\nPhone          : " + phone +
               "\nVehicle Number : " + vehicleNumber +
               "\nAvailability   : " + availability +
               "\n====================================";
    }
}