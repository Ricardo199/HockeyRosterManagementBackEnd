package com.example.hockeyrostermanagementbackend.service;

import com.example.hockeyrostermanagementbackend.model.Team;
import com.example.hockeyrostermanagementbackend.model.TeamRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static reactor.core.publisher.Mono.just;
import static reactor.core.publisher.Mono.justOrEmpty;

@Service
@Transactional
@AllArgsConstructor

public class TeamService {

    @Autowired
    private TeamRepo teamRepo;

    // Return all teams as a Flux stream by wrapping the blocking repository result.
    public Flux<Team> getAll(){
        return Flux.fromIterable(teamRepo.findAll());
    }

    // Get one team by id and return as a Mono (may be empty if not found).
    public Mono<Team> getById(@PathVariable final Integer id){
        return justOrEmpty(teamRepo.findById(id));
    }

    // Update a team and return the saved entity wrapped in a Mono.
    public Mono<Team> update(final String id, final Team team) {
        return just(teamRepo.save(team));
    }

    // Save a new team and return saved entity as a Mono.
    public Mono save(final Team team) {
        return just(teamRepo.save(team));
    }

    // Delete a team by id and return an empty Mono to signal completion.
    public Mono delete(final Integer id) {
        teamRepo.deleteById(id);
        return Mono.empty();
    }
}
