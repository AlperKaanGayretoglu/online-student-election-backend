package com.alpergayretoglu.online_student_election.model.entity;

import com.alpergayretoglu.online_student_election.model.enums.Term;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        uniqueConstraints =
        @UniqueConstraint(columnNames = {"department_id", "term", "year"})
)
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class Election {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToOne
    private Department department;

    @Column(nullable = false)
    private Term term;

    @Column(nullable = false)
    private Integer year;

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

    @OneToMany
    @Builder.Default
    private Set<User> candidates = new HashSet<>();

    @OneToMany
    @Builder.Default
    private Set<Vote> votes = new HashSet<>();

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

}
