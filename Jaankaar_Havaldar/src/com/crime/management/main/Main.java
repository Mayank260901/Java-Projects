package com.crime.management.main;

import com.crime.management.dao.implementations.*;
import com.crime.management.dao.interfaces.*;
import com.crime.management.exception.AuthenticationException;
import com.crime.management.model.Enums.Role;
import com.crime.management.model.User;
import com.crime.management.service.*;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static AuthenticationService authenticationService;

    public static void main(String[] args) {
        // Initialize UserDAO and AuthenticationService
        authenticationService = new AuthenticationService(new UserDAOImpl());

        // Creating DAO instances
        CrimeDAO crimeDAO = new CrimeDAOImpl();
        CriminalDAO criminalDAO = new CriminalDAOImpl();
        PoliceOfficerDAO policeOfficerDAO = new PoliceOfficerDAOImpl();
        PoliceStationDAO policeStationDAO = new PoliceStationDAOImpl();
        UserDAO userDAO = new UserDAOImpl();

        // Creating service instances with DAO dependencies
        CrimeService crimeService = new CrimeService(crimeDAO);
        CriminalService criminalService = new CriminalService(criminalDAO);
        PoliceOfficerService policeOfficerService = new PoliceOfficerService(policeOfficerDAO);
        PoliceStationService policeStationService = new PoliceStationService(policeStationDAO);
        UserService userService = new UserService(userDAO);

        // Create RoleBasedMenu instance
        RoleBasedMenu roleBasedMenu = new RoleBasedMenu(crimeService, criminalService, policeOfficerService,
                policeStationService, userService, scanner);

        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to the Crime Information Management System");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    login(roleBasedMenu);
                    break;
                case 2:
                  register();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }


    }

    private static void login(RoleBasedMenu roleBasedMenu) {
        System.out.println("\nLogin");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try {
            User user = authenticationService.login(username, password);
            System.out.println("Login successful!");
            // Passed  the logged-in user to the RoleBasedMenu
            roleBasedMenu.showRoleBasedMenu(user);

        } catch (AuthenticationException e) {
            System.out.println("Login failed: " + e.getMessage());
        }
    }

    private static void register() {
        System.out.println("\nRegister a New User");
        System.out.print("Username: ");
        String newUsername = scanner.nextLine();
        System.out.print("Password: ");
        String newPassword = scanner.nextLine();
        System.out.print("Role:( ADMIN, POLICE_OFFICER, INSPECTOR, CONSTABLE, SUPERINTENDENT, DETECTIVE,USER) ");
        String roleInput = scanner.nextLine().toUpperCase();
        Role role;

        try {
            role = Role.valueOf(roleInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid role. Please try again.");
            return;
        }

        User newUser = new User(0, newUsername, newPassword, role, LocalDateTime.now());
        try {
            authenticationService.register(newUser);
            System.out.println("Registration successful! You can now log in.");
        } catch (AuthenticationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


