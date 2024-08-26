package com.crime.management.dao.interfaces;

import com.crime.management.exception.PoliceOfficerException;
import com.crime.management.model.PoliceOfficer;

import java.util.List;

public interface PoliceOfficerDAO {
    void addPoliceOfficer(PoliceOfficer officer) throws PoliceOfficerException;

    List<PoliceOfficer> getAllPoliceOfficers() throws PoliceOfficerException;

    PoliceOfficer searchPoliceOfficerByName(String name) throws PoliceOfficerException;
}
