package br.com.barbershop.service

import br.com.barbershop.facade.request.OtpRequestFacade
import br.com.barbershop.facade.response.OtpResponseFacade

interface OtpService {
    fun getByTokensByPhoneNumber(request: OtpRequestFacade) : OtpResponseFacade
    fun generateCode(request: OtpRequestFacade)
    fun validateCode(request: OtpRequestFacade)
}