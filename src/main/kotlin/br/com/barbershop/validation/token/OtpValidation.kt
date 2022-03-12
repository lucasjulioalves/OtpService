package br.com.barbershop.validation.token

import br.com.barbershop.validation.Validation

class OtpValidation : Validation {
    override fun validations(): List<(String?) -> String> {
        return listOf(
            { phoneNumber -> if(phoneNumber.isNullOrEmpty()) "A phone number is required" else "" },
            { phoneNumber -> if(phoneNumber?.length!! < 11) "Invalid phone number" else ""}
        )
    }
}