package br.com.barbershop

import br.com.barbershop.module.OtpModule
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import br.com.barbershop.plugins.*
import org.koin.core.context.startKoin

fun main() {
    startKoin {
        modules(listOf(OtpModule.otpModule))
    }
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureSerialization()
    }.start(wait = true)
};
