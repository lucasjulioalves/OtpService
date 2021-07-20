package br.com.barbershop.repository.user

import br.com.barbershop.entities.User
import br.com.barbershop.repository.Repository

interface UserRepository : Repository {

    fun getUserByPhone(phoneNumber: String) : User?
}