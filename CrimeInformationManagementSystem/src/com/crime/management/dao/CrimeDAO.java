package com.crime.management.dao;

import com.crime.management.model.Crime;
import java.util.List;

public interface CrimeDAO {
    void addCrime(Crime crime);
    List<Crime> getAllCrimes();
    List<Crime> getCrimesByType(String crimeType);
    void updateCrimeStatus(int crimeId, String status);
}
