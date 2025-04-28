package com.example.demo.service

import com.example.demo.dto.CreateTeamRequest
import com.example.demo.dto.CreateTeamResponse
import com.example.demo.dto.TeamResponse
import com.example.demo.entity.Team
import com.example.demo.exception.TeamNotFoundException
import com.example.demo.repository.TeamRepository
import org.springframework.stereotype.Service

//when doing @Service Spring knows automatically this is a service that could be injected into other classes

//in the () i inject the repository(s) i will use
@Service
class TeamService(
    val teamRepository: TeamRepository
){

    //getting a team or throwing custom exception (check Exception package)
    fun findTeam(id: Long): TeamResponse {
        val team = teamRepository.findById(id).orElseThrow { TeamNotFoundException("Team not found") }

        return TeamResponse(team.id, team.name)
    }

    // for cleaner code and less problematic code, create DTO's for requests and responses
    fun createTeam(request: CreateTeamRequest): CreateTeamResponse {

        val team = Team(name = request.name)

        val savedTeam = teamRepository.save(team)

        return CreateTeamResponse(savedTeam.id, savedTeam.name)

    }
}