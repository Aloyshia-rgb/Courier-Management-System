package com.aec.repository;

import com.aec.database.Database;
import com.aec.model.Courier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourierRepositoryImpl
        implements CourierRepository {

    @Override
    public void bookCourier(Courier courier) {

        String sql =
                "INSERT INTO courier " +
                "(customer_id, receiver_name, receiver_phone, " +
                "source, destination, courier_type, weight, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = Database.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(
                             sql,
                             Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, courier.getCustomerId());
            ps.setString(2, courier.getReceiverName());
            ps.setString(3, courier.getReceiverPhone());
            ps.setString(4, courier.getSource());
            ps.setString(5, courier.getDestination());
            ps.setString(6, courier.getCourierType());
            ps.setDouble(7, courier.getWeight());
            ps.setString(8, "Booked");

            int rows = ps.executeUpdate();

            if (rows > 0) {

                ResultSet rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    courier.setCourierId(rs.getInt(1));
                }

                System.out.println(
                        "\nCourier booked successfully!");

                System.out.println(
                        "Courier ID : " +
                        courier.getCourierId());
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database Error: " +
                    e.getMessage());
        }
    }

    @Override
    public Courier getCourierById(int id) {

        String sql =
                "SELECT * FROM courier " +
                "WHERE courier_id = ?";

        try (Connection con = Database.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Courier courier = new Courier();

                courier.setCourierId(
                        rs.getInt("courier_id"));

                courier.setCustomerId(
                        rs.getInt("customer_id"));

                courier.setReceiverName(
                        rs.getString("receiver_name"));

                courier.setReceiverPhone(
                        rs.getString("receiver_phone"));

                courier.setSource(
                        rs.getString("source"));

                courier.setDestination(
                        rs.getString("destination"));

                courier.setCourierType(
                        rs.getString("courier_type"));

                courier.setWeight(
                        rs.getDouble("weight"));

                courier.setStatus(
                        rs.getString("status"));

                return courier;
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database Error: " +
                    e.getMessage());
        }

        return null;
    }

    @Override
    public List<Courier> getAllCouriers() {

        List<Courier> couriers =
                new ArrayList<>();

        String sql = "SELECT * FROM courier";

        try (Connection con = Database.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Courier courier = new Courier();

                courier.setCourierId(
                        rs.getInt("courier_id"));

                courier.setCustomerId(
                        rs.getInt("customer_id"));

                courier.setReceiverName(
                        rs.getString("receiver_name"));

                courier.setReceiverPhone(
                        rs.getString("receiver_phone"));

                courier.setSource(
                        rs.getString("source"));

                courier.setDestination(
                        rs.getString("destination"));

                courier.setCourierType(
                        rs.getString("courier_type"));

                courier.setWeight(
                        rs.getDouble("weight"));

                courier.setStatus(
                        rs.getString("status"));

                couriers.add(courier);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database Error: " +
                    e.getMessage());
        }

        return couriers;
    }

    @Override
    public void updateStatus(
            int id,
            String status) {

        String sql =
                "UPDATE courier SET status = ? " +
                "WHERE courier_id = ?";

        try (Connection con = Database.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Courier status updated successfully.");

            } else {

                System.out.println(
                        "Courier not found.");
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database Error: " +
                    e.getMessage());
        }
    }

    @Override
    public void deleteCourier(int id) {

        String sql =
                "DELETE FROM courier " +
                "WHERE courier_id = ?";

        try (Connection con = Database.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Courier deleted successfully.");

            } else {

                System.out.println(
                        "Courier not found.");
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database Error: " +
                    e.getMessage());
        }
    }
}