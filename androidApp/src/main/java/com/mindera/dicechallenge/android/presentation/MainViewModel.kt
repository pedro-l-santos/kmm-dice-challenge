package com.mindera.dicechallenge.android.presentation

import androidx.lifecycle.ViewModel
import com.mindera.dicechallenge.DiceManager

class MainViewModel : ViewModel() {

    fun rollDice(numFaces: Int): Int = DiceManager().rollDice(numFaces)

}