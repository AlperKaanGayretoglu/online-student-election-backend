package com.alpergayretoglu.online_student_election.model.response;

import com.alpergayretoglu.online_student_election.model.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String token;
    private UserRole role;

    private String id;
    private String name;
    private String surname;
}