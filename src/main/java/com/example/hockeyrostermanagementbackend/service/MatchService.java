/*
 * Student Name: Ricardo Burgos
 * Student ID: 301463628
 * Date: November 11, 2025
 * Assignment 3 - COMP303
 */
package com.example.hockeyrostermanagementbackend.service;

import com.example.hockeyrostermanagementbackend.model.Match;
import com.example.hockeyrostermanagementbackend.model.MatchRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static reactor.core.publisher.Mono.justOrEmpty;

/**
 * Service layer for Match operations.
 *
 * @author Ricardo Burgos
 * @version 1.0
 */
@Service
@AllArgsConstructor
public class MatchService {
    @Autowired
    private MatchRepo matchRepo;

    public Flux<Match> findAll() {
        return Flux.fromIterable(matchRepo.findAll());
    }

    public Mono<Match> getById(final Long id) {
        return justOrEmpty(matchRepo.findById(id));
    }

    public Mono<Match> update(final Long id, final Match match) {
        return Mono.just(matchRepo.save(match));
    }

    public Mono<Match> save(final Match match) {
        return Mono.just(matchRepo.save(match));
    }

    public Mono<Void> delete(final Long id) {
        matchRepo.deleteById(id);
        return Mono.empty();
    }
}
