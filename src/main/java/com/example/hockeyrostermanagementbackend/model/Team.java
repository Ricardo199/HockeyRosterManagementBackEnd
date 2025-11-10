package com.example.hockeyrostermanagementbackend.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@ToString

public class Team {
    private String id;
    private String name;
    private String city;
    private String founded;
    private String coach;
}