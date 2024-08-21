package com.crime.management.service;

import com.crime.management.dao.CrimeDAO;
import com.crime.management.dao.impl.CrimeDAOImpl;
import com.crime.management.model.Crime;
import com.crime.management.model.CrimeType;

import java.util.List;

public class CrimeService {
    private CrimeDAO crimeDAO;

    public CrimeService() {
        this.crimeDAO = new CrimeDAOImpl();
    }

    public void addCrime(Crime crime) {
        crimeDAO.addCrime(crime);
    }

    public List<Crime> getAllCrimes() {
        return crimeDAO.getAllCrimes();
    }

    public void updateCrimeStatus(int crimeId, String status) {
        crimeDAO.updateCrimeStatus(crimeId, status);
    }

    public List<Crime> getCrimesByType(CrimeType crimeType) {
        return crimeDAO.getCrimesByType(String.valueOf(crimeType));
    }
}
