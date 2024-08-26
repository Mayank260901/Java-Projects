package com.crime.management.dao.interfaces;

import com.crime.management.exception.PoliceStationException;
import com.crime.management.model.PoliceStation;

import java.util.List;

public interface PoliceStationDAO {
    void addPoliceStation(PoliceStation station) throws PoliceStationException;
    PoliceStation getPoliceStationById(int id) throws PoliceStationException;
    List<PoliceStation> getAllPoliceStations() throws PoliceStationException;
    PoliceStation searchPoliceStationByName(String name) throws PoliceStationException;
     void updatePoliceStation(PoliceStation station) throws PoliceStationException;
     void deletePoliceStation(int id) throws PoliceStationException;
}