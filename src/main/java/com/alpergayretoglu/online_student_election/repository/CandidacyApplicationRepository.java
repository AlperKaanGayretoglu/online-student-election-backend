package com.alpergayretoglu.online_student_election.repository;

import com.alpergayretoglu.online_student_election.model.entity.CandidacyApplication;
import com.alpergayretoglu.online_student_election.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidacyApplicationRepository extends JpaRepository<CandidacyApplication, String> {
    public List<CandidacyApplication> findAllByUser(User user);
}