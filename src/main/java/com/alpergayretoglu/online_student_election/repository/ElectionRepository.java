package com.alpergayretoglu.online_student_election.repository;

import com.alpergayretoglu.online_student_election.model.entity.Election;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ElectionRepository extends JpaRepository<Election, String> {
    public Optional<Election> findByName(String name);

    public boolean existsByName(String name); // TODO: Check if this works !!!
}