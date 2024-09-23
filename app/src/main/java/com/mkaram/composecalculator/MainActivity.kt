package com.mkaram.composecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mkaram.composecalculator.ui.theme.ComposeCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCalculatorTheme {
                val viewModel : CalculatorViewModel = viewModel()
                val state = viewModel.state
                val bottonSpace = 8.dp
                Calculator(
                    modifier = Modifier
                    , state = state,
                    bottomSpacing = bottonSpace,
                    onAction = viewModel::onAction
                )





            }
        }
    }
}

