/*
 * Student Name: Ricardo Burgos
 * Student ID: 301463628
 * Date: November 11, 2025
 * Assignment 3 - COMP303
 */
package com.example.hockeyrostermanagementbackend.model;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * In-memory repository for Match entities.
 *
 * @author Ricardo Burgos
 * @version 1.0
 */
@Repository
public class MatchRepo {

    final Map<Long, Match> matchDatabase = new ConcurrentHashMap<>();

    final AtomicLong nextId = new AtomicLong(1);

    public Match save(Match match){
        if (match.getId() == null) {
            match.setId(nextId.getAndIncrement());
        }
        matchDatabase.put(match.getId(), match);
        return match;
    }

    public Iterable<? extends Match> findAll(){
        return matchDatabase.values();
    }

    public Match findById(Long aLong){
        return matchDatabase.get(aLong);
    }

    public void deleteById(Long aLong){
        matchDatabase.remove(aLong);
    }
}

