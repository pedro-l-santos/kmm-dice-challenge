package com.mindera.dicechallenge.api

interface RandomApi {

    suspend fun generateInteger(num: Int, lowerBound: Int, upperBound: Int): List<Int>

}