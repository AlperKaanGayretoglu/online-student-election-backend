package com.alpergayretoglu.online_student_election.model.request;


import com.alpergayretoglu.online_student_election.model.entity.Election;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;


@Builder
@Getter
@Setter
public class ElectionUpdateRequest {

    @NotBlank
    private String name;

    @NotBlank
    private LocalDate startDate;

    @NotBlank
    private LocalDate endDate;

    public static Election toEntity(ElectionUpdateRequest request) {
        return Election.builder()
                .name(request.getName())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .isFinished(false)
                .winner(null)
                .build();
    }
}