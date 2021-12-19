package com.example.agerectifier.view.testing

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.agerectifier.viewmodel.ViewModel

@Composable
fun Testing(
    viewModel: ViewModel = hiltViewModel()
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){


        Text(
            text = "Test",
            fontSize = 20.sp,
            color = Color.Black
        )

        Button(onClick = {
        }) {
            Text(
                text = "Click",
                fontSize = 20.sp,
                color = Color.Black
            )
        }
    }
}