# Running Club Web App

A Spring Boot MVC web application for managing running clubs and their events, rendered server-side with Thymeleaf and secured with Spring Security form login.

## Tech Stack

- Java 17, Spring Boot 3.1
- Spring MVC + Thymeleaf (with Thymeleaf Layout Dialect)
- Spring Data JPA (Hibernate) + MySQL
- Spring Security (form login, BCrypt password hashing)
- Bean Validation, ModelMapper, Lombok

## Features

- Clubs: list, search by title, view details, create, edit, delete
- Events: list, view details, create an event for a club, edit, delete
- User registration and login/logout (`/clubs`, `/login` and `/register` are public; other pages require login)

## Getting Started

### Prerequisites

- JDK 17
- MySQL running locally

### Configuration

Create the database:

```sql
CREATE DATABASE rungroupdb;
```

Connection settings are in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/rungroupdb
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD:root}
```

Set the `DB_USERNAME` and `DB_PASSWORD` environment variables to override the default `root`/`root` credentials. Tables are created automatically (`spring.jpa.hibernate.ddl-auto=update`).

### Run

```bash
git clone https://github.com/Hussein-Fouani/Running_Application.git
cd Running_Application
./mvnw spring-boot:run
```

The application starts on `http://localhost:8080`.

## Pages

| Method | Path | Description |
|--------|------|-------------|
| GET | `/clubs` | List clubs |
| GET | `/clubs/search?param=` | Search clubs by title |
| GET/POST | `/clubs/new` | Create a club |
| GET | `/clubs/{clubId}` | Club details |
| GET/POST | `/clubs/{clubId}/edit` | Edit a club |
| GET | `/clubs/{clubId}/delete` | Delete a club |
| GET | `/events` | List events |
| GET | `/events/{eventId}` | Event details |
| GET | `/events/{clubId}/new` | New event form for a club |
| POST | `/events/{clubId}` | Create an event for a club |
| GET/POST | `/events/{eventId}/edit` | Edit an event |
| GET | `/events/{eventId}/delete` | Delete an event |
| GET | `/register` | Registration form |
| POST | `/register/save` | Register a user |
| GET | `/login` | Login page |
