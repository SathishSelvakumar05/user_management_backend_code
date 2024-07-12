package com.datayaan.user_management_system.controller

import com.datayaan.user_management_system.dto.AuthRequest
import com.datayaan.user_management_system.dto.AuthResponse
import com.datayaan.user_management_system.security.JwtUtil
import com.datayaan.user_management_system.service.UserDetailsServiceImpl
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authenticationManager: AuthenticationManager,
    private val userDetailsService: UserDetailsServiceImpl,
    private val jwtUtil: JwtUtil
) {

    @PostMapping("/login")
    fun authenticate(@RequestBody authRequest: AuthRequest): ResponseEntity<Any> {
        try {
            authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(authRequest.username, authRequest.password)
            )
        } catch (e: BadCredentialsException) {
            throw Exception("Incorrect username or password", e)
        }

        val userDetails = userDetailsService.loadUserByUsername(authRequest.username)
        val token = jwtUtil.generateToken(userDetails)

        return ResponseEntity.ok(AuthResponse(token))
    }
}
