package com.alpergayretoglu.online_student_election.service;

import com.alpergayretoglu.online_student_election.constants.ApplicationMessages;
import com.alpergayretoglu.online_student_election.exception.EntityNotFoundException;
import com.alpergayretoglu.online_student_election.model.entity.CandidacyApplication;
import com.alpergayretoglu.online_student_election.model.entity.EdevletUser;
import com.alpergayretoglu.online_student_election.model.entity.Election;
import com.alpergayretoglu.online_student_election.model.entity.User;
import com.alpergayretoglu.online_student_election.model.enums.UserRole;
import com.alpergayretoglu.online_student_election.model.response.MessageResponse;
import com.alpergayretoglu.online_student_election.repository.CandidacyApplicationRepository;
import com.alpergayretoglu.online_student_election.repository.ElectionRepository;
import com.alpergayretoglu.online_student_election.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final EdevletUserService edevletUserService;
    private final ElectionService electionService;
    private final ElectionRepository electionRepository;
    private final CandidacyApplicationRepository candidacyApplicationRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(String id) {
        return getUserWithException(id);
    }

    public void deleteUser(String userId) {
        User user = getUserWithException(userId);
        userRepository.delete(user);
    }

    public MessageResponse applyForCandidacy(String userId) {
        User user = getUserWithException(userId);

        Election election = electionService.getAllUpcomingElections().stream()
                .filter(elect -> elect.getDepartment().equals(user.getDepartment()))
                .findFirst().orElse(null);

        if (election == null) {
            throw new RuntimeException(ApplicationMessages.CANDIDATE_APPLICATION_SUBMIT_FAIL_NO_ELECTION);
        }

        if (user.getRole() == UserRole.CANDIDATE) {
            throw new RuntimeException(ApplicationMessages.CANDIDATE_APPLICATION_SUBMIT_FAIL_ALREADY_CANDIDATE);
        }

        List<CandidacyApplication> candidacyApplications = candidacyApplicationRepository.findAllByUser(user);
        if (candidacyApplications.stream().anyMatch(candidacyApplication -> candidacyApplication.getApplicationDate().plusDays(3).isAfter(LocalDateTime.now()))) {
            throw new RuntimeException(ApplicationMessages.CANDIDATE_APPLICATION_SUBMIT_FAIL_ALREADY_SUBMITTED);
        }

        EdevletUser edevletUser = edevletUserService.getEdevletUserByTcNo(user.getTcNo());

        CandidacyApplication candidacyApplication = CandidacyApplication.builder()
                .user(user)
                .election(election)
                .isAccepted(edevletUser.isEligible())
                .applicationDate(LocalDateTime.now())
                .build();
        candidacyApplicationRepository.save(candidacyApplication);

        if (!edevletUser.isEligible()) {
            return new MessageResponse(ApplicationMessages.CANDIDATE_APPLICATION_SUBMIT_SUCCESS, true);
        }

        user.setRole(UserRole.CANDIDATE);
        userRepository.save(user);

        election.addCandidate(user);
        electionRepository.save(election);
        return new MessageResponse(ApplicationMessages.CANDIDATE_APPLICATION_SUBMIT_SUCCESS, true);
    }

    private User getUserWithException(String id) {
        return userRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException();
        });
    }

    public MessageResponse getApplicationStatus(String userId) {
        User user = getUserWithException(userId);

        if (user.getRole() == UserRole.CANDIDATE) {
            return new MessageResponse(ApplicationMessages.CANDIDATE_APPLICATION_STATUS_ACCEPTED, true);
        }

        if (candidacyApplicationRepository.findAllByUser(user).stream().noneMatch(candidacyApplication -> candidacyApplication
                .getApplicationDate().plusDays(3).isAfter(LocalDateTime.now()))) {
            return new MessageResponse(ApplicationMessages.CANDIDATE_APPLICATION_STATUS_NOT_SUBMITTED, false);
        }

        return new MessageResponse(ApplicationMessages.CANDIDATE_APPLICATION_STATUS_REJECTED, false);
    }

    public MessageResponse withdrawFromCandidacy(String userId) {
        User user = getUserWithException(userId);

        if (user.getRole() != UserRole.CANDIDATE) {
            throw new EntityNotFoundException(ApplicationMessages.CANDIDATE_WITHDRAW_FAIL_NOT_CANDIDATE);
        }

        Election election = electionService.getAllUpcomingElections().stream()
                .filter(elect -> elect.getCandidates().stream().anyMatch(cand -> cand.getId().equals(user.getId())))
                .findFirst().orElse(null);

        if (election == null) {
            if (electionService.getAllOngoingElections().stream()
                    .anyMatch(elect -> elect.getCandidates().stream().anyMatch(cand -> cand.getId().equals(user.getId())))) {
                throw new EntityNotFoundException(ApplicationMessages.CANDIDATE_WITHDRAW_FAIL_ELECTION_STARTED);
            }
            throw new EntityNotFoundException("User is a candidate but no election found for him/her.");
        }

        if (election.getStartDate().isBefore(LocalDateTime.now())) {
            throw new EntityNotFoundException(ApplicationMessages.CANDIDATE_WITHDRAW_FAIL_ELECTION_STARTED);
        }

        user.setRole(UserRole.VOTER);
        userRepository.save(user);

        election.removeCandidate(user);
        electionRepository.save(election);

        return new MessageResponse(ApplicationMessages.CANDIDATE_WITHDRAW_SUCCESS, true);
    }
}