package com.mindera.dicechallenge.repository

interface IRandomRepository {

    suspend fun rollDice(numFaces: Int): Int

    suspend fun generateRandomInteger(num: Int, lowerBound: Int, upperBound: Int): List<Int>

}