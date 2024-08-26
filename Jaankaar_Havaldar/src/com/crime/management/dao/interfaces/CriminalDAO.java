package com.crime.management.dao.interfaces;

import com.crime.management.exception.CriminalException;
import com.crime.management.model.Enums.CrimeType;
import com.crime.management.model.Criminal;
import com.crime.management.model.Enums.PoliceStationName;

import java.util.List;

public interface CriminalDAO {

    void addCriminal(Criminal criminal) throws CriminalException;
    List<Criminal> getAllCriminals() throws CriminalException;
    Criminal getCriminalById(int id) throws CriminalException;
    Criminal searchCriminalByName(String name) throws CriminalException;
    List<Criminal> searchCriminalsByCrimeType(CrimeType crimeType) throws CriminalException;
    List<Criminal> searchCriminalsByPoliceStation(PoliceStationName policeStationName) throws CriminalException;
    void updateCriminal(Criminal criminal) throws CriminalException;
    void deleteCriminal(int id) throws CriminalException;
}
