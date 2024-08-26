package com.crime.management.utils;

import com.crime.management.dao.interfaces.CrimeDAO;
import com.crime.management.exception.CrimeException;

import java.util.Scanner;

public class ManageReport {
    private final ReportGenerator reportGenerator;

    public ManageReport(CrimeDAO crimeDAO) {
        this.reportGenerator = new ReportGenerator(crimeDAO);
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nManage Reports Menu:");
            System.out.println("1. Generate Crime Status Report");
            System.out.println("2. Generate Monthly Crime Report");
            System.out.println("3. Back to Main Menu");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        reportGenerator.generateCrimeStatusReport();
                        break;
                    case 2:
                        reportGenerator.generateMonthlyCrimeReport();
                        break;
                    case 3:
                        return; // Return to the main menu
                    case 4:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (CrimeException e) {
                System.out.println("An error occurred while generating the report: " + e.getMessage());
            }
        }
    }
}
