package com.alpergayretoglu.online_student_election.model.entity;

import com.alpergayretoglu.online_student_election.model.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
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

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private UserRole role = UserRole.VOTER; // this will determine whether the user is a candidate or a representative
    // -------------------------------------------------------

    // STUDENT
    // -------------------------------------------------------
    private String tcNo;
    
    private String studentNo;

    private Double gpa;

    @ManyToOne
    private Department department; // a user can only be candidate/representative for the department he/she is in
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
