package com.alpergayretoglu.online_student_election.service;

import com.alpergayretoglu.online_student_election.constants.ApplicationMessages;
import com.alpergayretoglu.online_student_election.model.entity.ObsUser;
import com.alpergayretoglu.online_student_election.model.entity.User;
import com.alpergayretoglu.online_student_election.model.enums.UserRole;
import com.alpergayretoglu.online_student_election.model.request.LoginRequest;
import com.alpergayretoglu.online_student_election.model.response.AuthenticationResponse;
import com.alpergayretoglu.online_student_election.repository.ObsUserRepository;
import com.alpergayretoglu.online_student_election.repository.UserRepository;
import com.alpergayretoglu.online_student_election.security.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {
    private final UserRepository userRepository; // TODO: make this userService
    private final ObsUserRepository obsUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthenticationResponse login(LoginRequest request) {
        if (!userRepository.existsByEmail(request.getEmail())) {
            return register(request);
        }

        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> {
            // invalid email
            throw new RuntimeException(ApplicationMessages.LOGIN_FAIL_INCORRECT_FIELDS); // TODO: specific exception
        });

        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            String token = jwtService.createToken(user.getId());
            return new AuthenticationResponse(token, user.getId(), user.getName(), user.getSurname());
        }
        // invalid password
        throw new RuntimeException(ApplicationMessages.LOGIN_FAIL_INCORRECT_FIELDS); // TODO specific exception
    }

    private AuthenticationResponse register(LoginRequest request) {
        ObsUser obsUser = obsUserRepository.findByEmail(request.getEmail()).orElseThrow(() -> {
            // invalid email
            throw new RuntimeException(ApplicationMessages.LOGIN_FAIL_INCORRECT_FIELDS); // TODO: specific exception
        });

        User user = User.builder()
                .name(obsUser.getName())
                .surname(obsUser.getSurname())
                .email(obsUser.getEmail())
                .password(passwordEncoder.encode(obsUser.getPassword())) // hash password
                .role(UserRole.VOTER)
                .build();

        User response = userRepository.save(user);
        String jwtToken = jwtService.createToken(response.getId());
        return new AuthenticationResponse(jwtToken, response.getId(), response.getName(), response.getSurname());
    }

}
