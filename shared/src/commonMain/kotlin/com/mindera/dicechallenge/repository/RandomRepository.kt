package com.mindera.dicechallenge.repository

import com.mindera.dicechallenge.api.RandomAPI

//Dice Const
private const val DICE_NUM = 1
private const val DICE_LOWER_BOUND = 1

class RandomRepository {
    private val api = RandomAPI()

    suspend fun rollDice(numFaces: Int): Int {
        return api.generateInteger(DICE_NUM, DICE_LOWER_BOUND, numFaces)[0]
    }

    suspend fun generateRandomInteger(num: Int, lowerBound: Int, upperBound: Int): List<Int> {
        return api.generateInteger(num, lowerBound, upperBound)
    }
}