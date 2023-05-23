package com.alpergayretoglu.online_student_election.model.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class Vote extends BaseEntity {
    @ManyToOne
    private User voter;

    @ManyToOne
    private Election forElection;

    @ManyToOne
    private User forCandidate;

    @Column(nullable = false)
    private LocalDateTime dateTime;
}
