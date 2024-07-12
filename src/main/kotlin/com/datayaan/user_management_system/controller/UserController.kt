package com.datayaan.user_management_system.controller


import com.datayaan.user_management_system.dto.UserDto
import com.datayaan.user_management_system.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*



@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    fun getAllUsers(): ResponseEntity<List<UserDto>> {
        return ResponseEntity.ok(userService.getAllUsers())
    }

    @PostMapping
    fun createUser(@RequestBody userDto: UserDto): ResponseEntity<UserDto> {
        return ResponseEntity.ok(userService.createUser(userDto))
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    fun updateUser(@PathVariable id: Long, @RequestBody userDto: UserDto): ResponseEntity<UserDto> {
        return ResponseEntity.ok(userService.updateUser(id, userDto))
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Void> {
        userService.deleteUser(id)
        return ResponseEntity.noContent().build()
    }
}
