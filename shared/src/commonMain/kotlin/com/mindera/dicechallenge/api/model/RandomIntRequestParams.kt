package com.mindera.dicechallenge.api.model


import kotlinx.serialization.Serializable

@Serializable
data class RandomIntRequestParams(
    val apiKey: String,
    val max: Int,
    val min: Int,
    val n: Int
)