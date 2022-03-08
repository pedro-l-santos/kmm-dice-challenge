package com.mindera.dicechallenge.api.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RandomIntRequest(
    val id: Int,
    @SerialName("jsonrpc")
    val jsonRpc: String,
    val method: String,
    val params: RandomIntRequestParams
)