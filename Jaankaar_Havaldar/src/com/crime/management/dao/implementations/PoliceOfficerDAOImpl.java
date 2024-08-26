package com.crime.management.dao.implementations;

import com.crime.management.dao.interfaces.PoliceOfficerDAO;
import com.crime.management.db.DatabaseConnection;
import com.crime.management.db.Queries;
import com.crime.management.exception.PoliceOfficerException;
import com.crime.management.model.Enums.Role;
import com.crime.management.model.PoliceOfficer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PoliceOfficerDAOImpl implements PoliceOfficerDAO {
    private final Connection conn;
    public PoliceOfficerDAOImpl() {
        try {
            conn = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Method 1

    @Override
    public void addPoliceOfficer(PoliceOfficer policeOfficer) throws PoliceOfficerException {
        try (
             PreparedStatement ps = conn.prepareStatement(Queries.ADD_POLICE_OFFICER)) {
            ps.setString(1, policeOfficer.getName());
            ps.setString(2, policeOfficer.getBadgeNumber());
            ps.setString(3, String.valueOf(policeOfficer.getRank()));
            ps.setInt(4, policeOfficer.getStationId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new PoliceOfficerException("Error adding police officer: " + e.getMessage());
        }
    }

    // Method 2

    @Override
    public List<PoliceOfficer> getAllPoliceOfficers() throws PoliceOfficerException {
        List<PoliceOfficer> policeOfficers = new ArrayList<>();
        try (
             PreparedStatement ps = conn.prepareStatement(Queries.GET_ALL_POLICE_OFFICERS);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                policeOfficers.add(new PoliceOfficer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("badge_number"),
                        Role.valueOf(rs.getString("rank")),
                        rs.getInt("station_id")
                ));
            }
        } catch (SQLException e) {
            throw new PoliceOfficerException("Error retrieving police officers: " + e.getMessage());
        }
        return policeOfficers;
    }

    // Method 3

    @Override
    public PoliceOfficer searchPoliceOfficerByName(String name) throws PoliceOfficerException {
        try (PreparedStatement ps = conn.prepareStatement(Queries.SEARCH_POLICE_OFFICER_BY_NAME)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new PoliceOfficer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("badge_number"),
                        Role.valueOf(rs.getString("rank")),
                        rs.getInt("station_id")
                );
            }
        } catch (SQLException e) {
            throw new PoliceOfficerException("Error searching police officer by name: " + e.getMessage());
        }
        return null;
    }
}
