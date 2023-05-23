package com.alpergayretoglu.online_student_election.model.response;

import com.alpergayretoglu.online_student_election.model.entity.Election;
import com.alpergayretoglu.online_student_election.model.entity.User;
import com.alpergayretoglu.online_student_election.model.enums.Term;
import lombok.*;

import java.time.LocalDate;
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
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isFinished;
    private String winnerName;
    private List<String> candidateNames;

    public static ElectionResponse fromEntity(Election election) {
        User winner = election.getWinner();
        String winnerName = winner == null ? null : winner.getName();
        return ElectionResponse.builder()
                .id(election.getId())
                .name(election.getName())
                .departmentName(election.getDepartment().getName())
                .term(election.getTerm())
                .year(election.getYear())
                .startDate(election.getStartDate())
                .endDate(election.getEndDate())
                .isFinished(election.getIsFinished())
                .winnerName(winnerName)
                .candidateNames(election.getCandidates().stream().map(User::getName).collect(Collectors.toList()))
                .build();
    }
}
