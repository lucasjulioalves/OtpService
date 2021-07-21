package br.com.barbershop.validation

interface Validation {
    fun validations() : List<(String?) -> String>
}