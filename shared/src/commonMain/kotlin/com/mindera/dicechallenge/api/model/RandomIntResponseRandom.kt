package com.mindera.dicechallenge.api.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RandomIntResponseRandom(
    val completionTime: String,
    @SerialName("data")
    val data: List<Int>
)