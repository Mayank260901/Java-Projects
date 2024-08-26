package com.crime.management.main;

import com.crime.management.menu.AdminMenu;
import com.crime.management.model.User;
import com.crime.management.service.*;

import java.util.Scanner;

public class RoleBasedMenu {
    private final CrimeService crimeService;
    private final CriminalService criminalService;
    private final PoliceOfficerService policeOfficerService;
    private final PoliceStationService policeStationService;
    private final UserService userService;
    private final Scanner scanner;

    public RoleBasedMenu(CrimeService crimeService, CriminalService criminalService,
                         PoliceOfficerService policeOfficerService, PoliceStationService policeStationService,
                         UserService userService, Scanner scanner) {
        this.crimeService = crimeService;
        this.criminalService = criminalService;
        this.policeOfficerService = policeOfficerService;
        this.policeStationService = policeStationService;
        this.userService = userService;
        this.scanner = scanner;
    }

    public void showRoleBasedMenu(User user) {
        switch (user.getRole()) {
            case ADMIN:
                AdminMenu adminMenu = new AdminMenu(crimeService, criminalService, policeOfficerService,
                        policeStationService, userService, scanner);
                adminMenu.showAdminMenu();
                break;
            case POLICE_OFFICER:
                showPoliceOfficerMenu(scanner);
                break;
            case INSPECTOR:
                showInspectorMenu(scanner);
                break;
            case CONSTABLE:
                showConstableMenu(scanner);
                break;
            case SUPERINTENDENT:
                showSuperintendentMenu(scanner);
                break;
            case DETECTIVE:
                showDetectiveMenu(scanner);
                break;
            case USER:
                showUserMenu(scanner);
                break;
            default:
                System.out.println("Invalid role! Cannot redirect to any menu.");


        }
    }


    private static void showPoliceOfficerMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nPolice Officer Menu:");
            System.out.println("1. Report a Crime");
            System.out.println("2. View Assigned Cases");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Reporting a crime...");
                    // Add code to report a crime
                    break;
                case 2:
                    System.out.println("Viewing assigned cases...");
                    // Add code to view assigned cases
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void showInspectorMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nInspector Menu:");
            System.out.println("1. View Crime Reports");
            System.out.println("2. Assign Cases to Officers");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Viewing crime reports...");
                    // Add code to view crime reports
                    break;
                case 2:
                    System.out.println("Assigning cases to officers...");
                    // Add code to assign cases
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void showConstableMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nConstable Menu:");
            System.out.println("1. Patrol Area");
            System.out.println("2. Assist in Investigations");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Patrolling area...");
                    // Add code to patrol area
                    break;
                case 2:
                    System.out.println("Assisting in investigations...");
                    // Add code to assist in investigations
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void showSuperintendentMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nSuperintendent Menu:");
            System.out.println("1. Oversee Department Operations");
            System.out.println("2. Approve Case Closures");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Overseeing department operations...");
                    // Add code to oversee department operations
                    break;
                case 2:
                    System.out.println("Approving case closures...");
                    // Add code to approve case closures
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void showDetectiveMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nDetective Menu:");
            System.out.println("1. Investigate Crimes");
            System.out.println("2. Analyze Evidence");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Investigating crimes...");
                    // Add code to investigate crimes
                    break;
                case 2:
                    System.out.println("Analyzing evidence...");
                    // Add code to analyze evidence
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void showUserMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nUser Menu:");
            System.out.println("1. View Crime Statistics");
            System.out.println("2. Report a Suspicious Activity");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Viewing crime statistics...");
                    // Add code to view crime statistics
                    break;
                case 2:
                    System.out.println("Reporting suspicious activity...");
                    // Add code to report suspicious activity
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }


}





