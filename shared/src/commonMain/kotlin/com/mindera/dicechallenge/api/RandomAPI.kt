package com.mindera.dicechallenge.api

import com.mindera.dicechallenge.api.model.RandomIntRequest
import com.mindera.dicechallenge.api.model.RandomIntRequestParams
import com.mindera.dicechallenge.api.model.RandomIntResponse
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*

class RandomAPI {

    private val httpClient = HttpClient(){
        install(JsonFeature){
            val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
    }

    suspend fun generateInteger(num: Int, upperBound: Int, lowerBound: Int): List<Int> {

        val response: RandomIntResponse = httpClient.post(RANDOM_ENDPOINT){
            contentType(ContentType.Application.Json)
            body = RandomIntRequest(REQ_BODY_ID, REQ_BODY_JPC, REQ_BODY_METHOD, RandomIntRequestParams(API_KEY,
                num, upperBound, lowerBound))
        }
        println("RESPONSE: " + response)
        return response.result.random.data
    }

    companion object{
        //API
        private const val RANDOM_ENDPOINT = "https://api.random.org/json-rpc/4/invoke"
        private const val API_KEY = "470b7796-fa61-4310-b709-ab52e27c23a2"

        //RequestBody
        private const val REQ_BODY_ID = 1
        private const val REQ_BODY_JPC = "2.0"
        private const val REQ_BODY_METHOD = "generateIntegers"

    }
}