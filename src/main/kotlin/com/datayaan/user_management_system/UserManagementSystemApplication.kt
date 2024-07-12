package com.datayaan.user_management_system
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UserManagementSystemApplication

fun main(args: Array<String>) {

	val passwordEncoder = BCryptPasswordEncoder()
	val rawPassword = "password123" // Replace with the actual password
	val hashedPassword = passwordEncoder.encode(rawPassword)

	println("Hashed Password: $hashedPassword")

	runApplication<UserManagementSystemApplication>(*args)
}
