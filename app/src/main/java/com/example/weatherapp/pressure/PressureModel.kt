package com.example.weatherapp.pressure

data class PressureModel(
    val `data`: List<Data>,
    val dateGenerated: String,
    val status: String,
    val user: String,
    val version: String
)