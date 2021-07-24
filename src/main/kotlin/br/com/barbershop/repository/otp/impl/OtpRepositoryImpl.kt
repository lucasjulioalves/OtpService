package br.com.barbershop.repository.otp.impl

import br.com.barbershop.entities.Otp
import br.com.barbershop.repository.otp.AbstractRepository
import br.com.barbershop.repository.otp.OtpRepository
import com.mongodb.client.MongoCollection

import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection

class OtpRepositoryImpl : OtpRepository, AbstractRepository() {

    override fun getUserByPhone(phoneNumber: String) : Otp? {
        val otpCollection : MongoCollection<Otp> =
            this.mongoUserDatabase.getCollection()

        return otpCollection.findOne(Otp::phoneNumber eq phoneNumber)
    }
}