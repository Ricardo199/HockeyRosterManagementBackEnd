/*
 * Student Name: Ricardo Burgos
 * Student ID: 301463628
 * Date: November 11, 2025
 * Assignment 3 - COMP303
 */
package com.example.hockeyrostermanagementbackend.controller;

import com.example.hockeyrostermanagementbackend.model.Player;
import com.example.hockeyrostermanagementbackend.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * REST controller for managing Player entities.
 * Base URL: /player
 *
 * @author Ricardo Burgos
 * @version 1.0
 */
@RequestMapping("player")
@AllArgsConstructor
@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public Flux<Player> findAll() {
        return playerService.findAll();
    }

    @GetMapping("{id}")
    public Mono<Player> getById(@PathVariable final Long id) {
        return playerService.getById(id);
    }

    @PutMapping("{id}")
    public Mono<Player> updateById(@PathVariable final Long id, @RequestBody final Player player) {
        return playerService.update(id, player);
    }

    @PostMapping
    public Mono<Player> save(@RequestBody final Player player) {
        return playerService.save(player);
    }

    @DeleteMapping("{id}")
    public Mono<Void> delete(@PathVariable final Long id) {
        return playerService.delete(id);
    }

    /**
     * INNOVATION: Get all players for a specific team.
     * GET /player/team/{teamId}
     */
    @GetMapping("/team/{teamId}")
    public Flux<Player> getPlayersByTeam(@PathVariable final Long teamId) {
        return playerService.getPlayersByTeamId(teamId);
    }
}
