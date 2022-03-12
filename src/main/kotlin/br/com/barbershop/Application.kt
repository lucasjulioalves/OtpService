package br.com.barbershop

import br.com.barbershop.config.configureExceptionHandling
import br.com.barbershop.config.configureRouting
import br.com.barbershop.config.configureSerialization
import br.com.barbershop.module.OtpModule
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import br.com.barbershop.util.ServerUtil
import org.koin.core.context.startKoin

fun main() {
    startKoin {
        modules(listOf(OtpModule.otpModule))
    }
    embeddedServer(Netty, port = ServerUtil.port, host = ServerUtil.host) {
        configureRouting()
        configureSerialization()
        configureExceptionHandling()
    }.start(wait = true)
};
