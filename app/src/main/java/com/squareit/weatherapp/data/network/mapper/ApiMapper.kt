package com.squareit.weatherapp.data.network.mapper

import com.squareit.weatherapp.data.network.model.WeatherApiResponse
import com.squareit.weatherapp.domain.model.Weather

interface ApiMapper {
    fun mapApiWeatherToDomain(weatherApiResponse: WeatherApiResponse): Weather
}