package com.crime.management.dao.interfaces;

import com.crime.management.exception.CrimeException;
import com.crime.management.model.Crime;

import java.util.List;

public interface CrimeDAO {

    void addCrime(Crime crime) throws CrimeException;
    List<Crime> getAllCrimes() throws CrimeException;
    List<Crime> searchCrimesByType(String type) throws CrimeException;
    Crime searchCrimesById(int id) throws CrimeException;
    void updateCrimeStatus(int id, String status) throws CrimeException;
    void updateCrime(Crime crime) throws CrimeException;
    void deleteCrime(int id) throws CrimeException;
}

