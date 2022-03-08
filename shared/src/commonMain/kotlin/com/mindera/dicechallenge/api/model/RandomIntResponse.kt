package com.mindera.dicechallenge.api.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RandomIntResponse(
    val id: Int,
    @SerialName("jsonrpc")
    val jsonRpc: String,
    val result: RandomIntResponseResult
)