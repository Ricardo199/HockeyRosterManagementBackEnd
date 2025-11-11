# Hockey Roster Management Backend

A RESTful web service for managing an Ice Hockey League system.

---

## 📋 Project Overview

A RESTful web service built with Spring Boot for managing an Ice Hockey League system. This application provides complete CRUD operations for Teams, Players, and Matches with reactive programming support using Project Reactor.

---

## 🚀 Features

### Core Functionality
- **Team Management** - Create, read, update, and delete hockey teams
- **Player Management** - Manage player rosters with team associations
- **Match Management** - Track games between teams with scores and venues
- **In-Memory Storage** - Fast, thread-safe data storage using ConcurrentHashMap
- **Reactive Programming** - Non-blocking I/O with Mono and Flux

### Innovation Features 🌟
1. **Team Search by Name** - `GET /team/search?name={searchTerm}`
   - Case-insensitive partial matching
   - Example: `/team/search?name=maple` finds "Maple Leafs"

2. **Players by Team** - `GET /player/team/{teamId}`
   - Retrieve all players for a specific team
   - Example: `/player/team/10` returns all players on team 10

---

## 🛠️ Technology Stack

- **Framework:** Spring Boot 3.4.0
- **Language:** Java 17
- **Build Tool:** Maven
- **Dependencies:**
  - Spring Web & WebFlux (REST + Reactive)
  - Lombok (Boilerplate reduction)
  - Spring Boot DevTools (Hot reload)
  - Reactor Test (Reactive testing)

---

## 📂 Project Structure

```
src/main/java/com/example/hockeyrostermanagementbackend/
├── SpringBootRicardoAssign3Appplication.java  # Main application
├── controller/
│   ├── TeamController.java      # Team REST endpoints
│   ├── PlayerController.java    # Player REST endpoints
│   └── MatchController.java     # Match REST endpoints
├── service/
│   ├── TeamService.java         # Team business logic
│   ├── PlayerService.java       # Player business logic
│   └── MatchService.java        # Match business logic
└── model/
    ├── Team.java                # Team entity
    ├── TeamRepo.java            # Team repository
    ├── Player.java              # Player entity
    ├── PlayerRepo.java          # Player repository
    ├── Match.java               # Match entity
    └── MatchRepo.java           # Match repository
```

---

## 🎯 Data Models

### Team
```json
{
  "id": 10,
  "name": "Maple Leafs",
  "city": "Toronto",
  "founded": "1917",
  "coach": "Craig Berube"
}
```

### Player
```json
{
  "id": 1,
  "fname": "Auston",
  "lname": "Matthews",
  "position": "center",
  "number": 34,
  "age": 28,
  "teamId": 10
}
```

### Match
```json
{
  "id": 1,
  "homeTeamId": 10,
  "awayTeamId": 8,
  "matchDate": "10/08/2025",
  "venue": "Scotiabank Arena, Toronto",
  "homeTeamScore": 5,
  "awayTeamScore": 2
}
```

---

## 🔌 API Endpoints

### Team Endpoints (`/team`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/team` | Get all teams |
| GET | `/team/{id}` | Get team by ID |
| POST | `/team` | Create new team |
| PUT | `/team/{id}` | Update team |
| DELETE | `/team/{id}` | Delete team |
| GET | `/team/search?name={name}` | 🌟 Search teams by name |

### Player Endpoints (`/player`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/player` | Get all players |
| GET | `/player/{id}` | Get player by ID |
| POST | `/player` | Create new player |
| PUT | `/player/{id}` | Update player |
| DELETE | `/player/{id}` | Delete player |
| GET | `/player/team/{teamId}` | 🌟 Get players by team |

### Match Endpoints (`/match`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/match` | Get all matches |
| GET | `/match/{id}` | Get match by ID |
| POST | `/match` | Create new match |
| PUT | `/match/{id}` | Update match |
| DELETE | `/match/{id}` | Delete match |

---

## 🏃 Running the Application

### Prerequisites
- Java 17 or higher
- Maven (or use included Maven Wrapper)

### Option 1: Using Maven Wrapper (Recommended)

**Windows PowerShell:**
```powershell
.\mvnw.cmd spring-boot:run
```

**Windows CMD:**
```cmd
mvnw.cmd spring-boot:run
```

**Mac/Linux:**
```bash
./mvnw spring-boot:run
```

### Option 2: Using IDE
1. Open project in IntelliJ IDEA or Eclipse
2. Run `SpringBootRicardoAssign3Appplication.java`
3. Application starts on `http://localhost:8080`

### Option 3: Build and Run JAR
```powershell
.\mvnw.cmd clean package
java -jar target\HockeyRosterManagementBackEnd-0.0.1-SNAPSHOT.jar
```

---

## 🧪 Testing with Postman

### Create a Team
```
POST http://localhost:8080/team
Content-Type: application/json

{
  "name": "Maple Leafs",
  "city": "Toronto",
  "founded": "1917",
  "coach": "Craig Berube"
}
```

### Get All Teams
```
GET http://localhost:8080/team
```

### Search Teams by Name (Innovation)
```
GET http://localhost:8080/team/search?name=maple
```

### Create a Player
```
POST http://localhost:8080/player
Content-Type: application/json

{
  "fname": "Auston",
  "lname": "Matthews",
  "position": "center",
  "number": 34,
  "age": 28,
  "teamId": 10
}
```

### Get Players by Team (Innovation)
```
GET http://localhost:8080/player/team/10
```

### Create a Match
```
POST http://localhost:8080/match
Content-Type: application/json

{
  "homeTeamId": 10,
  "awayTeamId": 8,
  "matchDate": "10/08/2025",
  "venue": "Scotiabank Arena, Toronto",
  "homeTeamScore": 5,
  "awayTeamScore": 2
}
```

### Update a Match Score
```
PUT http://localhost:8080/match/1
Content-Type: application/json

{
  "id": 1,
  "homeTeamId": 10,
  "awayTeamId": 8,
  "matchDate": "10/08/2025",
  "venue": "Scotiabank Arena, Toronto",
  "homeTeamScore": 6,
  "awayTeamScore": 2
}
```

### Delete a Player
```
DELETE http://localhost:8080/player/1
```

---

## 📝 Sample Test Workflow

1. **Create Team #10** (Maple Leafs)
2. **Create Team #8** (Canadiens)
3. **Create Player** (Auston Matthews, teamId: 10)
4. **Create Player** (William Nylander, teamId: 10)
5. **Get Players by Team 10** → Returns both players
6. **Create Match** between teams 10 and 8
7. **Update Match** with final score
8. **Search Teams** by name "maple"
9. **Get All Matches**
10. **Delete Test Data**

---


## 📦 Build Information

```xml
<groupId>com.example</groupId>
<artifactId>HockeyRosterManagementBackEnd</artifactId>
<version>0.0.1-SNAPSHOT</version>
<name>HockeyRosterManagementBackEnd</name>
<packaging>jar</packaging>
```

---

## 🔧 Configuration

Default configuration in `application.properties`:
- Server port: 8080
- Context path: /
- All data stored in-memory (non-persistent)

To change the port, add to `application.properties`:
```properties
server.port=9090
```

---

## 📚 Additional Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Project Reactor](https://projectreactor.io/)
- [Postman Documentation](https://learning.postman.com/)
- [RESTful API Design](https://restfulapi.net/)

---

## 📄 License

MIT License - Free to use and modify.

---

## 👨‍💻 Author

**Ricardo Burgos**  
Full Stack Developer  
[GitHub](https://github.com/burgo) | [LinkedIn](https://linkedin.com/in/ricardoburgos)

