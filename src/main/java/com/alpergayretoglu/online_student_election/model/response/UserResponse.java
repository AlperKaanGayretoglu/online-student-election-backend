package com.alpergayretoglu.online_student_election.model.response;

import com.alpergayretoglu.online_student_election.model.entity.Department;
import com.alpergayretoglu.online_student_election.model.entity.User;
import com.alpergayretoglu.online_student_election.model.enums.CandidateType;
import com.alpergayretoglu.online_student_election.model.enums.RepresentativeType;
import com.alpergayretoglu.online_student_election.model.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    private String studentNo;
    private Double gpa;
    private Department department;
    private CandidateType candidateType;
    private RepresentativeType representativeType;
    private LocalDate representativeStartDate;
    private LocalDate representativeEndDate;

    public static UserResponse fromEntity(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .role(user.getRole())
                .studentNo(user.getStudentNo())
                .gpa(user.getGpa())
                .department(user.getDepartment())
                .candidateType(user.getCandidateType())
                .representativeType(user.getRepresentativeType())
                .representativeStartDate(user.getRepresentativeStartDate())
                .representativeEndDate(user.getRepresentativeEndDate())
                .build();
    }
}