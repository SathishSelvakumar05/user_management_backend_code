package com.datayaan.user_management_system.service

import com.datayaan.user_management_system.dto.UserDto
import com.datayaan.user_management_system.repository.RoleRepository
import com.datayaan.user_management_system.repository.UserRepository


import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun getAllUsers(): List<UserDto> {
        return userRepository.findAll().map { UserDto(it) }
    }

    fun createUser(userDto: UserDto): UserDto {
        val roles = userDto.roles.map { roleRepository.findByName(it) ?: throw IllegalArgumentException("Role not found: $it") }.toSet()
        val user = com.datayaan.user_management_system.entity.User(
            username = userDto.username,
            password = passwordEncoder.encode(userDto.password),
            roles = roles,
            isActive = userDto.isActive
        )
        return UserDto(userRepository.save(user))
    }

    fun updateUser(id: Long, userDto: UserDto): UserDto {
        val user = userRepository.findById(id).orElseThrow { IllegalArgumentException("User not found: $id") }
        user.username = userDto.username
        user.password = passwordEncoder.encode(userDto.password)
        user.roles = userDto.roles.map { roleRepository.findByName(it) ?: throw IllegalArgumentException("Role not found: $it") }.toSet()
        user.isActive = userDto.isActive
        return UserDto(userRepository.save(user))
    }

    fun deleteUser(id: Long) {
        userRepository.deleteById(id)
    }

    fun saveUser(user: com.datayaan.user_management_system.entity.User) {

    }
}
