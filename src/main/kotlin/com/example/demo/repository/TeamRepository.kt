package com.example.demo.repository

import com.example.demo.entity.Team
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

//can be used throughout your code to make calls to the database for CRUD operations
//most simple things are built in
//Spring can even create for you custom calls for filtering etc.
//you can also create custom functions here with SELECT statements
interface TeamRepository : JpaRepository<Team, Long> {

    // Find teams by exact name
    // it is not necessary to do it like this, but it is a good practice to use raw SQL queries.
    // for simple operations, Spring provides built-in queries
    @Query("SELECT t FROM Team t WHERE t.name = :name")
    fun searchByName(@Param("name") name: String): List<Team>

}