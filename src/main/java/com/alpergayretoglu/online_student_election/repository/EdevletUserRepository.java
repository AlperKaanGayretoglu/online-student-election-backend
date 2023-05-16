package com.alpergayretoglu.online_student_election.repository;

import com.alpergayretoglu.online_student_election.model.entity.EdevletUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EdevletUserRepository extends JpaRepository<EdevletUser, String> {

    public Optional<EdevletUser> findByTcNo(String tcNo);

    public boolean existsByTcNo(String tcNo); // TODO: Check if this works !!!

}