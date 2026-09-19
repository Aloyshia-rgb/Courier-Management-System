package com.aec.service;

import com.aec.exception.CourierNotFoundException;
import com.aec.model.Courier;
import com.aec.repository.CourierRepository;

import java.util.List;

public class CourierServiceImpl
        implements CourierService {

    private CourierRepository repository;

    public CourierServiceImpl(
            CourierRepository repository) {

        this.repository = repository;
    }

    @Override
    public void bookCourier(Courier courier) {

        if (courier.getCustomerId() <= 0) {

            System.out.println(
                    "Invalid customer ID.");

            return;
        }

        if (courier.getReceiverName() == null ||
                courier.getReceiverName().trim().isEmpty()) {

            System.out.println(
                    "Receiver name cannot be empty.");

            return;
        }

        if (courier.getSource() == null ||
                courier.getSource().trim().isEmpty()) {

            System.out.println(
                    "Source cannot be empty.");

            return;
        }

        if (courier.getDestination() == null ||
                courier.getDestination().trim().isEmpty()) {

            System.out.println(
                    "Destination cannot be empty.");

            return;
        }

        if (courier.getWeight() <= 0) {

            System.out.println(
                    "Weight must be greater than zero.");

            return;
        }

        repository.bookCourier(courier);
    }

    @Override
    public Courier trackCourier(int id)
            throws CourierNotFoundException {

        Courier courier =
                repository.getCourierById(id);

        if (courier == null) {

            throw new CourierNotFoundException(
                    "Courier with ID " +
                    id +
                    " was not found.");
        }

        return courier;
    }

    @Override
    public List<Courier> getAllCouriers() {

        return repository.getAllCouriers();
    }

    @Override
    public void updateStatus(
            int id,
            String status)
            throws CourierNotFoundException {

        Courier courier =
                repository.getCourierById(id);

        if (courier == null) {

            throw new CourierNotFoundException(
                    "Courier with ID " +
                    id +
                    " was not found.");
        }

        repository.updateStatus(
                id,
                status);
    }

    @Override
    public void deleteCourier(int id) {

        repository.deleteCourier(id);
    }
}