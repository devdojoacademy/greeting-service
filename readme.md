# Greetings API
An API built with Spring Boot that allows users to manage greetings. That's w'll be used in the AWS white belt video series.

## Table of Contents
- [Greetings API](#greetings-api)
  - [Table of Contents](#table-of-contents)
  - [Project Structure](#project-structure)
  - [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
  - [Usage](#usage)
  - [Contributing](#contributing)
  - [License](#license)

## Project Structure
The main building blocks of the project are:

```
.
├── src/main/java/com/devdojo/greeting
│   ├── controller
│   │   ├── GreetingController.java
│   ├── model
│   │   ├── Greeting.java
│   ├── service
│   │   ├── GreetingService.java
|   ├── repository
│   │   ├── GreetingRepository.java
│   ├── GreetingServiceApplication.java
├── src/main/resources
│   ├── application.properties
├── .gitignore
├── pom.xml
├── README.md
├── docker-compose.yml
```

- `GreetingController.java`: This class is responsible for handling HTTP requests and responses.
- `Greeting.java`: This class is an entity that represents a greeting.
- `GreetingService.java`: This class provides business logic for managing greetings.
- `Application.java`: This is the main class that runs the Spring Boot application.
- `application.properties`: This file contains configuration properties for the application.
- `pom.xml`: This file contains project metadata and dependencies.

## Getting Started
These instructions will help you get a copy of the project up and running on your local machine.

### Prerequisites
- Java 8 or later
- Maven
- Docker

### Installation
1. Clone the repository to your local machine:
    ```
    git clone https://github.com/yourusername/greetings-api.git
    ```
2. Go to the project directory:
    ```
    cd greetings-api
    ```
3. Start the database:
    ```
    docker-compose up -d
    ```
4. Run the application:
    ```
    mvn spring-boot:run
    ```
The application should now be running on `http://localhost:8080`.

## Usage
Here are a few examples of how to use the API:

- Get all greetings: `GET /api/greetings`
- Get a specific greeting: `GET /api/greetings/{id}`
- Create a new greeting: `POST /api/greetings`
- Update a greeting: `PUT /api/greetings/{id}`
- Delete a greeting: `DELETE /api/greetings/{id}`

## Contributing
We love contributions! If you have any suggestions, bug reports, or feature requests, feel free to create an issue or a pull request.

## License
This project is licensed under the MIT License - see the LICENSE file for details.

---

Remember to replace `https://github.com/yourusername/greetings-api.git` with the actual URL of your GitHub repository.