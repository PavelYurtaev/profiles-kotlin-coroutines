package ru.pavelyurtaev.app.service

import kotlinx.coroutines.flow.Flow
import ru.pavelyurtaev.app.model.Profile
import ru.pavelyurtaev.app.web.dto.ProfileRequest
import ru.pavelyurtaev.app.web.dto.ProfileResponse
import java.util.UUID

interface ProfileService {
    suspend fun create(request: ProfileRequest): ProfileResponse
    fun getAll(): Flow<Profile>
    suspend fun getById(id: UUID): ProfileResponse
    suspend fun updateById(request: ProfileRequest, id: UUID): ProfileResponse
    suspend fun deleteById(id: UUID)
}