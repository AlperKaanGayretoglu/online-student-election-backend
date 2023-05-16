package com.alpergayretoglu.online_student_election.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class VoteCastingRequest {

    @NotBlank
    private String voterId;

    @NotBlank
    private String electionId;

    @NotBlank
    private String candidateId;

}