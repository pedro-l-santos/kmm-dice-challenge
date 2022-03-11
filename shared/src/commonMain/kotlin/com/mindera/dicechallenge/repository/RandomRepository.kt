package com.mindera.dicechallenge.repository

import com.mindera.dicechallenge.api.IRandomApiClient
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

//Dice Const
private const val DICE_NUM = 1
private const val DICE_LOWER_BOUND = 1

class RandomRepository : IRandomRepository, KoinComponent {
    private val api : IRandomApiClient by inject()

    override suspend fun rollDice(numFaces: Int): Int {
        if (numFaces < 1) {
            return ERROR_VALUE
        }
        return api.generateInteger(DICE_NUM, DICE_LOWER_BOUND, numFaces)[0]
    }

    override suspend fun generateRandomInteger(num: Int, lowerBound: Int, upperBound: Int): List<Int> {
        if ((num < 1) || (lowerBound >= upperBound)) {
            return listOf()
        }
        return api.generateInteger(num, lowerBound, upperBound)
    }
}