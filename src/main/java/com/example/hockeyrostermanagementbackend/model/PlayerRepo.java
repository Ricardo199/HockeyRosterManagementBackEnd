package com.example.hockeyrostermanagementbackend.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * PlayerRepo provides CRUD (Create, Read, Update, Delete) operations for Player entities.
 * By extending CrudRepository, Spring Data JPA auto-generates implementation methods like:
 * - save(), findById(), findAll(), deleteById(), etc.
 * The Long type parameter represents the Player's ID type.
 */
@Repository
public interface PlayerRepo extends CrudRepository<Player,Long> {
}
