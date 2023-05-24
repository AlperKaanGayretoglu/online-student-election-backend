package com.alpergayretoglu.online_student_election.model.request;


import com.alpergayretoglu.online_student_election.model.entity.Election;
import com.alpergayretoglu.online_student_election.model.enums.Term;
import com.alpergayretoglu.online_student_election.repository.DepartmentRepository;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Builder
@Getter
@Setter
public class ElectionCreateRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String departmentName;

    @NotNull
    private Term term;

    @NotNull
    private Integer year;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    public static Election toEntity(ElectionCreateRequest request, DepartmentRepository departmentRepository) {
        return Election.builder()
                .name(request.getName())
                .department(departmentRepository.findByName(request.getDepartmentName()).orElseThrow(() -> new RuntimeException("Department not found")))
                .term(request.getTerm())
                .year(request.getYear())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .isFinished(false)
                .winner(null)
                .build();
    }
}