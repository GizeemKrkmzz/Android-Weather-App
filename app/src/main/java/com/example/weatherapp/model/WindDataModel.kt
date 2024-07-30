package com.example.weatherapp.model

import com.example.weatherapp.model.wind.Data

data class WindDataModel(
    val data: List<Data>,
    val dateGenerated: String,
    val status: String,
    val user: String,
    val version: String
)