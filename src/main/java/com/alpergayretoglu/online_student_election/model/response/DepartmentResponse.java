package com.alpergayretoglu.online_student_election.model.response;

import com.alpergayretoglu.online_student_election.model.entity.Department;
import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class DepartmentResponse {
    private String name;

    public static DepartmentResponse fromEntity(Department department) {
        return DepartmentResponse.builder()
                .name(department.getName())
                .build();
    }
}
