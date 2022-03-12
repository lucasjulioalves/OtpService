package br.com.barbershop.validation.token

import br.com.barbershop.validation.Validation

class OtpUpdateValidation : Validation {
    override fun validations(): List<(String?) -> String> {
        return listOf(
            { code -> if(code.isNullOrEmpty()) "Otp is required" else "" },
            { code -> if(code?.length!! < 6) "Invalid Otp" else ""}
        )
    }
}