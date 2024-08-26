package com.crime.management.dao.implementations;

import com.crime.management.dao.interfaces.CriminalDAO;
import com.crime.management.db.DatabaseConnection;
import com.crime.management.db.Queries;
import com.crime.management.exception.CriminalException;
import com.crime.management.model.*;
import com.crime.management.model.Enums.CrimeType;
import com.crime.management.model.Enums.Gender;
import com.crime.management.model.Enums.PoliceStationName;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CriminalDAOImpl implements CriminalDAO {

    private final Connection conn;

    public CriminalDAOImpl() {
        try {
            conn = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Method 1

    @Override
    public void addCriminal(Criminal criminal) throws CriminalException {
        try (PreparedStatement ps = conn.prepareStatement(Queries.ADD_CRIMINAL)) {
            ps.setString(1, criminal.getName());
            ps.setInt(2, criminal.getAge());
            ps.setString(3, criminal.getGender().name());
            ps.setString(4,criminal.getCrimeType().name());
            ps.setString(4, criminal.getAddress());
            ps.setString(5, criminal.getIdentifyingMark());
            ps.setInt(6, criminal.getCrimeId());
            ps.executeUpdate();
            System.out.println("Criminal Added");
        } catch (SQLException e) {
            throw new CriminalException("Error adding criminal: " + e.getMessage());
        }
    }

    // Method 2

    @Override
    public List<Criminal> getAllCriminals() throws CriminalException {
        List<Criminal> criminals = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(Queries.GET_ALL_CRIMINALS);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                criminals.add(new Criminal(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        Gender.valueOf(rs.getString("gender")),
                        CrimeType.valueOf(rs.getString("crimeType")),
                        rs.getString("address"),
                        rs.getString("identifying_mark"),
                        rs.getInt("crime_id"),
                        PoliceStationName.valueOf(rs.getString("policeStationName"))
                ));
            }
        } catch (SQLException e) {
            throw new CriminalException("Error retrieving criminals: " + e.getMessage());
        }
        return criminals;
    }

    // Method 3

    @Override
    public Criminal searchCriminalByName(String name) throws CriminalException {
        try (PreparedStatement ps = conn.prepareStatement(Queries.SEARCH_CRIMINAL_BY_NAME)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Criminal(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        Gender.valueOf(rs.getString("gender")),
                        CrimeType.valueOf(rs.getString("crimeType")),
                        rs.getString("address"),
                        rs.getString("identifying_mark"),
                        rs.getInt("crime_id"),
                        PoliceStationName.valueOf(rs.getString("name"))
                        );
            }
        } catch (SQLException e) {
            throw new CriminalException("Error searching criminal by name: " + e.getMessage());
        }
        return null;
    }


    // Method 4

    @Override
    public List<Criminal> searchCriminalsByCrimeType(CrimeType type) throws CriminalException {
        List<Criminal> criminals = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(Queries.SEARCH_CRIMINALS_BY_CRIME_TYPE)) {
            ps.setString(1, type.name());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                criminals.add(new Criminal(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        Gender.valueOf(rs.getString("gender")),
                        CrimeType.valueOf(rs.getString("crimeType")),
                        rs.getString("address"),
                        rs.getString("identifying_mark"),
                        rs.getInt("crime_id"),
                        PoliceStationName.valueOf(rs.getString("name"))
                ));
            }
        } catch (SQLException e) {
            throw new CriminalException("Error searching criminals by crime type: " + e.getMessage());
        }
        return criminals;
    }


    // Method 5

    @Override
    public List<Criminal> searchCriminalsByPoliceStation(PoliceStationName stationName) throws CriminalException {
        List<Criminal> criminals = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(Queries.SEARCH_CRIMINALS_BY_POLICE_STATION)) {
            ps.setString(1, stationName.name());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                criminals.add(new Criminal(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        Gender.valueOf(rs.getString("gender")),
                        CrimeType.valueOf(rs.getString("crimeType")),
                        rs.getString("address"),
                        rs.getString("identifying_mark"),
                        rs.getInt("crime_id"),
                        PoliceStationName.valueOf(rs.getString("stationName"))

                ));
            }
        } catch (SQLException e) {
            throw new CriminalException("Error searching criminals by police station: " + e.getMessage());
        }
        return criminals;
    }


    @Override
    public Criminal getCriminalById(int id) {
        Criminal criminal = null;
        try {PreparedStatement stmt = conn.prepareStatement(Queries.GET_CRIMINAL_BY_ID);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                criminal = new Criminal(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        Gender.valueOf(rs.getString("gender")),
                        CrimeType.valueOf(rs.getString("crimeType")),
                        rs.getString("address"),
                        rs.getString("identifying_mark"),
                        rs.getInt("crime_id"),
                        PoliceStationName.valueOf(rs.getString("stationName"))

                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception properly
        }
        return criminal;
    }

    @Override
    public void updateCriminal(Criminal criminal) {
        try {
            PreparedStatement stmt = conn.prepareStatement(Queries.UPDATE_CRIMINAL);
            stmt.setString(1, criminal.getName());
            stmt.setString(2, String.valueOf(criminal.getCrimeType()));
            stmt.setInt(3, criminal.getAge());
            stmt.setInt(4, criminal.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception properly
        }
    }

    @Override
    public void deleteCriminal(int id) {
        try {
            PreparedStatement stmt = conn.prepareStatement(Queries.DELETE_CRIMINAL);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception properly
        }
    }

}
