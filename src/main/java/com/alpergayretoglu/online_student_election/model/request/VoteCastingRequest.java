package com.alpergayretoglu.online_student_election.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

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