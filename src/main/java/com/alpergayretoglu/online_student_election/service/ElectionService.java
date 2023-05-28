package com.alpergayretoglu.online_student_election.service;

import com.alpergayretoglu.online_student_election.constants.ApplicationMessages;
import com.alpergayretoglu.online_student_election.exception.EntityNotFoundException;
import com.alpergayretoglu.online_student_election.model.entity.Department;
import com.alpergayretoglu.online_student_election.model.entity.Election;
import com.alpergayretoglu.online_student_election.model.entity.User;
import com.alpergayretoglu.online_student_election.model.entity.Vote;
import com.alpergayretoglu.online_student_election.model.enums.Term;
import com.alpergayretoglu.online_student_election.model.enums.UserRole;
import com.alpergayretoglu.online_student_election.model.request.ElectionCreateRequest;
import com.alpergayretoglu.online_student_election.model.request.ElectionUpdateRequest;
import com.alpergayretoglu.online_student_election.model.request.VoteCastingRequest;
import com.alpergayretoglu.online_student_election.repository.DepartmentRepository;
import com.alpergayretoglu.online_student_election.repository.ElectionRepository;
import com.alpergayretoglu.online_student_election.repository.UserRepository;
import com.alpergayretoglu.online_student_election.repository.VoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ElectionService {

    private final ElectionRepository electionRepository;
    private final DepartmentRepository departmentRepository;
    private final UserRepository userRepository;
    private final VoteRepository voteRepository;

    public Election addElection(ElectionCreateRequest request) {
        assertElectionCreateRequestIsValid(request);
        return electionRepository.save(ElectionCreateRequest.toEntity(request, departmentRepository));
    }

    public List<Election> listElections() {
        return electionRepository.findAll();
    }

    public Election getElection(String id) {
        return getElectionWithException(id);
    }

    public Election updateElection(String id, ElectionUpdateRequest request) {
        assertElectionUpdateRequestIsValid(request);

        Election oldElection = getElectionWithException(id);

        if (oldElection.getIsFinished()) {
            throw new RuntimeException(ApplicationMessages.ELECTION_CREATE_FAIL_ELECTION_FINISHED);
        }

        return electionRepository.save(ElectionUpdateRequest.updateEntityUsingRequest(oldElection, request));
    }

    public void deleteElection(String electionId) {
        Election election = getElectionWithException(electionId);
        electionRepository.delete(election);
    }

    public List<Election> getAllElectionsForCurrentTerm() {
        return electionRepository.findAllByTermAndYear(Term.getCurrentTerm(), LocalDate.now().getYear());
    }

    public String endElection(String electionId) {
        Election election = getElectionWithException(electionId);

        if (election.getIsFinished()) {
            return ApplicationMessages.ELECTION_END_FAIL_ELECTION_ALREADY_FINISHED;
        }

        election.getCandidates().forEach(candidate -> {
            candidate.setRole(UserRole.VOTER);
        });

        User winner = election.decideWinner();
        if (winner == null) {
            throw new RuntimeException(ApplicationMessages.ELECTION_END_FAIL_WINNER_CANNOT_BE_DECIDED);
        }
        winner.setRole(UserRole.REPRESENTATIVE);

        election.setWinner(winner);
        election.setIsFinished(true);
        electionRepository.save(election);

        Department department = election.getDepartment();
        department.setRepresentative(winner);
        departmentRepository.save(department);

        return ApplicationMessages.ELECTION_END_SUCCESS;
    }

    public String castVote(String voterId, VoteCastingRequest voteCastingRequest) {
        User voter = userRepository.findById(voterId).orElseThrow(() -> {
            throw new EntityNotFoundException();
        });

        Election election = getElectionWithException(voteCastingRequest.getElectionId());

        if (election.getIsFinished()) {
            return ApplicationMessages.VOTE_SUBMIT_FAIL_ELECTION_FINISHED;
        }

        if (election.getStartDate().isAfter(LocalDateTime.now())) {
            return ApplicationMessages.VOTE_SUBMIT_FAIL_ELECTION_NOT_STARTED;
        }

        if (election.getEndDate().isBefore(LocalDateTime.now())) {
            return ApplicationMessages.VOTE_SUBMIT_FAIL_ELECTION_FINISHED;
        }

        User candidate = election.getCandidates().stream()
                .filter(cand -> cand.getId().equals(voteCastingRequest.getCandidateId()))
                .findFirst().orElse(null);

        if (election.getVotes().stream().anyMatch(vote -> vote.getVoter().getId().equals(voter.getId()))) {
            return ApplicationMessages.VOTE_SUBMIT_FAIL_ALREADY_VOTED;
        }

        if (candidate == null) {
            return ApplicationMessages.VOTE_SUBMIT_FAIL_INVALID_CANDIDATE;
        }

        Vote vote = Vote.builder()
                .voter(voter)
                .forCandidate(candidate)
                .forElection(election)
                .dateTime(LocalDateTime.now())
                .build();
        voteRepository.save(vote);

        election.addVote(vote);
        electionRepository.save(election);

        return ApplicationMessages.VOTE_SUBMIT_SUCCESS;
    }

    private Election getElectionWithException(String id) {
        return electionRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("Election not found with id: " + id);
        });
    }

    private void assertElectionCreateRequestIsValid(ElectionCreateRequest request) {
        assertDateIsValid(request.getStartDate(), request.getEndDate());

        Department department = departmentRepository.findByName(request.getDepartmentName()).orElseThrow(() -> {
            throw new RuntimeException(ApplicationMessages.ELECTION_CREATE_FAIL_DEPARTMENT_NOT_FOUND);
        });

        int year = request.getStartDate().getYear();

        Term term = Term.getTermOfDate(request.getStartDate());

        Election election = electionRepository.findByDepartmentAndTermAndYear(department, term, year).orElse(null);
        if (election != null && !election.getIsFinished()) {
            throw new RuntimeException(ApplicationMessages.ELECTION_CREATE_FAIL_ELECTION_ALREADY_EXISTS);
        }
    }

    private void assertElectionUpdateRequestIsValid(ElectionUpdateRequest request) {
        assertDateIsValid(request.getStartDate(), request.getEndDate());
    }

    private void assertDateIsValid(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate.isAfter(endDate)) {
            throw new RuntimeException(ApplicationMessages.ELECTION_CREATE_FAIL_START_DATE_AFTER_END_DATE);
        }

        if (startDate.isBefore(LocalDateTime.now())) {
            throw new RuntimeException(ApplicationMessages.ELECTION_CREATE_FAIL_START_DATE_BEFORE_CURRENT_DATE);
        }

        Term term = Term.getTermOfDate(startDate);
        if (term == null) {
            throw new RuntimeException(ApplicationMessages.ELECTION_CREATE_FAIL_DATE_OUT_OF_RANGE);
        }
    }

    public List<Election> getAllUpcomingElections() {
        return electionRepository.findAllByStartDateAfter(LocalDateTime.now());
    }
}