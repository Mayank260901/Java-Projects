package com.crime.management.service;

import com.crime.management.dao.CriminalDAO;
import com.crime.management.dao.impl.CriminalDAOImpl;
import com.crime.management.model.CrimeType;
import com.crime.management.model.Criminal;
import com.crime.management.model.PoliceStation;

import java.util.List;

public class CriminalService {
    private CriminalDAO criminalDAO;
    private String policeStation;

    public CriminalService() {
        this.criminalDAO = new CriminalDAOImpl();
    }

    public void addCriminal(Criminal criminal) {
        criminalDAO.addCriminal(criminal);
    }

    public List<Criminal> getAllCriminals() {
        return criminalDAO.getAllCriminals();
    }

    public List<Criminal> searchCriminalsByName(String name) {
        return criminalDAO.getCriminalsByName(name);
    }

    public List<Criminal> getCriminalsByPoliceStation(String police) {
        String PoliceStation = null;
        return criminalDAO.getCriminalsByPoliceStation(PoliceStation);
    }

    public List<Criminal> getCriminalsByCrimeType(CrimeType crimeType) {
        return criminalDAO.getCriminalsByCrimeType(crimeType);
    }
}
