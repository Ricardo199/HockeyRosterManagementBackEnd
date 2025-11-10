package com.example.hockeyrostermanagementbackend.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * MatchRepo handles database operations for Match entities.
 * Extends CrudRepository to inherit pre-built methods for save, find, delete operations.
 * Spring Data JPA auto-generates the implementation at runtime.
 * The Long type parameter specifies the Match entity's ID type.
 */
@Repository
public interface MatchRepo extends CrudRepository<Match,Long> {
}

