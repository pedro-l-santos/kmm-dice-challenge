package com.mindera.dicechallenge

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class RandomAPI {
    private val httpClient = HttpClient()

    suspend fun getData(): String {
        val response: HttpResponse = httpClient.get("https://ktor.io/");
        return response.readText().substring(0, 30);
    }
}