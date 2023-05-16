package com.alpergayretoglu.online_student_election.model.response;

import com.alpergayretoglu.online_student_election.model.entity.User;
import com.alpergayretoglu.online_student_election.model.enums.UserRole;
import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class UserResponse {
    private String id;
    private String name;
    private String surname;
    private String email;
    private UserRole role;
    private String studentNo;
    private Double gpa;
    private String departmentName;

    public static UserResponse fromEntity(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .role(user.getRole())
                .studentNo(user.getStudentNo())
                .gpa(user.getGpa())
                .departmentName(user.getDepartment().getName())
                .build();
    }
}