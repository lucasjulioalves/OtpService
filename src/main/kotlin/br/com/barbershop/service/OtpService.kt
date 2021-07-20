package br.com.barbershop.service

import br.com.barbershop.entities.User
import br.com.barbershop.facade.PhoneRequestFacade

interface OtpService {
    fun checkTokenStatus(request: PhoneRequestFacade) : User?
}