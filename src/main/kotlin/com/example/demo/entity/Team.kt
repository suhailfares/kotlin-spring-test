package com.example.demo.entity

import jakarta.persistence.*

//The classes you want to create as tables in the database you annotate with @Entity
// Spring will create a table in the database (picked in /resources/application.properties
// Spring will choose the name of the table automatically, but to be sure you can add @Table(name = "teams") for custom naming
//in Kotlin classes start with this () instead of {} like in Java.
// in {} you can create methods though. in () you can see it as a constructor.
@Entity
@Table(name = "teams")
class Team(

    //tables need primary id, this is the common way to do it: @Id for primary. @GeneratedValue for auto id.
    //strategy depends on what you want. you can for example generate UUID.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    //specifying db validation that name can't be null for this entity
    @Column(nullable = false)
    val name: String,

    //one to many relation. the opposite in user
    //mappedBy in OneToMany relations says who is the Entity that owns this relation. in this came a team HAS users so i chose it to be the main entity
    @OneToMany(mappedBy = "team")
    val users: List<User> = mutableListOf(),


    //in many to many relations you need to make a new table joining the ids of the entities.
    // joinColumns specifies current entity, inverseJoinColumns the other entity
    @ManyToMany
    @JoinTable(
        name = "team_sponsors",
        joinColumns = [JoinColumn(name = "team_id")],
        inverseJoinColumns = [JoinColumn(name = "sponsor_id")]
    )
    var sponsors: MutableList<Sponsor> = mutableListOf()
){}

