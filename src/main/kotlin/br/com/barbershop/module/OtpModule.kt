package br.com.barbershop.module

import br.com.barbershop.repository.otp.OtpRepository
import br.com.barbershop.repository.otp.impl.OtpRepositoryImpl
import br.com.barbershop.service.OtpService
import br.com.barbershop.service.impl.OtpServiceImpl
import org.koin.dsl.module

class OtpModule {
    companion object Module {
        val otpModule = module {
            single<OtpRepository> { OtpRepositoryImpl() }
            single<OtpService> { OtpServiceImpl(get())}
        }
    }

}