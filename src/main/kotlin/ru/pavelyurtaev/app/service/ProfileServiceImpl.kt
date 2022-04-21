package ru.pavelyurtaev.app.service

import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service
import ru.pavelyurtaev.app.exceptions.AppException
import ru.pavelyurtaev.app.model.Profile
import ru.pavelyurtaev.app.repository.ProfileRepository
import ru.pavelyurtaev.app.web.dto.ProfileRequest
import ru.pavelyurtaev.app.web.dto.ProfileResponse
import ru.pavelyurtaev.app.web.mapper.ProfileMapper
import java.util.*

@Service
class ProfileServiceImpl(
    private val profileRepository: ProfileRepository
) : ProfileService {

    override suspend fun create(request: ProfileRequest): ProfileResponse {
        val profile = ProfileMapper.mapProfile(Profile(), request)
        val savedProfile = profileRepository.save(profile)
        return ProfileMapper.mapProfileResponse(savedProfile)
    }

    override fun getAll(): Flow<Profile> {
        return profileRepository.findAll()
    }

    override suspend fun getById(id: UUID): ProfileResponse {
        val profile = getProfile(id)
        return ProfileMapper.mapProfileResponse(profile)
    }

    override suspend fun updateById(request: ProfileRequest, id: UUID): ProfileResponse {
        val profile = ProfileMapper.mapProfile(getProfile(id), request)
        val savedProfile = profileRepository.save(profile)
        return ProfileMapper.mapProfileResponse(savedProfile)
    }

    override suspend fun deleteById(id: UUID) {
        profileRepository.deleteById(id)
    }

    private suspend fun getProfile(id: UUID) =
        profileRepository.findById(id) ?: throw AppException("No such profile by id $id")
}
