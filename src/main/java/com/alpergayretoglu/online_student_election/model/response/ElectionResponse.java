package com.alpergayretoglu.online_student_election.model.response;

import com.alpergayretoglu.online_student_election.model.entity.Election;
import com.alpergayretoglu.online_student_election.model.entity.User;
import com.alpergayretoglu.online_student_election.model.enums.ElectionType;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class ElectionResponse {
    private String id;
    private String name;
    private ElectionType type;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isFinished;
    private User winner;

    public static ElectionResponse fromEntity(Election election) {
        return ElectionResponse.builder()
                .id(election.getId())
                .name(election.getName())
                .type(election.getType())
                .startDate(election.getStartDate())
                .endDate(election.getEndDate())
                .isFinished(election.getIsFinished())
                .winner(election.getWinner())
                .build();
    }
}
