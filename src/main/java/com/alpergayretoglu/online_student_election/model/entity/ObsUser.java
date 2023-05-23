package com.alpergayretoglu.online_student_election.model.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class ObsUser extends BaseEntity {

    // USER
    // -------------------------------------------------------
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
    private String tcNo;

    private String studentNo;

    private Double gpa;

    private String departmentName;
    // -------------------------------------------------------

}
