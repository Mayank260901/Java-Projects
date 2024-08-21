package com.crime.management.dao.impl;

import com.crime.management.dao.CriminalDAO;
import com.crime.management.model.Criminal;
import com.crime.management.util.DatabaseConnection;
import com.crime.management.model.CrimeType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CriminalDAOImpl implements CriminalDAO {

    private Connection conn;

    public CriminalDAOImpl() {
        this.conn = DatabaseConnection.getConnection();
    }

    @Override
    public void addCriminal(Criminal criminal) {
        String sql = "INSERT INTO criminals (name, age, gender, address, identifying_mark, area_of_crime) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, criminal.getName());
            pstmt.setInt(2, criminal.getAge());
            pstmt.setString(3, criminal.getGender());
            pstmt.setString(4, criminal.getAddress());
            pstmt.setString(5, criminal.getIdentifyingMark());
            pstmt.setString(6, criminal.getAreaOfCrime());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error adding criminal to the database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<Criminal> getAllCriminals() {
        List<Criminal> criminals = new ArrayList<>();
        String sql = "SELECT * FROM criminals";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Criminal criminal = new Criminal(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("address"),
                        rs.getString("identifying_mark"),
                        rs.getString("area_of_crime")
                );
                criminals.add(criminal);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving criminals from the database: " + e.getMessage());
            e.printStackTrace();
        }
        return criminals;
    }


    public List<Criminal> getCriminalsByCrimeType(CrimeType crimeType) {
        List<Criminal> criminals = new ArrayList<>();
        String query = "SELECT * FROM criminals c JOIN crimes cr ON c.id = cr.id WHERE cr.crime_type = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, crimeType.name());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Criminal criminal = new Criminal(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("address"),
                        rs.getString("identifying_mark"),
                        rs.getString("area_of_crime")
                );
                criminals.add(criminal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return criminals;
    }

    public List<Criminal> getCriminalsByPoliceStation(String policeStation) {
        List<Criminal> criminals = new ArrayList<>();
        String query = "SELECT * FROM criminals WHERE area_of_crime = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, policeStation);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Criminal criminal = new Criminal(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("address"),
                        rs.getString("identifying_mark"),
                        rs.getString("area_of_crime")
                );
                criminals.add(criminal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return criminals;
    }


    @Override
    public List<Criminal> getCriminalsByName(String name) {
        List<Criminal> criminals = new ArrayList<>();
        String sql = "SELECT * FROM criminals WHERE name LIKE ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Criminal criminal = new Criminal(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("address"),
                        rs.getString("identifying_mark"),
                        rs.getString("area_of_crime")
                );
                criminals.add(criminal);
            }
        } catch (SQLException e) {
            System.err.println("Error searching criminals by name: " + e.getMessage());
            e.printStackTrace();
        }
        return criminals;
    }
}
