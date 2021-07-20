val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val koin_version="3.1.2"
val kmongo_version="4.2.8"

plugins {
    application
    kotlin("jvm") version "1.5.21"
}

group = "br.com.barbershop"
version = "0.0.1"
application {
    mainClass.set("br.com.barbershop.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-jackson:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.insert-koin:koin-core:$koin_version")
    implementation("org.litote.kmongo:kmongo:$kmongo_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlin_version")
}