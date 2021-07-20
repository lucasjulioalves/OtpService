package br.com.barbershop.service.impl

import br.com.barbershop.entities.User
import br.com.barbershop.exception.AppBussinessException
import br.com.barbershop.facade.PhoneRequestFacade
import br.com.barbershop.helper.UserHelper
import br.com.barbershop.repository.user.UserRepository
import br.com.barbershop.service.OtpService
import org.koin.core.component.KoinComponent

class OtpServiceImpl(private val userRepository: UserRepository) : OtpService, KoinComponent {

    override fun checkTokenStatus(request: PhoneRequestFacade) : User? {
        UserHelper.validateAttributesForSearch(request.phoneNumber)
        return userRepository.getUserByPhone(request.phoneNumber)
            .also { u -> if(u == null) throw AppBussinessException("Phone number not found in the database") }
    }
}