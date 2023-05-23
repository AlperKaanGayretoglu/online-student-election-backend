package com.alpergayretoglu.online_student_election.model.request;


import com.alpergayretoglu.online_student_election.model.entity.Department;
import com.alpergayretoglu.online_student_election.model.entity.Election;
import com.alpergayretoglu.online_student_election.model.enums.Term;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Builder
@Getter
@Setter
public class ElectionCreateRequest {

    @NotBlank
    private String name;

    @NotBlank
    private Department department;

    @NotBlank
    private Term term;

    @NotBlank
    private Integer year;

    @NotBlank
    private LocalDate startDate;

    @NotBlank
    private LocalDate endDate;

    public static Election toEntity(ElectionCreateRequest request) {
        return Election.builder()
                .name(request.getName())
                .department(request.getDepartment())
                .term(request.getTerm())
                .year(request.getYear())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .isFinished(false)
                .winner(null)
                .build();
    }
}