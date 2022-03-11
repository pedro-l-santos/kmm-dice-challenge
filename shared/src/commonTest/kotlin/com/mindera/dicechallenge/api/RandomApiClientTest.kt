package com.mindera.dicechallenge.api

import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.coroutines.*
import kotlin.test.Test
import kotlin.test.assertEquals

class RandomApiClientTest {

    @Test
    fun generateRandomIntegerWithValidParameters() {
        val mockEngine = MockEngine { request ->
            respond(
                content = ByteReadChannel("""{
                            "jsonrpc": "2.0",
                            "result": {
                                "random": {
                                    "data": [
                                        1
                                    ],
                                    "completionTime": "2022-03-08 15:54:40Z"
                                },
                                "bitsUsed": 3,
                                "bitsLeft": 249997,
                                "requestsLeft": 999,
                                "advisoryDelay": 1980
                            },
                            "id": 1
                        }"""),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        runBlocking {
            val result = RandomApiClient(mockEngine).generateInteger(1,1,10)
            val expected = listOf(1)

            assertEquals(expected, result)
        }
    }

    @Test
    fun generateRandomIntegerWithInvalidParameters() {
        val mockEngine = MockEngine { request ->
            respond(
                content = ByteReadChannel("""{
                            "jsonrpc": "2.0",
                            "error": {
                                "code": 202,
                                "message": "Parameter 'n' is out of range; allowable values are [1,10000]",
                                "data": [
                                    "n",
                                    1,
                                    10000.0
                                ]
                            },
                            "id": 1
                        }"""),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        runBlocking {
            val result = RandomApiClient(mockEngine).generateInteger(0,1,10)
            val expected = listOf<Int>()

            assertEquals(expected, result)
        }
    }

}