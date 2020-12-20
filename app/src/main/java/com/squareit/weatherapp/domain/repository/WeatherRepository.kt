package com.squareit.weatherapp.domain.repository

import com.squareit.weatherapp.domain.model.Weather
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getWeatherApiResponse(latitude: String, longitude: String): Flow<Weather>
}