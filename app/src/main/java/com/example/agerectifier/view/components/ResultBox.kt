package com.example.agerectifier.view.components

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.agerectifier.R
import com.example.agerectifier.model.Date
import com.example.agerectifier.view.utils.ProjectFont
import com.example.agerectifier.viewmodel.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@ExperimentalAnimationApi
@Composable
fun ResultBox(
    viewModel: ViewModel = hiltViewModel()
){
    var date by remember { mutableStateOf(Date(0,0,0)) }
    var age by remember { mutableStateOf(viewModel.userDataCollector.value.age) }
    var ageInType by remember { mutableStateOf(viewModel.userDataCollector.value.ageInType) }
    var type by remember { mutableStateOf(viewModel.userDataCollector.value.type) }
    val isLoading = viewModel.isLoading.value

    var visible by remember { mutableStateOf(false)}
    val scope = rememberCoroutineScope()

    if (!isLoading){
        scope.launch {
            visible = false
            delay(300)
            date = viewModel.userDataCollector.value.selectedDate
            age = viewModel.userDataCollector.value.age
            ageInType = viewModel.userDataCollector.value.ageInType
            type = viewModel.userDataCollector.value.type
            visible = true
        }
    }

    Column{
        Surface(
            color = colorResource(id = R.color.teal_project),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .height(300.dp)
                .width(300.dp)
        ) {
            AnimatedVisibility(
                visible = visible
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally){
                        Text(
                            text = "Selected Data",
                            color = colorResource(id = R.color.white_project),
                            fontSize = 20.sp,
                            fontFamily = ProjectFont.fontFamily,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = if (date.year == 0) "-" else "${date.day}/${date.month+1}/${date.year}",
                            color = colorResource(id = R.color.white_project),
                            fontSize = 30.sp,
                            fontFamily = ProjectFont.fontFamily,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally){
                        Text(
                            text = "Age In $type",
                            color = colorResource(id = R.color.white_project),
                            fontSize = 20.sp,
                            fontFamily = ProjectFont.fontFamily,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = if (date.year == 0) "-" else ageInType.toString(),
                            color = colorResource(id = R.color.white_project),
                            fontSize = 30.sp,
                            fontFamily = ProjectFont.fontFamily,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally){
                        Text(
                            text = "Age",
                            color = colorResource(id = R.color.white_project),
                            fontSize = 20.sp,
                            fontFamily = ProjectFont.fontFamily,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = if (date.year == 0) "-" else age.toString(),
                            color = colorResource(id = R.color.white_project),
                            fontSize = 30.sp,
                            fontFamily = ProjectFont.fontFamily,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}