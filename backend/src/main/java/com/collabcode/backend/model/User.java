package com.collabcode.backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password; // BCrypt-hashed

    @OneToMany(mappedBy = "owner")
    private Set<Repository> ownedRepositories;

    @OneToMany(mappedBy = "user")
    private Set<Collaborator> collaborations;
} 