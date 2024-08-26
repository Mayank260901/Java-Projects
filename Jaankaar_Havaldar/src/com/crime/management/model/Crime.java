package com.crime.management.model;

import com.crime.management.model.Enums.CrimeType;
import com.crime.management.model.Enums.Status;

import java.time.LocalDate;

public class Crime {
    private int id;
    private CrimeType type;
    private String description;
    private LocalDate date;
    private Status status;
    private int stationId;



    private String suspect;

    public Crime(int id, CrimeType type, String description, LocalDate date, Status status, int stationId, String suspect) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.date = date;
        this.status = status;
        this.stationId = stationId;
        this.suspect = suspect;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CrimeType getType() {
        return type;
    }

    public void setType(CrimeType type) { this.type = type; }  //As, it is enum naming crime type.
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public String getSuspect() {
        return suspect;
    }

    public void setSuspect(String suspect) {
        this.suspect = suspect;
    }

    @Override
    public String toString() {
        return "Crime{" +
                "id=" + id +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", status=" + status +
                ", stationId=" + stationId +
                ", suspect='" + suspect + '\'' +
                '}';
    }
}
