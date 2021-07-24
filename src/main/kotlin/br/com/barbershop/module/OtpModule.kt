package br.com.barbershop.module

import br.com.barbershop.repository.otp.impl.OtpRepositoryImpl
import br.com.barbershop.service.impl.OtpServiceImpl
import org.koin.dsl.module

class OtpModule {
    companion object Module {
        val otpModule = module {
            single { OtpRepositoryImpl() }
            single { OtpServiceImpl(get())}
        }
    }

}