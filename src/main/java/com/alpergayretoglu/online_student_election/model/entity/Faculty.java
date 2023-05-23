package com.alpergayretoglu.online_student_election.model.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Faculty extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String name;
}
