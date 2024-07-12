package com.datayaan.user_management_system.dto

import com.datayaan.user_management_system.entity.User

data class UserDto(
    val id: Long? = null,
    val username: String,
    val password: String,
    val roles: List<String>,
    val isActive: Boolean
) {
    constructor(user: User) : this(
        id = user.id,
        username = user.username,
        password = "",
        roles = user.roles.map { it.name },
        isActive = user.isActive
    )
}
// AuthRequest.kt

data class AuthRequest(
    val username: String,
    val password: String
)

// AuthResponse.kt

data class AuthResponse(
    val token: String
)
