package br.com.barbershop.helper

import br.com.barbershop.validation.ValidatorExecutor
import br.com.barbershop.validation.token.UserValidation

class OtpHelper {
    companion object Validator {
        @JvmStatic
        fun validateAttributesForSearch(phoneNumber: String?) {
            ValidatorExecutor.executeValidationWith(UserValidation::class, phoneNumber)
        }
    }
}