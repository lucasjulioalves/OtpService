package br.com.barbershop.helper

import br.com.barbershop.facade.request.OtpRequestFacade
import br.com.barbershop.validation.ValidatorExecutor
import br.com.barbershop.validation.token.OtpUpdateValidation
import br.com.barbershop.validation.token.OtpValidation

class OtpHelper {
    companion object Validator {
        @JvmStatic
        fun validatePhoneNumber(phoneNumber: String?) {
            ValidatorExecutor.executeValidationWith(OtpValidation::class, phoneNumber)
        }

        fun validateAttributesForUpdate(otpRequestFacade: OtpRequestFacade) {
            ValidatorExecutor.executeValidationWith(OtpValidation::class, otpRequestFacade.phoneNumber)
            ValidatorExecutor.executeValidationWith(OtpUpdateValidation::class, otpRequestFacade.token)
        }
    }
}