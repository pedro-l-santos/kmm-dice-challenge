package com.mindera.dicechallenge.api

import com.mindera.dicechallenge.api.model.RandomIntRequest
import com.mindera.dicechallenge.api.model.RandomIntRequestParams
import com.mindera.dicechallenge.api.model.RandomIntResponse
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*

//API Const
private const val RANDOM_ENDPOINT = "https://api.random.org/json-rpc/4/invoke"
private const val API_KEY = "470b7796-fa61-4310-b709-ab52e27c23a2"

//RequestBody Const
private const val REQ_BODY_ID = 1
private const val REQ_BODY_JPC = "2.0"
private const val REQ_BODY_METHOD = "generateIntegers"

class RandomApiClient(engine: HttpClientEngine) : IRandomApiClient {

    private val httpClient = HttpClient(engine){
        install(JsonFeature){
            val json = kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
                explicitNulls = false
            }
            serializer = KotlinxSerializer(json)
        }
    }

    override suspend fun generateInteger(num: Int, lowerBound: Int, upperBound: Int): List<Int> {
        return try {
            val response: RandomIntResponse = httpClient.post(RANDOM_ENDPOINT){
                contentType(ContentType.Application.Json)
                body = RandomIntRequest(REQ_BODY_ID, REQ_BODY_JPC, REQ_BODY_METHOD,
                    RandomIntRequestParams(API_KEY, upperBound, lowerBound, num))
            }
            response.result.random.numbers
        } catch (e: Exception){
            println(e.message)
            listOf()
        }
    }
}
