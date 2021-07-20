package br.com.barbershop.repository.user.impl

import br.com.barbershop.entities.User
import br.com.barbershop.repository.user.AbstractRepository
import br.com.barbershop.repository.user.UserRepository
import com.mongodb.client.MongoCollection
import org.koin.core.component.KoinComponent
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection

class UserRepositoryImpl : UserRepository, KoinComponent, AbstractRepository() {

    override fun getUserByPhone(phoneNumber: String) : User? {
        val userCollection : MongoCollection<User> =
            this.mongoUserDatabase.getCollection()

        return userCollection.findOne(User::phoneNumber eq phoneNumber)
    }
}