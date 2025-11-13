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
 * In-memory repository for Player entities.
 *
 * @author Ricardo Burgos
 * @version 1.0
 */
@Repository
public class PlayerRepo{

    final Map<Long, Player> playerDatabase = new ConcurrentHashMap<>();
    final AtomicLong nextId = new AtomicLong(1);

    public Iterable<? extends Player> findAll(){
        return playerDatabase.values();
    }

    public Player findById(Long aLong){
        return playerDatabase.get(aLong);
    }

    public Player save(Player player){
        if (player.getId() == null) {
            player.setId(nextId.getAndIncrement());
        }
        playerDatabase.put(player.getId(), player);
        return player;
    }

    public void deleteById(Long aLong){
        playerDatabase.remove(aLong);
    }

    /**
     * INNOVATION: Find all players by team ID.
     */
    public Collection<Player> findByTeamId(Long teamId){
        return playerDatabase.values().stream()
                .filter(player -> teamId.equals(player.getTeamId()))
                .collect(Collectors.toList());
    }
}
