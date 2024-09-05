
# Jaankaar Havaldar - Crime Information Management System

Jaankaar Havaldar is a CLI-based Crime Information Management System designed to efficiently manage records related to crimes, criminals, police stations, police officers, and users. It provides secure user authentication, comprehensive reporting features, and a well-organized code structure based on the DAO (Data Access Object) pattern.

## Table of Contents
- [Features](#features)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Usage](#usage)
- [Technologies Used](#technologies-used)
- [Contributing](#contributing)
- [License](#license)

## Features
- **User Authentication**: Secure login and registration with password hashing for better security.
- **Role-Based Access**: Different functionalities and menus based on user roles (Admin, Police Officer, etc.).
- **Crime Management**: Add, update, view, and delete crime records.
- **Criminal Management**: Full CRUD operations (Create, Read, Update, Delete) for managing criminal records.
- **Police Station Management**: Manage and track police stations and their assigned officers.
- **Police Officer Management**: Handle police officer details including assignments and personal information.
- **User Management**: Administer user accounts with CRUD functionalities.
- **Reporting**: Generate reports like crime statistics, user activities, and criminal records.
- **Modular Design**: Clean and maintainable code using well-organized structure and design patterns.


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
│   │   │   │   │   │   ├── dao/         # DAO interfaces and implementations
│   │   │   │   │   │   ├── service/     # Business logic and service classes
│   │   │   │   │   │   ├── model/       # Data models (Crime, Criminal, PoliceStation, etc.)
│   │   │   │   │   │   ├── util/        # Utility classes (e.g., password hashing)
│   │   │   │   │   │   ├── exception/   # Custom exceptions
│   │   │   │   │   │   ├── menu/        # CLI Menus for various functionalities
│   │   │   │   │   │   ├── report/      # Report generation classes
│   │   │   │   │   │   ├── authentication/  # User authentication logic
│   │   │   │   │   │   ├── main/        # Main application entry point
│   └── test/                            # Test cases
│
├── resources/
│   └── schema.sql                       # SQL schema for database setup
│
└── README.md
```

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/username/jaankaar-havaldar.git
   cd jaankaar-havaldar
   ```

2. **Set up the database**:
   - Import the `schema.sql` file into your MySQL database.
   - Update the database connection details in the application (usually found in a properties or config file).

3. **Compile and run the project**:
   - Open the project in IntelliJ IDEA.
   - Ensure all required dependencies (like MySQL connector) are added.
   - Run the main application class to start the system.

## Usage

- **Admin**:
  - Login with admin credentials.
  - Manage crimes, criminals, police stations, police officers, and users.
  - View reports and generate statistics.
  
- **Police Officer**:
  - Login with police officer credentials.
  - Manage crimes and criminals assigned to your station.

- **General User**:
  - Register and view public crime statistics.

## Technologies Used

- **Java**: The core programming language used for developing the application.
- **JDBC**: For database interactions and SQL query execution.
- **MySQL**: The relational database used for storing data related to crimes, criminals, and users.
- **IntelliJ IDEA**: Recommended IDE for development.
- **Password Hashing (PBKDF2WithHmacSHA256)**: For secure password storage and verification.
- **DAO Pattern**: To separate business logic from data access logic.
- **Custom Exceptions**: For clean and controlled exception handling across the system.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request if you would like to contribute to Jaankaar Havaldar.

## License

This project is licensed under the MIT License. See the `LICENSE` file for more details.

---

This revised `README.md` offers a clean, professional structure with easy-to-understand instructions while still providing all necessary technical details. Let me know if you need further customization!
