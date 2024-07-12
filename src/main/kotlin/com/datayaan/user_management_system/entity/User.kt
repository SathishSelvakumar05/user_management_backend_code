package com.datayaan.user_management_system.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    @Column(nullable = false, unique = true) var username: String,
    @Column(nullable = false) var password: String,
    @ManyToMany(fetch = FetchType.EAGER) @JoinTable(
        name = "user_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    ) var roles: Set<Role> = setOf(),
    @Column(nullable = false) var isActive: Boolean = false
)
