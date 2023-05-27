package com.alpergayretoglu.online_student_election.model.request;


import com.alpergayretoglu.online_student_election.constants.ApplicationMessages;
import com.alpergayretoglu.online_student_election.model.entity.Election;
import com.alpergayretoglu.online_student_election.repository.DepartmentRepository;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class ElectionCreateRequest {

    @NotBlank
    private String departmentName;

    @NotNull
    private LocalDateTime startDate;

    @NotNull
    private LocalDateTime endDate;

    public static Election toEntity(ElectionCreateRequest request, DepartmentRepository departmentRepository) {
        return Election.builder()
                .department(departmentRepository.findByName(request.getDepartmentName()).orElseThrow(() -> new RuntimeException(ApplicationMessages.ELECTION_CREATE_FAIL_DEPARTMENT_NOT_FOUND)))
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .isFinished(false)
                .winner(null)
                .build();
    }
}