package com.crime.management.utils;

import com.crime.management.dao.interfaces.CrimeDAO;
import com.crime.management.exception.CrimeException;
import com.crime.management.model.Crime;
import com.crime.management.model.Enums.Status;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReportGenerator {
    private final CrimeDAO crimeDAO;

    public ReportGenerator(CrimeDAO crimeDAO) {
        this.crimeDAO = crimeDAO;
    }

    public void generateCrimeStatusReport() throws CrimeException {
        List<Crime> allCrimes = crimeDAO.getAllCrimes();
        long solvedCount = allCrimes.stream().filter(crime-> crime.getStatus() == Status.CLOSED ).count();
        long unsolvedCount = allCrimes.size() - solvedCount;

        System.out.println("Crime Status Report:");
        System.out.println("Solved Crimes: " + solvedCount);
        System.out.println("Unsolved Crimes: " + unsolvedCount);
    }

    public void generateMonthlyCrimeReport() throws CrimeException {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        String currentMonth = currentDate.format(formatter);

        List<Crime> allCrimes = crimeDAO.getAllCrimes();
        long crimesThisMonth = allCrimes.stream()
                .filter(crime -> crime.getDate().format(formatter).equals(currentMonth))
                .count();

        System.out.println("Monthly Crime Report:");
        System.out.println("Crimes Recorded in " + currentMonth + ": " + crimesThisMonth);
    }
}
