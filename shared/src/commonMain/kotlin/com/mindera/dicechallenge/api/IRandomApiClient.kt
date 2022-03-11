package com.mindera.dicechallenge.api

interface IRandomApiClient {

    suspend fun generateInteger(num: Int, lowerBound: Int, upperBound: Int): List<Int>

}