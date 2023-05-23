package com.alpergayretoglu.online_student_election.model.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department extends BaseEntity {
    
    @Column(unique = true, nullable = false)
    private String name;

    @OneToOne
    @Builder.Default
    private User representative = null;

    @ManyToOne
    private Faculty faculty;

}
