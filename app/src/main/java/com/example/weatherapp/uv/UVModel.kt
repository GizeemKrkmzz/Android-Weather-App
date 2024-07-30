package com.example.weatherapp.uv

data class UVModel(
    val `data`: List<Data>,
    val dateGenerated: String,
    val status: String,
    val user: String,
    val version: String
)