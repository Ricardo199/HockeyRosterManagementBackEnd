/*
 * Student Name: Ricardo Burgos
 * Student ID: 301463628
 * Date: November 11, 2025
 * Assignment 3 - COMP303
 */
package com.example.hockeyrostermanagementbackend.controller;

import com.example.hockeyrostermanagementbackend.model.Team;
import com.example.hockeyrostermanagementbackend.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * REST controller for managing Team entities.
 * Base URL: /team
 *
 * @author Ricardo Burgos
 * @version 1.0
 */
@RequestMapping("team")
@AllArgsConstructor
@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public Flux<Team> findAll() {
        return teamService.getAll();
    }

    @GetMapping("{id}")
    public Mono<Team> getById(@PathVariable final Long id) {
        return teamService.getById(id);
    }

    @PutMapping("{id}")
    public Mono<Team> updateById(@PathVariable final Long id, @RequestBody final Team team) {
        return teamService.update(id, team);
    }

    @PostMapping
    public Mono<Team> save(@RequestBody final Team team) {
        return teamService.save(team);
    }

    @DeleteMapping("{id}")
    public Mono<Void> delete(@PathVariable final Long id) {
        return teamService.delete(id);
    }

    /**
     * INNOVATION: Search teams by name (case-insensitive partial match).
     * GET /team/search?name=maple
     */
    @GetMapping("/search")
    public Flux<Team> searchByName(@RequestParam String name) {
        return teamService.searchByName(name);
    }
}
