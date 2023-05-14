package com.alpergayretoglu.online_student_election.model.response;

import com.alpergayretoglu.online_student_election.model.entity.User;
import com.alpergayretoglu.online_student_election.model.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class UserResponse {

    private String id;
    private String name;
    private String surname;
    private String email;
    private UserRole role;
    private boolean verified;

    public static UserResponse fromEntity(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .role(user.getRole())
                .verified(user.isVerified())
                .build();
    }
}