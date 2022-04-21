package ru.pavelyurtaev.app.exceptions

import org.apache.commons.logging.LogFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import ru.pavelyurtaev.app.exceptions.dto.ErrorResponse

@ControllerAdvice
class ControllerAdvice {

    private val log = LogFactory.getLog(javaClass)

    @ExceptionHandler(Exception::class)
    fun handleCommonException(e: Exception): ResponseEntity<ErrorResponse> {
        log.error("Handling general exception", e)
        return ResponseEntity.badRequest().body(
            ErrorResponse(
                code = "ERROR",
                message = e.message ?: "No message"
            )
        )
    }
}
