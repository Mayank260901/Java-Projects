package com.crime.management.dao.impl;

import com.crime.management.model.CrimeType;
import com.crime.management.dao.CrimeDAO;
import com.crime.management.model.Crime;
import com.crime.management.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrimeDAOImpl implements CrimeDAO {

    private Connection conn;

    public CrimeDAOImpl() {
        this.conn = DatabaseConnection.getConnection();
    }

    @Override
    public void addCrime(Crime crime) {
        String sql = "INSERT INTO crimes (date, place, crime_type, description, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, crime.getDate());
            pstmt.setString(2, crime.getPlace());
            pstmt.setString(3, String.valueOf(crime.getCrimeType()));
            pstmt.setString(4, crime.getDescription());
            pstmt.setString(5, crime.getStatus());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error adding crime to the database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<Crime> getAllCrimes() {
        List<Crime> crimes = new ArrayList<>();
        String sql = "SELECT * FROM crimes";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Crime crime = new Crime(
                        rs.getInt("id"),
                        rs.getString("date"),
                        rs.getString("place"),
                        CrimeType.valueOf(rs.getString("crime_type")),
                        rs.getString("description"),
                        rs.getString("status")
                );
                crimes.add(crime);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving crimes from the database: " + e.getMessage());
            e.printStackTrace();
        }
        return crimes;
    }


    @Override
    public List<Crime> getCrimesByType(String crimeType) {
        List<Crime> crimes = new ArrayList<>();
        String sql = "SELECT * FROM crimes WHERE crime_type LIKE ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + crimeType + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Crime crime = new Crime(
                        rs.getInt("id"),
                        rs.getString("date"),
                        rs.getString("place"),
                        CrimeType.valueOf(rs.getString("crime_type")),
                        rs.getString("description"),
                        rs.getString("status")
                );
                crimes.add(crime);
            }
        } catch (SQLException e) {
            System.err.println("Error searching crimes by type: " + e.getMessage());
            e.printStackTrace();
        }
        return crimes;
    }

    @Override
    public void updateCrimeStatus(int crimeId, String status) {
        String sql = "UPDATE crimes SET status = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status);
            pstmt.setInt(2, crimeId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating crime status: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
