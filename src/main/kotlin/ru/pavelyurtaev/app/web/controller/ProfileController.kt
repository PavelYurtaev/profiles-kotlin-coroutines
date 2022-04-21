package ru.pavelyurtaev.app.web.controller

import kotlinx.coroutines.flow.Flow
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.pavelyurtaev.app.model.Profile
import ru.pavelyurtaev.app.service.ProfileService
import ru.pavelyurtaev.app.web.dto.ProfileRequest
import ru.pavelyurtaev.app.web.dto.ProfileResponse
import java.util.*

@RestController
@RequestMapping("/profile")
class ProfileController(
    private val profileService: ProfileService
) {

    @PostMapping
    suspend fun create(@RequestBody request: ProfileRequest): ResponseEntity<ProfileResponse> {
        val response = profileService.create(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping
    suspend fun get(@RequestParam id: String): ResponseEntity<Any> {
        val response = profileService.getById(UUID.fromString(id))
        return ResponseEntity.ok(response)
    }

    @GetMapping("/all")
    suspend fun getAll(): Flow<Profile> {
        return profileService.getAll()
    }

    @PutMapping
    suspend fun update(
        @RequestBody request: ProfileRequest,
        @RequestParam id: String
    ): ResponseEntity<ProfileResponse> {
        val response = profileService.updateById(request, UUID.fromString(id))
        return ResponseEntity.ok(response)
    }

    @DeleteMapping
    suspend fun deleteProfile(@RequestParam id: String): ResponseEntity<Any> {
        val response = profileService.deleteById(UUID.fromString(id))

        return ResponseEntity.ok(response)
    }
}
