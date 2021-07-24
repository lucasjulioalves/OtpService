package br.com.barbershop.service

import br.com.barbershop.facade.request.OtpRequestFacade
import br.com.barbershop.facade.response.OtpResponseFacade

interface OtpService {
    fun checkTokenStatus(request: OtpRequestFacade) : OtpResponseFacade
}