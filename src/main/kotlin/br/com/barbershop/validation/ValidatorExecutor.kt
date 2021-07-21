package br.com.barbershop.validation

import br.com.barbershop.exception.AppBussinessException
import br.com.barbershop.validation.token.UserValidation
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.primaryConstructor

class ValidatorExecutor {
    companion object {
        @JvmStatic
        fun executeValidationWith(validation: KClass<out Validation>, value: String?) {
            val validationInstance: Validation = validation.createInstance()
            for(fn in validationInstance.validations()) {
                var message = fn(value);
                if(!message.isNullOrEmpty()) throw AppBussinessException(message)
            }
        }
    }
}