package com.mindera.dicechallenge.api.model


import kotlinx.serialization.Serializable

@Serializable
data class RandomIntResponseResult(
    val advisoryDelay: Int,
    val bitsLeft: Int,
    val bitsUsed: Int,
    val random: RandomIntResponseRandom,
    val requestsLeft: Int
)