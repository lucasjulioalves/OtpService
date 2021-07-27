package br.com.barbershop.config

import br.com.barbershop.exception.AppBussinessException
import br.com.barbershop.facade.response.ErrorResponseFacade
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*


fun Application.configureExceptionHandling() {
    install(StatusPages) {
        exception<AppBussinessException> { cause ->
            call.respond(HttpStatusCode.BadRequest, ErrorResponseFacade(cause.message))
        }
    }
}