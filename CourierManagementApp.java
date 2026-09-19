package com.aec.main;

import com.aec.controller.CourierController;
import com.aec.model.Courier;
import com.aec.repository.CourierRepository;
import com.aec.repository.CourierRepositoryImpl;
import com.aec.service.CourierService;
import com.aec.service.CourierServiceImpl;

import java.util.Scanner;

public class CourierManagementApp {

    private static Scanner scanner =
            new Scanner(System.in);

    private static CourierController controller;

    public static void main(String[] args) {

        // Repository
        CourierRepository repository =
                new CourierRepositoryImpl();

        // Service
        CourierService service =
                new CourierServiceImpl(repository);

        // Controller
        controller =
                new CourierController(service);

        System.out.println(
                "======================================");

        System.out.println(
                "       COURIER MANAGEMENT SYSTEM");

        System.out.println(
                "======================================");

        while (true) {

            System.out.println(
                    "\n------------- MENU -------------");

            System.out.println(
                    "1. Book Courier");

            System.out.println(
                    "2. Track Courier");

            System.out.println(
                    "3. View All Couriers");

            System.out.println(
                    "4. Update Courier Status");

            System.out.println(
                    "5. Delete Courier");

            System.out.println(
                    "6. Exit");

            System.out.println(
                    "--------------------------------");

            System.out.print(
                    "Enter your choice: ");

            int choice =
                    scanner.nextInt();

            scanner.nextLine();

            switch (choice) {

                case 1:

                    bookCourier();

                    break;

                case 2:

                    trackCourier();

                    break;

                case 3:

                    controller.viewAllCouriers();

                    break;

                case 4:

                    updateStatus();

                    break;

                case 5:

                    deleteCourier();

                    break;

                case 6:

                    System.out.println(
                            "\nThank you!");

                    scanner.close();

                    return;

                default:

                    System.out.println(
                            "Invalid choice.");
            }
        }
    }

    private static void bookCourier() {

        System.out.println(
                "\n========== BOOK COURIER ==========");

        System.out.print(
                "Enter Customer ID: ");

        int customerId =
                scanner.nextInt();

        scanner.nextLine();

        System.out.print(
                "Enter Receiver Name: ");

        String receiverName =
                scanner.nextLine();

        System.out.print(
                "Enter Receiver Phone: ");

        String receiverPhone =
                scanner.nextLine();

        System.out.print(
                "Enter Source: ");

        String source =
                scanner.nextLine();

        System.out.print(
                "Enter Destination: ");

        String destination =
                scanner.nextLine();

        System.out.print(
                "Enter Courier Type: ");

        String courierType =
                scanner.nextLine();

        System.out.print(
                "Enter Weight (kg): ");

        double weight =
                scanner.nextDouble();

        Courier courier =
                new Courier(
                        customerId,
                        receiverName,
                        receiverPhone,
                        source,
                        destination,
                        courierType,
                        weight);

        controller.bookCourier(courier);
    }

    private static void trackCourier() {

        System.out.println(
                "\n========== TRACK COURIER ==========");

        System.out.print(
                "Enter Courier ID: ");

        int id =
                scanner.nextInt();

        controller.trackCourier(id);
    }

    private static void updateStatus() {

        System.out.println(
                "\n======= UPDATE COURIER STATUS =======");

        System.out.print(
                "Enter Courier ID: ");

        int id =
                scanner.nextInt();

        scanner.nextLine();

        System.out.println(
                "\n1. Booked");

        System.out.println(
                "2. Picked Up");

        System.out.println(
                "3. In Transit");

        System.out.println(
                "4. Out for Delivery");

        System.out.println(
                "5. Delivered");

        System.out.println(
                "6. Cancelled");

        System.out.print(
                "Choose Status: ");

        int choice =
                scanner.nextInt();

        String status;

        switch (choice) {

            case 1:
                status = "Booked";
                break;

            case 2:
                status = "Picked Up";
                break;

            case 3:
                status = "In Transit";
                break;

            case 4:
                status = "Out for Delivery";
                break;

            case 5:
                status = "Delivered";
                break;

            case 6:
                status = "Cancelled";
                break;

            default:

                System.out.println(
                        "Invalid status.");

                return;
        }

        controller.updateStatus(
                id,
                status);
    }

    private static void deleteCourier() {

        System.out.println(
                "\n========== DELETE COURIER ==========");

        System.out.print(
                "Enter Courier ID: ");

        int id =
                scanner.nextInt();

        controller.deleteCourier(id);
    }
}