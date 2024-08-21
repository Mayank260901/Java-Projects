package com.crime.management.model;

public class Criminal {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String address;
    private String identifyingMark;
    private String areaOfCrime;

    public Criminal(int id, String name, int age, String gender, String address, String identifyingMark, String areaOfCrime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.identifyingMark = identifyingMark;
        this.areaOfCrime = areaOfCrime;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getAreaOfCrime() {
        return areaOfCrime;
    }

    public void setAreaOfCrime(String areaOfCrime) {
        this.areaOfCrime = areaOfCrime;
    }


    @Override
    public String toString() {
        return "Criminal ID: " + id +
                ", Name: " + name +
                ", Age: " + age +
                ", Gender: " + gender +
                ", Address: " + address +
                ", Identifying Mark: " + identifyingMark +
                ", Area of Crime: " + areaOfCrime;
    }
}
