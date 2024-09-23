package com.mkaram.composecalculator

sealed class CalculatorOperations (val symbol:String) {
    data object Add : CalculatorOperations("+")
    data object Sub : CalculatorOperations("-")
    data object Mul : CalculatorOperations("*")
    data object Div : CalculatorOperations("/")
}