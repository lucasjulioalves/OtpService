package br.com.barbershop.plugins

import br.com.barbershop.entities.User
import br.com.barbershop.facade.request.PhoneRequestFacade
import br.com.barbershop.facade.response.PhoneResponseFacade
import br.com.barbershop.service.OtpService
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.response.*
import org.koin.ktor.ext.inject


fun Application.configureRouting() {

    val otpService: OtpService by inject()

    routing {
        get("/v1/{phoneNumber}") {
            val response : PhoneResponseFacade = otpService.checkTokenStatus(
                PhoneRequestFacade(call.parameters["phoneNumber"])
            )
            call.respond(response)
        }
    }
}
