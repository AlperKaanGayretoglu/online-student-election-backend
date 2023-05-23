package com.alpergayretoglu.online_student_election.model.request;

import com.alpergayretoglu.online_student_election.constants.ApplicationConstants;
import com.alpergayretoglu.online_student_election.model.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Builder
@Getter
@Setter
public class UserUpdateRequest {

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

    public static User toEntity(UserUpdateRequest request) {
        return User.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }
}