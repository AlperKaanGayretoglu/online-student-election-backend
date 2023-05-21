package com.alpergayretoglu.online_student_election.controller;

import com.alpergayretoglu.online_student_election.model.request.LoginRequest;
import com.alpergayretoglu.online_student_election.model.response.AuthenticationResponse;
import com.alpergayretoglu.online_student_election.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@CrossOrigin
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public AuthenticationResponse login(@Valid @RequestBody LoginRequest request) {
        return authenticationService.login(request);
    }

}