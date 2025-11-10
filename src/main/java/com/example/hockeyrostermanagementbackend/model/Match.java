package com.example.hockeyrostermanagementbackend.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@ToString

public class Match {
    private String id;
    private String homeTeamId;
    private String awayTeamId;
    private String matchDate;
    private String venue;
    private int homeTeamScore;
    private int awayTeamScore;
}
