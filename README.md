# Simple CRUD App with Spring Boot

This is a simple CRUD (Create, Read, Update, Delete) application built using Spring Boot. It is a great beginner project to understand how to use Spring Boot, Thymeleaf, and MySQL for basic database operations.

## Project Structure

- **Spring Boot** for the backend
- **Thymeleaf** for templating engine
- **MySQL** for the database

## Prerequisites

- Java 17 or higher
- MySQL installed and running
- Maven or Gradle for dependency management

## Steps to Build the Application



### 1. Initialize the Project using Spring Initializr

Go to [Spring Initializr](https://start.spring.io/), and generate a Spring Boot project with the following options:

- **Project**: Maven Project
- **Language**: Java
- **Spring Boot version**: (Select the latest stable version)
- **Project Metadata**:
  - **Group**: `com.name`
  - **Artifact**: `name`
  - **Name**: `name`
  - **Description**: Simple CRUD App
  - **Package name**: `com.packagename`
  - **Packaging**: Jar
  - **Java**: 17 or higher
- **Dependencies**:
  - **Spring Web**
  - **Spring Data JPA**
  - **MySQL Driver**
  - **Thymeleaf**


### 1. Or you can Clone or Download the Repository
You can either clone the repository or download it as a ZIP file.

```bash
git clone https://github.com/ruturajjadhav07/Simple-CRUD-Spring-Application.git

```

### 2. Set Up the Database
Create a database in MySQL called springDB.
```bash
CREATE DATABASE springDB;
```
## SQL Query for Database Creation
Before running the application, ensure that you have MySQL installed and create the database. Here's the SQL query to create the required `clients` table:

```bash
CREATE TABLE clients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### 4. Build and Run the Application
```bash
mvn clean install
mvn spring-boot:run
```

### 5. Access the Application
http://localhost:8080/

# Summary
This CRUD app is a great project for beginners to get hands-on experience with Spring Boot, JPA, and MySQL. It will help you understand the basic flow of a Spring Boot application, how to use Thymeleaf for rendering HTML, and how to interact with a MySQL database.

Feel free to extend the project, add more features, or improve the UI!

Happy coding!


# Interface
## landing page
![image](https://github.com/user-attachments/assets/0f880426-3aa7-484b-a8ba-e62c9e98012a)
## Display data
![image](https://github.com/user-attachments/assets/df8d33a7-49e9-49df-8cde-010b63cf34a5)
## Insert data
![image](https://github.com/user-attachments/assets/28d6d7ff-7520-4571-9213-5a5c4f191f8e)
## Edit data
![image](https://github.com/user-attachments/assets/3b6a4545-4ae2-4e1a-834f-07bad6b2a147)
## Delete data
![image](https://github.com/user-attachments/assets/c4c5a798-2ec4-4a7b-b484-9db4f08e74ba)



