/*
 * Student Name: Ricardo Burgos
 * Student ID: 301463628
 * Date: November 11, 2025
 * Assignment 3 - COMP303
 */
package com.example.hockeyrostermanagementbackend.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Match entity representing a hockey game between two teams.
 *
 * @author Ricardo Burgos
 * @version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Match {
    private Long id;
    private Long homeTeamId;
    private Long awayTeamId;
    private String matchDate;
    private String venue;
    private int homeTeamScore;
    private int awayTeamScore;
}
