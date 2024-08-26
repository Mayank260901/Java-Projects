package com.crime.management.menu;

import com.crime.management.model.Enums.Role;
import com.crime.management.model.User;
import com.crime.management.service.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ManageUsers {

    private final UserService userService;
    private final Scanner scanner = new Scanner(System.in);

    public ManageUsers(UserService userService) {
        this.userService = userService;
    }

    public void displayMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\nManage Users Menu:");
            System.out.println("1. Add User");
            System.out.println("2. View All Users");
            System.out.println("3. Get User By ID");
            System.out.println("4. Get User By UserName");
            System.out.println("5. Authenticate User");
            System.out.println("6. Update User");
            System.out.println("7. Delete User");
            System.out.println("8. Back");
            System.out.println("9. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    viewAllUsers();
                    break;
                case 3:
                    getUserByID();
                    break;
                case 4:
                    getUserByUsername();
                    break;
                case 5:
                    authenticateUser();
                    break;
                case 6:
                    updateUser();
                    break;
                case 7:
                    deleteUser();
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



    private void addUser() {
        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        System.out.println("Enter role (e.g., ADMIN, POLICE_OFFICER):");
        String role = scanner.nextLine();
        Role roleEnum = Role.valueOf(role.toUpperCase());

        System.out.println("Enter last login (yyyy-MM-ddTHH:mm:ss):");
        String lastLoginStr = scanner.nextLine();
        LocalDateTime lastLogin = LocalDateTime.parse(lastLoginStr);

        User user = new User(0, username, password, roleEnum, lastLogin);
        try {
            userService.addUser(user);
            System.out.println("User added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding user: " + e.getMessage());
        }
    }

    private void viewAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
            if (users.isEmpty()) {
                System.out.println("No users found.");
            } else {
                for (User user : users) {
                    System.out.println(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error retrieving users: " + e.getMessage());
        }
    }

    private void getUserByUsername() {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        try {
            User user = userService.getUserByUsername(username);
            if (user != null) {
                System.out.println("User found: " + user);
            } else {
                System.out.println("User not found.");
            }

        } catch (Exception e) {
            System.out.println("Error retrieving users: " + e.getMessage());
        }
    }

    private void getUserByID() {

        System.out.println("Enter ID:");
        int Id = scanner.nextInt();
        try {
            User user = userService.getUserById(Id);
            if (user != null) {
                System.out.println("User found: ");
                System.out.println(user);;
            } else {
                System.out.println("User not found.");
            }

        } catch (Exception e) {
            System.out.println("Error retrieving users: " + e.getMessage());
        }

    }

    private void authenticateUser() {
        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        try {
            Optional<User> user = userService.authenticate(username, password);
            if (user.isPresent()) {
                System.out.println("Authentication successful. User details:");
                System.out.println(user.get());
            } else {
                System.out.println("Authentication failed. Invalid username or password.");
            }
        } catch (Exception e) {
            System.out.println("Error during authentication: " + e.getMessage());
        }
    }

    private void updateUser() {
        System.out.println("Enter user ID to update:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter new username:");
        String username = scanner.nextLine();

        System.out.println("Enter new password:");
        String password = scanner.nextLine();

        System.out.println("Enter new role (e.g., ADMIN, POLICE_OFFICER):");
        String role = scanner.nextLine();
        Role roleEnum = Role.valueOf(role.toUpperCase());

        System.out.println("Enter new last login (yyyy-MM-ddTHH:mm:ss):");
        String lastLoginStr = scanner.nextLine();
        LocalDateTime lastLogin = LocalDateTime.parse(lastLoginStr);

        User user = new User(id, username, password, roleEnum, lastLogin);
        try {
            userService.updateUser(user);
            System.out.println("User updated successfully.");
        } catch (Exception e) {
            System.out.println("Error updating user: " + e.getMessage());
        }
    }

    private void deleteUser() {
        System.out.println("Enter user ID to delete:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try {
            userService.deleteUser(id);
            System.out.println("User deleted successfully.");
        } catch (Exception e) {
            System.out.println("Error deleting user: " + e.getMessage());
        }
    }
}
