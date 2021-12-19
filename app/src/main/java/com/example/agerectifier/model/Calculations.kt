package com.example.agerectifier.model

import java.util.*

class Calculations{

    fun convertAgeToType(userData: UserData): Int?{
        var result: Int? = null
        when (userData.type) {
            "Month" -> {
                result = userData.age * 12
            }
            "Day" -> {
                result = userData.age * 365
            }
            "Hour" -> {
                result = userData.age * 365 * 24
            }
            "Min" -> {
                result = userData.age * 365 * 24 * 60
            }
            "Sec" -> {
                result = userData.age * 365 * 24 * 60 * 60
            }
        }
        return result
    }

    fun getAge(userData: UserData): Int {
        return Calendar.getInstance().get(Calendar.YEAR) - userData.selectedDate.year
    }
}