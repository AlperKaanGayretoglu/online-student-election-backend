package com.alpergayretoglu.online_student_election.model.response;

import com.alpergayretoglu.online_student_election.model.entity.Election;
import com.alpergayretoglu.online_student_election.model.entity.User;
import com.alpergayretoglu.online_student_election.model.enums.Term;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class ElectionResponse {
    private String id;
    private String name;
    private String departmentName;
    private Term term;
    private Integer year;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Boolean isFinished;
    private String winnerNameSurname;
    private List<String> candidateNames;
    private Integer voteCount;

    public static ElectionResponse fromEntity(Election election) {
        User winner = election.getWinner();
        String winnerName = winner == null ? null : (winner.getName() + " " + winner.getSurname());
        return ElectionResponse.builder()
                .id(election.getId())
                .name(election.getName())
                .departmentName(election.getDepartment().getName())
                .term(election.getTerm())
                .year(election.getYear())
                .startDate(election.getStartDate())
                .endDate(election.getEndDate())
                .isFinished(election.getIsFinished())
                .winnerNameSurname(winnerName)
                .candidateNames(election.getCandidates().stream().map(User::getName).collect(Collectors.toList()))
                .voteCount(election.getVoteCount())
                .build();
    }
}
