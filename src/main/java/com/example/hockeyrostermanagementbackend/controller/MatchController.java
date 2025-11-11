/*
 * Student Name: Ricardo Burgos
 * Student ID: 301463628
 * Date: November 11, 2025
 * Assignment 3 - COMP303
 */
package com.example.hockeyrostermanagementbackend.controller;

import com.example.hockeyrostermanagementbackend.model.Match;
import com.example.hockeyrostermanagementbackend.service.MatchService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * REST controller for managing Match entities.
 * Base URL: /match
 *
 * @author Ricardo Burgos
 * @version 1.0
 */
@RequestMapping("match")
@AllArgsConstructor
@RestController
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping
    public Flux<Match> findAll() {
        return matchService.findAll();
    }

    @GetMapping("{id}")
    public Mono<Match> getById(@PathVariable final Long id) {
        return matchService.getById(id);
    }

    @PutMapping("{id}")
    public Mono<Match> updateById(@PathVariable final Long id, @RequestBody final Match match) {
        return matchService.update(id, match);
    }

    @PostMapping
    public Mono<Match> save(@RequestBody final Match match) {
        return matchService.save(match);
    }

    @DeleteMapping("{id}")
    public Mono<Void> delete(@PathVariable final Long id) {
        return matchService.delete(id);
    }
}
