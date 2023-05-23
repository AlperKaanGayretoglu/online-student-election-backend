package com.alpergayretoglu.online_student_election.controller;

import com.alpergayretoglu.online_student_election.model.response.UserResponse;
import com.alpergayretoglu.online_student_election.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@CrossOrigin
public class UserController {

    private UserService userService;

    @GetMapping
    public List<UserResponse> listUsers() {
        return userService.getUsers().stream().map(UserResponse::fromEntity).collect(Collectors.toList());
    }

    @GetMapping("{userId}")
    public UserResponse getUser(@PathVariable String userId) {
        return UserResponse.fromEntity(userService.getUser(userId));
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }

    @PostMapping("{userId}/apply-for-candidacy")
    public String applyForCandidacy(@PathVariable String userId) {
        return userService.applyForCandidacy(userId);
    }

    @GetMapping("{userId}/checkout-application-status")
    public String getApplicationStatus(@PathVariable String userId) {
        return userService.getApplicationStatus(userId);
    }

    @PutMapping("{userId}/withdraw-from-candidacy")
    public String withdrawFromCandidacy(@PathVariable String userId) {
        return userService.withdrawFromCandidacy(userId);
    }

}
