package com.example.demo.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(TeamNotFoundException::class)
    fun handleClubNotFound(exception: TeamNotFoundException) =
        ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.message)
}