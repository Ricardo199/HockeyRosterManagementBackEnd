package com.example.hockeyrostermanagementbackend.service;

import com.example.hockeyrostermanagementbackend.model.Match;
import com.example.hockeyrostermanagementbackend.model.MatchRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static reactor.core.publisher.Mono.justOrEmpty;

@Service
@Transactional
@AllArgsConstructor

public class MatchService {
    @Autowired
    private MatchRepo matchRepo;

    // Return all matches as a reactive Flux using the blocking repository.
    public Flux<Match> findAll() {
        return Flux.fromIterable(matchRepo.findAll());
    }

    // Find one match by numeric id and return as a Mono.
    public Mono<Match> getById(final Integer id) {
        return justOrEmpty(matchRepo.findById(Long.valueOf(id)));
    }

    // Update an existing match and return the saved entity as a Mono.
    public Mono<Match> update(final String id, final Match match) {
        return Mono.just(matchRepo.save(match));
    }

    // Save a new match and return the saved entity as a Mono.
    public Mono<Match> save(final Match match) {
        return Mono.just(matchRepo.save(match));
    }

    // Delete a match and return an empty Mono to indicate completion.
    public Mono<Void> delete(final Integer id) {
        matchRepo.deleteById(Long.valueOf(id));
        return Mono.empty();
    }
}
