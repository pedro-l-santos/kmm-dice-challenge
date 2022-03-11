package com.mindera.dicechallenge.api

import io.ktor.client.engine.*
import io.ktor.client.engine.okhttp.*

actual class Engine {
    actual val engine: HttpClientEngine = OkHttp.create()
}