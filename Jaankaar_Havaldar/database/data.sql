//Inserting some raw data as Sample

// Insert Data into PoliceStation

INSERT INTO PoliceStation (stationName, location) VALUES
('CENTRAL_POLICE_STATION', 'Downtown'),
('NORTH_DIVISION', 'Northside District'),
('SOUTH_DIVISION', 'Southside District'),
('EAST_SIDE_POLICE_STATION', 'Eastside Boulevard'),
('WEST_SIDE_POLICE_STATION', 'West End Avenue'),
('CITY_CENTER_POLICE_STATION', 'City Center'),
('RIVERSIDE_POLICE_STATION', 'Riverfront Drive'),
('HILL_VIEW_POLICE_STATION', 'Hill View Heights'),
('DOWNTOWN_POLICE_STATION', 'Downtown'),
('OLD_TOWN_POLICE_STATION', 'Old Town District');

// Insert Data into Crime

INSERT INTO Crime (type, description, date, status, stationId, suspect) VALUES
('ROBBERY', 'Armed robbery at a local convenience store', '2024-08-20', 'OPEN', 1, 'John Doe'),
('ASSAULT', 'Physical altercation between two individuals', '2024-08-18', 'CLOSED', 2, 'Jane Smith'),
('BURGLARY', 'Unauthorized entry into a residential property', '2024-08-15', 'IN_PROGRESS', 3, 'Unknown'),
('VANDALISM', 'Graffiti on public property', '2024-08-19', 'CLOSED', 1, 'Tom Green'),
('FRAUD', 'Identity theft and fraudulent credit card use', '2024-08-21', 'OPEN', 4, 'Emily Brown'),
('HOMICIDE', 'Suspicious death investigation', '2024-08-14', 'IN_PROGRESS', 2, 'Michael Black'),
('DRUGS', 'Possession of illegal substances', '2024-08-22', 'CLOSED', 3, 'Sarah White'),
('ARSON', 'Intentional setting of a fire at an abandoned building', '2024-08-17', 'OPEN', 1, 'Unknown'),
('THEFT', 'Stolen vehicle reported', '2024-08-16', 'IN_PROGRESS', 2, 'Unknown'),
('TERRORISM', 'Phishing scam targeting online users', '2024-08-23', 'OPEN', 4, 'James Brown');
Insert Data into Criminal
sql
Copy code
INSERT INTO Criminal (name, age, gender, crimeType, address, identifyingMark, crimeId, policeStationName) VALUES
('John Doe', 34, 'MALE', 'ROBBERY', '123 Elm Street', 'Scar on left cheek', 1, 'CENTRAL_POLICE_STATION'),
('Jane Smith', 28, 'FEMALE', 'ASSAULT', '456 Oak Avenue', 'Tattoo on right arm', 2, 'NORTH_DIVISION'),
('Tom Green', 40, 'MALE', 'VANDALISM', '789 Pine Road', 'Missing left index finger', 4, 'CITY_CENTER_POLICE_STATION'),
('Emily Brown', 30, 'FEMALE', 'FRAUD', '101 Maple Street', 'Birthmark on neck', 5, 'SOUTH_DIVISION'),
('Michael Black', 37, 'MALE', 'HOMICIDE', '202 Birch Lane', 'Burn scar on hand', 6, 'RIVERSIDE_POLICE_STATION');

// Insert Data into PoliceOfficer

INSERT INTO PoliceOfficer (name, badgeNumber, rank, stationId) VALUES
('Officer John Roberts', '123456', 'POLICE_OFFICER', 1),
('Inspector Mary Johnson', '789012', 'INSPECTOR', 2),
('Constable David Wilson', '345678', 'CONSTABLE', 3),
('Detective Sarah Thompson', '901234', 'DETECTIVE', 4),
('Superintendent Emma White', '567890', 'SUPERINTENDENT', 5);

//Insert Data into Suspect

INSERT INTO Suspect (name, crimeHistory) VALUES
('John Doe', 'Multiple robberies in the downtown area'),
('Jane Smith', 'Assault charges in the past'),
('Tom Green', 'Vandalism and petty theft'),
('Emily Brown', 'Fraud and identity theft'),
('Michael Black', 'Involved in a homicide investigation');

//Insert Data into User

INSERT INTO User (username, password, role, lastLogin) VALUES
('admin_user', 'hashed_password_1', 'ADMIN', '2024-08-24 10:15:00'),
('officer_john', 'hashed_password_2', 'POLICE_OFFICER', '2024-08-23 09:45:00'),
('inspector_mary', 'hashed_password_3', 'INSPECTOR', '2024-08-24 11:00:00'),
('constable_david', 'hashed_password_4', 'CONSTABLE', '2024-08-22 08:30:00'),
('user_emma', 'hashed_password_5', 'USER', '2024-08-21 07:20:00');
