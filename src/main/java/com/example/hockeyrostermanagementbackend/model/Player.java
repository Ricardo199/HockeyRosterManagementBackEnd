package com.example.hockeyrostermanagementbackend.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@ToString

public class Player {
    private String id;
    private String fname;
    private String lname;
    private String position;
    private int number;
    private int age;
    private String teamId;
}
