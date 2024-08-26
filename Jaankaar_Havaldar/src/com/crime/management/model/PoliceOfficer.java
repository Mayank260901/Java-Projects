package com.crime.management.model;

import com.crime.management.model.Enums.Role;

public class PoliceOfficer {
    private int id;
    private String name;
    private String badgeNumber;
    private Role rank;
    private int stationId;

    public PoliceOfficer(int id, String name, String badgeNumber, Role rank, int stationId) {
        this.id = id;
        this.name = name;
        this.badgeNumber = badgeNumber;
        this.rank = rank;
        this.stationId = stationId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public Role getRank() {
        return rank;
    }

    public void setRank(Role rank) {
        this.rank = rank;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    @Override
    public String toString() {
        return "PoliceOfficer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", badgeNumber='" + badgeNumber + '\'' +
                ", rank=" + rank +
                ", stationId=" + stationId +
                '}';
    }
}
