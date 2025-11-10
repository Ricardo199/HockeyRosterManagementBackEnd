package com.example.hockeyrostermanagementbackend.controller;

import com.example.hockeyrostermanagementbackend.model.Player;
import com.example.hockeyrostermanagementbackend.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("player")
@AllArgsConstructor
@RestController

public class PlayerController {

    @Autowired
    private PlayerService playerService;

    // Return all players as a Flux. Used by GET /player
    @GetMapping
    public Flux<Player> findAll() {
        System.out.println("All the player information");
        return playerService.findAll();
    }

    // NOTE: corrected signature to return a Mono<Player> and accept the path id.
    // Return one player by id. Used by GET /player/{id}
    @GetMapping("{id}")
    public Mono<Player> getById(@PathVariable final Long id) {
        System.out.println("One player information based for the given ID");
        return playerService.getById(id.intValue());
    }

    // Update an existing player. Uses PUT /player/{id}
    @PutMapping("{id}")
    public Mono<Player> updateById(@PathVariable final Long id, @RequestBody final Player player) {
        System.out.println("Updating a player Info");
        return playerService.update(String.valueOf(id), player);
    }

    // Create a new player. Uses POST /player
    @PostMapping
    public Mono<Player> save(@RequestBody final Player player) {
        System.out.println("Added player Info");
        return playerService.save(player);
    }

    // Delete a player by id. Uses DELETE /player/{id}
    @DeleteMapping("{id}")
    public Mono<Void> delete(@PathVariable final Long id) {
        System.out.println("A player Info deleted");
        return playerService.delete(id.intValue());
    }
}
