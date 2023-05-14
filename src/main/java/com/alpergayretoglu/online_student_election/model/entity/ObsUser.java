package com.alpergayretoglu.online_student_election.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class ObsUser {

    // USER
    // -------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
    // -------------------------------------------------------


    // STUDENT
    // -------------------------------------------------------
    private String studentNo;

    private Double gpa;

    private String departmentName;
    // -------------------------------------------------------

}
