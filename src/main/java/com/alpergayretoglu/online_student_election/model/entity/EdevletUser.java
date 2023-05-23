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
public class EdevletUser extends BaseEntity {

    // USER
    // -------------------------------------------------------
    @Column(unique = true, nullable = false)
    private String tcNo;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;
    // -------------------------------------------------------

    // ELIGIBILITY
    // -------------------------------------------------------
    @Column(nullable = false)
    private Boolean isMemberOfAPoliticalPartyOrgan;

    @Column(nullable = false)
    private Boolean hasACriminalRecord;

    @Column(nullable = false)
    private Boolean isAffiliatedWithABadOrganization;
    // -------------------------------------------------------

    public boolean isEligible() {
        return !isMemberOfAPoliticalPartyOrgan && !hasACriminalRecord && !isAffiliatedWithABadOrganization;
    }
}
