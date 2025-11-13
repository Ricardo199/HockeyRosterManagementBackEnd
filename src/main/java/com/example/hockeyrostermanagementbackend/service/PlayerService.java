/*
 * Student Name: Ricardo Burgos
 * Student ID: 301463628
 * Date: November 11, 2025
 * Assignment 3 - COMP303
 */
package com.example.hockeyrostermanagementbackend.service;

import com.example.hockeyrostermanagementbackend.model.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static reactor.core.publisher.Mono.justOrEmpty;

/**
 * Service layer for Player operations.
 *
 * @author Ricardo Burgos
 * @version 1.0
 */
@Service
@AllArgsConstructor
public class PlayerService {
    @Autowired
    private PlayerRepo playerRepo;

    public Flux<Player> findAll() {
        return Flux.fromIterable(playerRepo.findAll());
    }

    public Mono<Player> getById(final Long id) {
        return justOrEmpty(playerRepo.findById(id));
    }

    public Mono<Player> update(final Long id, final Player player) {
        return Mono.just(playerRepo.save(player));
    }

    public Mono<Player> save(final Player player) {
        return Mono.just(playerRepo.save(player));
    }

    public Mono<Void> delete(final Long id) {
        playerRepo.deleteById(id);
        return Mono.empty();
    }

    /**
     * INNOVATION: Get all players for a specific team.
     */
    public Flux<Player> getPlayersByTeamId(final Long teamId) {
        return Flux.fromIterable(playerRepo.findByTeamId(teamId));
    }
}
