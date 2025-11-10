package com.example.hockeyrostermanagementbackend.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Player model representing a hockey player entity.
 * Uses Lombok annotations to auto-generate boilerplate code (getters, setters, toString, etc.).
 */
@Data           // Generates getters, setters, equals, hashCode, and toString
@Builder        // Implements the Builder pattern for object construction
@AllArgsConstructor  // Generates constructor with all fields as parameters
@ToString       // Generates toString method

public class Player {
    private String id;          // Unique identifier for the player
    private String fname;       // Player's first name
    private String lname;       // Player's last name
    private String position;    // Player's position (e.g., Forward, Defense, Goalie)
    private int number;         // Player's jersey number
    private int age;            // Player's age
    private String teamId;      // Foreign key reference to the team
}
