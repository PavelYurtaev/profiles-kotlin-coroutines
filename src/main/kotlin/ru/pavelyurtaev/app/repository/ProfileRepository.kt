package ru.pavelyurtaev.app.repository

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import ru.pavelyurtaev.app.model.Profile
import java.util.*

interface ProfileRepository : CoroutineCrudRepository<Profile, UUID>
