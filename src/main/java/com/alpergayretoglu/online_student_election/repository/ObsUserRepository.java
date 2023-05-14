package com.alpergayretoglu.online_student_election.repository;

import com.alpergayretoglu.online_student_election.model.entity.ObsUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ObsUserRepository extends JpaRepository<ObsUser, String> {

    public Optional<ObsUser> findByEmail(String email);

    public boolean existsByEmail(String email); // TODO: Check if this works !!!

}