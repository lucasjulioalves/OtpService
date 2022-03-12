package br.com.barbershop.config

import br.com.barbershop.facade.request.OtpRequestFacade
import br.com.barbershop.facade.response.OtpResponseFacade
import br.com.barbershop.service.OtpService
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import org.koin.ktor.ext.inject


fun Application.configureRouting() {

    val otpService: OtpService by inject()

    routing {
        get("/v1/{phoneNumber}") {
            val response : OtpResponseFacade = otpService.getByTokensByPhoneNumber(
                OtpRequestFacade(call.parameters["phoneNumber"])
            )
            call.respond(response)
        }

        post ("/v1"){
            val request : OtpRequestFacade = call.receive()
            otpService.generateCode(request)

            call.respond(HttpStatusCode.Created)
        }

        put ("v1/{phoneNumber}") {
            var request : OtpRequestFacade = call.receive()
            request.phoneNumber = call.parameters["phoneNumber"]

            otpService.validateCode(request)
            call.respond(HttpStatusCode.NoContent)
        }
    }
}
