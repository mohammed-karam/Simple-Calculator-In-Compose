package com.mkaram.composecalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel(){
    var state by mutableStateOf(CalculatorStates())
    private set // can not change from outside
    fun onAction (calculatorActions: CalculatorActions){
        when(calculatorActions){
            is CalculatorActions.Number -> enterNumber(calculatorActions.number)
            is CalculatorActions.Decimal -> enterDecimal()
            is CalculatorActions.Operation -> enterOperation(calculatorActions.operation)
            is CalculatorActions.Clear -> state = CalculatorStates()
            is CalculatorActions.Delete -> delete()
            is CalculatorActions.Calculate -> calculate()
        }
    }

    private fun delete() {
        when {
            state.number2.isNotBlank()->state = state.copy(
                number2 = state.number2.dropLast(1)
            )
            state.operation !=null -> state = state.copy(
                operation = null
            )
            state.number1.isNotBlank()->state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun calculate() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1 != null && number2 != null){

            val result = when(state.operation){
                CalculatorOperations.Add -> number1 + number2
                CalculatorOperations.Div -> number1 / number2
                CalculatorOperations.Mul -> number1 * number2
                CalculatorOperations.Sub -> number1 - number2
                null -> return
            }
            state = state.copy(number1 = result.toString().take(15),
                number2 = "", operation = null)
        }
    }

    private fun enterOperation(operation: CalculatorOperations) {
        if(state.number1.isNotBlank()){
            state = state.copy(operation = operation)
        }
    }

    private fun enterDecimal() {
        if(state.operation == null && !state.number1.contains(".")&&state.number1.isNotBlank()){
            state = state.copy(number1 = state.number1 + ".")
            return
        }
        if(state.operation != null && !state.number2.contains(".")&&state.number2.isNotBlank()){
            state = state.copy(number2 = state.number2 + ".")//
        }
    }

    private fun enterNumber(number: Int) {
        if(state.operation ==null){
            if(state.number1.length >= INT_MAX){

                return
            }
                state = state.copy(number1 = state.number1 + number)
            return
        }
        if (state.number2.length >= INT_MAX){
            return
        }
        state = state.copy(number2 = state.number2 + number)
    }
    companion object {
        private const val  INT_MAX = 8
    }
}
