package com.alpergayretoglu.online_student_election.model.entity;

import com.alpergayretoglu.online_student_election.model.enums.ElectionType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class Election {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private ElectionType type;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Builder.Default
    @Column(nullable = false)
    private Boolean isFinished = false;

    @Builder.Default
    @ManyToOne
    private User winner = null;
}
