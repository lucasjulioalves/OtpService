package br.com.barbershop.plugins

import br.com.barbershop.facade.request.OtpRequestFacade
import br.com.barbershop.facade.response.OtpResponseFacade
import br.com.barbershop.service.OtpService
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.response.*
import org.koin.ktor.ext.inject


fun Application.configureRouting() {

    val otpService: OtpService by inject()

    routing {
        get("/v1/{phoneNumber}") {
            val response : OtpResponseFacade = otpService.checkTokenStatus(
                OtpRequestFacade(call.parameters["phoneNumber"])
            )
            call.respond(response)
        }
    }
}
