package br.com.barbershop.dto

import br.com.barbershop.enum.OtpEnum

data class OtpDto(val phoneNumber: String, val code: Int, val status: OtpEnum = OtpEnum.PENDING)
