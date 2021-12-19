package com.example.agerectifier.view.components

import android.app.DatePickerDialog
import android.os.Build
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.agerectifier.R
import com.example.agerectifier.view.utils.ProjectFont
import com.example.agerectifier.viewmodel.ViewModel
import java.util.*

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun SelectDateButton(
    viewModel: ViewModel = hiltViewModel()
){
    var buttonText by remember {
        mutableStateOf("Select Date")
    }

    val yearHolder = Calendar.getInstance().get(Calendar.YEAR)
    val monthHolder = Calendar.getInstance().get(Calendar.MONTH)
    val dayHolder = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = DatePickerDialog(
        LocalContext.current,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            buttonText = "$dayOfMonth/${month+1}/$year"
            viewModel.userDataCollector.value.selectedDate.day = dayOfMonth
            viewModel.userDataCollector.value.selectedDate.month = month
            viewModel.userDataCollector.value.selectedDate.year = year
        }, yearHolder,monthHolder,dayHolder
    )

    Column{
        Surface(
            color = colorResource(id = R.color.teal_project),
            modifier = Modifier
                .height(60.dp)
                .width(162.dp)
                .clickable { datePickerDialog.show() },
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = buttonText,
                    color = colorResource(id = R.color.white_project),
                    fontSize = 15.sp,
                    fontFamily = ProjectFont.fontFamily,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}