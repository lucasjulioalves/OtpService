package br.com.barbershop.module

import br.com.barbershop.service.OtpService
import br.com.barbershop.service.impl.OtpServiceImpl
import org.koin.dsl.module

class OtpModule {
    companion object Module {
        val otpModule = module {
            single { OtpServiceImpl() as OtpService }
        }
    }

}