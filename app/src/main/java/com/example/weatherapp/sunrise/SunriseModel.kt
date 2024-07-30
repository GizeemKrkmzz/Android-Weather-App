package com.example.weatherapp.sunrise

data class SunriseModel(
    val `data`: List<Data>,
    val dateGenerated: String,
    val status: String,
    val user: String,
    val version: String
)