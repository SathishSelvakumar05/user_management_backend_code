package com.datayaan.user_management_system.repository


import com.datayaan.user_management_system.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository : JpaRepository<Role, Long> {
    fun findByName(name: String): Role?
}