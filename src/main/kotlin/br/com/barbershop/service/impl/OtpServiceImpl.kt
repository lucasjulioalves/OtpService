package br.com.barbershop.service.impl

import br.com.barbershop.entities.User
import br.com.barbershop.exception.AppBussinessException
import br.com.barbershop.facade.request.PhoneRequestFacade
import br.com.barbershop.facade.response.PhoneResponseFacade
import br.com.barbershop.helper.UserHelper
import br.com.barbershop.repository.user.UserRepository
import br.com.barbershop.service.OtpService

class OtpServiceImpl(private val userRepository: UserRepository) : OtpService {

    override fun checkTokenStatus(request: PhoneRequestFacade) : PhoneResponseFacade {
        UserHelper.validateAttributesForSearch(request.phoneNumber)
        val user: User? = userRepository.getUserByPhone(request.phoneNumber!!)
            .also { u -> if(u == null) throw AppBussinessException("Phone number not found in the database") }
        return PhoneResponseFacade(user);
    }
}