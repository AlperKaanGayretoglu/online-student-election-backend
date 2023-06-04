package com.alpergayretoglu.online_student_election.model.entity;

import com.alpergayretoglu.online_student_election.model.enums.Term;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class Election extends BaseEntity {

    @Column(unique = true, nullable = false)
    @Setter(AccessLevel.NONE)
    private String name;

    @ManyToOne
    private Department department;

    @Column(nullable = false)
    @Setter(AccessLevel.NONE)
    private Term term;

    @Column(nullable = false)
    @Setter(AccessLevel.NONE)
    private Integer year;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @Builder.Default
    @Column(nullable = false)
    private Boolean isFinished = false;

    @Builder.Default
    @ManyToOne
    private User winner = null;

    @OneToMany
    @Builder.Default
    private Set<User> candidates = new HashSet<>();

    @OneToMany
    @Builder.Default
    private Set<Vote> votes = new HashSet<>();

    @PrePersist
    public void prePersist() {
        this.term = decideTerm();
        if (term == Term.FALL) {
            this.year = getStartDate().getYear();
        } else {
            this.year = getStartDate().getYear() - 1;
        }
        this.name = year + "-" + (year + 1) + " " + term + " | " + department.getName() + " Representative Election";
    }

    public void addCandidate(User user) {
        candidates.add(user);
    }

    public void removeCandidate(User user) {
        candidates.remove(user);
    }

    public User decideWinner() {
        User winner = null;
        int maxVoteCount = 0;
        for (User candidate : candidates) {
            int voteCount = 0;
            for (Vote vote : votes) {
                if (vote.getForCandidate().equals(candidate)) {
                    voteCount++;
                }
            }

            if (voteCount == maxVoteCount && maxVoteCount != 0) {
                return null;
            }

            if (voteCount > maxVoteCount) {
                maxVoteCount = voteCount;
                winner = candidate;
            }
        }
        return winner;
    }

    public void addVote(Vote vote) {
        votes.add(vote);
    }

    public int getVoteCount() {
        return votes.size();
    }

    private Term decideTerm() {
        int year = getStartDate().getYear();
        if (startDate.isAfter(Term.FALL.getStartDateForYear(year).atStartOfDay()) && startDate.isBefore(Term.FALL.getEndDateForYear(year).atStartOfDay())) {
            return Term.FALL;
        } else if (startDate.isAfter(Term.SPRING.getStartDateForYear(year).atStartOfDay()) && startDate.isBefore(Term.SPRING.getEndDateForYear(year).atStartOfDay())) {
            return Term.SPRING;
        }
        return null;
    }

}
