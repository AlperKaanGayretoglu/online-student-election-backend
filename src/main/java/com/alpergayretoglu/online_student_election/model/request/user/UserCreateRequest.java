package com.alpergayretoglu.online_student_election.model.request.user;

import com.alpergayretoglu.online_student_election.constants.ApplicationConstants;
import com.alpergayretoglu.online_student_election.model.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserCreateRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = ApplicationConstants.PASSWORD_MIN_LENGTH, max = ApplicationConstants.PASSWORD_MAX_LENGTH)
    private String password;

    public static User toEntity(UserCreateRequest request) {
        return User.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }
}