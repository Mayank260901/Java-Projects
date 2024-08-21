package com.crime.management.dao;

import com.crime.management.model.CrimeType;
import com.crime.management.model.Criminal;
import java.util.List;

public interface CriminalDAO {
    void addCriminal(Criminal criminal);
    List<Criminal> getCriminalsByCrimeType(CrimeType crimeType);
    List<Criminal> getCriminalsByPoliceStation(String policeStation);
    List<Criminal> getAllCriminals();
    List<Criminal> getCriminalsByName(String name);
}
