package com.alpergayretoglu.online_student_election.service;

import com.alpergayretoglu.online_student_election.constants.ApplicationMessages;
import com.alpergayretoglu.online_student_election.exception.EntityNotFoundException;
import com.alpergayretoglu.online_student_election.model.entity.*;
import com.alpergayretoglu.online_student_election.model.enums.Term;
import com.alpergayretoglu.online_student_election.model.enums.UserRole;
import com.alpergayretoglu.online_student_election.model.request.ElectionCreateRequest;
import com.alpergayretoglu.online_student_election.model.request.ElectionUpdateRequest;
import com.alpergayretoglu.online_student_election.model.request.VoteCastingRequest;
import com.alpergayretoglu.online_student_election.model.response.MessageResponse;
import com.alpergayretoglu.online_student_election.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ElectionService {

    private final ElectionRepository electionRepository;
    private final DepartmentRepository departmentRepository;
    private final AnnouncementRepository announcementRepository;
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

    public List<Election> getAllElectionsForCurrentTerm() { // TODO: REMOVE THIS METHOD
        return electionRepository.findAllByTermAndYear(Term.getCurrentTerm(), LocalDate.now().getYear());
    }

    public List<User> getCandidates(String electionId) {
        Election election = getElectionWithException(electionId);
        return new ArrayList<>(election.getCandidates());
    }

    public MessageResponse endElection(String electionId) {
        Election election = getElectionWithException(electionId);

        if (election.getIsFinished()) {
            return new MessageResponse(ApplicationMessages.ELECTION_END_FAIL_ELECTION_ALREADY_FINISHED, false);
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

        Announcement announcement = Announcement.builder()
                .title("The " + election.getName() + " election has ended.")
                .content("The winner is " + winner.getName() + " " + winner.getSurname() + ".")
                .date(LocalDateTime.now())
                .build();
        announcementRepository.save(announcement);

        return new MessageResponse(ApplicationMessages.ELECTION_END_SUCCESS, true);
    }

    public MessageResponse castVote(String voterId, VoteCastingRequest voteCastingRequest) {
        User voter = userRepository.findById(voterId).orElseThrow(() -> {
            throw new EntityNotFoundException();
        });

        Election election = getElectionWithException(voteCastingRequest.getElectionId());

        if (election.getIsFinished()) {
            return new MessageResponse(ApplicationMessages.VOTE_SUBMIT_FAIL_ELECTION_FINISHED, false);
        }

        if (election.getStartDate().isAfter(LocalDateTime.now())) {
            return new MessageResponse(ApplicationMessages.VOTE_SUBMIT_FAIL_ELECTION_NOT_STARTED, false);
        }

        if (election.getEndDate().isBefore(LocalDateTime.now())) {
            return new MessageResponse(ApplicationMessages.VOTE_SUBMIT_FAIL_ELECTION_FINISHED, false);
        }

        User candidate = election.getCandidates().stream()
                .filter(cand -> cand.getId().equals(voteCastingRequest.getCandidateId()))
                .findFirst().orElse(null);

        if (election.getVotes().stream().anyMatch(vote -> vote.getVoter().getId().equals(voter.getId()))) {
            return new MessageResponse(ApplicationMessages.VOTE_SUBMIT_FAIL_ALREADY_VOTED, false);
        }

        if (candidate == null) {
            return new MessageResponse(ApplicationMessages.VOTE_SUBMIT_FAIL_INVALID_CANDIDATE, false);
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

        return new MessageResponse(ApplicationMessages.VOTE_SUBMIT_SUCCESS, true);
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

        Term term = Term.getTermOfDate(request.getStartDate());
        int year = term.decideYear(request.getStartDate());

        List<Election> elections = electionRepository.findAllByDepartmentAndTermAndYear(department, term, year);
        if (!elections.isEmpty() && elections.stream().anyMatch(election -> !election.getIsFinished())) {
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

    public List<Election> getAllFinishedElections() {
        List<Election> elections = electionRepository.findAllByIsFinished(true);
        elections.sort((o1, o2) -> o2.getEndDate().compareTo(o1.getEndDate()));
        return elections;
    }

    public List<Election> getAllOngoingElections() {
        return electionRepository.findAllByStartDateBeforeAndEndDateAfterAndIsFinished(LocalDateTime.now(), LocalDateTime.now(), false);
    }
}