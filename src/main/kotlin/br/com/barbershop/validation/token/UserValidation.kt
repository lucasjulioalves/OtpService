package br.com.barbershop.validation.token

import br.com.barbershop.validation.Validation

class UserValidation : Validation {
    override fun validations(): List<(String) -> String> {
        return listOf { phoneNumber: String ->
            if (phoneNumber.isNullOrEmpty() || phoneNumber.length < 11) "Invalid phone number" else ""
        };
    }
}