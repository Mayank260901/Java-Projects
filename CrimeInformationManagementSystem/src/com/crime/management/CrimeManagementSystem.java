package com.crime.management;

import com.crime.management.model.CrimeType;
import com.crime.management.model.Crime;
import com.crime.management.model.Criminal;
import com.crime.management.service.CrimeService;
import com.crime.management.service.CriminalService;
import com.crime.management.service.UserService;

import java.util.List;
import java.util.Scanner;

public class CrimeManagementSystem {

    public static void main(String[] args) {
        CrimeService crimeService = new CrimeService();
        CriminalService criminalService = new CriminalService();
        UserService userService = new UserService();

        Scanner scanner = new Scanner(System.in);

        // Simple text-based menu for the system
        while (true) {
            System.out.println("\n Crime Management System" +
                    "\n 1. Add Crime" +
                    "\n 2. View All Crimes" +
                    "\n 3. Search Crimes by crimeType" +
                    "\n 4. Update Crime Status" +
                    "\n 5. Add Criminal" +
                    "\n 6. View All Criminals" +
                    "\n 7. Search Criminals by Name" +
                    "\n 8. Search Criminal by Crime Type"+
                    "\n 9. Search Criminal by Police Station" +
                    "\n 10. Exit" +
                    "\n Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Add Crime
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter place: ");
                    String place = scanner.nextLine();
                    System.out.print("Enter crime type: ");
                    CrimeType Type = CrimeType.valueOf(scanner.nextLine());
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter status (Solved/Unsolved): ");
                    String status = scanner.nextLine();

                    Crime newCrime = new Crime(0, date, place, Type, description, status);
                    crimeService.addCrime(newCrime);
                    System.out.println("Crime added successfully.");
                    break;

                case 2:
                    // View All Crimes
                    List<Crime> crimes = crimeService.getAllCrimes();
                    for (Crime crime : crimes) {
                        System.out.println(crime);
                    }
                    break;

                case 3:
                    // Search Crimes by crimeType
                    System.out.print("Enter crime type (ROBBERY, THEFT, HOMICIDE, BURGLARY, ASSAULT): ");
                    String crimeTypeInputForCrime = scanner.next().toUpperCase();
                    CrimeType crimeTypeForCrime = CrimeType.valueOf(crimeTypeInputForCrime);
                    List<Crime> crimesByType = crimeService.getCrimesByType(crimeTypeForCrime);
                    crimesByType.forEach(System.out::println);
                    break;

                case 4:
                    // Update Crime Status
                    System.out.print("Enter crime ID to update: ");
                    int crimeId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new status (Solved/Unsolved): ");
                    String newStatus = scanner.nextLine();
                    crimeService.updateCrimeStatus(crimeId, newStatus);
                    System.out.println("Crime status updated successfully.");
                    break;

                case 5:
                    // Add Criminal
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter identifying mark: ");
                    String identifyingMark = scanner.nextLine();
                    System.out.print("Enter area of crime: ");
                    String areaOfCrime = scanner.nextLine();

                    Criminal newCriminal = new Criminal(0, name, age, gender, address, identifyingMark, areaOfCrime);
                    criminalService.addCriminal(newCriminal);
                    System.out.println("Criminal added successfully.");
                    break;

                case 6:
                    // View All Criminals
                    List<Criminal> criminals = criminalService.getAllCriminals();
                    if (criminals.isEmpty()) {
                        System.out.println("No criminals found.");
                    } else {
                        for (Criminal criminal : criminals) {
                            System.out.println(criminal);
                        }
                    }
                    break;


                case 7:
                    // Search Criminals by Name
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    List<Criminal> searchedCriminals = criminalService.searchCriminalsByName(searchName);
                    for (Criminal criminal : searchedCriminals) {
                        System.out.println(criminal);
                    }
                    break;

                case 8:
                    // Search Criminal by Crime Type
                    System.out.print("Enter crime type (ROBBERY, THEFT, HOMICIDE, BURGLARY, ASSAULT): ");
                    String crimeTypeInput = scanner.next().toUpperCase();
                    CrimeType crimeType = CrimeType.valueOf(crimeTypeInput);
                    List<Criminal> criminalsByCrimeType = criminalService.getCriminalsByCrimeType(crimeType);
                    criminalsByCrimeType.forEach(System.out::println);
                    break;

                case 9:
                    // Search Criminal by Police Station
                    System.out.print("Enter police station name: ");
                    String policeStation = scanner.next();
                    List<Criminal> criminalsByPoliceStation = criminalService.getCriminalsByPoliceStation(policeStation);
                    criminalsByPoliceStation.forEach(System.out::println);
                    break;

                case 10:
                    // Exit
                    System.out.println("Exiting Crime Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);


                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
