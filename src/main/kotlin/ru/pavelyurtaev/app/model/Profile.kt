package ru.pavelyurtaev.app.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("profile")
class Profile {
    @Id
    lateinit var id: UUID
    var title: String = ""
    var description: String = ""
}
