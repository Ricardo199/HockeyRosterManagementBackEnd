package com.example.hockeyrostermanagementbackend.model;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TeamRepo provides database access layer for Team entities.
 * Spring Data JPA automatically implements standard CRUD methods.
 * The Integer type parameter is the Team's ID type.
 */
@Repository
public interface TeamRepo extends CrudRepository<Team,Integer> {

    Map<Integer, Team> teamStorage = new ConcurrentHashMap<>();

    @Override
    default <S extends Team> S save(S entity) {
        teamStorage.put(Integer.valueOf(entity.getId()), entity);
        return entity;
    }

    @Override
    default <S extends Team> Iterable<S> saveAll(Iterable<S> entities) {
        for (S entity : entities) {
            teamStorage.put(Integer.valueOf(entity.getId()), entity);
        }
        return entities;
    }

    @Override
    default java.util.Optional<Team> findById(Integer id) {
        return Optional.ofNullable(teamStorage.get(id));
    }

    @Override
    default boolean existsById(Integer id) {
        return teamStorage.containsKey(id);
    }

    @Override
    default Iterable<Team> findAll(){
        return new ArrayList<>(teamStorage.values());
    }

    @Override
    default Iterable<Team> findAllById(Iterable<Integer> ids) {
        ArrayList<Team> teams = new ArrayList<>();
        for (Integer id : ids) {
            Team team = teamStorage.get(id);
            if (team != null) {
                teams.add(team);
            }
        }
        return teams;
    }

    @Override
    default long count() {
        return teamStorage.size();
    }

    @Override
    default void deleteById(Integer id) {
        teamStorage.remove(id);
    }

    @Override
    default void delete(Team entity) {
       teamStorage.remove(entity.getId());
    }

    @Override
    default void deleteAll(Iterable<? extends Team> entities) {
        for (Team entity : entities) {
            if (entity != null && entity.getId() != null) {
                teamStorage.remove(entity.getId());
            }
        }
    }

    @Override
    default void deleteAll() {
        teamStorage.clear();
    }
}
