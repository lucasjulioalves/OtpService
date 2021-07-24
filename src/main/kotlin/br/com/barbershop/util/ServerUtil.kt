package br.com.barbershop.util

import com.typesafe.config.ConfigFactory
import io.ktor.config.*

class ServerUtil {
    companion object {
        private val config = HoconApplicationConfig(ConfigFactory.load())
        val port = config.property("ktor.deployment.port").getString().toInt()
        val host = config.property("ktor.deployment.host").getString()
    }
}