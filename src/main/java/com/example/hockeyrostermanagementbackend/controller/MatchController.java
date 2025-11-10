package com.example.hockeyrostermanagementbackend.controller;

import com.example.hockeyrostermanagementbackend.model.Match;
import com.example.hockeyrostermanagementbackend.service.MatchService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("match")
@AllArgsConstructor
@RestController

public class MatchController {

    @Autowired
    private MatchService matchService;

    // Return all matches as a Flux. GET /match
    @GetMapping
    public Flux<Match> findAll() {
        System.out.println("All the match information");
        return matchService.findAll();
    }

    // Return one match by id. GET /match/{id}
    @GetMapping("{id}")
    public Mono<Match> getById(@PathVariable final Long id) {
        System.out.println("One match information based for the given ID");
        return matchService.getById(id.intValue());
    }

    // Update an existing match. PUT /match/{id}
    @PutMapping("{id}")
    public Mono<Match> updateById(@PathVariable final Long id, @RequestBody final Match match) {
        System.out.println("Updating a match Info");
        return matchService.update(String.valueOf(id), match);
    }

    // Create a new match. POST /match
    @PostMapping
    public Mono<Match> save(@RequestBody final Match match) {
        System.out.println("Added match Info");
        return matchService.save(match);
    }

    // Delete a match by id. DELETE /match/{id}
    @DeleteMapping("{id}")
    public Mono<Void> delete(@PathVariable final Long id) {
        System.out.println("A match Info deleted");
        return matchService.delete(id.intValue());
    }
}
