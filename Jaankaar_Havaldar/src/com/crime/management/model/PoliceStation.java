package com.crime.management.model;

import com.crime.management.model.Enums.PoliceStationName;

public class PoliceStation {
    private int id;
    private PoliceStationName stationName;
    private String location;

    public PoliceStation(int id, PoliceStationName stationName, String location) {
        this.id = id;
        this.stationName = stationName;
        this.location = location;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PoliceStationName getStationName() {
        return stationName;
    }

    public void setName(PoliceStationName stationName) {
        this.stationName = stationName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "PoliceStation{" +
                "id=" + id +
                ", stationName=" + stationName +
                ", location='" + location + '\'' +
                '}';
    }
}
