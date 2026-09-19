package com.aec.repository;

import com.aec.model.Courier;

import java.util.List;

public interface CourierRepository {

    void bookCourier(Courier courier);

    Courier getCourierById(int id);

    List<Courier> getAllCouriers();

    void updateStatus(int id, String status);

    void deleteCourier(int id);
}