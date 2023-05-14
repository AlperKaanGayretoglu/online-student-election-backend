package com.alpergayretoglu.online_student_election.repository;

import com.alpergayretoglu.online_student_election.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    public Optional<User> findByEmail(String email);

    public Optional<User> findByVerificationCode(String verificationCode);

    public Optional<User> findByRecoveryCode(String recoveryCode);

    public boolean existsByEmail(String email); // TODO: Check if this works !!!

}
