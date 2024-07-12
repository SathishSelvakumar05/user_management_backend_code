package com.datayaan.user_management_system.entity


import jakarta.persistence.*

@Entity
@Table(name = "roles")
data class Role(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    @Column(nullable = false, unique = true) val name: String
)
