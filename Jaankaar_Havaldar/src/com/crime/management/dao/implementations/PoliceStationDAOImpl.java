package com.crime.management.dao.implementations;

import com.crime.management.dao.interfaces.PoliceStationDAO;
import com.crime.management.db.DatabaseConnection;
import com.crime.management.db.Queries;
import com.crime.management.exception.PoliceStationException;
import com.crime.management.model.PoliceStation;
import com.crime.management.model.Enums.PoliceStationName;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PoliceStationDAOImpl implements PoliceStationDAO {


    private final Connection conn;
    public PoliceStationDAOImpl() {
        try {
            conn = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Method 1

    @Override
    public void addPoliceStation(PoliceStation policeStation) throws PoliceStationException {
        try (PreparedStatement ps = conn.prepareStatement(Queries.ADD_POLICE_STATION)) {
            ps.setString(1, policeStation.getStationName().toString());
            ps.setString(2, policeStation.getLocation());
            ps.executeUpdate();
            System.out.println("Police Station added Successfully");
        } catch (SQLException e) {
            throw new PoliceStationException("Error adding police station: " + e.getMessage());
        }
    }

    public PoliceStation getPoliceStationById(int id) throws PoliceStationException{
        try (PreparedStatement ps = conn.prepareStatement(Queries.GET_POLICE_STATION_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new PoliceStation(
                        rs.getInt("id"),
                        PoliceStationName.valueOf(rs.getString("stationName")),
                        rs.getString("location")
                );
            }
        }catch( SQLException e){
            e.printStackTrace();
            throw new PoliceStationException("Error retrieving police stations: " + e.getMessage());
        }
        return null;
    }

    // Method 2

    @Override
    public List<PoliceStation> getAllPoliceStations() throws PoliceStationException {
        List<PoliceStation> policeStations = new ArrayList<>();
        try (
             PreparedStatement ps = conn.prepareStatement(Queries.GET_ALL_POLICE_STATIONS);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                policeStations.add(new PoliceStation(
                        rs.getInt("id"),
                        PoliceStationName.valueOf(rs.getString("stationName")),
                        rs.getString("location")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PoliceStationException("Error retrieving police stations: " + e.getMessage());
        }
        return policeStations;
    }

    // Method 3

    @Override
    public PoliceStation searchPoliceStationByName(String name) throws PoliceStationException {
        try (
             PreparedStatement ps = conn.prepareStatement(Queries.SEARCH_POLICE_STATION_BY_NAME)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new PoliceStation(
                        rs.getInt("id"),
                        PoliceStationName.valueOf(rs.getString("stationName")),
                        rs.getString("location")
                );
            }
        } catch (SQLException e) {
            throw new PoliceStationException("Error searching police station by name: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void updatePoliceStation(PoliceStation station) throws PoliceStationException {
        try (PreparedStatement pstmt = conn.prepareStatement(Queries.UPDATE_POLICE_STATION)) {
            pstmt.setString(1, station.getStationName().name()); // Assuming name is an enum
            pstmt.setString(2, station.getLocation());
            pstmt.setInt(3, station.getId());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new PoliceStationException("Failed to update police station: No rows affected.");
            }
        } catch (SQLException e) {
            throw new PoliceStationException("Error updating police station: " + e.getMessage());
        }
    }

    @Override
    public void deletePoliceStation(int id) throws PoliceStationException {

        try (PreparedStatement pstmt = conn.prepareStatement(Queries.DELETE_POLICE_STATION)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
               throw new PoliceStationException("Failed to delete police station: No rows affected.");
           }
        } catch (SQLException e) {
            throw new PoliceStationException("Error deleting police station: " + e.getMessage(), e);
        }
    }
}
