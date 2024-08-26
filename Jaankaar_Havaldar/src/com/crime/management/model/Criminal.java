package com.crime.management.model;

import com.crime.management.model.Enums.CrimeType;
import com.crime.management.model.Enums.Gender;
import com.crime.management.model.Enums.PoliceStationName;

public class Criminal {
    private int id;
    private String name;
    private int age;
    private Gender gender;
    private CrimeType crimeType;
    private String address;
    private String identifyingMark;
    private int crimeId;
    private PoliceStationName policeStationName;

    public Criminal(int id, String name, int age, Gender gender,CrimeType crimeType, String address, String identifyingMark, int crimeId , PoliceStationName policeStationName) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.crimeType = crimeType;
        this.address = address;
        this.identifyingMark = identifyingMark;
        this.crimeId = crimeId;
        this.policeStationName = policeStationName;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public CrimeType getCrimeType() {
        return crimeType;
    }

    public void setCrimeType(CrimeType crimeType) {
        this.crimeType = crimeType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentifyingMark() {
        return identifyingMark;
    }

    public void setIdentifyingMark(String identifyingMark) {
        this.identifyingMark = identifyingMark;
    }

    public int getCrimeId() {
        return crimeId;
    }

    public void setCrimeId(int crimeId) {
        this.crimeId = crimeId;
    }

    public PoliceStationName getPoliceStationName() {
        return policeStationName;
    }

    public void setPoliceStationName(PoliceStationName policeStation) {
        this.policeStationName = policeStation;
    }

    @Override
    public String toString() {
        return "Criminal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", crimeType=" + crimeType +
                ", address='" + address + '\'' +
                ", identifyingMark='" + identifyingMark + '\'' +
                ", crimeId=" + crimeId +
                ", policeStationName=" + policeStationName +
                '}';
    }
}
