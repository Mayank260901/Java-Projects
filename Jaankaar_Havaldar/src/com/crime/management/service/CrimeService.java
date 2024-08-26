package com.crime.management.service;
import com.crime.management.dao.interfaces.CrimeDAO;
import com.crime.management.model.Crime;

import java.util.List;

public class CrimeService {

    private final CrimeDAO crimeDAO;

    public CrimeService(CrimeDAO crimeDAO) {
        this.crimeDAO = crimeDAO;
    }

    public void addCrime(Crime crime) {
        try {
            crimeDAO.addCrime(crime);
        } catch (Exception e) {
            // Handle the exception or wrap it in a custom exception
            throw new RuntimeException("Error adding crime", e);
        }
    }

    public List<Crime> getAllCrimes() {
        try {
            return crimeDAO.getAllCrimes();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving all crimes", e);
        }
    }

    public List<Crime> searchCrimesByType(String type) {
        try {
            return crimeDAO.searchCrimesByType(type);
        } catch (Exception e) {
            throw new RuntimeException("Error searching crimes by type", e);
        }
    }

    public Crime searchCrimesById(int id) {
        try {
            return crimeDAO.searchCrimesById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error searching crime by ID", e);
        }
    }

    public void updateCrimeStatus(int id, String status) {
        try {
            crimeDAO.updateCrimeStatus(id, status);
        } catch (Exception e) {
            throw new RuntimeException("Error updating crime status", e);
        }
    }

    public void updateCrime(Crime crime) {
        try {
            crimeDAO.updateCrime(crime);
        } catch (Exception e) {
            throw new RuntimeException("Error updating crime", e);
        }
    }

    public void deleteCrime(int id) {
        try {
            crimeDAO.deleteCrime(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting crime", e);
        }
    }
}
