package com.alpergayretoglu.online_student_election.service;

import com.alpergayretoglu.online_student_election.exception.EntityNotFoundException;
import com.alpergayretoglu.online_student_election.model.entity.User;
import com.alpergayretoglu.online_student_election.model.request.user.UserUpdateRequest;
import com.alpergayretoglu.online_student_election.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(String id) {
        return getUserWithException(id);
    }

    public User updateUser(String id, UserUpdateRequest request) {
        User oldUser = getUserWithException(id);

        oldUser.setName(request.getName());
        oldUser.setSurname(request.getSurname());
        oldUser.setEmail(request.getEmail());
        oldUser.setPassword(request.getPassword());

        return userRepository.save(oldUser);
    }

    public void deleteUser(String userId) {
        User user = getUserWithException(userId);
        userRepository.delete(user);
    }

    private User getUserWithException(String id) {
        return userRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException();
        });
    }

}