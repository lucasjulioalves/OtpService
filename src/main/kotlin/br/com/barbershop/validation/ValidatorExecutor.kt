package br.com.barbershop.validation

import br.com.barbershop.exception.AppBussinessException
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

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