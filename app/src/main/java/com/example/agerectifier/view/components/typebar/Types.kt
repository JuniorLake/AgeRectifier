package com.example.agerectifier.view.components.typebar

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.agerectifier.R
import com.example.agerectifier.view.utils.ProjectFont.fontFamily

@Composable
fun Types(name: String,isSelected: Boolean = false,modifier: Modifier){
    var currentTextColor by remember{
        mutableStateOf(Color(R.color.white_project))
    }

    @Composable
    fun typeText(){
        Text(
            text = name,
            color = currentTextColor,
            fontSize = 15.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            modifier = modifier
        )
    }
    currentTextColor = if (isSelected) {
        colorResource(R.color.teal_project)
    } else{
        colorResource(R.color.white_project)
    }

    typeText()

}