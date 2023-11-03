# Kulu Student Management System

This is a simple Spring Boot project that implements a student management system. It allows you to perform basic CRUD (Create, Read, Update, Delete) operations on student records. The project uses Spring Boot, Spring Data JPA, and a PostgreSQL database for data storage.

## Features

- **Add Student**: You can add a new student with their name, email, and date of birth (DOB).

- **Get Students**: Retrieve a list of all students stored in the database.

- **Update Student**: Update a student's name and email.

- **Delete Student**: Delete a student record by providing their unique ID.

## Prerequisites

Before you begin, ensure you have the following requirements:

- Java 17 or later installed on your system.
- A PostgreSQL database configured and running locally or remotely.
- Maven for building and running the project.

## Getting Started

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/yourusername/kulu-student-management.git
   ```

2. Open the project in your favorite Java IDE.

3. Configure your PostgreSQL database connection in the `application.properties` file located in `src/main/resources`.

4. Build and run the project using Maven:

   ```bash
   mvn spring-boot:run
   ```

   The application will start, and you can access it at `http://localhost:8080/api/v1/student`.

## API Endpoints

- **GET `/api/v1/student`**: Retrieve a list of all students.

- **POST `/api/v1/student`**: Add a new student by sending a JSON request with the student's name, email, and DOB.

- **DELETE `/api/v1/student/{studentId}`**: Delete a student by providing their unique ID.

- **PUT `/api/v1/student/{studentId}`**: Update a student's name and email by providing their unique ID and the new data in the request parameters.

## Sample Data

The project includes a CommandLineRunner that loads sample student data during application startup. You can find and customize this data in the `StudentConfig.java` file.

## Database Configuration

Make sure to configure your database settings in the `application.properties` file. The default configuration assumes a PostgreSQL database with the following properties:

- URL: `jdbc:postgresql://localhost:5434/student`
- Username: 
- Password: 

## Known Issues

- No user authentication and authorization have been implemented.
- Error handling and validation are minimal.

## Contributing

Contributions are welcome. If you encounter any issues or have suggestions for improvements, please feel free to open an issue or submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
