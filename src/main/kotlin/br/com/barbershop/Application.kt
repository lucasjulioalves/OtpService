package br.com.barbershop

import br.com.barbershop.module.OtpModule
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import br.com.barbershop.plugins.*
import br.com.barbershop.util.ServerUtil
import com.typesafe.config.ConfigFactory
import io.ktor.application.*
import io.ktor.config.*
import org.koin.core.context.startKoin

fun main() {
    startKoin {
        modules(listOf(OtpModule.otpModule))
    }
    embeddedServer(Netty, port = ServerUtil.port, host = ServerUtil.host) {
        configureRouting()
        configureSerialization()
    }.start(wait = true)
};
