package br.com.barbershop.service

import br.com.barbershop.entities.User
import br.com.barbershop.facade.request.PhoneRequestFacade
import br.com.barbershop.facade.response.PhoneResponseFacade

interface OtpService {
    fun checkTokenStatus(request: PhoneRequestFacade) : PhoneResponseFacade
}