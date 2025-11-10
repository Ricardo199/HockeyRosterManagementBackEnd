package com.example.hockeyrostermanagementbackend.model;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * TeamRepo provides database access layer for Team entities.
 * Spring Data JPA automatically implements standard CRUD methods.
 * The Integer type parameter is the Team's ID type.
 */
@Repository
public interface TeamRepo extends CrudRepository<Team,Integer> {
}
