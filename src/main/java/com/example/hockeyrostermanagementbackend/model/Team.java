package com.example.hockeyrostermanagementbackend.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Team model representing a hockey team entity.
 * Lombok annotations reduce boilerplate code for getters, setters, constructors, etc.
 */
@Data           // Auto-generates getters, setters, equals, hashCode, and toString
@Builder        // Enables fluent builder pattern for creating Team objects
@AllArgsConstructor  // Creates constructor accepting all fields
@ToString       // Generates human-readable string representation

public class Team {
    private String id;          // Unique identifier for the team
    private String name;        // Team name (e.g., "Maple Leafs")
    private String city;        // City where the team is based
    private String founded;     // Year or date the team was founded
    private String coach;       // Name of the team's head coach
}