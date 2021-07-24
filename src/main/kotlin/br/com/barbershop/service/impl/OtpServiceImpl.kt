package br.com.barbershop.service.impl

import br.com.barbershop.entities.Otp
import br.com.barbershop.exception.AppBussinessException
import br.com.barbershop.facade.request.OtpRequestFacade
import br.com.barbershop.facade.response.OtpResponseFacade
import br.com.barbershop.helper.OtpHelper
import br.com.barbershop.repository.otp.OtpRepository
import br.com.barbershop.service.OtpService

class OtpServiceImpl(private val otpRepository: OtpRepository) : OtpService {

    override fun checkTokenStatus(request: OtpRequestFacade) : OtpResponseFacade {
        OtpHelper.validateAttributesForSearch(request.phoneNumber)
        val otp: Otp? = otpRepository.getUserByPhone(request.phoneNumber!!)
            .also { u -> if(u == null) throw AppBussinessException("Phone number not found in the database") }
        return OtpResponseFacade(otp);
    }
}