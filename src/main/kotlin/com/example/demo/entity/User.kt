package com.example.demo.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "users")
class User(

    //this time the id is a UUID
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID,

    @Column(nullable = false)
    val username: String,

    // many to one relation (the opposite in the team entity)
    //JoinColumn is for giving Entity User the field team_id of the Team (mostly in ManyToOne relations only)
    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    val team: Team,

) {
}