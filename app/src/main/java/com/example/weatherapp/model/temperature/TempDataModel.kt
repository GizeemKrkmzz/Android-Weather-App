package com.example.weatherapp.model.temperature

data class TempDataModel(
    val `data`: List<Data>,
    val dateGenerated: String,
    val status: String,
    val user: String,
    val version: String
)