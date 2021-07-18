package br.com.barbershop.service.impl

import br.com.barbershop.entities.User
import br.com.barbershop.facade.PhoneRequestFacade
import br.com.barbershop.helper.UserHelper
import br.com.barbershop.service.OtpService
import org.koin.core.component.KoinComponent

class OtpServiceImpl : OtpService, KoinComponent {

    fun checkTokenStatus(request: PhoneRequestFacade) {
        UserHelper.validateAttributesForSearch(request.phoneNumber)
    }
}