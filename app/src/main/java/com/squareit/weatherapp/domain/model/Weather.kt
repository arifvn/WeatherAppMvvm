package com.squareit.weatherapp.domain.model

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val date: String,
    val sunrise: String,
    val sunset: String,
    val temp: String,
    val pressure: String,
    val humidity: String,
    val uvi: String,
    val windSpeed: String,
    val latitude: String,
    val longitude: String
)