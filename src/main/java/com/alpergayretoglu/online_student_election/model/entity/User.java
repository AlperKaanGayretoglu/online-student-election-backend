package com.alpergayretoglu.online_student_election.model.entity;

import com.alpergayretoglu.online_student_election.model.enums.CandidateType;
import com.alpergayretoglu.online_student_election.model.enums.RepresentativeType;
import com.alpergayretoglu.online_student_election.model.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class User implements UserDetails {

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

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private UserRole role = UserRole.VOTER;
    // -------------------------------------------------------


    // STUDENT
    // -------------------------------------------------------
    private String studentNo;

    private Double gpa;

    @ManyToOne
    private Department department;
    // -------------------------------------------------------

    // CANDIDATE
    // -------------------------------------------------------
    private CandidateType candidateType;
    // -------------------------------------------------------

    // REPRESENTATIVE
    // -------------------------------------------------------
    private RepresentativeType representativeType;

    private LocalDate representativeStartDate;

    private LocalDate representativeEndDate;
    // -------------------------------------------------------

    // SECURITY
    // -------------------------------------------------------
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    // -------------------------------------------------------
}
