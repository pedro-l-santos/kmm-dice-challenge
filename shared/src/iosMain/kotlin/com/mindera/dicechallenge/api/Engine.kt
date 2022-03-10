package com.mindera.dicechallenge.api

import io.ktor.client.engine.*
import io.ktor.client.engine.ios.*

actual class Engine {
    actual val engine: HttpClientEngine = Ios.create()
}