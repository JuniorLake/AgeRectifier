package com.example.agerectifier.view.components.typebar

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun offsetValue(selectedType: String): Dp{
    var value = 0.dp
    when(selectedType){
        "Month" -> value = 0.dp
        "Day" -> value = 60.dp
        "Hour" -> value = 120.dp
        "Min" -> value = 180.dp
        "Sec" -> value = 240.dp
    }
    return value
}