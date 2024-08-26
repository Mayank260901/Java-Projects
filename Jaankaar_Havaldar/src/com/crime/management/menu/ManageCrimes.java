package com.crime.management.menu;

import com.crime.management.model.Crime;
import com.crime.management.model.Enums.CrimeType;
import com.crime.management.model.Enums.Status;
import com.crime.management.service.CrimeService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ManageCrimes {

    private final CrimeService crimeService;
    private final Scanner scanner = new Scanner(System.in);

    public ManageCrimes(CrimeService crimeService) {
        this.crimeService = crimeService;
    }

    public void displayMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\nManage Crimes Menu:");
            System.out.println("1. Add Crime");
            System.out.println("2. View All Crimes");
            System.out.println("3. Search Crimes by Type");
            System.out.println("4. Search Crime by ID");
            System.out.println("5. Update Crime Status");
            System.out.println("6. Update Crime");
            System.out.println("7. Delete Crime");
            System.out.println("8. Back");
            System.out.println("9. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCrime();
                    break;
                case 2:
                    viewAllCrimes();
                    break;
                case 3:
                    searchCrimesByType();
                    break;
                case 4:
                    searchCrimeById();
                    break;
                case 5:
                    updateCrimeStatus();
                    break;
                case 6:
                    updateCrime();
                    break;
                case 7:
                    deleteCrime();
                    break;
                case 8:
                    running = false; // Return to main menu
                    break;
                case 9:
                    System.exit(0); // Exit application
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addCrime() {
        System.out.println("Enter crime type (e.g., ROBBERY, HOMICIDE):");
        String type = scanner.nextLine();
        CrimeType crimeType = CrimeType.valueOf(type.toUpperCase());

        System.out.println("Enter crime description:");
        String description = scanner.nextLine();

        System.out.println("Enter crime date (YYYY-MM-DD):");
        String date = scanner.nextLine();
        LocalDate crimeDate = LocalDate.parse(date);

        System.out.println("Enter crime status (OPEN, CLOSED, IN_PROGRESS):");
        String status = scanner.nextLine();
        Status crimeStatus = Status.valueOf(status.toUpperCase());

        System.out.println("Enter police station ID:");
        int stationId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter suspect (optional):");
        String suspect = scanner.nextLine();

        Crime crime = new Crime(0, crimeType, description, crimeDate, crimeStatus, stationId, suspect);
        crimeService.addCrime(crime);
        System.out.println("Crime added successfully.");
    }

    private void viewAllCrimes() {
        List<Crime> crimes = crimeService.getAllCrimes();
        if (crimes.isEmpty()) {
            System.out.println("No crimes found.");
        } else {
            for (Crime crime : crimes) {
                System.out.println(crime);
            }
        }
    }

    private void searchCrimesByType() {
        System.out.println("Enter crime type to search (e.g., ROBBERY, HOMICIDE):");
        String type = scanner.nextLine();
        CrimeType crimeType = CrimeType.valueOf(type.toUpperCase());

        List<Crime> crimes = crimeService.searchCrimesByType(type);
        if (crimes.isEmpty()) {
            System.out.println("No crimes found for the specified type.");
        } else {
            for (Crime crime : crimes) {
                System.out.println(crime);
            }
        }
    }

    private void searchCrimeById() {
        System.out.println("Enter crime ID to search:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Crime crime = crimeService.searchCrimesById(id);
        if (crime == null) {
            System.out.println("No crime found with the specified ID.");
        } else {
            System.out.println(crime);
        }
    }

    private void updateCrimeStatus() {
        System.out.println("Enter crime ID to update status:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter new crime status (OPEN, CLOSED, IN_PROGRESS):");
        String status = scanner.nextLine();
        Status crimeStatus = Status.valueOf(status.toUpperCase());

        crimeService.updateCrimeStatus(id, status);
        System.out.println("Crime status updated successfully.");
    }

    private void updateCrime() {
        System.out.println("Enter crime ID to update:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter new crime type (e.g., ROBBERY, HOMICIDE):");
        String type = scanner.nextLine();
        CrimeType crimeType = CrimeType.valueOf(type.toUpperCase());

        System.out.println("Enter new crime description:");
        String description = scanner.nextLine();

        System.out.println("Enter new crime date (YYYY-MM-DD):");
        String date = scanner.nextLine();
        LocalDate crimeDate = LocalDate.parse(date);

        System.out.println("Enter new crime status (OPEN, CLOSED, IN_PROGRESS):");
        String status = scanner.nextLine();
        Status crimeStatus = Status.valueOf(status.toUpperCase());

        System.out.println("Enter new police station ID:");
        int stationId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter new suspect (optional):");
        String suspect = scanner.nextLine();

        Crime crime = new Crime(id, crimeType, description, crimeDate, crimeStatus, stationId, suspect);
        crimeService.updateCrime(crime);
        System.out.println("Crime updated successfully.");
    }

    private void deleteCrime() {
        System.out.println("Enter crime ID to delete:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        crimeService.deleteCrime(id);
        System.out.println("Crime deleted successfully.");
    }
}
