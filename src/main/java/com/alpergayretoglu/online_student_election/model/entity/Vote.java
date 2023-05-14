package com.alpergayretoglu.online_student_election.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    private User voter;

    @ManyToOne
    private Election forElection;

    @ManyToOne
    private User forCandidate;

    @Column(nullable = false)
    private LocalDate date;
}
