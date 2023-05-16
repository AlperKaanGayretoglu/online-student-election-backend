package com.alpergayretoglu.online_student_election.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToOne
    @Builder.Default
    private User representative = null;

    @ManyToOne
    private Faculty faculty;

}
