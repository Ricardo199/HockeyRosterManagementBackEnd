/*
 * Student Name: Ricardo Burgos
 * Student ID: 301463628
 * Date: November 11, 2025
 * Assignment 3 - COMP303
 */
package com.example.hockeyrostermanagementbackend.model;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * In-memory repository for Team entities.
 *
 * @author Ricardo Burgos
 * @version 1.0
 */
@Repository
public class TeamRepo{

    final Map<Long, Team> teamDatabase = new ConcurrentHashMap<>();
    final AtomicLong nextId = new AtomicLong(1);

    public Collection<Team> findAll(){
        return teamDatabase.values();
    }

    public Team findById(Long id){
        return teamDatabase.get(id);
    }

    public Team save(Team team){
        if (team.getId() == null) {
            team.setId(nextId.getAndIncrement());
        }
        teamDatabase.put(team.getId(), team);
        return team;
    }

    public void deleteById(Long id){
        teamDatabase.remove(id);
    }

    /**
     * INNOVATION: Search teams by name (case-insensitive partial match).
     */
    public Collection<Team> findByNameContaining(String name){
        return teamDatabase.values().stream()
                .filter(team -> team.getName() != null &&
                        team.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
