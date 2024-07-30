package com.example.weatherapp.sunset

data class SunsetModel(
    val `data`: List<Data>,
    val dateGenerated: String,
    val status: String,
    val user: String,
    val version: String
)
