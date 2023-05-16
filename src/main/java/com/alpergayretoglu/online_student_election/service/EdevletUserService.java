package com.alpergayretoglu.online_student_election.service;

import com.alpergayretoglu.online_student_election.exception.EntityNotFoundException;
import com.alpergayretoglu.online_student_election.model.entity.EdevletUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EdevletUserService {

    private final com.alpergayretoglu.online_student_election.repository.EdevletUserRepository EdevletUserRepository;

    public List<EdevletUser> getEdevletUsers() {
        return EdevletUserRepository.findAll();
    }

    public EdevletUser getEdevletUser(String id) {
        return getEdevletUserWithException(id);
    }

    public EdevletUser getEdevletUserByTcNo(String tcNo) {
        return EdevletUserRepository.findByTcNo(tcNo).orElseThrow(() -> {
            throw new EntityNotFoundException();
        });
    }

    private EdevletUser getEdevletUserWithException(String id) {
        return EdevletUserRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException();
        });
    }

}