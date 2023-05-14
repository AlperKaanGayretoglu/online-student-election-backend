package com.alpergayretoglu.online_student_election.controller;

import com.alpergayretoglu.online_student_election.model.request.user.UserUpdateRequest;
import com.alpergayretoglu.online_student_election.model.response.UserResponse;
import com.alpergayretoglu.online_student_election.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping
    public List<UserResponse> listUsers() {
        return userService.getUsers().stream().map(UserResponse::fromEntity).toList();
    }

    @GetMapping("{userId}")
    public UserResponse getUser(@PathVariable String userId) {
        return UserResponse.fromEntity(userService.getUser(userId));
    }

    @PutMapping("{userId}")
    public UserResponse updateUser(@PathVariable String userId, @Valid @RequestBody UserUpdateRequest request) {
        return UserResponse.fromEntity(userService.updateUser(userId, request));
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }


    // ADMIN or SELF authorization testing route, TODO: SELF DOESN'T WORK!!! (problem with SelfFilter!!!)
    @GetMapping("/admin-or-self-test/{userId}")
    public UserResponse adminOrSelfResource(@PathVariable String userId) {
        return UserResponse.fromEntity(userService.getUser(userId));
    }
}
