
package com.crime.management.menu;
import com.crime.management.dao.implementations.CrimeDAOImpl;
import com.crime.management.dao.interfaces.CrimeDAO;
import com.crime.management.service.*;
import com.crime.management.utils.ManageReport;

import java.util.Scanner;

public class AdminMenu {

    private final CrimeService crimeService;
    private final CriminalService criminalService;
    private final PoliceOfficerService policeOfficerService;
    private final PoliceStationService policeStationService;
    private final UserService userService;
    private final Scanner scanner;

    public AdminMenu(CrimeService crimeService, CriminalService criminalService,
                     PoliceOfficerService policeOfficerService, PoliceStationService policeStationService,
                     UserService userService, Scanner scanner) {
        this.crimeService = crimeService;
        this.criminalService = criminalService;
        this.policeOfficerService = policeOfficerService;
        this.policeStationService = policeStationService;
        this.userService = userService;
        this.scanner = scanner;
    }

    public void showAdminMenu() {
        boolean running = true;

        ManageCrimes manageCrimes = new ManageCrimes(crimeService);
        ManageCriminals manageCriminals = new ManageCriminals(criminalService);
        ManagePoliceStations managePoliceStations = new ManagePoliceStations(policeStationService);
        ManagePoliceOfficers managePoliceOfficers = new ManagePoliceOfficers(policeOfficerService);
        ManageUsers manageUsers = new ManageUsers(userService);
        ManageReport manageReport = new ManageReport(new CrimeDAOImpl());

        while (running) {
            System.out.println("\nMain Admin Menu:");
            System.out.println("1. Manage Crimes");
            System.out.println("2. Manage Criminals");
            System.out.println("3. Manage Police Stations");
            System.out.println("4. Manage Police Officers");
            System.out.println("5. Manage Users");
            System.out.println("6. Generate Report");
            System.out.println("7. LogOut");
            System.out.println("8. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    manageCrimes.displayMenu();
                    break;
                case 2:
                    manageCriminals.displayMenu();
                    break;
                case 3:
                    managePoliceStations.displayMenu();
                    break;
                case 4:
                    managePoliceOfficers.displayMenu();
                    break;
                case 5:
                    manageUsers.displayMenu();
                    break;
                case 6:
                    manageReport.displayMenu();
                    break;
                case 7:
                    running = false;
                    break;
                case 8:
                    System.exit(0); // Exit application
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}

