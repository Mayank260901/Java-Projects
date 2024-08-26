package com.crime.management.service;
import com.crime.management.dao.interfaces.PoliceStationDAO;
import com.crime.management.exception.PoliceStationException;
import com.crime.management.model.PoliceStation;

import java.util.List;

public class PoliceStationService {

    private final PoliceStationDAO policeStationDAO;

    public PoliceStationService(PoliceStationDAO policeStationDAO) {
        this.policeStationDAO = policeStationDAO;
    }

    public void addPoliceStation(PoliceStation station) throws PoliceStationException {
        try {
            policeStationDAO.addPoliceStation(station);
        } catch (Exception e) {
            throw new PoliceStationException("Error adding police station", e);
        }
    }

    public PoliceStation getPoliceStationById(int id) throws PoliceStationException {
        try {
            return policeStationDAO.getPoliceStationById(id);
        } catch (Exception e) {
            throw new PoliceStationException("Error retrieving police station by ID", e);
        }
    }

    public List<PoliceStation> getAllPoliceStations() throws PoliceStationException {
        try {
            return policeStationDAO.getAllPoliceStations();
        } catch (Exception e) {
            throw new PoliceStationException("Error retrieving all police stations", e);
        }
    }

    public PoliceStation searchPoliceStationByName(String name) throws PoliceStationException {
        try {
            return policeStationDAO.searchPoliceStationByName(name);
        } catch (Exception e) {
            throw new PoliceStationException("Error searching police station by name", e);
        }
    }

    public void updatePoliceStation(PoliceStation station)  throws PoliceStationException {
        try {
            policeStationDAO.updatePoliceStation(station);
        } catch (Exception e) {
            throw new RuntimeException("Error updating police station", e);
        }
    }

    public void deletePoliceStation(int id)  throws PoliceStationException {
        try {
            policeStationDAO.deletePoliceStation(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting police station", e);
        }
    }
}
