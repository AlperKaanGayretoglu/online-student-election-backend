package com.alpergayretoglu.online_student_election.model.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidacyApplication extends BaseEntity {
  
    @OneToOne
    private User user;

    @OneToOne
    private Election election;

    @Column(nullable = false)
    private boolean isAccepted;

    @Column(nullable = false)
    private LocalDateTime applicationDate;

}
