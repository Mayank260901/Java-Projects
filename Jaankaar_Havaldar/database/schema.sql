// All the Sql commands for creating DataBase and tables inside it.

CREATE DATABASE Jaankaar_Havaldar;
USE Jaankaar_Havaldar;


CREATE TABLE PoliceStation (
    id INT PRIMARY KEY AUTO_INCREMENT,
    stationName VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL
);

CREATE TABLE Crime (
    id INT PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    date DATE NOT NULL,
    status VARCHAR(255) NOT NULL,
    stationId INT,
    suspect VARCHAR(255),
    FOREIGN KEY (stationId) REFERENCES PoliceStation(id)
);

CREATE TABLE Criminal (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(50) NOT NULL,
    crimeType VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    identifyingMark VARCHAR(255),
    crimeId INT,
    policeStationName VARCHAR(255),
    FOREIGN KEY (crimeId) REFERENCES Crime(id)
);

CREATE TABLE PoliceOfficer (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    badgeNumber VARCHAR(255) UNIQUE NOT NULL,
    `rank` VARCHAR(255) NOT NULL,
    stationId INT,
    FOREIGN KEY (stationId) REFERENCES PoliceStation(id)
);

CREATE TABLE Suspect (
    suspectId INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    crimeHistory TEXT
);

CREATE TABLE User (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL,
    lastLogin DATETIME
);
