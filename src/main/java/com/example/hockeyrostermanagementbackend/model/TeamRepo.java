package com.example.hockeyrostermanagementbackend.model;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepo extends CrudRepository<Team,Integer> {
}
