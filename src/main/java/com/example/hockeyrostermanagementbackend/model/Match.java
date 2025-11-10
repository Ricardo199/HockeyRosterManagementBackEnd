package com.example.hockeyrostermanagementbackend.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Match model representing a hockey game between two teams.
 * Tracks game details including teams, scores, date, and venue.
 */
@Data           // Generates getters, setters, equals, hashCode, and toString
@Builder        // Provides builder pattern for flexible object construction
@AllArgsConstructor  // Constructor with all fields as parameters
@ToString       // Generates readable string representation of match data

public class Match {
    private String id;              // Unique identifier for the match
    private String homeTeamId;      // Foreign key to the home team
    private String awayTeamId;      // Foreign key to the away/visiting team
    private String matchDate;       // Date and time when the match is/was played
    private String venue;           // Location/arena where the match takes place
    private int homeTeamScore;      // Final score for the home team
    private int awayTeamScore;      // Final score for the away team
}
