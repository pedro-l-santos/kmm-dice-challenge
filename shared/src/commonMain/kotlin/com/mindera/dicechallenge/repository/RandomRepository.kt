package com.mindera.dicechallenge.repository

import com.mindera.dicechallenge.api.RandomApiClient

//Dice Const
private const val DICE_NUM = 1
private const val DICE_LOWER_BOUND = 1

class RandomRepository : IRandomRepository {
    private val api = RandomApiClient()

    override suspend fun rollDice(numFaces: Int): Int {
        return api.generateInteger(DICE_NUM, DICE_LOWER_BOUND, numFaces)[0]
    }

    override suspend fun generateRandomInteger(num: Int, lowerBound: Int, upperBound: Int): List<Int> {
        return api.generateInteger(num, lowerBound, upperBound)
    }
}