package com.example.weatherapp.utils

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun String.toDate(): String{
    val dateTimeString = "2024-07-29T19:03:00Z"
    val zonedDateTime = ZonedDateTime.parse(dateTimeString)

    val hourFormatter = DateTimeFormatter.ofPattern("HH:mm")
    return zonedDateTime.format(hourFormatter)
}