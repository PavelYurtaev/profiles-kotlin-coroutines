package ru.pavelyurtaev.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication
@Configuration
@EnableWebFlux
class ProfileApplication

fun main(args: Array<String>) {
    runApplication<ProfileApplication>(*args)
}
