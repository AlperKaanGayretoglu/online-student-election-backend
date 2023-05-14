package com.alpergayretoglu.online_student_election.model.request.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 6, max = 32)
    private String password;

}