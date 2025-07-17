package com.collabcode.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "collaborators")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Collaborator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repository_id", nullable = false)
    private Repository repository;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public enum Role {
        OWNER, COLLABORATOR, VIEWER
    }
} 