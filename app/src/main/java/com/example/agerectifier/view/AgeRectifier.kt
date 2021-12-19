package com.example.agerectifier.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.agerectifier.R
import com.example.agerectifier.view.components.ConfirmationButton
import com.example.agerectifier.view.components.ResultBox
import com.example.agerectifier.view.components.SelectDateButton
import com.example.agerectifier.view.components.typebar.TypeBar
import kotlinx.coroutines.DelicateCoroutinesApi

@ExperimentalAnimationApi
@DelicateCoroutinesApi
@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun AgeRectifier(){
    @Composable
    fun Spacer(verticalPadding: Int){
        Spacer(modifier = Modifier.padding(vertical = verticalPadding.dp))
    }

    Surface(
        color = colorResource(id = R.color.dark_blue_project)
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(16)
            ResultBox()
            Spacer(20)
            TypeBar()
            Spacer(30)
            SelectDateButton()
            ConfirmationButton()
        }
    }
}