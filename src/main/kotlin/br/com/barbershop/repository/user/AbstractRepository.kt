package br.com.barbershop.repository.user

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoDatabase
import org.litote.kmongo.KMongo

abstract class AbstractRepository {
    private val mongoDatabaseClient : MongoClient = KMongo.createClient();
    val mongoUserDatabase: MongoDatabase = mongoDatabaseClient.getDatabase("users");
}