package com.mindera.dicechallenge

class DiceManager {
    fun rollDice(numFaces: Int): Int {
        return (0 until numFaces).random() + 1;
    }
}