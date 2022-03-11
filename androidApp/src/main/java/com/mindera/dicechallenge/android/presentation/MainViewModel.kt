package com.mindera.dicechallenge.android.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.mindera.dicechallenge.DiceManager
import com.mindera.dicechallenge.repository.IRandomRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal const val INITIAL_VALUE = 0
internal const val ERROR_VALUE = -1

class MainViewModel(private val repository: IRandomRepository) : ViewModel() {

    private val _diceValue = MutableStateFlow(INITIAL_VALUE)
    val diceValue: StateFlow<Int> = _diceValue

    fun rollDice(numFaces: Int) = viewModelScope.launch {
        kotlin.runCatching {
            repository.rollDice(numFaces)
        }.onSuccess {
            _diceValue.value = it
        }.onFailure {
            _diceValue.value = ERROR_VALUE
        }
    }

    //fun rollDice(numFaces: Int): Int = DiceManager().rollDice(numFaces)

}