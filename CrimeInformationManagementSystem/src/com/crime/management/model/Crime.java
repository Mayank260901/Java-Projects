package com.crime.management.model;

public class Crime {
    private int id;
    private String date;
    private String place;
    private CrimeType crimeType;
    private String description;
    private String status;

    public Crime(int id, String date, String place, CrimeType crimeType, String description, String status) {
        this.id = id;
        this.date = date;
        this.place = place;
        this.crimeType = crimeType;
        this.description = description;
        this.status = status;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public CrimeType getCrimeType() {
        return crimeType;
    }

    public void setCrimeType(CrimeType crimeType) {
        this.crimeType = crimeType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Crime{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", place='" + place + '\'' +
                ", crimeType='" + crimeType + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
