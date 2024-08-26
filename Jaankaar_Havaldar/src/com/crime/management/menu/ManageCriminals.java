package com.crime.management.menu;

import com.crime.management.exception.CriminalException;
import com.crime.management.model.Criminal;
import com.crime.management.model.Enums.CrimeType;
import com.crime.management.model.Enums.Gender;
import com.crime.management.model.Enums.PoliceStationName;
import com.crime.management.service.CriminalService;

import java.util.List;
import java.util.Scanner;

public class ManageCriminals {

    private final CriminalService criminalService;
    private final Scanner scanner = new Scanner(System.in);

    public ManageCriminals(CriminalService criminalService) {
        this.criminalService = criminalService;
    }

    public void displayMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\nManage Criminals Menu:");
            System.out.println("1. Add Criminal");
            System.out.println("2. View All Criminals");
            System.out.println("3. Search Criminal by Name");
            System.out.println("4. Search Criminal by ID");
            System.out.println("5. Search Criminals by Crime Type");
            System.out.println("6. Search Criminals by Police Station");
            System.out.println("7. Update Criminal");
            System.out.println("8. Delete Criminal");
            System.out.println("9. Back");
            System.out.println("10. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCriminal();
                    break;
                case 2:
                    viewAllCriminals();
                    break;
                case 3:
                    searchCriminalByName();
                    break;
                case 4:
                    searchCriminalById();
                    break;
                case 5:
                    searchCriminalsByCrimeType();
                    break;
                case 6:
                    searchCriminalsByPoliceStation();
                    break;
                case 7:
                    updateCriminal();
                    break;
                case 8:
                    deleteCriminal();
                    break;
                case 9:
                    running = false; // Return to main menu
                    break;
                case 10:
                    System.exit(0); // Exit application
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addCriminal() {
        System.out.println("Enter criminal name:");
        String name = scanner.nextLine();

        System.out.println("Enter criminal age:");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter criminal gender (MALE, FEMALE, OTHER):");
        String gender = scanner.nextLine();
        Gender genderEnum = Gender.valueOf(gender.toUpperCase());

        System.out.println("Enter crime type (e.g., ROBBERY, HOMICIDE):");
        String crimeType = scanner.nextLine();
        CrimeType crimeTypeEnum = CrimeType.valueOf(crimeType.toUpperCase());

        System.out.println("Enter criminal address:");
        String address = scanner.nextLine();

        System.out.println("Enter identifying mark (optional):");
        String identifyingMark = scanner.nextLine();

        System.out.println("Enter crime ID associated with the criminal:");
        int crimeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter police station name (e.g., CENTRAL_POLICE_STATION):");
        String policeStationName = scanner.nextLine();
        PoliceStationName policeStationNameEnum = PoliceStationName.valueOf(policeStationName.toUpperCase());
        try {
            Criminal criminal = new Criminal(0, name, age, genderEnum, crimeTypeEnum, address, identifyingMark, crimeId, policeStationNameEnum);
            criminalService.addCriminal(criminal);
            System.out.println("Criminal added successfully.");
        } catch (CriminalException e) {
            System.out.println("Error adding  criminals: " + e.getMessage());
        }
    }
    private void viewAllCriminals() {
        try {
            List<Criminal> criminals = criminalService.getAllCriminals();
            if (criminals.isEmpty()) {
                System.out.println("No criminals found.");
            } else {
                for (Criminal criminal : criminals) {
                    System.out.println(criminal);
                }
            }
        } catch (CriminalException e) {
            System.out.println("Error retrieving criminals: " + e.getMessage());
        }
    }

    private void searchCriminalByName() {
        System.out.println("Enter criminal name to search:");
        String name = scanner.nextLine();

        try {
            Criminal criminal = criminalService.searchCriminalByName(name);
            if (criminal == null) {
                System.out.println("No criminal found with the specified name.");
            } else {
                System.out.println(criminal);
            }
        } catch (CriminalException e) {
            System.out.println("Error searching for criminal: " + e.getMessage());
        }
    }

    private void searchCriminalById() {
        System.out.println("Enter criminal ID to search:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Criminal criminal = criminalService.getCriminalById(id);
        if (criminal == null) {
            System.out.println("No criminal found with the specified ID.");
        } else {
            System.out.println(criminal);
        }
    }

    private void searchCriminalsByCrimeType() {
        System.out.println("Enter crime type to search (e.g., ROBBERY, HOMICIDE):");
        String type = scanner.nextLine();
        CrimeType crimeTypeEnum = CrimeType.valueOf(type.toUpperCase());

        try {
            List<Criminal> criminals = criminalService.searchCriminalsByCrimeType(crimeTypeEnum);
            if (criminals.isEmpty()) {
                System.out.println("No criminals found for the specified crime type.");
            } else {
                for (Criminal criminal : criminals) {
                    System.out.println(criminal);
                }
            }
        } catch (CriminalException e) {
            System.out.println("Error searching for criminals: " + e.getMessage());
        }
    }

    private void searchCriminalsByPoliceStation() {
        System.out.println("Enter police station name to search (e.g., CENTRAL_POLICE_STATION):");
        String name = scanner.nextLine();
        PoliceStationName policeStationNameEnum = PoliceStationName.valueOf(name.toUpperCase());

        try {
            List<Criminal> criminals = criminalService.searchCriminalsByPoliceStation(policeStationNameEnum);
            if (criminals.isEmpty()) {
                System.out.println("No criminals found for the specified police station.");
            } else {
                for (Criminal criminal : criminals) {
                    System.out.println(criminal);
                }
            }
        } catch (CriminalException e) {
            System.out.println("Error searching for criminals: " + e.getMessage());
        }
    }

    private void updateCriminal() {
        System.out.println("Enter criminal ID to update:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter new criminal name:");
        String name = scanner.nextLine();

        System.out.println("Enter new criminal age:");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter new criminal gender (MALE, FEMALE, OTHER):");
        String gender = scanner.nextLine();
        Gender genderEnum = Gender.valueOf(gender.toUpperCase());

        System.out.println("Enter new crime type (e.g., ROBBERY, HOMICIDE):");
        String crimeType = scanner.nextLine();
        CrimeType crimeTypeEnum = CrimeType.valueOf(crimeType.toUpperCase());

        System.out.println("Enter new criminal address:");
        String address = scanner.nextLine();

        System.out.println("Enter new identifying mark (optional):");
        String identifyingMark = scanner.nextLine();

        System.out.println("Enter new crime ID associated with the criminal:");
        int crimeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter new police station name (e.g., CENTRAL_POLICE_STATION):");
        String policeStationName = scanner.nextLine();
        PoliceStationName policeStationNameEnum = PoliceStationName.valueOf(policeStationName.toUpperCase());

        Criminal criminal = new Criminal(id, name, age, genderEnum, crimeTypeEnum, address, identifyingMark, crimeId, policeStationNameEnum);
        criminalService.updateCriminal(criminal);
        System.out.println("Criminal updated successfully.");
    }

    private void deleteCriminal() {
        System.out.println("Enter criminal ID to delete:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        criminalService.deleteCriminal(id);
        System.out.println("Criminal deleted successfully.");
    }
}
