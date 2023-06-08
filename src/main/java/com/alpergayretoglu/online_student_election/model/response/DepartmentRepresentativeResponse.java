package com.alpergayretoglu.online_student_election.model.response;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class DepartmentRepresentativeResponse {
    private String departmentName;
    private String representativeNameSurname;
    private String faculty;
}
