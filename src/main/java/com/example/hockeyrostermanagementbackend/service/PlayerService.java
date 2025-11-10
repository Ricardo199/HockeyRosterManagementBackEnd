package com.example.hockeyrostermanagementbackend.service;

import com.example.hockeyrostermanagementbackend.model.*;
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

public class PlayerService {
    @Autowired
    private PlayerRepo playerRepo;

    // Return all players as a reactive Flux stream.
    // Uses the blocking CrudRepository under the hood by wrapping its Iterable.
    public Flux<Player> findAll() {
        return Flux.fromIterable(playerRepo.findAll());
    }

    // Find one player by numeric id and wrap result in a Mono (may be empty).
    // Note: underlying repo returns an Optional-like value; justOrEmpty converts null -> empty.
    public Mono<Player> getById(final Integer id) {
        return justOrEmpty(playerRepo.findById(Long.valueOf(id)));
    }

    // Update a player record. The save method on the repo returns the saved entity.
    // We wrap it in a Mono to keep the controller/service APIs reactive.
    public Mono<Player> update(final String id, final Player player) {
        return Mono.just(playerRepo.save(player));
    }

    // Create a new player record and return the saved entity as a Mono.
    public Mono<Player> save(final Player player) {
        return Mono.just(playerRepo.save(player));
    }

    // Delete a player by id. The repo call is synchronous; return an empty Mono to signal completion.
    public Mono<Void> delete(final Integer id) {
        playerRepo.deleteById(Long.valueOf(id));
        return Mono.empty();
    }
}
