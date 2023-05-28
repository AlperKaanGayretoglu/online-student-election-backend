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
    private String winnerNameSurname;

    public static ElectionResultResponse fromEntity(Election election) {
        User winner = election.getWinner();
        String winnerNameSurname = winner == null ? null : (winner.getName() + " " + winner.getSurname());
        return ElectionResultResponse.builder()
                .departmentName(election.getDepartment().getName())
                .winnerNameSurname(winnerNameSurname)
                .build();
    }
}
