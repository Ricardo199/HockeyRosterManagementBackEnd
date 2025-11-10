package com.example.hockeyrostermanagementbackend.controller;

import com.example.hockeyrostermanagementbackend.model.Team;
import com.example.hockeyrostermanagementbackend.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("team")
@AllArgsConstructor
@RestController

public class TeamController {

    @Autowired
    private TeamService teamService;

    // Return all teams
    @GetMapping
    public Flux<Team> findAll() {
        System.out.println("All the team information");
        return teamService.getAll();
    }

    // Return a single team by id
    @GetMapping("{id}")
    public Mono<Team> getById(@PathVariable final Long id) {
        System.out.println("One team information based for the given ID");
        return teamService.getById(id.intValue());
    }

    // Update a team
    @PutMapping("{id}")
    public Mono updateById(@PathVariable final Long id, @RequestBody final Team team) {
        System.out.println("Updating a team Info");
        return teamService.save(team);
    }

    // Create a team
    @PostMapping
    public Mono save(@RequestBody final Team team) {
        System.out.println("Added team Info");
        return teamService.save(team);
    }

    // Delete a team
    @DeleteMapping("{id}")
    public Mono delete(@PathVariable final Long id) {
        System.out.println("A team Info deleted");
        return teamService.delete(id.intValue());
    }
}
