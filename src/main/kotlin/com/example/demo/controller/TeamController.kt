package com.example.demo.controller

import com.example.demo.dto.CreateTeamRequest
import com.example.demo.dto.CreateTeamResponse
import com.example.demo.dto.TeamResponse
import com.example.demo.service.TeamService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


// specifies that this is a reset controller and automatically runs as so. You don't have to call it anywhere
//RequestMapping gives this controller a path
@RestController
@RequestMapping("/api/teams")
class TeamController(
    val teamService: TeamService
) {

    //Post request on the default path of this controller, with a RequestBody object of type CreateTeamRequest
    //ResponseEntity works very well for HTTP responses and error or success codes
    @PostMapping
    fun createTeam(@RequestBody request: CreateTeamRequest): ResponseEntity<CreateTeamResponse> {
        val response: CreateTeamResponse = teamService.createTeam(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    //get mapping on api/teams/teamId
    @GetMapping("/{teamId}")
    fun findTeam(@PathVariable teamId: Long): ResponseEntity<TeamResponse> {
        val response: TeamResponse = teamService.findTeam(teamId)
        return ResponseEntity.status(HttpStatus.OK).body(response)
    }
}