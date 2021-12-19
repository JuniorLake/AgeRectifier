package com.example.agerectifier.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.agerectifier.model.Calculations
import com.example.agerectifier.model.Date
import com.example.agerectifier.model.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(): ViewModel() {

    var userDataCollector = mutableStateOf(UserData(Date(0,0,0),"",0,0))
    var isLoading = mutableStateOf(false)

    @DelicateCoroutinesApi
    fun getData() {
        GlobalScope.launch(Dispatchers.IO) {
            isLoading.value = true
            userDataCollector.value.age = Calculations().getAge(userDataCollector.value)
            userDataCollector.value.ageInType = Calculations().convertAgeToType(userDataCollector.value)!!
            isLoading.value = false
        }
    }
}