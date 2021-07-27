package br.com.barbershop.repository.otp

import br.com.barbershop.util.ServerUtil
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoDatabase
import org.litote.kmongo.KMongo

abstract class AbstractRepository {
    private val mongoDatabaseClient : MongoClient = KMongo.createClient(ServerUtil.databaseHost);
    val mongoOtpDatabase: MongoDatabase = mongoDatabaseClient.getDatabase("otp");
}