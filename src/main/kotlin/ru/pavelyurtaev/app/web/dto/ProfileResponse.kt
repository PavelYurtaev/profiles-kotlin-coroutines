package ru.pavelyurtaev.app.web.dto

import java.util.UUID

data class ProfileResponse(
    val id: UUID,
    val title: String,
    val description: String
)
