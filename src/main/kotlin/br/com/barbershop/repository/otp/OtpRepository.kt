package br.com.barbershop.repository.otp

import br.com.barbershop.entities.Otp
import br.com.barbershop.repository.Repository

interface OtpRepository : Repository {

    fun getUserByPhone(phoneNumber: String) : Otp?
}