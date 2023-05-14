package com.alpergayretoglu.online_student_election.service;

import com.alpergayretoglu.online_student_election.exception.EntityNotFoundException;
import com.alpergayretoglu.online_student_election.model.entity.ObsUser;
import com.alpergayretoglu.online_student_election.repository.ObsUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ObsUserService {

    private final ObsUserRepository ObsUserRepository;

    public List<ObsUser> getObsUsers() {
        return ObsUserRepository.findAll();
    }

    public ObsUser getObsUser(String id) {
        return getObsUserWithException(id);
    }

    public ObsUser getObsUserByEmail(String email) {
        return ObsUserRepository.findByEmail(email).orElseThrow(() -> {
            throw new EntityNotFoundException();
        });
    }

    private ObsUser getObsUserWithException(String id) {
        return ObsUserRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException();
        });
    }

}