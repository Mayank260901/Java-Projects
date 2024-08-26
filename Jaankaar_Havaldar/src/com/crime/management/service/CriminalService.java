package com.crime.management.service;
import com.crime.management.dao.interfaces.CriminalDAO;
import com.crime.management.exception.CriminalException;
import com.crime.management.model.Criminal;
import com.crime.management.model.Enums.CrimeType;
import com.crime.management.model.Enums.PoliceStationName;

import java.util.List;

public class CriminalService {

    private final CriminalDAO criminalDAO;

    public CriminalService(CriminalDAO criminalDAO) {
        this.criminalDAO = criminalDAO;
    }

    public void addCriminal(Criminal criminal) throws CriminalException {
        try {
            criminalDAO.addCriminal(criminal);
        } catch (Exception e) {
            throw new CriminalException("Error adding criminal", e);
        }
    }

    public List<Criminal> getAllCriminals() throws CriminalException {
        try {
            return criminalDAO.getAllCriminals();
        } catch (Exception e) {
            throw new CriminalException("Error retrieving all criminals", e);
        }
    }

    public Criminal getCriminalById(int id) {
        try {
            return criminalDAO.getCriminalById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving criminal by ID", e);
        }
    }

    public Criminal searchCriminalByName(String name) throws CriminalException {
        try {
            return criminalDAO.searchCriminalByName(name);
        } catch (Exception e) {
            throw new CriminalException("Error searching criminal by name", e);
        }
    }

    public List<Criminal> searchCriminalsByCrimeType(CrimeType crimeType) throws CriminalException {
        try {
            return criminalDAO.searchCriminalsByCrimeType(crimeType);
        } catch (Exception e) {
            throw new CriminalException("Error searching criminals by crime type", e);
        }
    }

    public List<Criminal> searchCriminalsByPoliceStation(PoliceStationName policeStationName) throws CriminalException {
        try {
            return criminalDAO.searchCriminalsByPoliceStation(policeStationName);
        } catch (Exception e) {
            throw new CriminalException("Error searching criminals by police station", e);
        }
    }

    public void updateCriminal(Criminal criminal) {
        try {
            criminalDAO.updateCriminal(criminal);
        } catch (Exception e) {
            throw new RuntimeException("Error updating criminal", e);
        }
    }

    public void deleteCriminal(int id) {
        try {
            criminalDAO.deleteCriminal(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting criminal", e);
        }
    }
}
