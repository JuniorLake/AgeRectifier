package com.example.agerectifier.model

data class UserData (
    var selectedDate: Date,
    var type: String,
    var ageInType: Int,
    var age: Int
)

data class Date (
    var year: Int,
    var month: Int,
    var day: Int
)