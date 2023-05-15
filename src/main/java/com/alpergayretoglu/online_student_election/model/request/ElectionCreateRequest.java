package com.alpergayretoglu.online_student_election.model.request;


import com.alpergayretoglu.online_student_election.model.entity.Election;
import com.alpergayretoglu.online_student_election.model.enums.ElectionType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class ElectionCreateRequest {

    @NotBlank
    private String name;

    @NotBlank
    private ElectionType type;

    @NotBlank
    private LocalDate startDate;

    @NotBlank
    private LocalDate endDate;

    public static Election toEntity(ElectionCreateRequest request) {
        return Election.builder()
                .name(request.getName())
                .type(request.getType())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .isFinished(false)
                .winner(null)
                .build();
    }
}