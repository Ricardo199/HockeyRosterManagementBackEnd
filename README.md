# Hockey Roster Management Backend

A Spring Boot REST API for managing hockey teams, players, and matches.

## Features

- Team management (create, read, update, delete)
- Player management with team assignments
- Match scheduling and tracking
- RESTful API endpoints

## Tech Stack

- **Java 17**
- **Spring Boot 3.5.7**
- **Spring Data JPA**
- **Spring WebFlux**
- **Spring Boot DevTools**
- **Maven**
- **Lombok**

## Prerequisites

- Java 17 or higher
- Maven 3.6+

## Getting Started

### Clone the repository
```bash
git clone <repository-url>
cd HockeyRosterManagementBackEnd
```

### Run the application
```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

### Run tests
```bash
./mvnw test
```

## API Endpoints

### Teams
- `GET /team` - Get all teams
- `POST /team` - Create a new team
- `GET /team/{id}` - Get team by ID
- `PUT /team/{id}` - Update team
- `DELETE /team/{id}` - Delete team

### Players
- `GET /player` - Get all players
- `POST /player` - Create a new player
- `GET /player/{id}` - Get player by ID
- `PUT /player/{id}` - Update player
- `DELETE /player/{id}` - Delete player

### Matches
- `GET /match` - Get all matches
- `POST /match` - Create a new match
- `GET /match/{id}` - Get match by ID
- `PUT /match/{id}` - Update match
- `DELETE /match/{id}` - Delete match

## Project Structure

```
src/main/java/com/example/hockeyrostermanagementbackend/
├── controller/          # REST controllers
│   ├── MatchController.java
│   ├── PlayerController.java
│   └── TeamController.java
├── model/              # Entity classes and repositories
│   ├── Match.java
│   ├── MatchRepo.java
│   ├── Player.java
│   ├── PlayerRepo.java
│   ├── Team.java
│   └── TeamRepo.java
├── service/            # Business logic
│   ├── MatchService.java
│   ├── PlayerService.java
│   └── TeamService.java
└── HockeyRosterManagementBackEndApplication.java
```

## License

This project is licensed under the MIT License.