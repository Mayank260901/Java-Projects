package com.crime.management.menu;

import com.crime.management.exception.PoliceStationException;
import com.crime.management.model.Enums.PoliceStationName;
import com.crime.management.model.PoliceStation;
import com.crime.management.service.PoliceStationService;

import java.util.List;
import java.util.Scanner;

public class ManagePoliceStations {

    private final PoliceStationService policeStationService;
    private final Scanner scanner = new Scanner(System.in);

    public ManagePoliceStations(PoliceStationService policeStationService) {
        this.policeStationService = policeStationService;
    }

    public void displayMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\nManage Police Stations Menu:");
            System.out.println("1. Add Police Station");
            System.out.println("2. View All Police Stations");
            System.out.println("3. Search Police Station by Name");
            System.out.println("4. Search Police Station by ID");
            System.out.println("5. Update Police Station");
            System.out.println("6. Delete Police Station");
            System.out.println("7. Back");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addPoliceStation();
                    break;
                case 2:
                    viewAllPoliceStations();
                    break;
                case 3:
                    searchPoliceStationById();
                    break;
                case 4:
                    searchPoliceStationByName();
                    break;
                case 5:
                    updatePoliceStation();
                    break;
                case 6:
                    deletePoliceStation();
                    break;
                case 7:
                    running = false; // Return to main menu
                    break;
                case 8:
                    System.exit(0); // Exit application
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void searchPoliceStationById() {
        System.out.println("Enter police station ID to search ");
        int Id = scanner.nextInt();

        try {
            PoliceStation station = policeStationService.getPoliceStationById(Id);
            if (station == null) {
                System.out.println("No police station found with the specified name.");
            } else {
                System.out.println(station);
            }
        } catch (PoliceStationException e) {
            System.out.println("Error searching for police station: " + e.getMessage());
        }
    }

    private void addPoliceStation() {
        System.out.println("Enter police station name (e.g., CENTRAL_POLICE_STATION):");
        String name = scanner.nextLine();
        PoliceStationName stationNameEnum = PoliceStationName.valueOf(name.toUpperCase());

        System.out.println("Enter police station location:");
        String location = scanner.nextLine();

        PoliceStation station = new PoliceStation(0, stationNameEnum, location);
        try {
            policeStationService.addPoliceStation(station);
            System.out.println("Police station added successfully.");
        } catch (PoliceStationException e) {
            System.out.println("Error adding police station: " + e.getMessage());
        }
    }

    private void viewAllPoliceStations() {
        try {
            List<PoliceStation> stations = policeStationService.getAllPoliceStations();
            if (stations.isEmpty()) {
                System.out.println("No police stations found.");
            } else {
                for (PoliceStation station : stations) {
                    System.out.println(station);
                }
            }
        } catch (PoliceStationException e) {
            System.out.println("Error retrieving police stations: " + e.getMessage());
        }
    }

    private void searchPoliceStationByName() {
        System.out.println("Enter police station name to search (e.g., CENTRAL_POLICE_STATION):");
        String name = scanner.nextLine();
        PoliceStationName stationNameEnum = PoliceStationName.valueOf(name.toUpperCase());

        try {
            PoliceStation station = policeStationService.searchPoliceStationByName(String.valueOf(stationNameEnum));
            if (station == null) {
                System.out.println("No police station found with the specified name.");
            } else {
                System.out.println(station);
            }
        } catch (PoliceStationException e) {
            System.out.println("Error searching for police station: " + e.getMessage());
        }
    }

    private void updatePoliceStation() {
        System.out.println("Enter police station ID to update:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter new police station name (e.g., CENTRAL_POLICE_STATION):");
        String name = scanner.nextLine();
        PoliceStationName stationNameEnum = PoliceStationName.valueOf(name.toUpperCase());

        System.out.println("Enter new police station location:");
        String location = scanner.nextLine();


        try {
            PoliceStation station = new PoliceStation(id, stationNameEnum, location);
            policeStationService.updatePoliceStation(station);
            System.out.println("Police station updated successfully.");
        } catch (PoliceStationException e) {
            System.out.println("Error updating police station: " + e.getMessage());
        }
    }

    private void deletePoliceStation() {
        System.out.println("Enter police station ID to delete:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try {
            policeStationService.deletePoliceStation(id);
            System.out.println("Police station deleted successfully.");
        } catch (PoliceStationException e) {
            System.out.println("Error deleting police station: " + e.getMessage());
        }
    }
}
