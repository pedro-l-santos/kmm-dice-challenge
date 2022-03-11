package com.mindera.dicechallenge.repository

import com.mindera.dicechallenge.api.IRandomApiClient
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

//Dice Const
private const val DICE_NUM = 1
private const val DICE_LOWER_BOUND = 1
private const val NUM_LOWER_LIMIT = 1
private const val NUM_UPPER_LIMIT = 10000
private const val BOUNDS_LIMIT = 1000000000

class RandomRepository : IRandomRepository, KoinComponent {
    private val api : IRandomApiClient by inject()

    override suspend fun rollDice(numFaces: Int): Int {
        if (numFaces < 1) {
            return ERROR_VALUE
        }
        return api.generateInteger(DICE_NUM, DICE_LOWER_BOUND, numFaces)[0]
    }

    override suspend fun generateRandomInteger(num: Int, lowerBound: Int, upperBound: Int): List<Int> {
        if ((num < NUM_LOWER_LIMIT) || (num > NUM_UPPER_LIMIT) || (lowerBound >= upperBound) || (lowerBound < -BOUNDS_LIMIT) ||
            (lowerBound > BOUNDS_LIMIT) || (upperBound < -BOUNDS_LIMIT) || (upperBound > BOUNDS_LIMIT)) {
            return listOf()
        }
        return api.generateInteger(num, lowerBound, upperBound)
    }
}