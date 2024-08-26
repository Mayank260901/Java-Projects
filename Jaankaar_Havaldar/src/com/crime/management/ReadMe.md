# Jaankaar Havaldar - Crime Information Management System

Jaankaar Havaldar is a comprehensive CLI-based Crime Information Management System designed to manage crime records, criminals, police stations, police officers, and users. This system also provides robust user authentication, reporting features, and a well-organized project structure using the DAO (Data Access Object) pattern.

## Table of Contents

- [Features](#features)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Usage](#usage)
- [Technologies Used](#technologies-used)
- [Contributing](#contributing)
- [License](#license)

## Features

- User Authentication: Secure login and registration with password hashing.
- Role-Based Access: Different menus and operations based on user roles (Admin, Police Officer, etc.).
- Crime Management: Add, update, view, and delete crime records.
- Criminal Management: Manage criminal records with comprehensive CRUD operations.
- Police Station Management: Handle operations related to police stations.
- Police Officer Management: Manage police officer details and assignments.
- User Management: Administer user accounts with CRUD functionalities.
- Reporting: Generate various reports like crime statistics, user activity, and criminal records.
- Modular Design: Clean and maintainable codebase with a well-organized structure.

## Project Structure

```plaintext
jaankaar_havaldar/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── jaankaar/
│   │   │   │   │   ├── havaldar/
│   │   │   │   │   │   ├── dao/
│   │   │   │   │   │   ├── service/
│   │   │   │   │   │   ├── model/
│   │   │   │   │   │   ├── util/
│   │   │   │   │   │   ├── exception/
│   │   │   │   │   │   ├── menu/
│   │   │   │   │   │   ├── report/
│   │   │   │   │   │   ├── authentication/
│   │   │   │   │   │   ├── main/
│   └── test/
│
├── resources/
│   └── schema.sql
│
└── README.md

Technologies Used
Java: Core programming language.
JDBC: For connecting and interacting with the MySQL database.
MySQL: Relational database for storing system data.
IntelliJ IDEA: Recommended IDE for development.

The project structure you've outlined will use the following technologies:

### **1. Programming Language**
- **Java**: The primary programming language used for developing the entire application, including the model, service, DAO, and main application logic.

### **2. Database**
- **MySQL/PostgreSQL/SQLite**: The project can use any relational database com.crime.management system (RDBMS) for storing and managing data such as crimes, criminals, police stations, and users.

### **3. JDBC (Java Database Connectivity)**
- **JDBC**: For connecting the Java application to the database and executing SQL queries. The JDBC API allows the application to interact with the database, perform CRUD operations, and manage transactions.

### **4. SQL**
- **SQL (Structured Query Language)**: Used for writing queries to create tables, insert data, update records, and fetch data from the database.

### **5. Design Patterns**
- **DAO (Data Access Object) Pattern**: To abstract and encapsulate all access to the data source. The DAO pattern provides a clean separation between business logic and data access logic.
- **Singleton Pattern**: Used in managing the `DatabaseConnection` class to ensure only one instance of the database connection is used throughout the application.

### **6. Security**
- **Password Hashing (e.g., bcrypt)**: For securely storing user passwords.
- **Role-Based Access Control (RBAC)**: To manage and restrict user access to certain features based on their roles.
- **Session Management**: For managing user sessions and maintaining login states.

### **7. Exception Handling**
- **Custom Exceptions**: Java custom exceptions to handle specific error cases such as authentication failures, record not found, or validation errors.

### **12. Logging**
- **SLF4J with Logback/Log4j2**: For logging important information, errors, and debugging purposes.

### **13. Configuration**
- **Properties Files**: (`application.properties`) for managing configuration details like database connection strings, logging configurations, and other environment-specific settings.

### **14. IDE**
- **IntelliJ IDEA/Eclipse/NetBeans**: As the Integrated Development Environment (IDE) for writing, debugging, and managing the Java codebase.

This combination of technologies forms a full-fledged Java application with a focus on maintainability, scalability, and security.Given the project requirements, the technologies used in your Crime Information Management System are:
