package com.example.tiptime.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat

class TipTimeViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(TipTimeUiState())
    val uiState: StateFlow<TipTimeUiState> = _uiState.asStateFlow()

    var amountInput by mutableStateOf("0")
        private set

    var tipInput by mutableStateOf("0")
        private set

    var roundUp by mutableStateOf(false)
        private set

    fun updateAmountInput(input: String) {
        amountInput = input
    }

    fun updateTipInput(input: String) {
        tipInput = input
    }

    fun onRoundUpChanged() {
        roundUp = !roundUp
    }

    fun calculateTip(amount: Double, tipPercent: Double) {
        _uiState.update { currentState ->
            if (roundUp) {
                currentState.copy(
                    tipAmount = kotlin.math.ceil(tipPercent / 100 * amount)
                )
            } else {
                currentState.copy(
                    tipAmount = tipPercent / 100 * amount
                )
            }
        }
    }
}