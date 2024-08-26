package com.crime.management.menu;

import com.crime.management.exception.PoliceOfficerException;
import com.crime.management.model.Enums.Role;
import com.crime.management.model.PoliceOfficer;
import com.crime.management.service.PoliceOfficerService;

import java.util.List;
import java.util.Scanner;

public class ManagePoliceOfficers {

    private final PoliceOfficerService policeOfficerService;
    private final Scanner scanner = new Scanner(System.in);

    public ManagePoliceOfficers(PoliceOfficerService policeOfficerService) {
        this.policeOfficerService = policeOfficerService;
    }

    public void displayMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\nManage Police Officers Menu:");
            System.out.println("1. Add Police Officer");
            System.out.println("2. View All Police Officers");
            System.out.println("3. Search Police Officer by Name");
            System.out.println("4. Update Police Officer");
            System.out.println("5. Delete Police Officer");
            System.out.println("6. Back");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addPoliceOfficer();
                    break;
                case 2:
                    viewAllPoliceOfficers();
                    break;
                case 3:
                    searchPoliceOfficerByName();
                    break;
                case 4:
                    //updatePoliceOfficer();
                    break;
                case 5:
                    //deletePoliceOfficer();
                    break;
                case 6:
                    running = false; // Return to main menu
                    break;
                case 7:
                    System.exit(0); // Exit application
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addPoliceOfficer() {
        System.out.println("Enter police officer name:");
        String name = scanner.nextLine();

        System.out.println("Enter badge number:");
        String badgeNumber = scanner.nextLine();

        System.out.println("Enter rank (e.g., ADMIN, POLICE_OFFICER):");
        String rank = scanner.nextLine();
        Role roleEnum = Role.valueOf(rank.toUpperCase());

        System.out.println("Enter police station ID:");
        int stationId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        PoliceOfficer officer = new PoliceOfficer(0, name, badgeNumber, roleEnum, stationId);
        try {
            policeOfficerService.addPoliceOfficer(officer);
            System.out.println("Police officer added successfully.");
        } catch (PoliceOfficerException e) {
            System.out.println("Error adding police officer: " + e.getMessage());
        }
    }

    private void viewAllPoliceOfficers() {
        try {
            List<PoliceOfficer> officers = policeOfficerService.getAllPoliceOfficers();
            if (officers.isEmpty()) {
                System.out.println("No police officers found.");
            } else {
                for (PoliceOfficer officer : officers) {
                    System.out.println(officer);
                }
            }
        } catch (PoliceOfficerException e) {
            System.out.println("Error retrieving police officers: " + e.getMessage());
        }
    }

    private void searchPoliceOfficerByName() {
        System.out.println("Enter police officer name to search:");
        String name = scanner.nextLine();

        try {
            PoliceOfficer officer = policeOfficerService.searchPoliceOfficerByName(name);
            if (officer == null) {
                System.out.println("No police officer found with the specified name.");
            } else {
                System.out.println(officer);
            }
        } catch (PoliceOfficerException e) {
            System.out.println("Error searching for police officer: " + e.getMessage());
        }
    }

    /*
     private void updatePoliceOfficer() {
        System.out.println("Enter police officer ID to update:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter new police officer name:");
        String name = scanner.nextLine();

        System.out.println("Enter new badge number:");
        String badgeNumber = scanner.nextLine();

        System.out.println("Enter new rank (e.g., ADMIN, POLICE_OFFICER):");
        String rank = scanner.nextLine();
        Role roleEnum = Role.valueOf(rank.toUpperCase());

        System.out.println("Enter new police station ID:");
        int stationId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        PoliceOfficer officer = new PoliceOfficer(id, name, badgeNumber, roleEnum, stationId);
        try {
            policeOfficerService.updatePoliceOfficer(officer);
            System.out.println("Police officer updated successfully.");
        } catch (PoliceOfficerException e) {
            System.out.println("Error updating police officer: " + e.getMessage());
        }
    }
    */

   /* private void deletePoliceOfficer() {
        System.out.println("Enter police officer ID to delete:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try {
            policeOfficerService.deletePoliceOfficer(id);
            System.out.println("Police officer deleted successfully.");
        } catch (PoliceOfficerException e) {
            System.out.println("Error deleting police officer: " + e.getMessage());
        } */
    }

