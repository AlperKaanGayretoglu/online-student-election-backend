package com.alpergayretoglu.online_student_election.model.response;

import com.alpergayretoglu.online_student_election.model.entity.Election;
import com.alpergayretoglu.online_student_election.model.entity.User;
import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class ElectionResultResponse {
    private String departmentName;
    private String winnerName;

    public static ElectionResultResponse fromEntity(Election election) {
        User winner = election.getWinner();
        String winnerName = winner == null ? null : winner.getName();
        return ElectionResultResponse.builder()
                .departmentName(election.getDepartment().getName())
                .winnerName(winnerName)
                .build();
    }
}
