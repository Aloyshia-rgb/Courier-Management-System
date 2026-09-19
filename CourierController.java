package com.aec.controller;

import com.aec.exception.CourierNotFoundException;
import com.aec.model.Courier;
import com.aec.service.CourierService;

import java.util.List;

public class CourierController {

    private CourierService service;

    public CourierController(
            CourierService service) {

        this.service = service;
    }

    public void bookCourier(Courier courier) {

        service.bookCourier(courier);
    }

    public void trackCourier(int id) {

        try {

            Courier courier =
                    service.trackCourier(id);

            System.out.println(courier);

        } catch (CourierNotFoundException e) {

            System.out.println(
                    "Error: " +
                    e.getMessage());
        }
    }

    public void viewAllCouriers() {

        List<Courier> couriers =
                service.getAllCouriers();

        if (couriers.isEmpty()) {

            System.out.println(
                    "No courier records found.");

            return;
        }

        for (Courier courier : couriers) {

            System.out.println(courier);
        }
    }

    public void updateStatus(
            int id,
            String status) {

        try {

            service.updateStatus(
                    id,
                    status);

        } catch (CourierNotFoundException e) {

            System.out.println(
                    "Error: " +
                    e.getMessage());
        }
    }

    public void deleteCourier(int id) {

        service.deleteCourier(id);
    }
}