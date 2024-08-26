package com.crime.management.service;
import com.crime.management.dao.interfaces.PoliceOfficerDAO;
import com.crime.management.exception.PoliceOfficerException;
import com.crime.management.model.PoliceOfficer;

import java.util.List;

public class PoliceOfficerService {

    private final PoliceOfficerDAO policeOfficerDAO;

    public PoliceOfficerService(PoliceOfficerDAO policeOfficerDAO) {
        this.policeOfficerDAO = policeOfficerDAO;
    }

    public void addPoliceOfficer(PoliceOfficer officer) throws PoliceOfficerException {
        try {
            policeOfficerDAO.addPoliceOfficer(officer);
        } catch (Exception e) {
            throw new PoliceOfficerException("Error adding police officer", e);
        }
    }

    public List<PoliceOfficer> getAllPoliceOfficers() throws PoliceOfficerException {
        try {
            return policeOfficerDAO.getAllPoliceOfficers();
        } catch (Exception e) {
            throw new PoliceOfficerException("Error retrieving all police officers", e);
        }
    }

    public PoliceOfficer searchPoliceOfficerByName(String name) throws PoliceOfficerException {
        try {
            return policeOfficerDAO.searchPoliceOfficerByName(name);
        } catch (Exception e) {
            throw new PoliceOfficerException("Error searching police officer by name", e);
        }
    }
}
