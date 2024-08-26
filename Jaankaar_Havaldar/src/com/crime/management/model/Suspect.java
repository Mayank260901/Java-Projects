package com.crime.management.model;

public class Suspect {

    private int suspectId;
    private String name;
    private String crimeHistory;

    public Suspect(int suspectId, String name, String crimeHistory) {
        this.suspectId = suspectId;
        this.name = name;
        this.crimeHistory=crimeHistory;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrimeHistory() {
        return crimeHistory;
    }

    public void setCrimeHistory(String crimeHistory) {
        this.crimeHistory = crimeHistory;
    }
    public int getSuspectId() {
        return suspectId;
    }

    public void setSuspectId(int suspectId) {
        this.suspectId = suspectId;
    }

    @Override
    public String toString() {
        return "Suspect{" +
                "suspectId=" + suspectId +
                ", name='" + name + '\'' +
                ", crimeHistory='" + crimeHistory + '\'' +
                '}';
    }
}
