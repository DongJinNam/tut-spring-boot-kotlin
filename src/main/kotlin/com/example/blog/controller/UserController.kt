package com.example.blog.controller

import com.example.blog.repository.UserRepository
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/user")
class UserController(private val userRepository: UserRepository) {

    @GetMapping("/")
    fun findAll() = userRepository.findAll()

    @GetMapping("/{login}")
    fun findOne(@PathVariable login: String) =
        userRepository.findByLogin(login) ?: throw ResponseStatusException(NOT_FOUND, "This user does not exist")
}
