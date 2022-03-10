package com.mindera.dicechallenge.api

import io.ktor.client.engine.*

expect class Engine() {
    val engine: HttpClientEngine
}