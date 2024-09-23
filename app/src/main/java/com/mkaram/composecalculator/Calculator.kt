package com.mkaram.composecalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mkaram.composecalculator.ui.theme.LightGray
import com.mkaram.composecalculator.ui.theme.MediumGray
import com.mkaram.composecalculator.ui.theme.Orange

@Composable
fun Calculator(
    modifier: Modifier,
    state: CalculatorStates,
    bottomSpacing: Dp,
    onAction : (CalculatorActions) -> Unit
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray)
        .padding(16.dp)
        , contentAlignment = Alignment.BottomEnd
        ) {
        Column(

            verticalArrangement = Arrangement.spacedBy(bottomSpacing)
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
            .background(Color.White)){
                Text(text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                    fontSize = 30.sp,
                    maxLines = 4,
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(bottomSpacing)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(bottomSpacing)
                ) {
                    CalculatorButton(
                        symbol = "AC", modifier = Modifier
                            .size(70.dp)
                            .weight(2f)
                            .background(LightGray),
                        onClick = {
                            onAction(CalculatorActions.Clear)
                        }
                    )


                    CalculatorButton(
                        symbol = "DEL", modifier = Modifier
                            .size(70.dp)
                            .weight(1f)
                            .background(MediumGray),
                        onClick = {
                            onAction(CalculatorActions.Delete)
                        }
                    )


                    CalculatorButton(
                        symbol = "/", modifier = Modifier
                            .size(70.dp)
                            .weight(1f)
                            .background(Orange),
                        onClick = {
                            onAction(CalculatorActions.Operation(CalculatorOperations.Div))
                        }
                    )


                }


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(bottomSpacing)
                ) {
                    CalculatorButton(
                        symbol = "7", modifier = Modifier
                            .size(70.dp)
                            .weight(1f)
                            .background(MediumGray),
                        onClick = {
                            onAction(CalculatorActions.Number(7))
                        }
                    )


                    CalculatorButton(
                        symbol = "8", modifier = Modifier
                            .size(70.dp)
                            .weight(1f)
                            .background(MediumGray),
                        onClick = {
                            onAction(CalculatorActions.Number(8))
                        }
                    )


                    CalculatorButton(
                        symbol = "9", modifier = Modifier
                            .size(70.dp)
                            .weight(1f)
                            .background(MediumGray),
                        onClick = {
                            onAction(CalculatorActions.Number(9))
                        }
                    )


                    CalculatorButton(
                        symbol = "x", modifier = Modifier
                            .size(70.dp)
                            .weight(1f)
                            .background(Orange),
                        onClick = {
                            onAction(CalculatorActions.Operation(CalculatorOperations.Mul))
                        }
                    )


                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(bottomSpacing)
                ) {
                    CalculatorButton(
                        symbol = "4", modifier = Modifier
                            .size(70.dp)
                            .weight(1f)
                            .background(MediumGray),
                        onClick = {
                            onAction(CalculatorActions.Number(4))
                        }
                    )


                    CalculatorButton(
                        symbol = "5", modifier = Modifier
                            .size(70.dp)
                            .weight(1f)
                            .background(MediumGray),
                        onClick = {
                            onAction(CalculatorActions.Number(5))
                        }
                    )


                    CalculatorButton(
                        symbol = "6", modifier = Modifier
                            .size(70.dp)
                            .weight(1f)
                            .background(MediumGray),
                        onClick = {
                            onAction(CalculatorActions.Number(6))
                        }
                    )


                    CalculatorButton(
                        symbol = "-", modifier = Modifier
                            .size(70.dp)
                            .weight(1f)
                            .background(Orange),
                        onClick = {
                            onAction(CalculatorActions.Operation(CalculatorOperations.Sub))
                        }
                    )


                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(bottomSpacing)
                ) {
                    CalculatorButton(
                        symbol = "1", modifier = Modifier
                            .size(70.dp)
                            .weight(1f)
                            .background(MediumGray),
                        onClick = {
                            onAction(CalculatorActions.Number(1))
                        }
                    )


                    CalculatorButton(
                        symbol = "2", modifier = Modifier
                            .size(70.dp)
                            .weight(1f)
                            .background(MediumGray),
                        onClick = {
                            onAction(CalculatorActions.Number(2))
                        }
                    )


                    CalculatorButton(
                        symbol = "3", modifier = Modifier
                            .size(70.dp)
                            .weight(1f)
                            .background(MediumGray),
                        onClick = {
                            onAction(CalculatorActions.Number(3))
                        }
                    )


                    CalculatorButton(
                        symbol = "+", modifier = Modifier
                            .size(70.dp)
                            .weight(1f)
                            .background(Orange),
                        onClick = {
                            onAction(CalculatorActions.Operation(CalculatorOperations.Add))
                        }
                    )


                }



                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(bottomSpacing)
                ) {
                    CalculatorButton(
                        symbol = "0", modifier = Modifier
                            .size(70.dp)
                            .weight(2f)
                            .background(MediumGray),
                        onClick = {
                            onAction(CalculatorActions.Number(0))
                        }
                    )



                    CalculatorButton(
                        symbol = ".", modifier = Modifier
                            .size(70.dp)
                            .weight(1f)
                            .background(MediumGray),
                        onClick = {
                            onAction(CalculatorActions.Decimal)
                        }
                    )


                    CalculatorButton(
                        symbol = "=", modifier = Modifier
                            .size(70.dp)
                            .weight(1f)
                            .background(Orange),
                        onClick = {
                            onAction(CalculatorActions.Calculate)
                        }
                    )


                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewCalculator() {

    Calculator(modifier = Modifier, CalculatorStates("1", "4", CalculatorOperations.Add), 10.dp,{})
}