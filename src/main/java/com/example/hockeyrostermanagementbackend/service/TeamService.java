/*
 * Student Name: Ricardo Burgos
 * Student ID: 301463628
 * Date: November 11, 2025
 * Assignment 3 - COMP303
 */
package com.example.hockeyrostermanagementbackend.service;

import com.example.hockeyrostermanagementbackend.model.Team;
import com.example.hockeyrostermanagementbackend.model.TeamRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static reactor.core.publisher.Mono.just;
import static reactor.core.publisher.Mono.justOrEmpty;

/**
 * Service layer for Team operations.
 *
 * @author Ricardo Burgos
 * @version 1.0
 */
@Service
@AllArgsConstructor
public class TeamService {

    @Autowired
    private TeamRepo teamRepo;

    public Flux<Team> getAll(){
        return Flux.fromIterable(teamRepo.findAll());
    }

    public Mono<Team> getById(final Long id){
        return justOrEmpty(teamRepo.findById(id));
    }

    public Mono<Team> update(final Long id, final Team team) {
        return just(teamRepo.save(team));
    }

    public Mono<Team> save(final Team team) {
        return just(teamRepo.save(team));
    }

    public Mono<Void> delete(final Long id) {
        teamRepo.deleteById(id);
        return Mono.empty();
    }

    /**
     * INNOVATION: Search teams by name (case-insensitive partial match).
     */
    public Flux<Team> searchByName(final String name) {
        return Flux.fromIterable(teamRepo.findByNameContaining(name));
    }
}
