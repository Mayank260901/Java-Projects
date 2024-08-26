package com.crime.management.db;

public class Queries {

    // Queries for CrimeDAO
    public static final String ADD_CRIME = "INSERT INTO Crime (type, description, date, status, stationId, suspect) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String GET_ALL_CRIMES = "SELECT * FROM Crime";
    public static final String SEARCH_CRIMES_BY_TYPE = "SELECT * FROM Crime WHERE type = ?";
    public static final String SEARCH_CRIMES_BY_ID = "SELECT * FROM Crime WHERE id = ?";
    public static final String UPDATE_CRIME_STATUS = "UPDATE Crime SET status = ? WHERE id = ?";
    public static final String UPDATE_CRIME = "UPDATE Crime SET type = ?, description = ?, date = ?, status = ?, stationId = ?, suspect = ? WHERE id = ?";
    public static final String DELETE_CRIME = "DELETE FROM Crime WHERE id = ?";

    // Queries for CriminalDAO
    public static final String ADD_CRIMINAL = "INSERT INTO Criminal (name, age, gender, crimeType, address, identifyingMark, crimeId, policeStationName) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String GET_ALL_CRIMINALS = "SELECT * FROM Criminal";
    public static final String GET_CRIMINAL_BY_ID = "SELECT * FROM Criminal WHERE id = ?";
    public static final String SEARCH_CRIMINAL_BY_NAME = "SELECT * FROM Criminal WHERE name = ?";
    public static final String SEARCH_CRIMINALS_BY_CRIME_TYPE = "SELECT * FROM Criminal WHERE crimeType = ?";
    public static final String SEARCH_CRIMINALS_BY_POLICE_STATION = "SELECT * FROM Criminal WHERE policeStationName = ?";
    public static final String UPDATE_CRIMINAL = "UPDATE Criminal SET name = ?, age = ?, gender = ?, crimeType = ?, address = ?, identifyingMark = ?, crimeId = ?, policeStationName = ? WHERE id = ?";
    public static final String DELETE_CRIMINAL = "DELETE FROM Criminal WHERE id = ?";

    // Queries for PoliceOfficerDAO
    public static final String ADD_POLICE_OFFICER = "INSERT INTO PoliceOfficer (name, badgeNumber, rank, stationId) VALUES (?, ?, ?, ?)";
    public static final String GET_ALL_POLICE_OFFICERS = "SELECT * FROM PoliceOfficer";
    public static final String SEARCH_POLICE_OFFICER_BY_NAME = "SELECT * FROM PoliceOfficer WHERE name = ?";

    // Queries for PoliceStationDAO
    public static final String ADD_POLICE_STATION = "INSERT INTO PoliceStation (stationName, location) VALUES (?, ?)";
    public static final String GET_POLICE_STATION_BY_ID = "SELECT * FROM PoliceStation WHERE id = ?";
    public static final String GET_ALL_POLICE_STATIONS = "SELECT * FROM PoliceStation";
    public static final String SEARCH_POLICE_STATION_BY_NAME = "SELECT * FROM PoliceStation WHERE stationName = ?";
    public static final String UPDATE_POLICE_STATION = "UPDATE PoliceStation SET stationName = ?, location = ? WHERE id = ?";
    public static final String DELETE_POLICE_STATION = "DELETE FROM PoliceStation WHERE id = ?";

    // Queries for UserDAO
    public static final String ADD_USER = "INSERT INTO User (username, password, role, lastLogin) VALUES (?, ?, ?, ?)";
    public static final String GET_ALL_USERS = "SELECT * FROM User";
    public static final String AUTHENTICATE_USER = "SELECT * FROM User WHERE username = ? AND password = ?";
    public static final String GET_USER_BY_ID = "SELECT * FROM User WHERE id = ?";
    public static final String GET_USER_BY_USERNAME = "SELECT * FROM User WHERE username = ?";
    public static final String UPDATE_USER = "UPDATE User SET username = ?, password = ?, role = ?, lastLogin = ? WHERE id = ?";
    public static final String DELETE_USER = "DELETE FROM User WHERE id = ?";

}

/*
public class Queries {
    // Crime Queries
    public static final String ADD_CRIME = "INSERT INTO Crime (type, description, date, status, stationId) VALUES (?, ?, ?, ?, ?)";
    public static final String GET_ALL_CRIMES = "SELECT * FROM Crime";
    public static final String SEARCH_CRIMES_BY_TYPE = "SELECT * FROM Crime WHERE type = ?";
    public static final String SEARCH_CRIMES_BY_ID = "SELECT * FROM Crime WHERE id = ?";
    public static final String UPDATE_CRIME_STATUS = "UPDATE Crime SET status = ? WHERE id = ?";
    public static final String UPDATE_CRIME = "UPDATE crime SET type = ?, description = ?, date = ? WHERE id = ?";
    public static final String DELETE_CRIME = "DELETE FROM crime WHERE id = ?";

    // Criminal Queries
    public static final String ADD_CRIMINAL = "INSERT INTO Criminal (name, age, gender, crimeType , address, identifying_mark, crime_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String GET_ALL_CRIMINALS = "SELECT * FROM Criminal";
    public static final String SEARCH_CRIMINAL_BY_NAME = "SELECT * FROM Criminal WHERE name = ?";
    public static final String SEARCH_CRIMINALS_BY_CRIME_TYPE = "SELECT Criminal.* FROM Criminal JOIN Crime ON Criminal.crime_id = Crime.id WHERE Crimes.type = ?";
    public static final String SEARCH_CRIMINALS_BY_Police_Station = "SELECT Criminal.* FROM Criminal JOIN PoliceStation ON Criminal.crime_id = Crimes.id WHERE PoliceStation.name = ?";

    // Police Station Queries
    public static final String ADD_POLICE_STATION = "INSERT INTO PoliceStation (name, location) VALUES (?, ?)";
    public static final String GET_ALL_POLICE_STATIONS = "SELECT * FROM PoliceStation";
    public static final String GET_POLICE_STATION_BY_ID = "SELECT * FROM PoliceStation WHERE  id = ?";
    public static final String SEARCH_POLICE_STATION_BY_NAME = "SELECT * FROM PoliceStation WHERE name = ?";

    // Police Officer Queries
    public static final String ADD_POLICE_OFFICER = "INSERT INTO PoliceOfficer (name, badgeNumber, rank, stationId) VALUES (?, ?, ?, ?)";
    public static final String GET_ALL_POLICE_OFFICERS = "SELECT * FROM PoliceOfficer";
    public static final String SEARCH_POLICE_OFFICER_BY_NAME = "SELECT * FROM PoliceOfficer WHERE name = ?";

    // User Queries
    public static final String ADD_USER = "INSERT INTO User (username, password, role) VALUES (?, ?, ?)";
    public static final String AUTHENTICATE_USER = "SELECT * FROM User WHERE username = ? AND password = ?";
    public static final String GET_USER_BY_USERNAME = "SELECT * FROM User WHERE username = ?";
}
*/