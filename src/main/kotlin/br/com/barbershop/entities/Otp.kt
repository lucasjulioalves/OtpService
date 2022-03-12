package br.com.barbershop.entities

import br.com.barbershop.enum.OtpEnum

class Otp(
    val phoneNumber: String,
    val status: OtpEnum,
    val code: String
) {

}