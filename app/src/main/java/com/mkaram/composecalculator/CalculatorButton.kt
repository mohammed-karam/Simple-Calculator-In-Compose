package com.mkaram.composecalculator

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CalculatorButton(
    symbol:String,
    modifier:Modifier,
    onClick : () -> Unit,

) {
    Box(modifier = Modifier
        .clip(CircleShape)
        .clickable { onClick() }
        .then(modifier)
        , contentAlignment = Alignment.Center
    ){
        Text(
            text = symbol,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontWeight = FontWeight.Bold,
            color = Color.White,
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewCalculatorButton() {
    CalculatorButton("2", modifier = Modifier,{})
}