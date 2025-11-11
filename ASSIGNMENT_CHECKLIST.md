# Assignment 3 Completion Checklist
**Student:** Ricardo Burgos  
**Student ID:** 301463628  
**Date:** November 11, 2025,  
**Course:** COMP303 - Assignment 3

---

## ✅ Requirements Completed

### 1. **Student Header Comments** ✅
- All `.java` files include required header with:
  - Student Name: Ricardo Burgos
  - Student ID: 301463628
  - Date: November 11, 2025
  - Assignment 3 - COMP303

### 2. **Entities (Models)** ✅
All three entities created with proper ID types (Long):

- **Team** - `Team.java`
  - id (Long)
  - name (String)
  - city (String)
  - founded (String)
  - coach (String)

- **Player** - `Player.java`
  - id (Long)
  - fname (String)
  - lname (String)
  - position (String)
  - number (int)
  - age (int)
  - teamId (Long) - Foreign key

- **Match** - `Match.java`
  - id (Long)
  - homeTeamId (Long) - Foreign key
  - awayTeamId (Long) - Foreign key
  - matchDate (String)
  - venue (String)
  - homeTeamScore (int)
  - awayTeamScore (int)

### 3. **Repositories (In-Memory Storage)** ✅
- `TeamRepo.java` - ConcurrentHashMap with Long keys
- `PlayerRepo.java` - ConcurrentHashMap with Long keys
- `MatchRepo.java` - ConcurrentHashMap with Long keys

All repositories implement:
- `findAll()`
- `findById(Long id)`
- `save(Entity entity)` - auto-generates ID if null
- `deleteById(Long id)`

### 4. **Services (Business Logic)** ✅
- `TeamService.java` - Reactive operations with Mono/Flux
- `PlayerService.java` - Reactive operations with Mono/Flux
- `MatchService.java` - Reactive operations with Mono/Flux

All services implement:
- `getAll()` / `findAll()` - Returns Flux
- `getById(Long id)` - Returns Mono
- `save(Entity entity)` - Returns Mono
- `update(Long id, Entity entity)` - Returns Mono
- `delete(Long id)` - Returns Mono<Void>

### 5. **Controllers (REST Endpoints)** ✅
All three controllers created with proper REST mappings:

- **TeamController** - `/team`
  - GET `/team` - Get all teams
  - GET `/team/{id}` - Get team by ID
  - POST `/team` - Create team
  - PUT `/team/{id}` - Update team
  - DELETE `/team/{id}` - Delete team

- **PlayerController** - `/player`
  - GET `/player` - Get all players
  - GET `/player/{id}` - Get player by ID
  - POST `/player` - Create player
  - PUT `/player/{id}` - Update player
  - DELETE `/player/{id}` - Delete player

- **MatchController** - `/match`
  - GET `/match` - Get all matches
  - GET `/match/{id}` - Get match by ID
  - POST `/match` - Create match
  - PUT `/match/{id}` - Update match
  - DELETE `/match/{id}` - Delete match

### 6. **HTTP Methods Implemented** ✅
- ✅ GET - Retrieve entities
- ✅ POST - Create new entities
- ✅ PUT - Update existing entities
- ✅ DELETE - Delete entities

### 7. **Dependencies in POM.xml** ✅
- ✅ spring-boot-starter-web
- ✅ spring-boot-starter-webflux (for reactive programming)
- ✅ spring-boot-devtools
- ✅ lombok (for reducing boilerplate)
- ✅ spring-boot-starter-test
- ✅ reactor-test

### 8. **Main Application Class** ✅
- `SpringBootRicardoAssign3Appplication.java`
- Runs on port 8080 (default)
- Can be changed in `application.properties` if needed

### 9. **Code Quality** ✅
- ✅ Consistent ID types (Long throughout)
- ✅ No unnecessary type conversions
- ✅ Clean, optimized comments
- ✅ Proper use of Lombok annotations
- ✅ Reactive programming with Project Reactor
- ✅ No compilation errors

### 10. **INNOVATION Features** ✅

#### Feature 1: Team Search by Name
- **Endpoint:** `GET /team/search?name={searchTerm}`
- **Location:** `TeamController.searchByName()`
- **Description:** Case-insensitive partial name matching for teams
- **Example:** `GET /team/search?name=maple` returns all teams with "maple" in the name

#### Feature 2: Get Players by Team
- **Endpoint:** `GET /player/team/{teamId}`
- **Location:** `PlayerController.getPlayersByTeam()`
- **Description:** Retrieve all players belonging to a specific team
- **Example:** `GET /player/team/10` returns all players on team 10

---

## 🧪 Testing Instructions

### Using Postman:

#### Team Endpoints:
```
POST http://localhost:8080/team
Body: {"name":"Maple Leafs","city":"Toronto","founded":"1917","coach":"Craig Berube"}

GET http://localhost:8080/team

GET http://localhost:8080/team/1

PUT http://localhost:8080/team/1
Body: {"id":1,"name":"Toronto Maple Leafs","city":"Toronto","founded":"1917","coach":"Craig Berube"}

DELETE http://localhost:8080/team/1

GET http://localhost:8080/team/search?name=maple (INNOVATION)
```

#### Player Endpoints:
```
POST http://localhost:8080/player
Body: {"fname":"Auston","lname":"Matthews","position":"center","number":34,"age":28,"teamId":10}

GET http://localhost:8080/player

GET http://localhost:8080/player/1

PUT http://localhost:8080/player/1
Body: {"id":1,"fname":"Auston","lname":"Matthews","position":"center","number":34,"age":28,"teamId":10}

DELETE http://localhost:8080/player/1

GET http://localhost:8080/player/team/10 (INNOVATION)
```

#### Match Endpoints:
```
POST http://localhost:8080/match
Body: {"homeTeamId":10,"awayTeamId":8,"matchDate":"10/08/2025","venue":"Scotiabank Arena, Toronto","homeTeamScore":5,"awayTeamScore":2}

GET http://localhost:8080/match

GET http://localhost:8080/match/1

PUT http://localhost:8080/match/1
Body: {"id":1,"homeTeamId":10,"awayTeamId":8,"matchDate":"10/08/2025","venue":"Scotiabank Arena, Toronto","homeTeamScore":6,"awayTeamScore":2}

DELETE http://localhost:8080/match/1
```

---

## 📋 Assignment Grading Criteria

| Criteria                                                                            | Points | Status      |
|-------------------------------------------------------------------------------------|--------|-------------|
| Functionalities: Spring Boot REST app with entities, services, controllers, POM.xml | 20     | ✅ Complete  |
| Testing: REST services with POSTMAN (demonstration)                                 | 10     | ✅ Ready     |
| Code standards, Java comments, usability                                            | 5      | ✅ Complete  |
| Innovation: New feature/additional REST service                                     | 5      | ✅ Complete  |
| **Total**                                                                           | **40** | **✅ Ready** |

---

## 🚀 How to Run

1. Open project in IntelliJ IDEA or your IDE
2. Run `SpringBootRicardoAssign3Appplication.java`
3. Server starts on `http://localhost:8080`
4. Use Postman to test endpoints
5. All data is stored in-memory (ConcurrentHashMap)

---

## 📝 Notes

- All IDs are auto-generated using AtomicLong (starting from 1)
- Data is stored in-memory and will be lost when the application stops
- Reactive programming used throughout (Mono/Flux)
- No database configuration required
- Ready for demonstration and submission

