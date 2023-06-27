# greeting API
An API built with Spring Boot that allows users to manage greeting. That's w'll be used in the AWS white belt video series.

## Table of Contents
- [greeting API](#greeting-api)
  - [Table of Contents](#table-of-contents)
  - [Project Structure](#project-structure)
  - [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Build and Running Locally from docker](#build-and-running-locally-from-docker)
    - [Running from docker image](#running-from-docker-image)
  - [Usage](#usage)
  - [Contributing](#contributing)
  - [License](#license)

## Project Structure
The main building blocks of the project are:

```
.
├── App
    ├── src/main/java/com/devdojo/greeting
    │   ├── controller
    │   │   ├── GreetingController.java
    │   ├── model
    │   │   ├── Greeting.java
    │   ├── service
    │   │   ├── greetingervice.java
    |   ├── repository
    │   │   ├── GreetingRepository.java
    │   ├── greetingerviceApplication.java
    ├── src/main/resources
    │   ├── application.properties
    ├── .gitignore
    ├── pom.xml
    ├── README.md
    ├── Dockerfile
    ├── docker-compose.yml
├── client
    ├── greeting-api.js
    ├── index.hmtl
    ├── styles.css
├── scripts
    ├── build.sh
    ├── run.sh

```

- `Greeting.java`: This class is an entity that represents a greeting.
- `greetingervice.java`: This class provides business logic for managing greeting.
- `Application.java`: This is the main class that runs the Spring Boot application.
- `application.properties`: This file contains configuration properties for the application.
- `pom.xml`: This file contains project metadata and dependencies.

## Getting Started
These instructions will help you get a copy of the project up and running on your local machine.

### Prerequisites
- Java 8 or later
- Maven
- Docker

### Build and Running Locally from docker
1. Clone the repository to your local machine:
    ```
    git clone https://github.com/devdojoacademy/greeting-service.git
    ```
2. Go to the project directory:
    ```
    cd greeting-api
    ```
3. Starting with script thats build and up the client and the backend:
    ```
    ./scripts/run.sh
    ```

The backend application should now be running on `http://localhost:8080`.
The frontend client should now be running on `http://localhost:8081`.

### Running from docker image
Please follow the instructions at the [docker repository.](https://hub.docker.com/r/brnnai/greeting-service)

## Usage
Here are a few examples of how to use the API:

- Get all greeting: `GET /api/greeting`
- Get a specific greeting: `GET /api/greeting/{id}`
- Create a new greeting: `POST /api/greeting`
- Update a greeting: `PUT /api/greeting/{id}`
- Delete a greeting: `DELETE /api/greeting/{id}`

## Contributing
We love contributions! If you have any suggestions, bug reports, or feature requests, feel free to create an issue or a pull request.

## License
This project is licensed under the MIT License - see the LICENSE file for details.

---