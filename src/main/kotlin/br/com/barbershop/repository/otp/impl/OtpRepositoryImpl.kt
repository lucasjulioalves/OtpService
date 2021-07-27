package br.com.barbershop.repository.otp.impl

import br.com.barbershop.dto.OtpDto
import br.com.barbershop.entities.Otp
import br.com.barbershop.repository.otp.AbstractRepository
import br.com.barbershop.repository.otp.OtpRepository
import com.mongodb.client.MongoCollection
import org.litote.kmongo.*

class OtpRepositoryImpl : OtpRepository, AbstractRepository() {

    private val otpCollection : String = "otps"

    override fun getTokensByPhone(phoneNumber: String) : List<Otp> {
        val otpCollection : MongoCollection<Otp> =
            this.mongoOtpDatabase.getCollection(otpCollection, Otp::class.java)


        return otpCollection.find(Otp::phoneNumber eq phoneNumber).toList()
    }

    override fun insertOtp(otpDto: OtpDto) {
        val otpCollection : MongoCollection<OtpDto> =
            this.mongoOtpDatabase.getCollection(otpCollection, OtpDto::class.java)

       otpCollection.insertOne(otpDto);
    }

    override fun updateOtp(otpDto: OtpDto) {
        val otpCollection : MongoCollection<OtpDto> =
            this.mongoOtpDatabase.getCollection(otpCollection, OtpDto::class.java)

        otpCollection.updateOne(
            and(OtpDto::phoneNumber eq otpDto.phoneNumber,
                OtpDto::code eq otpDto.code
            ) , otpDto)
    }
}