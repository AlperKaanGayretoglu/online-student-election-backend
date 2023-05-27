package com.alpergayretoglu.online_student_election.model.request;


import com.alpergayretoglu.online_student_election.model.entity.Election;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Builder
@Getter
@Setter
public class ElectionUpdateRequest {

    @NotBlank
    private LocalDateTime startDate;

    @NotBlank
    private LocalDateTime endDate;

    public static Election updateEntityUsingRequest(Election oldElection, ElectionUpdateRequest request) {
        oldElection.setStartDate(request.getStartDate());
        oldElection.setEndDate(request.getEndDate());
        return oldElection;
    }
}