# Movie REST API Service

This project implements a RESTful API service for managing movies.

## Table of Contents
- [Overview](#overview)
- [RESTful Specifications](#restful-specifications)
- [Endpoints](#endpoints)
    - [List of Movies](#list-of-movies)
    - [Detail of Movie](#detail-of-movie)
    - [Add New Movie](#add-new-movie)
    - [Update Movie](#update-movie)
    - [Delete Movie](#delete-movie)
- [Project Structure](#project-structure)
- [How to Run](#how-to-run)
- [Authentication and Authorization](#authentication-and-authorization)
- [Unit Testing](#unit-testing)
- [Contributing](#contributing)

## Overview
This project provides a backend API service for managing movies. It follows RESTful guidelines and utilizes a PostgreSQL/MySQL database for data storage. Request validation is applied, and unit tests are provided.

## RESTful Specifications

1. The API complies with RESTful guidelines.
2. Custom API response objects are implemented.
3. Endpoints follow the specified requirements.
4. The API is implemented using Java.
5. Data is stored using PostgreSQL or MySQL.
6. Request validation is applied.
7. Unit tests are provided.
8. A proper README is included.
9. Additional features like architectural enhancements and error handling are implemented.

## Endpoints
### List of Movies

- **Endpoint:** `/movies`
- **Method:** `GET`
- **Description:** Returns the details of movies in JSON format.

#### Example Response:

```json
[
  {
    "id": 1,
    "title": "Pengabdi Setan 2 Comunion",
    "description": "dalah sebuah film horor Indonesia tahun 2022 yang disutradarai dan ditulis oleh Joko Anwar sebagai sekuel dari film tahun 2017, Pengabdi Setan.",
    "rating": 7.0,
    "image": "",
    "created_at": "2022-08-01 10:56:31",
    "updated_at": "2022-08-13 09:30:23"
  },
  {
    "id": 2,
    "title": "Pengabdi Setan",
    "description": "",
    "rating": 8.0,
    "image": "",
    "created_at": "2022-08-01 10:56:31",
    "updated_at": "2022-08-13 09:30:23"
  }
]
```

### Detail of Movie
- **Endpoint:** `/movies/:id`
- **Method:** `GET`
- **Description:** Returns the details of movies in JSON format.
#### Example Response:
```json
{
  "id": 1,
  "title": "Pengabdi Setan 2 Comunion",
  "description": "dalah sebuah film horor Indonesia tahun 2022 yang disutradarai dan ditulis oleh Joko Anwar sebagai sekuel dari film tahun 2017, Pengabdi Setan.",
  "rating": 7,
  "image": "",
  "created_at": "2022-08-01 10:56:31",
  "updated_at": "2022-08-13 09:30:23"
}
```

### Add New Movie
- **Endpoint:** `/movies`
- **Method:** `POST`
- **Description:** Adds a new movie to the list.
#### Example Response:
```json
{
  "id" : 1,
  "title" : "Pengabdi Setan 2 Comunion",
  "description" : "Adalah sebuah film horor Indonesia tahun 2022 yang disutradarai dan ditulis oleh Joko Anwar sebagai sekuel dari film tahun 2017, Pengabdi Setan.",
  "rating" : 7.0,
  "image" : "",
  "created_at" : "2022-08-01 10:56:31",
  "updated_at": "2022-08-13 09:30:23"
}
```

### Update Movie
- **Endpoint:** `/movies/:id`
- **Method:** `PATCH`
- **Description:** Updates details of a movie.
#### Example Response:
```json
{
"id" : 1,
"title" : "Pengabdi Setan 2 Comunion",
"description" : "Adalah sebuah film horor Indonesia tahun 2022 yang disutradarai dan ditulis oleh Joko Anwar sebagai sekuel dari film tahun 2017, Pengabdi Setan.",
"rating" : 7.0,
"image" : "",
"created_at" : "2022-08-01 10:56:31",
"updated_at": "2022-08-13 09:30:23"
}
```

### Delete Movie
- **Endpoint:** `/movies/:id`
- **Method:** `DELETE`
- **Description:** Deletes a movie from the database.

## Technologies Used at This Project
- **Java**
- **Spring Boot**
- **PostgreSQL**
- **Maven**

## Project Structure
```plaintext
Assessment_Backend_Developer_Xsis
|-- .idea
|-- .mvn
|-- src
|   |-- main
|       |-- java
|           |-- assessment_backend_developer_xsis
|               |-- controller
|                   |-- MovieController
|               |-- model
|                   |-- dto
|                       |-- MovieDto
|                   |-- entity
|                       |-- Movie
|                   |-- BaseResponse
|               |-- repository
|                   |-- MovieRepository
|               |-- service
|                   |-- MovieService
|               |-- AssessmentBackendDeveloperXsisApplication
|       |-- resources
|           |-- static
|           |-- templates
|           |-- application.properties
|-- test
|-- target
|-- .gitignore
|-- Assessment_Backend_Developer_Xsis.iml
|-- HELP.md
|-- Movie.postman_collection.json
|-- mvnw
|-- mvnw.cmd
|-- pom.xml
|-- README.md
|-- script.sql
```

## How to Run
- Clone this repository.
- Set up a PostgreSQL/MySQL database.
- Update application.properties with your database configuration.
- Run the application using Maven or your IDE.


## Authentication and Authorization
This application does not require authentication or authorization to access the API endpoints.

## Unit Testing
Unit tests are provided in the test directory.

## Contributing
**Contributions are welcome! Please fork this repository and create a pull request.**

