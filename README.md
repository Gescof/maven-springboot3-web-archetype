# Maven Spring Boot 3 Web Archetype

## Introduction

This project is a Maven archetype for creating a Spring Boot 3 with Java 21 web application with a predefined structure and dependencies.

## Usage

To create a new project using the archetype, follow the next steps:

### 1. Clone or download this project

```sh
git clone https://github.com/gescof/spring-boot-web-archetype.git
```

### 2. Install the archetype in your local Maven repository

```sh
mvn clean install
```

### 3. Generate a new project using the archetype

```sh
mvn archetype:generate 
    -DarchetypeGroupId=com.github.gescof 
    -DarchetypeArtifactId=maven-springboot3-web-archetype 
    -DarchetypeVersion=1.0.0-SNAPSHOT 
    -DgroupId={YOUR_GROUP_ID}
    -DartifactId={YOUR_ARTIFACT_ID}
    -Dversion={YOUR_VERSION}
    -Dpackage={YOUR_PACKAGE}
    -DinteractiveMode=false
```

By default, the archetype uses the following values if you do not specify them:

- `YOUR_GROUP_ID`: com.example
- `YOUR_ARTIFACT_ID`: demo
- `YOUR_VERSION`: 0.0.1-SNAPSHOT
- `YOUR_PACKAGE`: com.example.demo

## Generated Project

### Structure

The architecture style of the project is based on the Clean Architecture principles of N-Tier architecture.

The project structure is as follows:

- `src/main/java`: Contains the main Java source files.
  - `config`: Contains the configuration classes: properties and programmatic configurations.
  - `controllers`: Contains the controller classes.
  - `exceptions`: Contains the exception and handlers classes.
  - `models`: Contains the model classes: entities and DTOs.
  - `repositories`: Contains the repository classes.
  - `services`: Contains the service classes.

- `src/main/resources`: Contains the main resources.
  - `application.yml`: Contains the application properties.

- `src/test/java`: Contains the test Java source files.

- `src/test/resources`: Contains the test resources.

### Dependencies

The project includes the following dependencies:

- Spring Boot Starter Web
- Spring Boot Starter Validation
- Spring Boot Starter Data JPA
- Lombok
- MapStruct
- H2 Database
- Spring Boot Starter Test
- JUnit

Please see the `pom.xml` file for the full list of dependencies and plugins.

### Build and Run

To build and run the project, you can use the following Maven commands:

```sh
mvn clean install
mvn spring-boot:run