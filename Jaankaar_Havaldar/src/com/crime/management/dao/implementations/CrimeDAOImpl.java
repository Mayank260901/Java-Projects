package com.crime.management.dao.implementations;

import com.crime.management.dao.interfaces.CrimeDAO;
import com.crime.management.db.DatabaseConnection;
import com.crime.management.db.Queries;
import com.crime.management.exception.CrimeException;
import com.crime.management.model.Crime;
import com.crime.management.model.Enums.CrimeType;
import com.crime.management.model.Enums.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrimeDAOImpl implements CrimeDAO {

    private final Connection conn;
    public CrimeDAOImpl() {
        try {
            conn = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Method 1

    @Override
    public void addCrime(Crime crime) {
        try (
             PreparedStatement statement = conn.prepareStatement(Queries.ADD_CRIME)) {
            statement.setString(1, crime.getType().toString());
            statement.setString(2, crime.getDescription());
            statement.setDate(3, Date.valueOf(crime.getDate()));
            statement.setString(4, crime.getStatus().toString());
            statement.setInt(5, crime.getStationId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("problem in adding crime");
            e.printStackTrace();
        }
    }


    // Method 2

    @Override
    public List<Crime> getAllCrimes() {
        List<Crime> crimes = new ArrayList<>();
        try (
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(Queries.GET_ALL_CRIMES)) {

            while (resultSet.next()) {
                Crime crime = new Crime(
                        resultSet.getInt("id"),
                        CrimeType.valueOf(resultSet.getString("type")),
                        resultSet.getString("description"),
                        resultSet.getDate("date").toLocalDate(),
                        Status.valueOf(resultSet.getString("status")),
                        resultSet.getInt("id"),
                        resultSet.getString("suspect")
                );
                crimes.add(crime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return crimes;
    }


    // Method 3

    @Override
    public List<Crime> searchCrimesByType(String type) {
        List<Crime> crimes = new ArrayList<>();
        try (
             PreparedStatement statement = conn.prepareStatement(Queries.SEARCH_CRIMES_BY_TYPE)) {
            statement.setString(1, type);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Crime crime = new Crime(
                            resultSet.getInt("id"),
                            CrimeType.valueOf(resultSet.getString("type")),
                            resultSet.getString("description"),
                            resultSet.getDate("date").toLocalDate(),
                            Status.valueOf(resultSet.getString("status")),
                            resultSet.getInt("station_id"),
                            resultSet.getString("suspect")
                    );
                    crimes.add(crime);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return crimes;
    }

    @Override
    public Crime searchCrimesById(int id) {
        try (
             PreparedStatement statement = conn.prepareStatement(Queries.SEARCH_CRIMES_BY_ID)) {
            statement.setInt(1,id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while(resultSet.next()) {
                    return new Crime(
                            resultSet.getInt("id"),
                            CrimeType.valueOf(resultSet.getString("type")),
                            resultSet.getString("description"),
                            resultSet.getDate("date").toLocalDate(),
                            Status.valueOf(resultSet.getString("status")),
                            resultSet.getInt("station_id"),
                            resultSet.getString("suspect")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



     // Method 4
    @Override
    public void updateCrimeStatus(int id, String status) {
        try (
             PreparedStatement statement = conn.prepareStatement(Queries.UPDATE_CRIME_STATUS)) {
            statement.setString(1, status);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCrime(Crime crime) {
        try {
            PreparedStatement stmt = conn.prepareStatement(Queries.UPDATE_CRIME);
            stmt.setString(1, String.valueOf(crime.getType()));
            stmt.setString(2, crime.getDescription());
            stmt.setDate(3, Date.valueOf(crime.getDate()));
            stmt.setInt(4, crime.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception properly
        }
    }

    @Override
    public void deleteCrime(int id) {
        try {
            PreparedStatement stmt = conn.prepareStatement(Queries.DELETE_CRIME);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception properly
        }
    }



}

