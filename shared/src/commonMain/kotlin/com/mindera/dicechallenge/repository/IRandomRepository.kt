package com.mindera.dicechallenge.repository

const val ERROR_VALUE = -1

interface IRandomRepository {

    suspend fun rollDice(numFaces: Int): Int

    suspend fun generateRandomInteger(num: Int, lowerBound: Int, upperBound: Int): List<Int>

}