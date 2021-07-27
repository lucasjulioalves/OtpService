package br.com.barbershop.service.impl

import br.com.barbershop.dto.OtpDto
import br.com.barbershop.entities.Otp
import br.com.barbershop.enum.OtpEnum
import br.com.barbershop.exception.AppBussinessException
import br.com.barbershop.facade.request.OtpRequestFacade
import br.com.barbershop.facade.response.OtpResponseFacade
import br.com.barbershop.helper.OtpHelper
import br.com.barbershop.repository.otp.OtpRepository
import br.com.barbershop.service.OtpService
import kotlin.random.Random

class OtpServiceImpl(private val otpRepository: OtpRepository) : OtpService {

    override fun getByTokensByPhoneNumber(request: OtpRequestFacade) : OtpResponseFacade {
        OtpHelper.validatePhoneNumber(request.phoneNumber)
        val otp: List<Otp> = otpRepository.getTokensByPhone(request.phoneNumber!!)
        return OtpResponseFacade(otp);
    }

    override fun generateCode(request: OtpRequestFacade) {
        OtpHelper.validatePhoneNumber(request.phoneNumber)
        val otpDto = OtpDto(request.phoneNumber!!, Random.nextInt(100000, 999999))
        otpRepository.insertOtp(otpDto)
    }

    override fun validateCode(request: OtpRequestFacade) {
        OtpHelper.validateAttributesForUpdate(request)

        val token = getByTokensByPhoneNumber(request)
            .also { otpToken -> if(otpToken.otp.isEmpty()) throw AppBussinessException("No code to validate") }

        val tokenToUpdate = token.otp.find { otp -> otp.code == request.token && otp.status == OtpEnum.PENDING }
            .also { otpToken -> if(otpToken == null) throw AppBussinessException("Invalid token") }

        otpRepository.updateOtp(
            OtpDto(
                phoneNumber = tokenToUpdate!!.phoneNumber,
                code = tokenToUpdate!!.code.toInt(),
                status = OtpEnum.VALIDATED
            )
        )

    }
}