package com.datayaan.user_management_system.repository

import com.datayaan.user_management_system.entity.User


import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String): User?
}


