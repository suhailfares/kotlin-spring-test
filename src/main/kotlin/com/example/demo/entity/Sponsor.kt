package com.example.demo.entity

import jakarta.persistence.*

@Entity
@Table(name = "sponsors")
class Sponsor (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val name: String
){
}