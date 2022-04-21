package ru.pavelyurtaev.app.web.mapper

import ru.pavelyurtaev.app.model.Profile
import ru.pavelyurtaev.app.web.dto.ProfileRequest
import ru.pavelyurtaev.app.web.dto.ProfileResponse

object ProfileMapper {

    fun mapProfile(profile: Profile, request: ProfileRequest): Profile {
        profile.title = request.title
        profile.description = request.description
        return profile;
    }

    fun mapProfileResponse(profile: Profile): ProfileResponse {
        return ProfileResponse(
            id = profile.id,
            title = profile.title,
            description = profile.description
        )
    }

}