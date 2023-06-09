package com.alpergayretoglu.online_student_election.repository;

import com.alpergayretoglu.online_student_election.model.entity.Department;
import com.alpergayretoglu.online_student_election.model.entity.Election;
import com.alpergayretoglu.online_student_election.model.enums.Term;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ElectionRepository extends JpaRepository<Election, String> {
    public Optional<Election> findByName(String name);

    public boolean existsByName(String name);

    public List<Election> findAllByDepartmentAndTermAndYear(Department department, Term term, int year);

    public boolean existsByDepartmentAndTermAndYear(Department department, Term term, int year);

    public List<Election> findAllByTermAndYear(Term term, int year);

    public List<Election> findAllByStartDateAfter(LocalDateTime startDate);

    public List<Election> findAllByIsFinished(boolean isFinished);

    public List<Election> findAllByStartDateBeforeAndEndDateAfterAndIsFinished(LocalDateTime startDate, LocalDateTime endDate, boolean isFinished);
}