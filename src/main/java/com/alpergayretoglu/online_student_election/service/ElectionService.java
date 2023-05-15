package com.alpergayretoglu.online_student_election.service;

import com.alpergayretoglu.online_student_election.constants.ApplicationMessages;
import com.alpergayretoglu.online_student_election.exception.EntityNotFoundException;
import com.alpergayretoglu.online_student_election.model.entity.Election;
import com.alpergayretoglu.online_student_election.model.request.ElectionCreateRequest;
import com.alpergayretoglu.online_student_election.model.request.ElectionUpdateRequest;
import com.alpergayretoglu.online_student_election.repository.ElectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ElectionService {

    private final ElectionRepository electionRepository;

    public Election addElection(ElectionCreateRequest request) {
        if (electionRepository.existsByName(request.getName())) {
            throw new RuntimeException(ApplicationMessages.ELECTION_CREATE_FAIL_NAME_ALREADY_EXISTS); // TODO make specific exception
        }

        return electionRepository.save(ElectionCreateRequest.toEntity(request));
    }

    public List<Election> getElections() {
        return electionRepository.findAll();
    }

    public Election getElection(String id) {
        return getElectionWithException(id);
    }

    public Election updateElection(String id, ElectionUpdateRequest request) {
        Election oldElection = getElectionWithException(id);

        if (oldElection.getIsFinished()) {
            throw new RuntimeException(ApplicationMessages.ELECTION_CREATE_FAIL_ELECTION_FINISHED); // TODO make specific exception
        }

        oldElection.setName(request.getName());
        oldElection.setType(request.getType());
        oldElection.setStartDate(request.getStartDate());
        oldElection.setEndDate(request.getEndDate());

        return electionRepository.save(oldElection);
    }

    public void deleteElection(String electionId) {
        Election election = getElectionWithException(electionId);
        electionRepository.delete(election);
    }

    private Election getElectionWithException(String id) {
        return electionRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException();
        });
    }

}