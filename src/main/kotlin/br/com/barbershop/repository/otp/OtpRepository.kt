package br.com.barbershop.repository.otp

import br.com.barbershop.dto.OtpDto
import br.com.barbershop.entities.Otp
import br.com.barbershop.repository.Repository

interface OtpRepository : Repository {

    fun getTokensByPhone(phoneNumber: String) : List<Otp>
    fun insertOtp(otpDto: OtpDto)
    fun updateOtp(otpDto: OtpDto)
}